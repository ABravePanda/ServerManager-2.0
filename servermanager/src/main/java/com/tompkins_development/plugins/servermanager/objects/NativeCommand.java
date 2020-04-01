package com.tompkins_development.plugins.servermanager.objects;

import com.tompkins_development.plugins.servermanager.other.Permissions;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public abstract class NativeCommand {
	private final CommandSender _sender;

	private final String _permission;

	public NativeCommand(CommandSender sender, String permission) {
		this._sender = sender;
		this._permission = permission;
	}

	public CommandSender getSender() {
		return this._sender;
	}

	public String getPermission() {
		return this._permission;
	}

	public boolean hasPermission() {
		return (this._sender.hasPermission(this._permission) || this._sender.isOp()
				|| this._sender.hasPermission(Permissions.OVERRIDE));
	}

	public boolean hasPermission(String permission) {
		return this._sender.hasPermission(permission);
	}

	public abstract void execute(CommandSender paramCommandSender, Command paramCommand, String[] paramArrayOfString);
}
