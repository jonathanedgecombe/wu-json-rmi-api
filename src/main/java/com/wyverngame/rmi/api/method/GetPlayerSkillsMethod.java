package com.wyverngame.rmi.api.method;

import java.rmi.RemoteException;
import java.util.Map;

import com.wyverngame.rmi.api.RMIClient;
import com.wyverngame.rmi.api.http.Request;
import com.wyverngame.rmi.api.response.SkillsResponse;

public final class GetPlayerSkillsMethod extends Method<SkillsResponse> {
	@Override
	public SkillsResponse process(RMIClient client, Request request) throws RemoteException {
		long playerId = Long.parseLong(request.get("id"));
		Map<String, Float> skills = client.getWebInterface().getSkills(client.getPassword(), playerId);
		return new SkillsResponse(skills);
	}
}
