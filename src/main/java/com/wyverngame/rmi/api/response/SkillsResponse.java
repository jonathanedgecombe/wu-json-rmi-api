package com.wyverngame.rmi.api.response;

import java.util.Map;

public final class SkillsResponse extends Response {
	private final Map<String, Float> skills;

	public SkillsResponse(Map<String, Float> skills) {
		super(200);

		this.skills = skills;
	}

	public Map<String, Float> getSkills() {
		return skills;
	}
}
