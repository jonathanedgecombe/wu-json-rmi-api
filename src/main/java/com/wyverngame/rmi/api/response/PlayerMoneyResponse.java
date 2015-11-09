package com.wyverngame.rmi.api.response;

public final class PlayerMoneyResponse extends Response {
	private final long money;

	public PlayerMoneyResponse(long money) {
		super(200);

		this.money = money;
	}

	public long getMoney() {
		return money;
	}
}
