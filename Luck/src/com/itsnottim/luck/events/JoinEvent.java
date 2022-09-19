package com.itsnottim.luck.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.md_5.bungee.api.ChatColor;

public class JoinEvent implements Listener{
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		player.sendMessage(ChatColor.BLUE + "Dummy stupid");
		player.sendTitle(ChatColor.BLUE + "What the dog doing?", ChatColor.DARK_AQUA + "Ong on my mama", 10, 70, 20);
	}
}
