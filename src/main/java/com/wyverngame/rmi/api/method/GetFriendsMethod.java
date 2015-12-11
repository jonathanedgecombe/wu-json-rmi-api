package com.wyverngame.rmi.api.method;

import java.rmi.RemoteException;
import java.util.Map;

import com.wyverngame.rmi.api.RMIClient;
import com.wyverngame.rmi.api.http.Request;
import com.wyverngame.rmi.api.response.FriendsResponse;

public final class GetFriendsMethod extends Method<FriendsResponse> {
	@Override
	public FriendsResponse process(RMIClient client, Request request) throws RemoteException {
		long playerId = Long.parseLong(request.get("id"));
		Map<String, Long> friends = client.getWebInterface().getFriends(client.getPassword(), playerId);
		return new FriendsResponse(friends);
	}
}
