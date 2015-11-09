package com.wyverngame.rmi.api.response.model;

public final class ContainedItem<T extends Item> {
	private final long parentId;
	private final T details;

	public ContainedItem(long parentId, T details) {
		this.parentId = parentId;
		this.details = details;
	}

	public long getParentId() {
		return parentId;
	}

	public T getDetails() {
		return details;
	}
}
