package com.tompkins_development.plugins.servermanager.commands.executors.sm;

import com.tompkins_development.plugins.servermanager.Main;
import com.tompkins_development.plugins.servermanager.files.messages.MessageLines;
import com.tompkins_development.plugins.servermanager.objects.NativeCommand;
import com.tompkins_development.plugins.servermanager.other.Permissions;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatCommand extends NativeCommand {
	public ChatCommand(CommandSender sender) {
		super(sender, Permissions.CHAT_STATUS);
	}

	public void execute(CommandSender sender, Command cmd, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (hasPermission()) {
				if (args[1].equalsIgnoreCase("on")) {
					Main.chatManager.enableChat();
					p.sendMessage(Main.messages.get(MessageLines.CHAT_ON_TO_PLAYER));
					Bukkit.broadcastMessage(
							Main.messages.get(MessageLines.CHAT_ON_TO_SERVER).replace("%player%", p.getName()));
				}
				if (args[1].equalsIgnoreCase("off")) {
					Main.chatManager.disableChat();
					p.sendMessage(Main.messages.get(MessageLines.CHAT_OFF_TO_PLAYER));
					Bukkit.broadcastMessage(
							Main.messages.get(MessageLines.CHAT_OFF_TO_SERVER).replace("%player%", p.getName()));
				}
			} else {
				p.sendMessage(Main.messages.get(MessageLines.NO_PERMISSION));
			}
		}
	}
}
