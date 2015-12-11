package com.wyverngame.rmi.api.method;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.wyverngame.rmi.api.RMIClient;
import com.wyverngame.rmi.api.http.Request;
import com.wyverngame.rmi.api.response.SkillListResponse;
import com.wyverngame.rmi.api.response.model.SkillEntry;

public final class GetSkillsMethod extends Method<SkillListResponse> {
	@Override
	public SkillListResponse process(RMIClient client, Request request) throws RemoteException {
		Map<Integer, String> skills = client.getWebInterface().getSkills(client.getPassword());
		List<SkillEntry> entries = new ArrayList<>();

		for (Entry<Integer, String> entry : skills.entrySet()) {
			entries.add(new SkillEntry(entry.getKey(), entry.getValue()));
		}

		return new SkillListResponse(entries);
	}
}
