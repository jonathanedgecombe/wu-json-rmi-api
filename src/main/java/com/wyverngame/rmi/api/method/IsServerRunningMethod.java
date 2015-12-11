package com.wyverngame.rmi.api.method;

import java.rmi.RemoteException;

import com.wyverngame.rmi.api.RMIClient;
import com.wyverngame.rmi.api.http.Request;
import com.wyverngame.rmi.api.response.ServerRunningResponse;

public final class IsServerRunningMethod extends Method<ServerRunningResponse> {
	@Override
	public ServerRunningResponse process(RMIClient client, Request request) throws RemoteException {
		boolean running = client.getWebInterface().isRunning(client.getPassword());
		return new ServerRunningResponse(running);
	}
}
