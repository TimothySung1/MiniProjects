package com.itsnottim.luck.events;

import java.util.List;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PiglinBarterEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

public class PiglinTradeEvent implements Listener {
	@EventHandler
	public void piglinTrade(PiglinBarterEvent event) {
		//LivingEntity piglin = event.getEntity();
		List<ItemStack> lootTable = event.getOutcome();
		lootTable.clear();
		
		//this drops all of them, so do random and if statements to only drop some
		Random random = new Random();
		//0-499
		int roll = random.nextInt(500);
		//roll = 25;
		//8% epearl drop 25
		if (roll < 40) {
			//roll again for quantity
			int roll2 = random.nextInt(3) + 2;
			for (int i = 0; i < roll2; i++) {
				lootTable.add(new ItemStack(Material.ENDER_PEARL));
			}
		}
		//enchantment book (soul speed) 5
		if (roll >= 40 && roll < 45) {
			
			ItemStack book = new ItemStack(Material.ENCHANTED_BOOK);
			//roll for enchantment level (1-3)
			int roll2 = random.nextInt(3) + 1;
			ItemMeta bMeta = book.getItemMeta();
			EnchantmentStorageMeta bookMeta = (EnchantmentStorageMeta) bMeta;
			bookMeta.addStoredEnchant(Enchantment.SOUL_SPEED, roll2, true);
			//book.addEnchantment(Enchantment.SOUL_SPEED, roll2);
			book.setItemMeta(bMeta);
			lootTable.add(book);
			//ItemStack justcause = new ItemStack(Material.IRON_AXE);
			//lootTable.add(justcause);
		}
		//iron boots soul speed 9
		else if (roll >= 45 && roll < 54) {
			ItemStack boots = new ItemStack(Material.IRON_BOOTS);
			//roll for enchantment level (1-3)
			int roll2 = random.nextInt(3) + 1;
			boots.addEnchantment(Enchantment.SOUL_SPEED, roll2);
			lootTable.add(boots);
		}
		//splash fire res 9
		else if (roll >= 54 && roll < 63) {
			ItemStack splash = new ItemStack(Material.SPLASH_POTION);
			//180 second duration (3600 ticks, 20 ticks per second, 3 minutes)
			ItemMeta meta = splash.getItemMeta();
			PotionMeta pmeta = (PotionMeta) meta;
			//pmeta.addCustomEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 3600, 1), true);
			PotionData pdata = new PotionData(PotionType.FIRE_RESISTANCE);
			pmeta.setBasePotionData(pdata);
			splash.setItemMeta(meta);
			lootTable.add(splash);
		}
		//fire res pot 9
		else if (roll >= 63 && roll < 72) {
			ItemStack potion = new ItemStack(Material.POTION);
			//180 second duration (3600 ticks, 20 ticks per second, 3 minutes)
			ItemMeta meta = potion.getItemMeta();
			PotionMeta pmeta = (PotionMeta) meta;
			PotionData pdata = new PotionData(PotionType.FIRE_RESISTANCE);
			//((PotionMeta)potion.getItemMeta()).addCustomEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 3600, 1), true);
			pmeta.setBasePotionData(pdata);
			potion.setItemMeta(meta);
			lootTable.add(potion);
		}
		//water bottle 11
		else if (roll >= 72 && roll < 83) {
			ItemStack bottle = new ItemStack(Material.POTION);
			//((PotionMeta)bottle.getItemMeta()).setBasePotionData(new PotionData(PotionType.WATER));
			//lootTable.add(bottle);
			ItemMeta meta = bottle.getItemMeta();
			PotionMeta pmeta = (PotionMeta) meta;
			PotionData pdata = new PotionData(PotionType.WATER);
			pmeta.setBasePotionData(pdata);
			bottle.setItemMeta(meta);
			lootTable.add(bottle);
		}
		//iron nugget 11
		else if (roll >= 83 && roll < 94) {
			ItemStack ironNugget = new ItemStack(Material.IRON_NUGGET);
			//roll again to determine quantity (10 - 36)
			int roll2 = random.nextInt(27) + 10;
			for (int i = 0; i < roll2; i++) {
				lootTable.add(ironNugget);
			}
		}
		//string 21
		else if (roll >= 94 && roll < 115) {
			ItemStack string = new ItemStack(Material.STRING);
			//roll for quantity (3 - 9)
			int roll2 = random.nextInt(7) + 3;
			for (int i = 0; i < roll2; i++) {
				lootTable.add(string);
			}
		}
		//netherquartz 21
		else if (roll >= 115 && roll < 136) {
			ItemStack quartz = new ItemStack(Material.QUARTZ);
			//roll for q (5 - 12)
			int roll2 = random.nextInt(8) + 5;
			for (int i = 0; i < roll2; i++) {
				lootTable.add(quartz);
			}
		}
		//obsidian 40
		else if (roll >= 136 && roll < 176) {
			ItemStack obsidian = new ItemStack(Material.OBSIDIAN);
			lootTable.add(obsidian);
		}
		//crying obsidian 40
		else if (roll >= 176 && roll < 216) {
			ItemStack crying = new ItemStack(Material.CRYING_OBSIDIAN);
			//roll for q (1 - 3)
			int roll2 = random.nextInt(3) + 1;
			for (int i = 0; i < roll2; i++) {
				lootTable.add(crying);
			}
		}
		//fire charge 40
		else if (roll >= 216 && roll < 256) {
			ItemStack charge = new ItemStack(Material.FIRE_CHARGE);
			lootTable.add(charge);
		}
		//leather 40
		else if (roll >= 256 && roll < 296) {
			ItemStack leather = new ItemStack(Material.LEATHER);
			//roll for q (2-4)
			int roll2 = random.nextInt(3) + 2;
			for (int i = 0; i < roll2; i++) {
				lootTable.add(leather);
			}
		}
		//soul sand 40
		else if (roll >= 296 && roll < 336) {
			ItemStack soulSand = new ItemStack(Material.SOUL_SAND);
			//roll for q (2-8)
			int roll2 = random.nextInt(7) + 2;
			for (int i = 0; i < roll2; i++) {
				lootTable.add(soulSand);
			}
		}
		//nether brick 41
		else if (roll >= 336 && roll < 377) {
			ItemStack netherBrick = new ItemStack(Material.NETHER_BRICK);
			//roll for q (2-8)
			int roll2 = random.nextInt(7) + 2;
			for (int i = 0; i < roll2; i++) {
				lootTable.add(netherBrick);
			}
		}
		//spectral arrow 41
		else if (roll >= 377 && roll < 418) {
			ItemStack spectral = new ItemStack(Material.SPECTRAL_ARROW);
			//roll for q (6 - 12)
			int roll2 = random.nextInt(7) + 6;
			for (int i = 0; i < roll2; i++) {
				lootTable.add(spectral);
			}
		}
		//gravel 41
		else if (roll >= 418 && roll < 459) {
			ItemStack gravel = new ItemStack(Material.GRAVEL);
			//roll for q (8 - 16)
			int roll2 = random.nextInt(9) + 8;
			for (int i = 0; i < roll2; i++) {
				lootTable.add(gravel);
			}
		}
		//blackstone 41
		else if (roll >= 459) {
			ItemStack blackstone = new ItemStack(Material.BLACKSTONE);
			//roll for q (8 - 16)
			int roll2 = random.nextInt(9) + 8;
			for (int i = 0; i < roll2; i++) {
				lootTable.add(blackstone);
			}
		}
	}
}
