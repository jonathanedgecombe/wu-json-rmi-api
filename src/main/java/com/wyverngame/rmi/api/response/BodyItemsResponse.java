package com.wyverngame.rmi.api.response;

import java.util.List;

import com.wyverngame.rmi.api.response.model.ContainedItem;
import com.wyverngame.rmi.api.response.model.DetailedItem;

public final class BodyItemsResponse extends Response {
	private final List<ContainedItem<DetailedItem>> items;

	public BodyItemsResponse(List<ContainedItem<DetailedItem>> items) {
		super(200);

		this.items = items;
	}

	public List<ContainedItem<DetailedItem>> getItems() {
		return items;
	}
}
