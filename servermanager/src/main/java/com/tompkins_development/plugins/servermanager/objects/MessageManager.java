package com.tompkins_development.plugins.servermanager.objects;

import com.tompkins_development.plugins.servermanager.Main;
import com.tompkins_development.plugins.servermanager.files.messages.MessageLines;
import com.tompkins_development.plugins.servermanager.other.Permissions;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class MessageManager {
	private String _to;

	private Player _from;

	private String _message;

	public MessageManager(String to, Player from, String message) {
		this._to = to;
		this._from = from;
		this._message = message;
	}

	public boolean send() {
		if (isValid()) {
			getPlayer().sendMessage(formattedMessage(MessageLines.MESSAGE_TO_RECEIVER));
			this._from.sendMessage(formattedMessage(MessageLines.MESSAGE_TO_SENDER));
			return true;
		}
		return false;
	}

	public void sendStaff() {
		for (Player p : Bukkit.getOnlinePlayers()) {
			if (p.hasPermission(Permissions.MESSAGE_PEEK))
				p.sendMessage(formattedMessage(MessageLines.MESSAGE_PEEK));
		}
	}

	private boolean isValid() {
		for (Player p : Bukkit.getOnlinePlayers()) {
			if (p.getName().equalsIgnoreCase(this._to))
				return true;
		}
		return false;
	}

	private Player getPlayer() {
		return Bukkit.getPlayer(this._to);
	}

	private String formattedMessage(MessageLines line) {
		return Main.messages.get(line).replace("%sender%", this._from.getName())
				.replace("%receiver%", getPlayer().getName()).replace("%message%", this._message);
	}
}
