package fr.dechiret.plugincoreclan;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class menu implements Listener {
	
/*	@EventHandler
	public void onJoin(PlayerJoinEvent event){   ////////////////////////// quand un joueur rejoind le serveur on lui donnne :////////////////////////////////////////////
		Player player = event.getPlayer();
		
}*/
	
	@EventHandler
	public void onClick(InventoryClickEvent event){
		Player player = (Player) event.getWhoClicked();
		ItemStack current = event.getCurrentItem();
		
		//if(PluginMain.getInstance().economy.getBalance(player) > 0) {
		
		if(current == null) return;
		
		if(event.getView().getTitle().equalsIgnoreCase("§3            --- §cS§6h§ao§bp §3---")){	
		event.setCancelled(true);
		
		switch(current.getType()){        // quand on clique
		
		case BONE:
			player.openInventory(Inv.Loot(player));
			break;
		
		case DIAMOND:
			player.openInventory(Inv.Minerai(player));
			break;
		
		case GLASS:
			player.openInventory(Inv.Blocks(player));
			break;
					
		case BARRIER:
			player.closeInventory();
			break;

		default:
			break;
				}
		
	}
		
		if(event.getView().getTitle().equalsIgnoreCase("§c        --- §eLoot de Mob §c---")){	
			event.setCancelled(true);
			
			switch(current.getType()){
			
			case BONE:
				player.getInventory().addItem(getItem(Material.BONE));
				PluginMain.getInstance().economy.withdrawPlayer(player, 5);
				player.sendMessage("§c-5$");
				break;
			
			case BLAZE_POWDER:
				player.getInventory().addItem(getItem(Material.BLAZE_POWDER));
				PluginMain.getInstance().economy.withdrawPlayer(player, 50);
				player.sendMessage("§c-50$");
				break;
			
			case GHAST_TEAR:
				player.getInventory().addItem(getItem(Material.GHAST_TEAR));
				PluginMain.getInstance().economy.withdrawPlayer(player, 90);
				player.sendMessage("§c-90$");
				break;
						
			case BARRIER:
				player.closeInventory();
				break;

			default:
				break;
					}
			
		}
		
		if(event.getView().getTitle().equalsIgnoreCase("§e          --- §aBlocks §e---")){	
			event.setCancelled(true);
			
			switch(current.getType()){
			
			case OAK_WOOD:
				player.getInventory().addItem(getItem(Material.OAK_WOOD));
				PluginMain.getInstance().economy.withdrawPlayer(player, 2.5);
				player.sendMessage("§c-2.5$");
				break;
			
			case DIRT:
				player.getInventory().addItem(getItem(Material.DIRT));
				PluginMain.getInstance().economy.withdrawPlayer(player, 2);
				player.sendMessage("§c-2$");
				break;
			
			case GRASS_BLOCK:
				player.getInventory().addItem(getItem(Material.GRASS_BLOCK));
				PluginMain.getInstance().economy.withdrawPlayer(player, 2);
				player.sendMessage("§c-2$");
				break;
						
			case BARRIER:
				player.closeInventory();
				break;

			default:
				break;
					}
			
		}
		
		if(event.getView().getTitle().equalsIgnoreCase("§3           --- §bMinerai §3---")){
			event.setCancelled(true);
			
			switch(current.getType()){
			
			case COAL:
				player.getInventory().addItem(getItem(Material.COAL));
				PluginMain.getInstance().economy.withdrawPlayer(player, 1);
				player.sendMessage("§c-1$");
				break;
			
			case IRON_INGOT:
				player.getInventory().addItem(getItem(Material.IRON_INGOT));
				PluginMain.getInstance().economy.withdrawPlayer(player, 8);
				player.sendMessage("§c-8$");
				break;
			
			case GOLD_INGOT:
				player.getInventory().addItem(getItem(Material.GOLD_INGOT));
				PluginMain.getInstance().economy.withdrawPlayer(player, 10);
				player.sendMessage("§c-10$");
				break;
				
			case DIAMOND:
				player.getInventory().addItem(getItem(Material.DIAMOND));
				PluginMain.getInstance().economy.withdrawPlayer(player, 75);
				player.sendMessage("§c-75$");
				break;
			
			case LAPIS_LAZULI:
				player.getInventory().addItem(getItem(Material.LAPIS_LAZULI));
				PluginMain.getInstance().economy.withdrawPlayer(player, 25);
				player.sendMessage("§c-25$");
				break;
			
			case REDSTONE:
				player.getInventory().addItem(getItem(Material.REDSTONE));
				PluginMain.getInstance().economy.withdrawPlayer(player, 15);
				player.sendMessage("§c-15$");
				break;
						
			case BARRIER:
				player.closeInventory();
				break;

			default:
				break;
					}
		}
		
		if(event.getView().getTitle().equalsIgnoreCase("§a        --- §eTéléportation §b---")){	
			event.setCancelled(true);
			
			switch(current.getType()){
			
			case DIAMOND_HOE:
				player.chat("/mvtp fram");
				player.sendMessage("§eTéléportaion > §aVous avez été téléporté aux farms");
				break;
			
			case IRON_SWORD:
				player.chat("/mvtp faction");
				player.sendMessage("§eTéléportaion > §aVous avez été téléporté aux factions");
				break;
			
			case GRASS_BLOCK:
				player.chat("/mvtp world");
				player.sendMessage("§eTéléportaion > §aVous avez été téléporté au spawn");
				break;
						
			case BARRIER:
				player.closeInventory();
				break;

			default:
				break;
					}
			
		}
			
		}
	//}
	
	private static ItemStack getItem(Material material){
		ItemStack it = new ItemStack(material, 1);
		ItemMeta itM = it.getItemMeta();
		it.setItemMeta(itM);
		return it;
	}
}