package com.wyverngame.rmi.api.method;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.wyverngame.rmi.api.RMIClient;
import com.wyverngame.rmi.api.http.Request;
import com.wyverngame.rmi.api.response.DeedListResponse;
import com.wyverngame.rmi.api.response.model.Deed;
import com.wyverngame.rmi.api.response.model.DetailedDeed;

public final class GetDeedList extends Method<DeedListResponse<? extends Deed>> {
	@Override
	public DeedListResponse<? extends Deed> process(RMIClient client, Request request) throws RemoteException {
		Map<Integer, String> deeds = client.getWebInterface().getDeeds(client.getPassword());
		boolean detailed = Boolean.parseBoolean(request.getOrDefault("detailed", "false"));

		if (detailed) {
			List<DetailedDeed> list = new ArrayList<>();

			for (Entry<Integer, String> entry : deeds.entrySet()) {
				Map<String, ?> details = client.getWebInterface().getDeedSummary(client.getPassword(), entry.getKey());

				Integer guards = (Integer) details.get("guards");
				if (guards == null) {
					guards = 0;
				}

				list.add(new DetailedDeed(
						entry.getKey(), 
						entry.getValue(), 
						(String) details.get("Motto"), 
						(String) details.get("Location"), 
						(int) details.get("Size"), 
						(String) details.get("Founder"), 
						(String) details.get("Mayor"), 
						(int) details.get("Citizens"), 
						(int) details.get("Allies"), 
						guards, 
						(int) details.get("Token Coord x"), 
						(int) details.get("Token Coord y")));
			}

			return new DeedListResponse<>(list);
		}

		List<Deed> list = new ArrayList<>();

		for (Entry<Integer, String> entry : deeds.entrySet()) {
			list.add(new Deed(entry.getKey(), entry.getValue()));
		}
		return new DeedListResponse<>(list);
	}
}
