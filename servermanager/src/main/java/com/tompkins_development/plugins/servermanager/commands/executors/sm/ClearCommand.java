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

public class ClearCommand extends NativeCommand {
	public ClearCommand(CommandSender sender) {
		super(sender, null);
	}

	public void execute(CommandSender sender, Command cmd, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (args[1].equalsIgnoreCase("global") || args[1].equalsIgnoreCase("g"))
				if (hasPermission(Permissions.CLEAR_GLOBAL_CHAT)) {
					Main.chatManager.clearChat();
					p.sendMessage(Main.messages.get(MessageLines.GLOBAL_CLEAR_TO_PLAYER));
					Bukkit.broadcastMessage(
							Main.messages.get(MessageLines.GLOBAL_CLEAR_TO_SERVER).replace("%player%", p.getName()));
				} else {
					p.sendMessage(Main.messages.get(MessageLines.NO_PERMISSION));
				}
			if (args[1].equalsIgnoreCase("self") || args[1].equalsIgnoreCase("s"))
				if (hasPermission(Permissions.CLEAR_SELF_CHAT)) {
					Main.chatManager.clearChat(p);
					p.sendMessage(Main.messages.get(MessageLines.SELF_CLEAR));
				} else {
					p.sendMessage(Main.messages.get(MessageLines.NO_PERMISSION));
				}
			if (args[1].equalsIgnoreCase("other") || args[1].equalsIgnoreCase("o"))
				if (args.length == 3) {
					if (hasPermission(Permissions.CLEAR_SELF_CHAT)) {
						Player to = Bukkit.getPlayer(args[2]);
						if (to != null) {
							if (!to.hasPermission(Permissions.OVERRIDE)) {
								Main.chatManager.clearChat(to);
								p.sendMessage(Main.messages.get(MessageLines.OTHER_CLEAR_TO_PERSON).replace("%player%",
										args[2]));
								to.sendMessage(Main.messages.get(MessageLines.OTHER_CLEAR_TO_RECIEVER)
										.replace("%player%", p.getName()));
							} else {
								p.sendMessage(FinalMessages.ERROR_OVERRIDE_CLEAR);
							}
						} else {
							p.sendMessage(
									Main.messages.get(MessageLines.OTHER_CLEAR_NOT_FOUND).replace("%player%", args[2]));
						}
					} else {
						p.sendMessage(Main.messages.get(MessageLines.NO_PERMISSION));
					}
				} else {
					p.sendMessage(FinalMessages.ARGS_CLEAR_OTHER);
				}
		}
	}
}
