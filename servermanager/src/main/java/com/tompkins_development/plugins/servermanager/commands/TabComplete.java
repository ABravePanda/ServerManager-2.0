package com.tompkins_development.plugins.servermanager.commands;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

public class TabComplete implements TabCompleter {
	public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			List<String> completions = new ArrayList<String>();
			if (cmd.getName().equalsIgnoreCase("servermanager")) {
				if (args.length == 1) {
					completions.add("broadcast");
					completions.add("clear");
					completions.add("chat");
					return completions;
				}
				if (args[0].equalsIgnoreCase("clear")) {
					if (args.length == 2) {
						completions.add("global");
						completions.add("other");
						completions.add("self");
						return completions;
					}
					if (args.length >= 2 && args[1].equalsIgnoreCase("other")) {
						for (Player pl : Bukkit.getOnlinePlayers())
							completions.add(pl.getName());
						return completions;
					}
				}
				if (args[0].equalsIgnoreCase("broadcast") && args.length == 2) {
					completions.add("true");
					completions.add("false");
					return completions;
				}
				if (args[0].equalsIgnoreCase("chat") && args.length == 2) {
					completions.add("on");
					completions.add("off");
					return completions;
				}
			}
		}
		return null;
	}
}
