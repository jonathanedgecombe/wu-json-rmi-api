package com.wyverngame.rmi.api.http;

import java.util.logging.Level;

import com.sun.istack.internal.logging.Logger;
import com.wyverngame.rmi.api.API;
import com.wyverngame.rmi.api.RMIClient;
import com.wyverngame.rmi.api.method.Method;
import com.wyverngame.rmi.api.response.Response;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpResponse;

public class HTTPServer {
	private static final Logger LOGGER = Logger.getLogger(HTTPServer.class);

	public static final String SERVER_NAME = "json-rmi-api";
	public static final int MAX_CONTENT_LENGTH = 65536;

	private final RMIClient rmiClient;
	private final int port;
	private final String apiPassword;

	public HTTPServer(RMIClient rmiClient, int port, String apiPassword) {
		this.rmiClient = rmiClient;
		this.port = port;
		this.apiPassword = apiPassword;
	}

	public void run() throws Exception {
		LOGGER.log(Level.INFO, "Starting server");

		EventLoopGroup bossGroup = new NioEventLoopGroup(1);
		EventLoopGroup workerGroup = new NioEventLoopGroup(4);

		try {
			ServerBootstrap bootstrap = new ServerBootstrap();
			bootstrap.option(ChannelOption.SO_BACKLOG, 1024);
			bootstrap.group(bossGroup, workerGroup);
			bootstrap.channel(NioServerSocketChannel.class);
			bootstrap.childHandler(new HTTPServerInitializer(this));

			Channel channel = bootstrap.bind(port).sync().channel();
			LOGGER.log(Level.INFO, "Listening on port " + port);
			channel.closeFuture().sync();
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}

	public HttpResponse handle(Request request) throws Exception {
		if (!apiPassword.isEmpty() && !apiPassword.equals(request.get("password"))) {
			return ErrorFormatter.format(request, 401);
		}

		Method<? extends Response> method = API.METHODS.get(request.getPath());

		if (method != null) {
			try {
				return ResponseFormatter.formatJson(request, method.process(rmiClient, request));
			} catch (Throwable cause) {
				return ErrorFormatter.format(request, 500, cause);
			}
		} else {
			return ErrorFormatter.format(request, 404);
		}
	}
}
