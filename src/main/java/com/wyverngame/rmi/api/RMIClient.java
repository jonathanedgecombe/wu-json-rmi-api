package com.wyverngame.rmi.api;

import java.net.InetSocketAddress;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.wurmonline.server.webinterface.WebInterface;

public final class RMIClient {
	private final WebInterface webInterface;
	private final String password;

	public RMIClient(InetSocketAddress socketAddress, String rmiPassword) throws RemoteException, NotBoundException {
		Registry registry = LocateRegistry.getRegistry(socketAddress.getHostName(), socketAddress.getPort());
		this.webInterface = (WebInterface) registry.lookup("wuinterface");
		this.password = rmiPassword;
	}

	public WebInterface getWebInterface() {
		return webInterface;
	}

	public String getPassword() {
		return password;
	}
}
