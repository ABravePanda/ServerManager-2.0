package com.tompkins_development.plugins.servermanager.commands.executors.sm;

import com.tompkins_development.plugins.servermanager.Main;
import com.tompkins_development.plugins.servermanager.files.messages.FinalMessages;
import com.tompkins_development.plugins.servermanager.files.messages.MessageLines;
import com.tompkins_development.plugins.servermanager.objects.NativeCommand;
import com.tompkins_development.plugins.servermanager.other.Permissions;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BroadcastCommand extends NativeCommand {
	public BroadcastCommand(CommandSender sender) {
		super(sender, Permissions.BROADCAST);
	}

	public void execute(CommandSender sender, Command cmd, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (hasPermission()) {
				if (args.length >= 3) {
					if (args[1].equalsIgnoreCase("true")) {
						String broadcast = Main.messages.get(MessageLines.BROADCAST_NAME_FORMAT)
								.replace("%player%", p.getName()).replace("%message%", buildString(args));
						Bukkit.broadcastMessage(broadcast);
					} else {
						String broadcast = Main.messages.get(MessageLines.BROADCAST_FORMAT).replace("%message%",
								buildString(args));
						Bukkit.broadcastMessage(broadcast);
					}
				} else {
					p.sendMessage(FinalMessages.ARGS_BROADCAST);
				}
			} else {
				p.sendMessage(Main.messages.get(MessageLines.NO_PERMISSION));
			}
		}
	}

	private String buildString(String[] args) {
		String message = "";
		for (int i = 2; i < args.length; i++)
			message = message + args[i] + " ";
		return message;
	}
}
