package com.wyverngame.rmi.api.response;

import java.util.List;
import com.wyverngame.rmi.api.response.model.Item;

public final class InventoryResponse extends Response {
	private final List<Item> items;

	public InventoryResponse(List<Item> items) {
		super(200);

		this.items = items;
	}

	public List<Item> getItems() {
		return items;
	}
}
