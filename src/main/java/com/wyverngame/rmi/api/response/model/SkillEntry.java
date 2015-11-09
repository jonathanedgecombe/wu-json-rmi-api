package com.wyverngame.rmi.api.response.model;

public final class SkillEntry {
	private final int id;
	private final String name;

	public SkillEntry(int id, String name) {
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
