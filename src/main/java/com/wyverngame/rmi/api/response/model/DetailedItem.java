package com.wyverngame.rmi.api.response.model;

public final class DetailedItem extends Item {
	private final int sizeX, sizeY, sizeZ;
	private final long owner;
	private final int posX, posY;
	private final String creator;
	private final String creationDate;
	private final String description;
	private final String material;

	public DetailedItem(long id, String name, float quality, float damage, int sizeX, int sizeY, int sizeZ, long owner, int posX, int posY, String creator, String creationDate, String description, String material) {
		super(id, name, quality, damage);

		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.sizeZ = sizeZ;

		this.posX = posX;
		this.posY = posY;

		this.owner = owner;
		this.creator = creator;

		this.creationDate = creationDate;
		this.description = description;
		this.material = material;
	}

	public int getSizeX() {
		return sizeX;
	}

	public int getSizeY() {
		return sizeY;
	}

	public int getSizeZ() {
		return sizeZ;
	}

	public long getOwner() {
		return owner;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public String getCreator() {
		return creator;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public String getDescription() {
		return description;
	}

	public String getMaterial() {
		return material;
	}
}
