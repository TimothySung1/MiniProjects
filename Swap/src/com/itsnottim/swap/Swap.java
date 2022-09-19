package com.itsnottim.swap;

import org.bukkit.plugin.java.JavaPlugin;

public class Swap extends JavaPlugin{
	@Override
	public void onEnable() {
		getServer().getConsoleSender().sendMessage("[Swap]: Plugin enabled");
	}
	
	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage("[Swap]: Plugin disabled");
	}
}
