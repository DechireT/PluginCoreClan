package fr.dechiret.plugincoreclan;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

@SuppressWarnings("deprecation")
public class Inv implements Listener {
			
			public static Inventory Main(Player player) {
				
				Inventory inv = Bukkit.createInventory(null, 36, "§3            --- §cS§6h§ao§bp §3---");			
			
				/*ItemStack banque = new ItemStack(Material.PAPER, 1);
				ItemMeta banqueM = banque.getItemMeta();
				banqueM.setDisplayName("§6Banque");
				banqueM.setLore(Arrays.asList("1 XD","2 XD","3 XD"));              // papier banque custom
				banqueM.addEnchant(Enchantment.MENDING, 200, true);
				banqueM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				banque.setItemMeta(banqueM);*/
			
				ItemStack head = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
			
				SkullMeta meta = (SkullMeta) head.getItemMeta();
			
				meta.setOwningPlayer(player);
				meta.setDisplayName("§eInfomation sur §b" + player.getName());
				meta.setLore(Arrays.asList(" ",
					"§eJoueur: §b" + player.getName(),
					"§eUUID: §b" + player.getUniqueId(),
					"", 
					 "§eVie: §b" + player.getHealth(),
					 "§eNourriture: §b" + player.getFoodLevel(),
					 "§eXP: §b" + player.getLevel(),
					 " ",
					 "§ePosition: ",
					 "§eMonde: §b" + player.getWorld().getName(),
					 "§eX: §b" + player.getLocation().getX(),
					 "§eY: §b" + player.getLocation().getY(),
					 "§eZ: §b" + player.getLocation().getZ(),
					 "§eYaw: §b" + player.getLocation().getYaw(),
					 "§ePitch: §b" + player.getLocation().getPitch()
					 ));
			
				head.setItemMeta(meta);
			
				//player.getInventory().addItem(head);
				inv.setItem(0, head);
			
				inv.setItem(8, getItem("DechireT", "§cS§6h§ao§bp §dClan", "Version"));
			
				ItemStack dev = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
			
				SkullMeta metadev = (SkullMeta) head.getItemMeta();
			
				metadev.setOwner("DechireT");
				metadev.setDisplayName("§cS§6h§ao§bp §dClan");
				metadev.setLore(Arrays.asList(" ",
					"§aVersion: §b" + PluginMain.getVersion,
					"§aDeveloppeur: §b" + PluginMain.getDeveloppeur,
					"§aPour: " + "§cS§6h§ao§bp §dClan"
					 ));
			
				dev.setItemMeta(metadev);
			
				//player.getInventory().addItem(head);
				inv.setItem(8, dev);
			
				inv.setItem(20, getItem(Material.BONE, "§eLoot de Mob"));
				inv.setItem(22, getItem(Material.DIAMOND, "§bMinerai"));
				inv.setItem(24, getItem(Material.GLASS, "§aBlocks"));
			
				inv.setItem(35, getItem(Material.BARRIER, "§cFermer", "Pour fermer le shop"));
			
				player.openInventory(inv);
				return inv;			
			
			}
			
			public static Inventory Loot(Player player) {
			
				Inventory loot = Bukkit.createInventory(null, 27, "§c        --- §eLoot de Mob §c---");
			
				loot.setItem(11, getItem(Material.BONE, "§fOS §7(5$/u)", "(Clique pour acheter)"));
				loot.setItem(13, getItem(Material.BLAZE_POWDER, "§6Blaze Pouder §7(50$/u)", "(Clique pour acheter)"));
				loot.setItem(15, getItem(Material.GHAST_TEAR, "§flarme de gost §7(90$/u)", "(Clique pour acheter)"));		
			
				loot.setItem(26, getItem(Material.BARRIER, "§cFermer", "Pour fermer le shop"));
			
				player.openInventory(loot);
				return loot;
				}
			
