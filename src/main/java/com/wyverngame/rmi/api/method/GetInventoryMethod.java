package com.wyverngame.rmi.api.method;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.wyverngame.rmi.api.RMIClient;
import com.wyverngame.rmi.api.http.Request;
import com.wyverngame.rmi.api.response.InventoryResponse;
import com.wyverngame.rmi.api.response.model.DetailedItem;
import com.wyverngame.rmi.api.response.model.Item;

public final class GetInventoryMethod extends Method<InventoryResponse> {
	private static final Pattern PATTERN = Pattern.compile("(.*), QL: (.*), DAM: (.*)");
	@Override
	public InventoryResponse process(RMIClient client, Request request) throws RemoteException {
		long playerId = Long.parseLong(request.get("id"));
		boolean detailed = Boolean.parseBoolean(request.getOrDefault("detailed", "false"));
		Map<String, String> inventory = client.getWebInterface().getInventory(client.getPassword(), playerId);
		List<Item> items = new ArrayList<>();

		for (Entry<String, String> entry : inventory.entrySet()) {
			if (detailed) {
				Map<String, ?> details = client.getWebInterface().getItemSummary(client.getPassword(), Long.parseLong(entry.getKey()));

				Long owner = (Long) details.get("Owner");
				if (owner == null) {
					owner = (Long) details.get("Last owner");
				}

				items.add(new DetailedItem(
						Long.parseLong(entry.getKey()), 
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
						(String) details.get("Material")));

				continue;
			}

			String data = entry.getValue();
			Matcher matcher = PATTERN.matcher(data);

			if (matcher.matches()) {
				String name = matcher.group(1);
				float ql = Float.parseFloat(matcher.group(2));
				float dmg = Float.parseFloat(matcher.group(3));

				items.add(new Item(Long.parseLong(entry.getKey()), name, ql, dmg));
			}
		}

		return new InventoryResponse(items);
	}
}
