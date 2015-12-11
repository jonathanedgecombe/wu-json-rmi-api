package com.wyverngame.rmi.api.method;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import com.wyverngame.rmi.api.RMIClient;
import com.wyverngame.rmi.api.http.Request;
import com.wyverngame.rmi.api.response.BodyItemsResponse;
import com.wyverngame.rmi.api.response.model.ContainedItem;
import com.wyverngame.rmi.api.response.model.DetailedItem;

public final class GetBodyItemsMethod extends Method<BodyItemsResponse> {
	@Override
	public BodyItemsResponse process(RMIClient client, Request request) throws RemoteException {
		long playerId = Long.parseLong(request.get("id"));
		Map<Long, Long> bodyItems = client.getWebInterface().getBodyItems(client.getPassword(), playerId);
		List<ContainedItem<DetailedItem>> items = new ArrayList<>();

		for (Entry<Long, Long> entry : bodyItems.entrySet()) {
			long id = entry.getKey();
			long parent = entry.getValue();
			Map<String, ?> details = client.getWebInterface().getItemSummary(client.getPassword(), id);

			Long owner = (Long) details.get("Owner");
			if (owner == null) {
				owner = (Long) details.get("Last owner");
			}

			items.add(new ContainedItem<>(parent, new DetailedItem(
					id, 
					(String) details.get("Name"), 
					Float.parseFloat((String) details.get("QL")), 
					Float.parseFloat((String) details.get("DMG")), 
					Integer.parseInt((String) details.get("SizeX")), 
					Integer.parseInt((String) details.get("SizeY")), 
					Integer.parseInt((String) details.get("SizeZ")), 
					owner, 
					(int) details.get("Coord x"), 
					(int) details.get("Coord y"), 
					(String) details.get("Creator"), 
					(String) details.get("Creationdate"), 
					(String) details.get("Description"), 
					(String) details.get("Material"))));
		}

		return new BodyItemsResponse(items);
	}
}
