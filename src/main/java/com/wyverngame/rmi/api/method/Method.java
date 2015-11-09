package com.wyverngame.rmi.api.method;

import java.rmi.RemoteException;

import com.wyverngame.rmi.api.RMIClient;
import com.wyverngame.rmi.api.http.Request;
import com.wyverngame.rmi.api.response.Response;

public abstract class Method<T extends Response> {
	public abstract T process(RMIClient client, Request request) throws RemoteException;
}
