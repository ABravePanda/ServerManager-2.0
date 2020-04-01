package com.tompkins_development.plugins.servermanager.commands.executors.msg;

import com.tompkins_development.plugins.servermanager.Main;
import com.tompkins_development.plugins.servermanager.files.messages.FinalMessages;
import com.tompkins_development.plugins.servermanager.files.messages.MessageLines;
import com.tompkins_development.plugins.servermanager.objects.MessageManager;
import com.tompkins_development.plugins.servermanager.objects.NativeCommand;
import com.tompkins_development.plugins.servermanager.other.Permissions;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessageCommand extends NativeCommand {
	public MessageCommand(CommandSender sender) {
		super(sender, Permissions.MESSAGE_SEND);
	}

	public void execute(CommandSender sender, Command cmd, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (hasPermission()) {
				if (args.length > 1) {
					MessageManager message = new MessageManager(args[0], p, buildString(args));
					message.send();
					message.sendStaff();
				} else {
					p.sendMessage(FinalMessages.ARGS_MESSAGE);
				}
			} else {
				p.sendMessage(Main.messages.get(MessageLines.NO_PERMISSION));
			}
		}
	}

	private String buildString(String[] args) {
		String message = "";
		for (int i = 1; i < args.length; i++)
			message = message + args[i] + " ";
		return message;
	}
}
