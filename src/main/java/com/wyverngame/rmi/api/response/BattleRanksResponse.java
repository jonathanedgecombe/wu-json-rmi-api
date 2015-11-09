package com.wyverngame.rmi.api.response;

import java.util.Map;

public final class BattleRanksResponse extends Response {
	private final Map<String, Integer> ranks;

	public BattleRanksResponse(Map<String, Integer> ranks) {
		super(200);

		this.ranks = ranks;
	}

	public Map<String, Integer> getRanks() {
		return ranks;
	}
}
