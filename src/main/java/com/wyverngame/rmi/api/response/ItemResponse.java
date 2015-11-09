package com.wyverngame.rmi.api.response;

import com.wyverngame.rmi.api.response.model.Item;

public final class ItemResponse<T extends Item> extends Response {
	private final T item;

	public ItemResponse(T item) {
		super(200);

		this.item = item;
	}

	public T getItem() {
		return item;
	}
}
