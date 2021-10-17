package fr.dechiret.plugincoreclan;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import net.milkbowl.vault.economy.Economy;

public class PluginMain extends JavaPlugin {

	public static PluginManager pm = Bukkit.getPluginManager();
	public Economy economy = null;	
	private static PluginMain instance;
	
	public static String getVersion = "Beta"; 
	public static String getDeveloppeur = "DechireT";

	
	@Override
	public void onEnable() {
		
		if(!setupEconomy()) {
			System.out.println("You must have Vault and an Economy pluin installed");
			getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "[PluginCoreClan] " + ChatColor.RED + "--------------------------------------------------");
			getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "[PluginCoreClan] " + ChatColor.RED + "You must have Vault and an Economy pluin installed");
			getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "[PluginCoreClan] " + ChatColor.RED + "--------------------------------------------------");
		}
		
		//saveDefaultConfig();
		
		instance = this;
		ConfigManager.setup();
		
		//cfgm.getPlayers().set("test.test", "65");
		
		System.out.println("[PluginCoreClan] " + "Demarrage !");
		getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "[PluginCoreClan] " + ChatColor.GREEN + "Demarrage");
		
		//loadConfigManager();
				
		//getCommand("ticket").setExecutor(new CommandMain(this));
		//getCommand("ticket").setTabCompleter(new CommandTab(this));
		getCommand("tete").setExecutor(new CommandMain(this));
		//getCommand("tete").setTabCompleter(new CommandTab(this));
		//getCommand("file").setExecutor(new CommandMain(this));
		//getCommand("file").setTabCompleter(new CommandTab(this));
		getCommand("shop").setExecutor(new CommandMain(this));
		getCommand("clan").setExecutor(new CommandMain(this));
		//getCommand("clan").setTabCompleter(new CommandTab(this));
		//getCommand("guerre").setExecutor(new CommandMain(this));
		//getCommand("guerre").setTabCompleter(new CommandTab(this));
		getServer().getPluginManager().registerEvents(new listeners(), this);

		getServer().getPluginManager().registerEvents(new menu(), this);
		
	}
	
	public static PluginMain getInstance() {
		return instance;
	}
	
	/*public void loadConfigManager() {
		ConfigManager.setup();
		
		ConfigManager.getPlayers().set("test.1.2.3.final", 65);
		//cfgm.getPlayers().addDefault("test.1", 0);
		
		ConfigManager.saveFiles(ConfigManager.AllFiles);
		ConfigManager.reloadFiles(ConfigManager.AllFiles);
	}*/
	
	public boolean setupEconomy() {
		RegisteredServiceProvider<Economy> eco = getServer().getServicesManager().getRegistration(Economy.class);
		if(eco != null) {
			economy = eco.getProvider();
		}
		return economy != null;
	}
	
	
	@Override
	public void onDisable() {
		System.out.println("[PluginCoreClan] " + "arret");
		getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "[PluginCoreClan] " + ChatColor.RED  + "Arret");
	}

}
