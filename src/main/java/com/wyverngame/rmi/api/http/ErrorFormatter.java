package com.wyverngame.rmi.api.http;

import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_LENGTH;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_TYPE;
import static io.netty.handler.codec.http.HttpHeaders.Names.SERVER;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public final class ErrorFormatter {
	private static final Map<Integer, String> ERRORS = new HashMap<>();

	static {
		ERRORS.put(401, "Unauthorized");
		ERRORS.put(404, "Not Found");
		ERRORS.put(500, "Internal Server Error");
		ERRORS.put(501, "Not Implemented");
	}

	public static HttpResponse format(Request request, int errorCode, Throwable... causes) {
		String errorName = ERRORS.getOrDefault(errorCode, "Internal Server Error");
		ByteBuf buf = request.getAllocator().buffer();

		String error = "";
		for (Throwable cause : causes) {
			error += cause.toString() + "<br />";

			for (StackTraceElement element : cause.getStackTrace()) {
				error += element.toString() + "<br />";
			}

			error += "<hr />";
		}

		buf.writeBytes((
				"<!DOCTYPE><html><head><title>" + errorName + 
				"</title></head><body><h1>" + errorCode + " - " + errorName + 
				"</h1><hr /><i>" + request.getHost() + request.getPath() + " - " + HTTPServer.SERVER_NAME + 
				"</i><hr />" + error + "</body></html>").getBytes(StandardCharsets.UTF_8));

		HttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, HttpResponseStatus.NOT_FOUND, buf);

		response.headers().set(CONTENT_TYPE, "text/html; charset=utf-8");
		response.headers().set(CONTENT_LENGTH, ((DefaultFullHttpResponse) response).content().readableBytes());
		response.headers().set(SERVER, HTTPServer.SERVER_NAME);

		return response;
	}
}
