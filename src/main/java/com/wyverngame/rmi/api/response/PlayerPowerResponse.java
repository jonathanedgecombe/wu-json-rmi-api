package com.wyverngame.rmi.api.response;

public final class PlayerPowerResponse extends Response {
	private final int power;

	public PlayerPowerResponse(int power) {
		super(200);

		this.power = power;
	}

	public int getPower() {
		return power;
	}
}
