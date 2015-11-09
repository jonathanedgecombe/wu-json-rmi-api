package com.wyverngame.rmi.api.response;

import java.util.List;

import com.wyverngame.rmi.api.response.model.SkillEntry;

public final class SkillListResponse extends Response {
	private final List<SkillEntry> skills;

	public SkillListResponse(List<SkillEntry> skills) {
		super(200);

		this.skills = skills;
	}

	public List<SkillEntry> getSkills() {
		return skills;
	}
}
