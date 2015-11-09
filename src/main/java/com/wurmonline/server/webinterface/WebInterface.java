package com.wurmonline.server.webinterface;

import com.wurmonline.server.players.BannedIp;
import com.wurmonline.shared.exceptions.WurmServerException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface WebInterface extends Remote {
   int getPower(long var1) throws RemoteException;

   boolean isRunning() throws RemoteException;

   int getPlayerCount() throws RemoteException;

   int getPremiumPlayerCount() throws RemoteException;

   String getTestMessage() throws RemoteException;

   void broadcastMessage(String var1) throws RemoteException;

   long getAccountStatusForPlayer(String var1) throws RemoteException;

   long chargeMoney(String var1, long var2) throws RemoteException;

   String getServerStatus() throws RemoteException;

   Map<String, Integer> getBattleRanks(int var1) throws RemoteException;

   Map<String, Long> getFriends(long var1) throws RemoteException;

   Map<String, String> getInventory(long var1) throws RemoteException;

   Map<Long, Long> getBodyItems(long var1) throws RemoteException;

   Map<String, Float> getSkills(long var1) throws RemoteException;

   Map<String, ?> getPlayerSummary(long var1) throws RemoteException;

   long getLocalCreationTime() throws RemoteException;

   String ban(String var1, String var2, int var3) throws RemoteException;

   String pardonban(String var1) throws RemoteException;

   String addBannedIp(String var1, String var2, int var3) throws RemoteException;

   BannedIp[] getPlayersBanned() throws RemoteException;

   BannedIp[] getIpsBanned() throws RemoteException;

   String removeBannedIp(String var1) throws RemoteException;

   Map<Integer, String> getKingdoms() throws RemoteException;

   Map<Long, String> getPlayersForKingdom(int var1) throws RemoteException;

   long getPlayerId(String var1) throws RemoteException;

   Map<String, ?> createPlayer(String var1, String var2, String var3, String var4, String var5, byte var6, byte var7, long var8, byte var10) throws RemoteException;

   Map<String, String> createPlayerPhaseOne(String var1, String var2) throws RemoteException;

   Map<String, ?> createPlayerPhaseTwo(String var1, String var2, String var3, String var4, String var5, byte var6, byte var7, long var8, byte var10, String var11) throws RemoteException;

   Map<String, ?> createPlayerPhaseTwo(String var1, String var2, String var3, String var4, String var5, byte var6, byte var7, long var8, byte var10, String var11, int var12) throws RemoteException;

   Map<String, ?> createPlayerPhaseTwo(String var1, String var2, String var3, String var4, String var5, byte var6, byte var7, long var8, byte var10, String var11, int var12, boolean var13) throws RemoteException;

   byte[] createAndReturnPlayer(String var1, String var2, String var3, String var4, String var5, byte var6, byte var7, long var8, byte var10, boolean var11, boolean var12, boolean var13) throws RemoteException;

   Map<String, String> addMoneyToBank(String var1, long var2, String var4) throws RemoteException;

   long getMoney(long var1, String var3) throws RemoteException;

   Map<String, String> reversePayment(long var1, int var3, int var4, String var5, String var6, String var7) throws RemoteException;

   Map<String, String> addMoneyToBank(String var1, long var2, String var4, boolean var5) throws RemoteException;

   Map<String, String> addMoneyToBank(String var1, long var2, long var4, String var6, boolean var7) throws RemoteException;

   Map<String, String> addPlayingTime(String var1, int var2, int var3, String var4, boolean var5) throws RemoteException;

   Map<String, String> addPlayingTime(String var1, int var2, int var3, String var4) throws RemoteException;

   Map<Integer, String> getDeeds() throws RemoteException;

   Map<String, ?> getDeedSummary(int var1) throws RemoteException;

   Map<String, Long> getPlayersForDeed(int var1) throws RemoteException;

   Map<String, Integer> getAlliesForDeed(int var1) throws RemoteException;

   String[] getHistoryForDeed(int var1, int var2) throws RemoteException;

   String[] getAreaHistory(int var1) throws RemoteException;

   Map<String, ?> getItemSummary(long var1) throws RemoteException;

   Map<String, String> getPlayerIPAddresses() throws RemoteException;

   Map<String, String> getNameBans() throws RemoteException;

   Map<String, String> getIPBans() throws RemoteException;

   Map<String, String> getWarnings() throws RemoteException;

   String getWurmTime() throws RemoteException;

   String getUptime() throws RemoteException;

   String getNews() throws RemoteException;

   String getGameInfo() throws RemoteException;

   Map<String, String> getKingdomInfluence() throws RemoteException;

   Map<String, ?> getMerchantSummary(long var1) throws RemoteException;

   Map<String, ?> getBankAccount(long var1) throws RemoteException;

   Map<String, ?> authenticateUser(String var1, String var2, String var3, Map<String, ?> var4) throws RemoteException;

   Map<String, ?> authenticateUser(String var1, String var2, String var3) throws RemoteException;

   Map<String, String> changePassword(String var1, String var2, String var3) throws RemoteException;

   Map<String, String> changePassword(String var1, String var2, String var3, String var4) throws RemoteException;

   boolean changePassword(long var1, String var3) throws RemoteException;

   Map<String, String> changeEmail(String var1, String var2, String var3) throws RemoteException;

   String getChallengePhrase(String var1) throws RemoteException;

   String[] getPlayerNamesForEmail(String var1) throws RemoteException;

   String getEmailAddress(String var1) throws RemoteException;

   Map<String, String> requestPasswordReset(String var1, String var2) throws RemoteException;

   Map<Integer, String> getAllServers() throws RemoteException;

   Map<Integer, String> getAllServerInternalAddresses() throws RemoteException;

   boolean sendMail(String var1, String var2, String var3, String var4) throws RemoteException;

   Map<String, String> getPendingAccounts() throws RemoteException;

   void shutDown(String var1, String var2, String var3, int var4) throws RemoteException;

   Map<String, Byte> getReferrers(long var1) throws RemoteException;

   String addReferrer(String var1, long var2) throws RemoteException;

   String acceptReferrer(long var1, String var3, boolean var4) throws RemoteException;

   Map<String, Double> getSkillStats(int var1) throws RemoteException;

   Map<Integer, String> getSkills() throws RemoteException;

   Map<String, ?> getStructureSummary(long var1) throws RemoteException;

   long getStructureIdFromWrit(long var1) throws RemoteException;

   Map<String, ?> getTileSummary(int var1, int var2, boolean var3) throws RemoteException;

   String getReimbursementInfo(String var1) throws RemoteException;

   boolean withDraw(String var1, String var2, String var3, int var4, int var5, boolean var6, int var7) throws RemoteException;

   boolean transferPlayer(String var1, int var2, int var3, boolean var4, int var5, byte[] var6) throws RemoteException;

   boolean setCurrentServer(String var1, int var2) throws RemoteException;

   boolean addDraggedItem(long var1, byte[] var3, long var4, int var6, int var7) throws RemoteException;

   String rename(String var1, String var2, String var3, int var4) throws RemoteException;

   String changePassword(String var1, String var2, String var3, int var4) throws RemoteException;

   String changeEmail(String var1, String var2, String var3, String var4, int var5, String var6, String var7) throws RemoteException;

   String addReimb(String var1, String var2, int var3, int var4, int var5, boolean var6) throws RemoteException;

   long[] getCurrentServerAndWurmid(String var1, long var2) throws RemoteException;

   Map<Long, byte[]> getPlayerStates(long[] var1) throws RemoteException, WurmServerException;

   void manageFeature(int var1, int var2, boolean var3, boolean var4, boolean var5) throws RemoteException;

   void startShutdown(String var1, int var2, String var3) throws RemoteException;

   String sendMail(byte[] var1, byte[] var2, long var3, long var5, int var7) throws RemoteException;

   String setPlayerPremiumTime(long var1, long var3, int var5, int var6, String var7) throws RemoteException;

   String setPlayerMoney(long var1, long var3, long var5, String var7) throws RemoteException;

   Map<String, String> doesPlayerExist(String var1) throws RemoteException;

   void setWeather(float var1, float var2, float var3) throws RemoteException;

   String sendVehicle(byte[] var1, byte[] var2, long var3, long var5, int var7, int var8, int var9, int var10, float var11) throws RemoteException;

   void requestDemigod(byte var1, String var2) throws RemoteException;

   String ascend(int var1, String var2, long var3, byte var5, byte var6, byte var7, float var8, float var9) throws RemoteException;

   boolean requestDeityMove(int var1, int var2, String var3) throws RemoteException;

   void setKingdomInfo(int var1, byte var2, byte var3, String var4, String var5, String var6, String var7, String var8, String var9, boolean var10) throws RemoteException;

   boolean kingdomExists(int var1, byte var2, boolean var3) throws RemoteException;

   void genericWebCommand(short var1, long var2, byte[] var4) throws RemoteException;

   int[] getPremTimeSilvers(long var1) throws RemoteException;

   void awardPlayer(long var1, String var3, int var4, int var5) throws RemoteException;
}
