package com.tompkins_development.plugins.servermanager.listeners;

import com.tompkins_development.plugins.servermanager.other.Permissions;
import com.tompkins_development.plugins.servermanager.other.Settings;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {
	@EventHandler
	public void onAsyncPlayerChatEvent(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if (!Settings.CHAT_ENABLED && !p.hasPermission(Permissions.CHAT_ON_DISABLE)) {
			e.setCancelled(true);
			p.sendMessage(ChatColor.DARK_RED + "Chat is disabled.");
		}
	}
}
