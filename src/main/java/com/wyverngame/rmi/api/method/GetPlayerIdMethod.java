package com.wyverngame.rmi.api.method;

import java.rmi.RemoteException;

import com.wyverngame.rmi.api.RMIClient;
import com.wyverngame.rmi.api.http.Request;
import com.wyverngame.rmi.api.response.PlayerIdResponse;

public final class GetPlayerIdMethod extends Method<PlayerIdResponse> {
	@Override
	public PlayerIdResponse process(RMIClient client, Request request) throws RemoteException {
		String playerName = request.get("name");
		long playerId = client.getWebInterface().getPlayerId(client.getPassword(), playerName);
		return new PlayerIdResponse(playerId);
	}
}
