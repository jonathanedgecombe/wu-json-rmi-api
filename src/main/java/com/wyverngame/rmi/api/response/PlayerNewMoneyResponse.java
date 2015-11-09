package com.wyverngame.rmi.api.response;

public final class PlayerNewMoneyResponse extends SuccessResponse {
	private final long money;

	public PlayerNewMoneyResponse(boolean success, long money) {
		super(success);

		this.money = money;
	}

	public long getMoney() {
		return money;
	}
}
