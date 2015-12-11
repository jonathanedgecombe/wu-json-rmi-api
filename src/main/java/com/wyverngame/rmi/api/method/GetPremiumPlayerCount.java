package com.wyverngame.rmi.api.method;

import java.rmi.RemoteException;

import com.wyverngame.rmi.api.RMIClient;
import com.wyverngame.rmi.api.http.Request;
import com.wyverngame.rmi.api.response.PlayerCountResponse;

public final class GetPremiumPlayerCount extends Method<PlayerCountResponse> {
	@Override
	public PlayerCountResponse process(RMIClient client, Request request) throws RemoteException {
		int playerCount = client.getWebInterface().getPremiumPlayerCount(client.getPassword());
		return new PlayerCountResponse(playerCount);
	}
}
