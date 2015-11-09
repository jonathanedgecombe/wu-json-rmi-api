package com.wyverngame.rmi.api.response;

import java.util.List;

import com.wyverngame.rmi.api.response.model.Deed;

public final class DeedListResponse<T extends Deed> extends Response {
	private final List<T> deeds;

	public DeedListResponse(List<T> deeds) {
		super(200);

		this.deeds = deeds;
	}

	public List<T> getDeeds() {
		return deeds;
	}
}
