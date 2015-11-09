package com.wurmonline.server.players;

public final class BannedIp {
   public final String ipaddress;
   public String reason;
   public long expiry;
   public final boolean player;

   public BannedIp(String _ipaddress, String _reason, long _expiry, boolean _player) {
      this.ipaddress = _ipaddress;
      this.reason = _reason;
      this.expiry = _expiry;
      this.player = _player;
   }

   public boolean isExpired() {
      return System.currentTimeMillis() > this.expiry;
   }
}
