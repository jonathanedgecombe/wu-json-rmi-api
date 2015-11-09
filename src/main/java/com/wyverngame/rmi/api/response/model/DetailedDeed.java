package com.wyverngame.rmi.api.response.model;

public final class DetailedDeed extends Deed {
	private final String motto, kingdom;
	private final int size;
	private final String founder, mayor;
	private final int citizens, allies, guards;
	private final int posX, posY;

	public DetailedDeed(int id, String name, String motto, String kingdom, int size, String founder, String mayor, int citizens, int allies, int guards, int posX, int posY) {
		super(id, name);

		this.motto = motto;
		this.kingdom = kingdom;

		this.size = size;

		this.founder = founder;
		this.mayor = mayor;

		this.citizens = citizens;
		this.allies = allies;
		this.guards = guards;

		this.posX = posX;
		this.posY = posY;
	}

	public String getMotto() {
		return motto;
	}

	public String getKingdom() {
		return kingdom;
	}

	public int getSize() {
		return size;
	}

	public String getFounder() {
		return founder;
	}

	public String getMayor() {
		return mayor;
	}

	public int getCitizens() {
		return citizens;
	}

	public int getAllies() {
		return allies;
	}

	public int getGuards() {
		return guards;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

}
