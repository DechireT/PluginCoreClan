package fr.dechiret.plugincoreclan;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

/*mport java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;*/

public class ConfigManager {
	
	private static PluginMain plugin = PluginMain.getPlugin(PluginMain.class);
	
	//Files & files config
	
	private static FileConfiguration cfgPlayer;
	private static File playersfile;
	
	private static FileConfiguration cfgTicket;
	private static File ticketfile;
	
	private static FileConfiguration cfgClan;
	private static File clanfile;
	
	public static String PlayerFile = "player.yml";
	public static String TicketFile = "ticket.yml";
	public static String ClanFile = "clan.yml";
	public static String AllFiles = "all";
	
	//-------------------
	
	public static void setup() {
		if(!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdir();
		}
				
		playersfile = new File(plugin.getDataFolder(), PlayerFile);
		ticketfile = new File(plugin.getDataFolder(), TicketFile);
		clanfile = new File(plugin.getDataFolder(), ClanFile);
		
		if(!playersfile.exists()) {
			try {
				playersfile.createNewFile();
				Bukkit.getServer().getConsoleSender().sendMessage("§aLe fichier '" + PlayerFile + "' a bien ete cree !");
			}catch (IOException e) {
				Bukkit.getServer().getConsoleSender().sendMessage("§cLe fichier '" + PlayerFile + "' n'a pas ete cree !");
			}
		}
		
		if(!ticketfile.exists()) {
			try {
				ticketfile.createNewFile();
				Bukkit.getServer().getConsoleSender().sendMessage("§aLe fichier '" + TicketFile + "' a bien ete cree !");
			}catch (IOException e) {
				Bukkit.getServer().getConsoleSender().sendMessage("§cLe fichier '" + TicketFile + "' n'a pas ete cree !");
			}
		}
		
		if(!clanfile.exists()) {
			try {
				clanfile.createNewFile();
				Bukkit.getServer().getConsoleSender().sendMessage("§aLe fichier '" + ClanFile + "' a bien ete cree !");
			}catch (IOException e) {
				Bukkit.getServer().getConsoleSender().sendMessage("§cLe fichier '" + ClanFile + "' n'a pas ete cree !");
			}
		}
		
		cfgPlayer = YamlConfiguration.loadConfiguration(playersfile);
		cfgTicket = YamlConfiguration.loadConfiguration(ticketfile);
		cfgClan = YamlConfiguration.loadConfiguration(clanfile);
	}
	
	public static FileConfiguration getPlayers() {
		return cfgPlayer;
	}
	
	public static FileConfiguration getTicket() {
		return cfgTicket;
	}
	
	public static FileConfiguration getClan() {
		return cfgClan;
	}
	
	public static void saveFiles(String file) {
		
		if(file.equalsIgnoreCase(PlayerFile)) {
		try {
			cfgPlayer.save(playersfile);
			Bukkit.getServer().getConsoleSender().sendMessage("§aLe fichier '" + PlayerFile + "' a bien ete sauvgarde !");
		}catch (IOException e) {
			Bukkit.getServer().getConsoleSender().sendMessage("§cLe fichier '" + PlayerFile + "' n'a pas ete sauvgarde !");
		}
		}
		
		if(file.equalsIgnoreCase(TicketFile)) {
		try {
			cfgTicket.save(ticketfile);
			Bukkit.getServer().getConsoleSender().sendMessage("§aLe fichier '" + TicketFile + "' a bien ete sauvgarde !");
		}catch (IOException e) {
			Bukkit.getServer().getConsoleSender().sendMessage("§cLe fichier '" + TicketFile + "' n'a pas ete sauvgarde !");
		}
		}
		
		if(file.equalsIgnoreCase(ClanFile)) {
		try {
			cfgClan.save(clanfile);
			Bukkit.getServer().getConsoleSender().sendMessage("§aLe fichier '" + ClanFile + "' a bien ete sauvgarde !");
		}catch (IOException e) {
			Bukkit.getServer().getConsoleSender().sendMessage("§cLe fichier '" + ClanFile + "' n'a pas ete sauvgarde !");
		}
		}
		
		if(file.equalsIgnoreCase("all")) {
		try {
			cfgPlayer.save(playersfile);
			Bukkit.getServer().getConsoleSender().sendMessage("§aLe fichier '" + PlayerFile + "' a bien ete sauvgarde !");
		}catch (IOException e) {
			Bukkit.getServer().getConsoleSender().sendMessage("§cLe fichier '" + PlayerFile + "' n'a pas ete sauvgarde !");
		}
		try {
			cfgTicket.save(ticketfile);
			Bukkit.getServer().getConsoleSender().sendMessage("§aLe fichier '" + TicketFile + "' a bien ete sauvgarde !");
		}catch (IOException e) {
			Bukkit.getServer().getConsoleSender().sendMessage("§cLe fichier '" + TicketFile + "' n'a pas ete sauvgarde !");
		}
		try {
			cfgClan.save(clanfile);
			Bukkit.getServer().getConsoleSender().sendMessage("§aLe fichier '" + ClanFile + "' a bien ete sauvgarde !");
		}catch (IOException e) {
			Bukkit.getServer().getConsoleSender().sendMessage("§cLe fichier '" + ClanFile + "' n'a pas ete sauvgarde !");
		}
		}
	}
	
	public static void reloadFiles(String file) {
		
			if(file.equalsIgnoreCase(PlayerFile)) {
				cfgPlayer = YamlConfiguration.loadConfiguration(playersfile);
				Bukkit.getServer().getConsoleSender().sendMessage("§aLe fichier '" + PlayerFile + "' a bien ete redemare !");
			}
			
			if(file.equalsIgnoreCase(TicketFile)) {
				cfgTicket = YamlConfiguration.loadConfiguration(ticketfile);
				Bukkit.getServer().getConsoleSender().sendMessage("§aLe fichier '" + TicketFile + "' a bien ete redemare !");
			}
			
			if(file.equalsIgnoreCase(ClanFile)) {
				cfgClan = YamlConfiguration.loadConfiguration(clanfile);
				Bukkit.getServer().getConsoleSender().sendMessage("§aLe fichier '" + ClanFile + "' a bien ete redemare !");
			}
			
			if(file.equalsIgnoreCase("all")) {
				
				cfgPlayer = YamlConfiguration.loadConfiguration(playersfile);
				Bukkit.getServer().getConsoleSender().sendMessage("§aLe fichier '" + PlayerFile + "' a bien ete redemare !!");
				
				cfgTicket = YamlConfiguration.loadConfiguration(ticketfile);
				Bukkit.getServer().getConsoleSender().sendMessage("§aLe fichier '" + TicketFile + "' a bien ete redemare !");
				
				cfgClan = YamlConfiguration.loadConfiguration(clanfile);
				Bukkit.getServer().getConsoleSender().sendMessage("§aLe fichier '" + ClanFile + "' a bien ete redemare !");
			}
	}
	
}
