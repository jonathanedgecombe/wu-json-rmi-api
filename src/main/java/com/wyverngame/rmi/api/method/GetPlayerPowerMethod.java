package com.wyverngame.rmi.api.method;

import java.rmi.RemoteException;

import com.wyverngame.rmi.api.RMIClient;
import com.wyverngame.rmi.api.http.Request;
import com.wyverngame.rmi.api.response.PlayerPowerResponse;

public final class GetPlayerPowerMethod extends Method<PlayerPowerResponse> {
	@Override
	public PlayerPowerResponse process(RMIClient client, Request request) throws RemoteException {
		long playerId = Long.parseLong(request.get("id"));
		int power = client.getWebInterface().getPower(playerId);
		return new PlayerPowerResponse(power);
	}
}
