package com.wyverngame.rmi.api.response;

public class SuccessResponse extends Response {
	private final boolean success;

	public SuccessResponse(boolean success) {
		super(200);

		this.success = success;
	}

	public boolean isSuccess() {
		return success;
	}
}
