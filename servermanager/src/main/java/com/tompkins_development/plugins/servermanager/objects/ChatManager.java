package com.tompkins_development.plugins.servermanager.objects;

import com.tompkins_development.plugins.servermanager.other.Settings;
import com.tompkins_development.plugins.servermanager.other.StaffMessageType;
import com.tompkins_development.plugins.servermanager.utils.ChatUtils;
import org.bukkit.entity.Player;

public class ChatManager {
	private ChatUtils _chatUtil = new ChatUtils();

	public void disableChat() {
		Settings.CHAT_ENABLED = false;
	}

	public void enableChat() {
		Settings.CHAT_ENABLED = true;
	}

	public void clearChat() {
		this._chatUtil.sendLines();
	}

	public void clearChat(Player player) {
		this._chatUtil.sendLines(player);
	}

	public void broadcast(String message) {
		this._chatUtil.sendMessage(message);
	}

	public void sendStaff(Player player, String message, StaffMessageType type) {
		this._chatUtil.sendMessageToStaff(message, player, type);
	}
}
