package com.itsnottim.luck.events;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class MobDropEvents implements Listener{
	
	@EventHandler
	public void mobDeath(EntityDeathEvent event) {
		//clear mob drops
		//event.getDrops().clear();
		
		LivingEntity e = event.getEntity();
		if (e instanceof Enderman) {
			event.getDrops().clear();
			//%70
			Random random = new Random();
			if (random.nextInt(10) > 2) {
				
				e.getLocation().getWorld().dropItem(e.getLocation(), new ItemStack(Material.ENDER_PEARL));
			}
			
		}
		
		if (e instanceof Blaze) {
			event.getDrops().clear();
			//%70
			Random random = new Random();
			if (random.nextInt(10) > 2) {
				e.getLocation().getWorld().dropItem(e.getLocation(), new ItemStack(Material.BLAZE_ROD));
			}
		}
	}
}
