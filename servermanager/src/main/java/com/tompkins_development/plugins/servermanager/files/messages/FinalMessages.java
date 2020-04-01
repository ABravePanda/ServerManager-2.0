package com.tompkins_development.plugins.servermanager.files.messages;

import org.bukkit.ChatColor;

public class FinalMessages {
	public static String ARGS_BROADCAST = ChatColor.DARK_RED
			+ "Incorrect Arguments: /sm broadcast [true,false] [message]";

	public static String ARGS_CLEAR_OTHER = ChatColor.DARK_RED + "Incorrect Arguments: /sm clear [other] [player name]";

	public static String ARGS_MESSAGE = ChatColor.DARK_RED + "Incorrect Arguments: /msg [player name] [message]";

	public static String ERROR_OVERRIDE_CLEAR = ChatColor.DARK_RED + "Uh oh! You can't clear this persons chat!";
}