				public static Inventory Blocks(Player player) {
				
					Inventory blocks = Bukkit.createInventory(null, 27, "§e          --- §aBlocks §e---");
				
					blocks.setItem(11, getItem(Material.OAK_WOOD, "Bois §7(2.5$/u)", "(Clique pour acheter)"));
					blocks.setItem(13, getItem(Material.DIRT, "§6Terre §7(2$/u)", "(Clique pour acheter)"));
					blocks.setItem(15, getItem(Material.GRASS_BLOCK, "§aBlock d'herbe §7(2$/u)", "(Clique pour acheter)"));		
				
					blocks.setItem(26, getItem(Material.BARRIER, "§cFermer", "Pour fermer le shop"));
				
					player.openInventory(blocks);
				return blocks;
			}
		
			public static Inventory Minerai(Player player) {
				
				Inventory minerai = Bukkit.createInventory(null, 27, "§3           --- §bMinerai §3---");
				
				minerai.setItem(9, getItem(Material.COAL, "§8Charbon §7(1$/u)", "(Clique pour acheter)"));
				minerai.setItem(10, getItem(Material.IRON_INGOT, "§fFer §7(8$/u)", "(Clique pour acheter)"));
				minerai.setItem(12, getItem(Material.GOLD_INGOT, "§eOr §7(10$/u)", "(Clique pour acheter)"));
				minerai.setItem(14, getItem(Material.DIAMOND, "§bDiamant §7(75$/u)", "(Clique pour acheter)"));
				minerai.setItem(16, getItem(Material.LAPIS_LAZULI, "§9Lapis lazuli §7(25$/u)", "(Clique pour acheter)"));
				minerai.setItem(17, getItem(Material.REDSTONE, "§cRedstone §7(15$/u)", "(Clique pour acheter)"));
			
			
				minerai.setItem(26, getItem(Material.BARRIER, "§cFermer", "Pour fermer le shop"));
				
				player.openInventory(minerai);
			
				return minerai;
			}
			
			public static Inventory Tp(Player player) {
				
				Inventory minerai = Bukkit.createInventory(null, 27, "§a        --- §eTéléportation §b---");
				
				minerai.setItem(11, getItem(Material.DIAMOND_HOE, "§aVers les Farms", "(Clique pour te téléporter)"));
				minerai.setItem(13, getItem(Material.IRON_SWORD, "§eVers les Factions", "(Clique pour te téléporter)"));
				minerai.setItem(15, getItem(Material.GRASS_BLOCK, "§bVers le Spawn", "(Clique pour te téléporter)"));
				
				minerai.setItem(26, getItem(Material.DIAMOND, "§cFermer", "(Clique pour fermer le menu)"));
				
				player.openInventory(minerai);
			
				return minerai;
			}
			
			
	
	public static ItemStack getItem(Material material, String customName, String customLore){
		ItemStack it = new ItemStack(material, 1);
		ItemMeta itM = it.getItemMeta();
		if(customName != null) itM.setDisplayName(customName);          // pour item custom
		itM.setLore(Arrays.asList(customLore));
		it.setItemMeta(itM);
		return it;
	}
	
	public static ItemStack getItem(Material material, String customName, String customLore, String customLore1){
		ItemStack itp = new ItemStack(material, 1);
		ItemMeta itpM = itp.getItemMeta();
		if(customName != null) itpM.setDisplayName(customName);          // pour item custom
		itpM.setLore(Arrays.asList(customLore, customLore1));
		itp.setItemMeta(itpM);
		return itp;
	}
		
	public static ItemStack getItem(Material material, String customName){
		ItemStack its = new ItemStack(material, 1);
		ItemMeta itsM = its.getItemMeta();
		if(customName != null) itsM.setDisplayName(customName);
		its.setItemMeta(itsM);
		return its;
			
		
	}		
	
	public static ItemStack getItem(String owner, String customName, String customLore){
		ItemStack sh = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
		SkullMeta sM = (SkullMeta) sh.getItemMeta();
		sM.setOwner(owner);
		if(customName != null) sM.setDisplayName(customName);          // pour item custom
		sM.setLore(Arrays.asList(customLore));
		sh.setItemMeta(sM);
		return sh;

	}
	
}
