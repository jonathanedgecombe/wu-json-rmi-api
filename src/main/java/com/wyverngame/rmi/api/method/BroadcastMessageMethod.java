package com.wyverngame.rmi.api.method;

import java.rmi.RemoteException;

import com.wyverngame.rmi.api.RMIClient;
import com.wyverngame.rmi.api.http.Request;
import com.wyverngame.rmi.api.response.SuccessResponse;

public final class BroadcastMessageMethod extends Method<SuccessResponse> {
	@Override
	public SuccessResponse process(RMIClient client, Request request) throws RemoteException {
		String message = request.get("message");
		client.getWebInterface().broadcastMessage(client.getPassword(), message);
		return new SuccessResponse(true);
	}
}
