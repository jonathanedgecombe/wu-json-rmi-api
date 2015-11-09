package com.wyverngame.rmi.api;

public final class Config {
	private final String rmiHost;
	private final int rmiPort;
	private final String rmiPassword;
	private final int apiPort;
	private final String apiPassword;

	public Config(String rmiHost, int rmiPort, String rmiPassword, int apiPort, String apiPassword) {
		this.rmiHost = rmiHost;
		this.rmiPort = rmiPort;
		this.rmiPassword = rmiPassword;
		this.apiPort = apiPort;
		this.apiPassword = apiPassword;
	}

	public String getRmiHost() {
		return rmiHost;
	}

	public int getRmiPort() {
		return rmiPort;
	}

	public String getRmiPassword() {
		return rmiPassword;
	}

	public int getApiPort() {
		return apiPort;
	}

	public String getApiPassword() {
		return apiPassword;
	}
}
