package com.wyverngame.rmi.api.http;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.logging.Level;

import com.sun.istack.internal.logging.Logger;

import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpResponse;
import static io.netty.handler.codec.http.HttpHeaders.Names.*;
import static io.netty.handler.codec.http.HttpHeaders.*;
import static io.netty.handler.codec.http.HttpResponseStatus.*;
import static io.netty.handler.codec.http.HttpVersion.*;

public class HTTPServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
	private static final Logger LOGGER = Logger.getLogger(HTTPServerHandler.class);
	private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

	private final HTTPServer server;

	public HTTPServerHandler(HTTPServer server) {
		this.server = server;
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) {
		ctx.flush();
	}

	@Override
	public void channelRead0(ChannelHandlerContext ctx, FullHttpRequest httpRequest) throws Exception {
		if (is100ContinueExpected(httpRequest)) ctx.write(new DefaultFullHttpResponse(HTTP_1_1, CONTINUE));
		boolean keepAlive = isKeepAlive(httpRequest);

		LOGGER.log(Level.INFO, 
				ctx.channel().remoteAddress() + 
				" [" + DATE_FORMATTER.format(Date.from(Instant.now())) + "] " + 
						httpRequest.getMethod().toString() + " " + 
						httpRequest.headers().get(HOST) + httpRequest.getUri() + " " + 
						httpRequest.getProtocolVersion());

		if (httpRequest.getMethod().equals(HttpMethod.GET)) {
			Request request = new Request(
					httpRequest.getMethod(), httpRequest.headers().get(HOST), 
					httpRequest.getUri(), ctx.alloc(), ctx);

			HttpResponse response = server.handle(request);

			if (!keepAlive) {
				ctx.write(response).addListener(ChannelFutureListener.CLOSE);
			} else {
				response.headers().set(CONNECTION, Values.KEEP_ALIVE);
				ctx.write(response);
			}
		} else {
			Request request = new Request(
					httpRequest.getMethod(), httpRequest.headers().get(HOST), 
					httpRequest.getUri(), ctx.alloc(), ctx);

			ctx.write(ErrorFormatter.format(request, 501));
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		LOGGER.log(Level.WARNING, "Error in " + ctx.name(), cause);
		ctx.close();
	}
}