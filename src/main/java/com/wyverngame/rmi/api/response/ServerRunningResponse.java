package com.wyverngame.rmi.api.response;

public final class ServerRunningResponse extends Response {
	private final boolean running;

	public ServerRunningResponse(boolean running) {
		super(200);

		this.running = running;
	}

	public boolean isRunning() {
		return running;
	}
}
