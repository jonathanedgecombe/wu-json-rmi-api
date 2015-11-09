package com.wyverngame.rmi.api.response;

import java.util.Map;

public final class FriendsResponse extends Response {
	private final Map<String, Long> friends;

	public FriendsResponse(Map<String, Long> friends) {
		super(200);

		this.friends = friends;
	}

	public Map<String, Long> getFriends() {
		return friends;
	}
}
