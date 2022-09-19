package com.itsnottim.commands.coms;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ComsTest implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) { return true; }
		Player player = (Player) sender;
		
		//give jumpboost, 3 mins, amplifier 2
		if (cmd.getName().equalsIgnoreCase("jump")) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 3600, 2));
		}
		
		//give strength, 3 mins, amp 2
		else if (cmd.getName().equalsIgnoreCase("strength")) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 3600, 2));
		}
		return true;
		
		//args is the number of command arguments
		//for example: /strength 2 has args array length 2
		// /strength 2 ItsNotTim has args array length 3
	}
}
