package com.wyverngame.rmi.api.response;

public final class MessageResponse extends Response {
	private final String message;

	public MessageResponse(String message) {
		super(200);

		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
