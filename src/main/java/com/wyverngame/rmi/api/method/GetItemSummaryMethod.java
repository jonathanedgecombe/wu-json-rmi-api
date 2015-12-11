package com.wyverngame.rmi.api.method;

import java.rmi.RemoteException;
import java.util.Map;

import com.wyverngame.rmi.api.RMIClient;
import com.wyverngame.rmi.api.http.Request;
import com.wyverngame.rmi.api.response.ItemResponse;
import com.wyverngame.rmi.api.response.model.DetailedItem;

public class GetItemSummaryMethod extends Method<ItemResponse<DetailedItem>> {
	@Override
	public ItemResponse<DetailedItem> process(RMIClient client, Request request) throws RemoteException {
		long itemId = Long.parseLong(request.get("id"));
		Map<String, ?> details = client.getWebInterface().getItemSummary(client.getPassword(), itemId);

		Long owner = (Long) details.get("Owner");
		if (owner == null) {
			owner = (Long) details.get("Last owner");
		}

		DetailedItem item = new DetailedItem(
				itemId, 
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
				(String) details.get("Material"));

		return new ItemResponse<>(item);
	}
}
