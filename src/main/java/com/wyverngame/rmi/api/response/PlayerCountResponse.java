package com.wyverngame.rmi.api.response;

public final class PlayerCountResponse extends Response {
	private final int playerCount;

	public PlayerCountResponse(int playerCount) {
		super(200);

		this.playerCount = playerCount;
	}

	public int getPlayerCount() {
		return playerCount;
	}
}
