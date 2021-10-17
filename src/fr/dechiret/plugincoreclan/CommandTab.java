package fr.dechiret.plugincoreclan;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class CommandTab implements TabCompleter {

	//private PluginMain main;
	
	List<String> list = new ArrayList<>();
	
	public CommandTab(PluginMain pluginMain) {
	}

	//@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		
		/*if(cmd.getName().equalsIgnoreCase("file")){
			if(args.length == 1) {
		
		List<String> list = Arrays.asList(ConfigManager.PlayerFile, ConfigManager.TicketFile, ConfigManager.ClanFile, ConfigManager.AllFiles);
		String input = args[0].toLowerCase();
		
		List<String> completions = null;
		for(String s : list) {
			if(s.startsWith(input)) {
				if(completions == null) {
					completions = new ArrayList();
				}
				
				completions.add(s);
			}
		
		}
		
		if(completions != null) {
			Collections.sort(completions);
		}
		return completions;
		}
			
		if(args.length == 2) {
				
		List<String> list = Arrays.asList("reload", "save", "delete");
		String input = args[1].toLowerCase();
				
		List<String> completions = null;
		for(String s : list) {
			if(s.startsWith(input)) {
				if(completions == null) {
					completions = new ArrayList();
				}
						
				completions.add(s);
			}
				
		}
				
		if(completions != null) {
			Collections.sort(completions);
		}
		return completions;
		}
	}*/
			
		
		return null;
		
	}

}
