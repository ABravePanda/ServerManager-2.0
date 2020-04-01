package com.tompkins_development.plugins.servermanager.commands;

import com.tompkins_development.plugins.servermanager.commands.executors.msg.MessageCommand;
import com.tompkins_development.plugins.servermanager.commands.executors.sm.BroadcastCommand;
import com.tompkins_development.plugins.servermanager.commands.executors.sm.ChatCommand;
import com.tompkins_development.plugins.servermanager.commands.executors.sm.ClearCommand;
import com.tompkins_development.plugins.servermanager.objects.NativeCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandHandler implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		MessageCommand messageCommand;
		NativeCommand nc = null;
		if (cmd.getName().equalsIgnoreCase("servermanager")) {
			if (args[0].equalsIgnoreCase("chat"))
				nc = new ChatCommand(sender);
			if (args[0].equalsIgnoreCase("clear"))
				nc = new ClearCommand(sender);
			if (args[0].equalsIgnoreCase("broadcast"))
				nc = new BroadcastCommand(sender);
		}
		if (cmd.getName().equalsIgnoreCase("message"))
			nc = new MessageCommand(sender);
		nc.execute(sender, cmd, args);
		return true;
	}
}
