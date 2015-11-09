package com.wyverngame.rmi.api.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

public class HTTPServerInitializer extends ChannelInitializer<SocketChannel> {
	private final HTTPServer server;

	public HTTPServerInitializer(HTTPServer server) {
		this.server = server;
	}

	@Override
	public void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline p = ch.pipeline();

		p.addLast("codec", new HttpServerCodec());
		p.addLast("agg", new HttpObjectAggregator(HTTPServer.MAX_CONTENT_LENGTH));
		p.addLast("handler", new HTTPServerHandler(server));
	}
}