package com.wyverngame.rmi.api.method;

import java.rmi.RemoteException;

import com.wyverngame.rmi.api.RMIClient;
import com.wyverngame.rmi.api.http.Request;
import com.wyverngame.rmi.api.response.StatusMessage;

public final class GetServerStatusMethod extends Method<StatusMessage> {
	@Override
	public StatusMessage process(RMIClient client, Request request) throws RemoteException {
		String status = client.getWebInterface().getServerStatus();
		return new StatusMessage(status);
	}
}
