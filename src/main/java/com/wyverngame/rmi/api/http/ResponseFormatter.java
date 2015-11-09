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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wyverngame.rmi.api.response.Response;

public final class ResponseFormatter {
	private static final GsonBuilder BUILDER = new GsonBuilder().setPrettyPrinting();

	public static <T extends Response> HttpResponse formatJson(Request request, T target) {
		Gson gson = BUILDER.create();
		String json = gson.toJson(target);

		ByteBuf buf = request.getAllocator().buffer();

		buf.writeBytes(json.getBytes(StandardCharsets.UTF_8));
		HttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, HttpResponseStatus.valueOf(target.getHttpStatus()), buf);

		response.headers().set(CONTENT_TYPE, "application/json; charset=utf-8");
		response.headers().set(CONTENT_LENGTH, ((DefaultFullHttpResponse) response).content().readableBytes());
		response.headers().set(SERVER, HTTPServer.SERVER_NAME);

		return response;
	}
}
