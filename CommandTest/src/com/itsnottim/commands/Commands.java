package com.itsnottim.commands;

import org.bukkit.plugin.java.JavaPlugin;

import com.itsnottim.commands.coms.ComsTest;

public class Commands extends JavaPlugin{
	
	@Override
	public void onEnable() {
		ComsTest commands = new ComsTest();
		getServer().getConsoleSender().sendMessage("[Command Test]: Active");
		getCommand("jump").setExecutor(commands);
		getCommand("strength").setExecutor(commands);
	}
	
	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage("[Command Test]: Off");
	}
}
