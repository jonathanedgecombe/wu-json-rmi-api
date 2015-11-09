package com.wyverngame.rmi.api.response;

public final class StatusMessage extends Response {
	private final String status;

	public StatusMessage(String status) {
		super(200);

		this.status = status;
	}

	public String getMessage() {
		return status;
	}
}
