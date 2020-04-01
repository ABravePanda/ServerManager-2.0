package com.tompkins_development.plugins.servermanager.files.messages;

import com.tompkins_development.plugins.servermanager.Main;
import java.io.File;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Messages {
	private File _file = new File(Main.instance.getDataFolder(), "EN.yml");

	private FileConfiguration _messages;

	public Messages() {
		if (!this._file.exists())
			Main.instance.saveResource("EN.yml", false);
		this._messages = (FileConfiguration) YamlConfiguration.loadConfiguration(this._file);
	}

	public String get(MessageLines line) {
		String message = "Error: Line type (" + line + ") not found! Please contact server admin!";
		if (line == MessageLines.NO_PERMISSION)
			message = this._messages.getString("messages.No_Permission");
		if (line == MessageLines.SENDER_TYPE)
			message = this._messages.getString("messages.Sender_Error");
		if (line == MessageLines.CHAT_OFF_TO_PLAYER)
			message = this._messages.getString("messages.Chat_Off_To_Person");
		if (line == MessageLines.CHAT_ON_TO_PLAYER)
			message = this._messages.getString("messages.Chat_On_To_Person");
		if (line == MessageLines.CHAT_ON_TO_SERVER)
			message = this._messages.getString("messages.Chat_On_To_Server");
		if (line == MessageLines.CHAT_OFF_TO_SERVER)
			message = this._messages.getString("messages.Chat_Off_To_Server");
		if (line == MessageLines.GLOBAL_CLEAR_TO_PLAYER)
			message = this._messages.getString("messages.Global_Clear_To_Person");
		if (line == MessageLines.GLOBAL_CLEAR_TO_SERVER)
			message = this._messages.getString("messages.Global_Clear_To_Server");
		if (line == MessageLines.SELF_CLEAR)
			message = this._messages.getString("messages.Self_Clear");
		if (line == MessageLines.OTHER_CLEAR_TO_PERSON)
			message = this._messages.getString("messages.Other_Clear_To_Person");
		if (line == MessageLines.OTHER_CLEAR_TO_RECIEVER)
			message = this._messages.getString("messages.Other_Clear_To_Reciever");
		if (line == MessageLines.OTHER_CLEAR_NOT_FOUND)
			message = this._messages.getString("messages.Other_Clear_Not_Found");
		if (line == MessageLines.BROADCAST_FORMAT)
			message = this._messages.getString("messages.Broadcast_Format");
		if (line == MessageLines.BROADCAST_NAME_FORMAT)
			message = this._messages.getString("messages.Broadcast_Name_Format");
		if (line == MessageLines.MESSAGE_PEEK)
			message = this._messages.getString("messages.Message_Peek");
		if (line == MessageLines.MESSAGE_TO_RECEIVER)
			message = this._messages.getString("messages.Message_To_Receiver");
		if (line == MessageLines.MESSAGE_TO_SENDER)
			message = this._messages.getString("messages.Message_To_Sender");
		return ChatColor.translateAlternateColorCodes('&', message);
	}
}
