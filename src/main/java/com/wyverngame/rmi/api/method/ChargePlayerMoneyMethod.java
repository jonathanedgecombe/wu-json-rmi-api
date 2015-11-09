package com.wyverngame.rmi.api.method;

import java.rmi.RemoteException;

import com.wyverngame.rmi.api.RMIClient;
import com.wyverngame.rmi.api.http.Request;
import com.wyverngame.rmi.api.response.PlayerNewMoneyResponse;

public final class ChargePlayerMoneyMethod extends Method<PlayerNewMoneyResponse> {
	@Override
	public PlayerNewMoneyResponse process(RMIClient client, Request request) throws RemoteException {
		String playerName = request.get("name");
		long amount = Long.parseLong(request.get("amount"));
		long newAmount = client.getWebInterface().chargeMoney(playerName, amount);
		return new PlayerNewMoneyResponse(newAmount >= 0, newAmount);
	}
}
