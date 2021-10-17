package fr.dechiret.plugincoreclan;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class listeners implements Listener {

	//private PluginMain main;

	//public listeners(PluginMain varr) {
	//this.main = varr;
	//}

	/*@EventHandler
	public void onJoin(PlayerJoinEvent event){   ////////////////////////// quand un joueur rejoind le serveur on lui donnne :////////////////////////////////////////////
		Player player = event.getPlayer();
		
		PacketPlayOutTitle title = new PacketPlayOutTitle(EnumTitleAction.TITLE,ChatSerializer.a(" {\"text\":\"B\",\"color\":\"#FF504E\"},"
				+ "{\"text\":\"i\",\"color\":\"#FAA300\"},{\"text\":\"e\",\"color\":\"#F5FF00\"},{\"text\":\"n\",\"color\":\"#39FA00\"},"
				+ "{\"text\":\"v\",\"color\":\"#00FA97\"},{\"text\":\"e\",\"color\":\"#009DF1\"},{\"text\":\"n\",\"color\":\"#000BFF\"},"
				+ "{\"text\":\"u\",\"color\":\"#8700F5\"},{\"text\":\"e\",\"color\":\"#FB0070\"}"),140,40,20);
		((CraftPlayer) player).getHandle().playerConnection.sendPacket(title);
	
	 player.launchProjectile(Fireball.class);
	
	
	
	}*/
	 
	
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event){
		
		Player player = event.getPlayer();
		
		//TextComponent msg = new TextComponent("§aSalut "  + player.getName() + ", n'hesite pas a faire §b/tete {joueur}");
		//TextComponent msg2 = new TextComponent("§aou §b/tete {joueur} {description} §a pour avoir une tête");
		
		//msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§cFais §b/tete").create()));
		//msg.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/tete " + player.getName()));		
		//msg2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§cFais §b/tete {Joueur} {Description}").create()));
		//msg2.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/tete " + player.getName() + " Voici la tête de {player}"));
		
		
		ItemStack tp = new ItemStack(Material.COMPASS);
		
		ItemMeta meta = tp.getItemMeta();
		
		meta.setDisplayName("�a~ �b~ �eT�l�portation �b~ �a~");
		meta.setLore(Arrays.asList("Pour se t�l�porter a differents endroits", "(Clique)"));
		
		tp.setItemMeta(meta);
		
		player.getInventory().addItem(tp);
		//player.spigot().sendMessage(msg);
		//player.spigot().sendMessage(msg2);
		
	}
		/*@EventHandler
		public void drop(PlayerDropItemEvent event) {
		Item bookd = event.getItemDrop();
		ItemStack it = event.getItemDrop().getItemStack();
		
		if (it.getType() == Material.WRITTEN_BOOK && it.getItemMeta().getDisplayName().equalsIgnoreCase("Serveur")) {
		   //if (it.getType().equals(Material.matchMaterial(""))) {
		    //return; 
			   
		  bookd.setCustomName("custom-drop-name.name");
		  bookd.setCustomNameVisible(true);
		    	//}
			} 	
		}	
		
		@EventHandler
	    public void onInteract(PlayerInteractEvent event) {

	        //Player player = event.getPlayer();
	        Action action = event.getAction();
	        Player player = event.getPlayer();
	        
	        ItemStack it = event.getItem();
			if(it == null) return;        	        

	        if (it.getType() == Material.FIRE_CHARGE && action == Action.RIGHT_CLICK_BLOCK || it.getType() == Material.FIRE_CHARGE && action == Action.RIGHT_CLICK_AIR) {

	                
	                player.launchProjectile(Fireball.class);
	                
	            }
	            
	            if (event.getClickedBlock() != null && action == Action.RIGHT_CLICK_BLOCK) {

	            BlockState bs1 = event.getClickedBlock().getState();
	            if (bs1 instanceof Sign) {
	                Sign sign = (Sign) bs1;

	                if (sign.getLine(0).equalsIgnoreCase("##") && sign.getLine(1).equalsIgnoreCase("serveur") && sign.getLine(3).equalsIgnoreCase("##")) {
	                	
	                	sign.setLine(0, ChatColor.RED + "---------------");
	                	sign.setLine(1, ChatColor.YELLOW + "Serveur");//"§cS§6e§ev§ae§bu§dr");
	                	sign.setLine(2, "");
	                	sign.setLine(3, ChatColor.RED + "---------------");
	                	sign.update();
	                } 	
	                	
	               if (sign.getLine(0).equalsIgnoreCase("|--|") && sign.getLine(3).equalsIgnoreCase("|--|")) {
		               	
		               	sign.setLine(0, ChatColor.YELLOW + "|--------------|");
		               	sign.setLine(1, ChatColor.BLUE + sign.getLine(1));//"§cS§6e§ev§ae§bu§dr");
		               	sign.setLine(2, ChatColor.GREEN + player.getName());
		               	sign.setLine(3, ChatColor.YELLOW + "|--------------|");
		               	sign.update();
		                
	               }
	            }
	        }    //New BukkitRunnable || .runTaskTime(PluginMain.getInstance(), 0, 20); 
		}*/
		
		@EventHandler
		public void OnChat(AsyncPlayerChatEvent e) {
			Player player = e.getPlayer();
			if(e.getMessage().toLowerCase().startsWith("#admin")) {
			if(player.hasPermission("pl.admin.chat") || player.hasPermission("pl.admin")) {
				
				e.setCancelled(true);
				
				for(Player players : Bukkit.getOnlinePlayers()) {
					if(players.hasPermission("pl.admin.chat") || player.hasPermission("pl.admin")) {
						player.sendMessage("§7[§eAdmin Chat§7]§6 " + player.getName() + "§f:§c " + e.getMessage().substring(7));
					}
				}
				
				}
			}
			if(e.getMessage().startsWith("!!") && e.getMessage().endsWith("!!")) {
				if(player.hasPermission("pl.admin.alert") || player.hasPermission("pl.admin")) {
				e.setCancelled(true);
				
						Bukkit.broadcastMessage("§6[§c⚠§e Alerte §c⚠§6] §c" + e.getMessage().replace("!! ", "").replace(" !!", "") + " §6[§c⚠§e Alerte §c⚠§6]");
						
				}
			}
		}
		
		/*@EventHandler
		public void onQuit(PlayerQuitEvent event){		
			Player player = event.getPlayer();
			Location loc = player.getLocation();
			
			ConfigManager.getPlayers().set("Connceted.player." + player.getName() + ".pos.World", loc.getWorld().getName());			
			ConfigManager.getPlayers().set("Connceted.player." + player.getName() + ".pos.X", loc.getX());
			ConfigManager.getPlayers().set("Connceted.player." + player.getName() + ".pos.Y", loc.getY());
			ConfigManager.getPlayers().set("Connceted.player." + player.getName() + ".pos.Z", loc.getZ());
			ConfigManager.getPlayers().set("Connceted.player." + player.getName() + ".pos.Yaw", loc.getYaw());
			ConfigManager.getPlayers().set("Connceted.player." + player.getName() + ".pos.Pitch", loc.getPitch());
			
			//ConfigManager.getPlayers().set("Connceted.player." + player.getName(), 1);
			ConfigManager.getPlayers().set("Connceted.player." + player.getName() + ".connected", false);
			ConfigManager.saveFiles(ConfigManager.PlayerFile);
		}
	}


   // code panneaux
	/*@EventHandler
    public void onInteract(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        Action action = event.getAction();
        if (event.getClickedBlock() != null && action == Action.RIGHT_CLICK_BLOCK) {

            BlockState bs = event.getClickedBlock().getState();
            if (bs instanceof Sign) {
                Sign sign = (Sign) bs;

                if (sign.getLine(0).equalsIgnoreCase("demarrer le") && sign.getLine(1).equalsIgnoreCase("mini mini jeu") && sign.getLine(2).equalsIgnoreCase("§4shoot")) {

                    // c'est la qu'il y'a le mini jeu

                    Main.setState(states.PLAYING);
                    player.sendMessage("Le mini jeu demarre dans 5 secondes");
                    Bukkit.getScheduler().runTaskTimer(this, new BukkitRunnable() {

                        @Override
                        public void run() {
                            player.sendMessage("bientot");
                        }
                    }, 100);

                }
            }*/

	}

/*ItemStack glass = new ItemStack(Material.GLASS);
		ItemMeta IM = glass.getItemMeta();
		IM.setUnbreakable(true);
		glass.setItemMeta(IM);
		
		player.getInventory().setHelmet(glass);*/

		/*ItemStack sog = new ItemStack(Material.BLAZE_ROD, 1);
		ItemMeta sogM = sog.getItemMeta();
		sogM.setDisplayName("§eStick Of God");
		sogM.setLore(Arrays.asList(" "));
		sogM.addEnchant(Enchantment.MENDING, 200, true);
		sogM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		//sog.setDurability((short) 5);
		sog.setItemMeta(sogM);
		player.getInventory().addItem(sog);
		player.updateInventory();*/
		
			
	

