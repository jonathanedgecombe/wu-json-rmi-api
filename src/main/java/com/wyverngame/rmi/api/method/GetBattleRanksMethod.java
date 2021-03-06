package com.wyverngame.rmi.api.method;

import java.rmi.RemoteException;
import java.util.Map;

import com.wyverngame.rmi.api.RMIClient;
import com.wyverngame.rmi.api.http.Request;
import com.wyverngame.rmi.api.response.BattleRanksResponse;

public final class GetBattleRanksMethod extends Method<BattleRanksResponse> {
	@Override
	public BattleRanksResponse process(RMIClient client, Request request) throws RemoteException {
		int limit = Integer.parseInt(request.getOrDefault("limit", Integer.toString(10)));
		Map<String, Integer> ranks = client.getWebInterface().getBattleRanks(client.getPassword(), limit);
		return new BattleRanksResponse(ranks);
	}
}
