package com.wyverngame.rmi.api.http;

import java.util.HashMap;
import java.util.Map;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpMethod;

public final class Request {
	private final HttpMethod method;
	private final String host;
	private final String path;
	private final ByteBufAllocator allocator;
	private final ChannelHandlerContext ctx;

	private final Map<String, String> getParameters = new HashMap<>();

	public Request(HttpMethod method, String host, String path, ByteBufAllocator allocator, ChannelHandlerContext ctx) {
		this.method = method;
		this.host = host;
		this.allocator = allocator;
		this.ctx = ctx;

		if (path.contains("?")) {
			String[] parts = path.split("\\?", 2);
			this.path = parts[0];

			String[] parameters = parts[1].split("&");
			for (String parameter : parameters) {
				String[] split = parameter.split("=", 2);

				if (split.length != 2) {
					continue;
				}

				getParameters.put(split[0], split[1]);
			}
		} else {
			this.path = path;
		}
	}

	public String getHost() {
		return host;
	}

	public String getPath() {
		return path;
	}

	public ByteBufAllocator getAllocator() {
		return allocator;
	}

	public HttpMethod getMethod() {
		return method;
	}

	public ChannelHandlerContext getCtx() {
		return ctx;
	}

	public String get(String key) {
		return getParameters.get(key);
	}

	public String getOrDefault(String key, String defaultValue) {
		return getParameters.getOrDefault(key, defaultValue);
	}
}
