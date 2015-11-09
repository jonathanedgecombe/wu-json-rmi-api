package com.wyverngame.rmi.api.method;

import java.rmi.RemoteException;

import com.wyverngame.rmi.api.RMIClient;
import com.wyverngame.rmi.api.http.Request;
import com.wyverngame.rmi.api.response.PlayerMoneyResponse;

public final class GetPlayerMoneyMethod extends Method<PlayerMoneyResponse> {
	@Override
	public PlayerMoneyResponse process(RMIClient client, Request request) throws RemoteException {
		String playerName = request.get("playerName");
		long money = client.getWebInterface().getAccountStatusForPlayer(playerName);
		return new PlayerMoneyResponse(money);
	}
}
