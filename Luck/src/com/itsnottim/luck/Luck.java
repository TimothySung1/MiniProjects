package com.itsnottim.luck;

import org.bukkit.plugin.java.JavaPlugin;

import com.itsnottim.luck.events.JoinEvent;
import com.itsnottim.luck.events.MobDropEvents;
import com.itsnottim.luck.events.PiglinTradeEvent;

public class Luck extends JavaPlugin{
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new MobDropEvents(), this);
		getServer().getPluginManager().registerEvents(new PiglinTradeEvent(), this);
		getServer().getPluginManager().registerEvents(new JoinEvent(), this);
		getServer().getConsoleSender().sendMessage("[Luck]: Plugin is enabled.");
		
		
	}
	
	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage("[Luck]: Plugin is disabled.");
	}
}
