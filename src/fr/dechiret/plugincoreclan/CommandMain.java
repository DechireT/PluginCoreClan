package fr.dechiret.plugincoreclan;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

@SuppressWarnings("deprecation")
public class CommandMain implements CommandExecutor {

	//private PluginMain main;
	//private ConfigManager cfgm;
	
	private static int nb;
	@SuppressWarnings("unused")
	private static ArrayList<String> playersList = new ArrayList<String>();

	public CommandMain(PluginMain pluginMain) {
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("clan")) {
			@SuppressWarnings("unused")
			Player player = (Player)sender;
			
			if(args.length == 0) {
				sender.sendMessage(ChatColor.RED + "/clan {parametre}");
			}
			
			if(args.length > 1) {
				if(args[0].equalsIgnoreCase("create") || (sender.hasPermission("pcc.admin") || sender.hasPermission("pcc.create"))) {
					
					if(args.length == 2) {
						if(ConfigManager.getClan().get("clan.nb") != null ) {
							nb = ConfigManager.getClan().getInt("clan.nb");
							sender.sendMessage(ChatColor.RED + "ConfigManager.getClan().get(\"clan.nb\") != null");
						}else {
							sender.sendMessage(ChatColor.RED + "ConfigManager.getClan().get(\"clan.nb\") = null");
							ConfigManager.getClan().set("clan.nb", "test");
							nb = ConfigManager.getClan().getInt("clan.nb");
						}
						nb = nb++;
						ConfigManager.getClan().set("clan.nb", nb);
						ConfigManager.getClan().set("clan", args[0]);
						
						//if(sender instanceof Player) {
						//	if(ConfigManager.getClan().get("clan." + args[0] + ".players") != null) {
						//		playersList.add(player.toString());
						//		playersList.add((String) ConfigManager.getClan().get("clan." + args[0] + ".players"));
						//		ConfigManager.getClan().set("clan." + args[0] + ".players", playersList);
						//	}
						//	ConfigManager.getClan().set("clan." + args[0] + ".players", player);
						//}
						
					}else {
						sender.sendMessage(ChatColor.RED + "/clan create {name}");
					}
					
				}else
				if(args[0].equalsIgnoreCase("join")) {
						
				}else			
				if(args[0].equalsIgnoreCase("settown") || (sender.hasPermission("pcc.admin") || sender.hasPermission("pcc.settown"))) {
					
				}else
				if(args[0].equalsIgnoreCase("leave")) {
					
				}else
				if(args[0].equalsIgnoreCase("town")) {
						
				}
			}
			
		}
		
		if(cmd.getName().equalsIgnoreCase("guerre")) {
			
		}
		
		if(cmd.getName().equalsIgnoreCase("file")) {
			Player player = (Player)sender;
			
			if(args.length == 0) {
				if(sender instanceof Player) {
					player.sendMessage("§c/File {file}");
				}else {
					Bukkit.getServer().getConsoleSender().sendMessage("§c/File {file}");
				}
			}
			
			if(args.length >= 1) {
			
			if(args[1].equalsIgnoreCase("reload")) {
				ConfigManager.reloadFiles(args[0]);
				if(sender instanceof Player) {
					player.sendMessage("§aLe fichier '" + args[0] + "' à bien été redemaré !");
				}else {
					Bukkit.getServer().getConsoleSender().sendMessage("§aLe fichier '" + args[0] + "' a bien ete redemare !");
				}
			}else
			if(args[1].equalsIgnoreCase("save")) {
				ConfigManager.saveFiles(args[0]);
				if(sender instanceof Player) {
					player.sendMessage("§aLe fichier '" + args[0] + "' à bien été sauvgardé !");
				}else {
					Bukkit.getServer().getConsoleSender().sendMessage("§aLe fichier '" + args[0] + "' a bien ete redemare !");
				}
			}else
			if(args[1].equalsIgnoreCase("delete")) {
				if(sender instanceof Player) {
					player.sendMessage("§aLe fichier '" + args[0] + "' à bien été supprimé !");
				}else {
					Bukkit.getServer().getConsoleSender().sendMessage("§aLe fichier '" + args[0] + "' a bien ete supprime !");
				}
				
			}
		}
		}
			
			if(sender instanceof Player) {
				Player player = (Player)sender;
			if(label.equalsIgnoreCase("tete")) {
								
				if(args.length == 0) {
					player.sendMessage("§cCommande: /tete {Joueur} {Description}");
					player.sendMessage("§eExemple: /tete DechireT &eVoici la tête de &b{player}");
				}
				
				if(args.length == 1) {
					
					
					ItemStack head = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
					
					SkullMeta meta = (SkullMeta) head.getItemMeta();
					
					meta.setOwner(args[0]);
					meta.setDisplayName(args[0]);
					
					head.setItemMeta(meta);
					
					player.getInventory().addItem(head);
					
						}
				if(args.length >= 2) {
					
					/*StringBuilder tete = new StringBuilder();
					for(String d : args) {
						tete.append(d + " ");
						}*/
					
					String tete = "";
					for(int i = 1; i < args.length; i++) {
						tete += args[i] + " ";
						}
					
					ItemStack head = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
					
					SkullMeta meta = (SkullMeta) head.getItemMeta();
					
					meta.setOwner(args[0]);
					meta.setDisplayName(args[0]);				
					meta.setLore(Arrays.asList(tete.toString().replace("{player}", args[0]).replace("&", "§")));
					head.setItemMeta(meta);
					
					player.getInventory().addItem(head);    	
					player.updateInventory();
					
					}
				
				
			}		
			
			
			/*if(cmd.getName().equalsIgnoreCase("ticket")){
				
			if(args.length == 0) {
				player.sendMessage("§c/ticket {raison}");
			}
			if(args.length >= 1) {
				
				StringBuilder ticket = new StringBuilder();
				for(String raison : args) {
					ticket.append(raison + " ");
					}
				Bukkit.broadcastMessage("§c" + player.getName() + " §ea ouvert un ticket. Raison: §c" + ticket.toString());
				
				ItemStack ticketit = new ItemStack(Material.PAPER, 1);
				ItemMeta ticketitM = ticketit.getItemMeta();
				ticketitM.setDisplayName("§eTicket");
				ticketitM.setLore(Arrays.asList(" ", "§eTu as ouvert un ticket !","§eRaison:", "§c" + ticket.toString()));
				ticketitM.addEnchant(Enchantment.MENDING, 200, true);
				ticketitM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				ticketit.setItemMeta(ticketitM);
				player.getInventory().addItem(ticketit);    
				
				player.updateInventory();
				
				}
			}*/
			
			if(cmd.getName().equalsIgnoreCase("shop")){
				player.openInventory(Inv.Main(player));
				//player.sendMessage("Money:" + main.economy.getBalance(player));
			}
			
			if(cmd.getName().equalsIgnoreCase("wraptp")) {
				player.openInventory(Inv.Tp(player));
			}
		
		}
		
		return true;
	}
}


