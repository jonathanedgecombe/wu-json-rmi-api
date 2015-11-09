package com.wyverngame.rmi.api.response;

public abstract class Response {
	protected transient final int httpStatus;

	public Response(int httpStatus) {
		this.httpStatus = httpStatus;
	}

	public int getHttpStatus() {
		return httpStatus;
	}
}
