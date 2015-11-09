package com.wyverngame.rmi.api.response.model;

public class Deed {
	private final int id;
	private final String name;

	public Deed(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
