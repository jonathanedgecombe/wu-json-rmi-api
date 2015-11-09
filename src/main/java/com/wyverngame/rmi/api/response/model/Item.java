package com.wyverngame.rmi.api.response.model;

public class Item {
	private final long id;
	private final String name;
	private final float quality, damage;

	public Item(long id, String name, float quality, float damage) {
		this.id = id;
		this.name = name;
		this.quality = quality;
		this.damage = damage;
	}

	public String getName() {
		return name;
	}

	public float getQuality() {
		return quality;
	}

	public float getDamage() {
		return damage;
	}

	public long getId() {
		return id;
	}
}
