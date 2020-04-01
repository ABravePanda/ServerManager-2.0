package com.tompkins_development.plugins.servermanager;

import com.tompkins_development.plugins.servermanager.commands.CommandHandler;
import com.tompkins_development.plugins.servermanager.commands.TabComplete;
import com.tompkins_development.plugins.servermanager.files.messages.Messages;
import com.tompkins_development.plugins.servermanager.listeners.ChatListener;
import com.tompkins_development.plugins.servermanager.objects.ChatManager;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	public static ChatManager chatManager;

	public static Main instance;

	public static Messages messages;

	public void onEnable() {
		init();
	}

	public void onDisable() {
	}

	public void init() {
		registerCommands();
		registerTabComplete();
		registerEvents();
		createInstances();
	}

	public void registerCommands() {
		getCommand("servermanager").setExecutor((CommandExecutor) new CommandHandler());
		getCommand("message").setExecutor((CommandExecutor) new CommandHandler());
	}

	public void registerTabComplete() {
		getCommand("servermanager").setTabCompleter((TabCompleter) new TabComplete());
		getCommand("message").setTabCompleter((TabCompleter) new TabComplete());
	}

	public void registerEvents() {
		getServer().getPluginManager().registerEvents((Listener) new ChatListener(), (Plugin) this);
	}

	public void createInstances() {
		instance = this;
		chatManager = new ChatManager();
		messages = new Messages();
	}
}
