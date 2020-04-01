package com.tompkins_development.plugins.servermanager.utils;

import com.tompkins_development.plugins.servermanager.other.Permissions;
import com.tompkins_development.plugins.servermanager.other.StaffMessageType;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ChatUtils {
	public void sendLines() {
		for (int i = 0; i < 100;) {
			for (Player p : Bukkit.getOnlinePlayers())
				p.sendMessage("");
			i++;
		}
	}

	public void sendLines(Player p) {
		for (int i = 0; i < 100;) {
			p.sendMessage("");
			i++;
		}
	}

	public void sendMessage(String message) {
		Bukkit.broadcastMessage(message);
	}

	public void sendMessageToStaff(String message, Player p, StaffMessageType type) {
		if (type == StaffMessageType.CHAT)
			sendStaff(Permissions.RECIEVE_STAFF_HELP,
					String.format("[Staff %s] (%s) - %s", new Object[] { "Help", p.getName(), message }));
		if (type == StaffMessageType.HELP)
			sendStaff(Permissions.RECIEVE_STAFF_CHAT,
					String.format("[Staff %s] (%s) - %s", new Object[] { "Chat", p.getName(), message }));
	}

	private void sendStaff(String permission, String message) {
		for (Player player : Bukkit.getOnlinePlayers()) {
			if (player.hasPermission(permission))
				player.sendMessage(message);
		}
	}
}
