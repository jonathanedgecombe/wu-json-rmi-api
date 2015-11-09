package com.wyverngame.rmi.api.method;

import java.rmi.RemoteException;

import com.wyverngame.rmi.api.RMIClient;
import com.wyverngame.rmi.api.http.Request;
import com.wyverngame.rmi.api.response.MessageResponse;

public final class GetTestMessageMethod extends Method<MessageResponse> {
	@Override
	public MessageResponse process(RMIClient client, Request request) throws RemoteException {
		String message = client.getWebInterface().getTestMessage();
		return new MessageResponse(message);
	}
}
