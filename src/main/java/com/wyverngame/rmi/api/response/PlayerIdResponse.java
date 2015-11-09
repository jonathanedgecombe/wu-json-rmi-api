package com.wyverngame.rmi.api.response;

public final class PlayerIdResponse extends Response {
	private final long playerId;

	public PlayerIdResponse(long playerId) {
		super(200);

		this.playerId = playerId;
	}

	public long getPlayerId() {
		return playerId;
	}
}
