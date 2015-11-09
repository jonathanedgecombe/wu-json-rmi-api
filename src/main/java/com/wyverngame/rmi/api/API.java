package com.wyverngame.rmi.api;

import java.io.Reader;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.wyverngame.rmi.api.http.HTTPServer;
import com.wyverngame.rmi.api.method.BroadcastMessageMethod;
import com.wyverngame.rmi.api.method.GetBattleRanksMethod;
import com.wyverngame.rmi.api.method.GetBodyItemsMethod;
import com.wyverngame.rmi.api.method.GetFriendsMethod;
import com.wyverngame.rmi.api.method.GetInventoryMethod;
import com.wyverngame.rmi.api.method.GetItemSummaryMethod;
import com.wyverngame.rmi.api.method.GetPlayerCountMethod;
import com.wyverngame.rmi.api.method.GetPlayerIdMethod;
import com.wyverngame.rmi.api.method.GetPlayerMoneyMethod;
import com.wyverngame.rmi.api.method.GetPlayerPowerMethod;
import com.wyverngame.rmi.api.method.GetPremiumPlayerCount;
import com.wyverngame.rmi.api.method.GetServerStatusMethod;
import com.wyverngame.rmi.api.method.GetSkillsMethod;
import com.wyverngame.rmi.api.method.GetPlayerSkillsMethod;
import com.wyverngame.rmi.api.method.IsServerRunningMethod;
import com.wyverngame.rmi.api.method.GetTestMessageMethod;
import com.wyverngame.rmi.api.method.Method;
import com.wyverngame.rmi.api.response.Response;

public final class API {
	public static void main(String[] args) throws Exception {
		try (Reader reader = Files.newBufferedReader(Paths.get("config.json"))) {
			Gson gson = new Gson();
			Config config = gson.fromJson(reader, Config.class);
			reader.close();
			RMIClient client = new RMIClient(new InetSocketAddress(config.getRmiHost(), config.getRmiPort()), config.getRmiPassword());
			HTTPServer server = new HTTPServer(client, config.getApiPort(), config.getApiPassword());
			server.run();
		}
	}

	public static final Map<String, Method<? extends Response>> METHODS = new HashMap<>();

	static {
		METHODS.put("/broadcastMessage", new BroadcastMessageMethod());
		METHODS.put("/getBattleRanks", new GetBattleRanksMethod());
		METHODS.put("/getBodyItems", new GetBodyItemsMethod());
		METHODS.put("/getFriends", new GetFriendsMethod());
		METHODS.put("/getInventory", new GetInventoryMethod());
		METHODS.put("/getItemSummary", new GetItemSummaryMethod());
		METHODS.put("/getPlayerCount", new GetPlayerCountMethod());
		METHODS.put("/getPlayerId", new GetPlayerIdMethod());
		METHODS.put("/getPlayerMoneyMethod", new GetPlayerMoneyMethod());
		METHODS.put("/getPlayerPower", new GetPlayerPowerMethod());
		METHODS.put("/getPremiumPlayerCount", new GetPremiumPlayerCount());
		METHODS.put("/getServerStatus", new GetServerStatusMethod());
		METHODS.put("/getSkillList", new GetSkillsMethod());
		METHODS.put("/getSkills", new GetPlayerSkillsMethod());
		METHODS.put("/getTestMessage", new GetTestMessageMethod());
		METHODS.put("/isServerRunning", new IsServerRunningMethod());
	}
}
