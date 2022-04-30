package ml.bosstop.core.comands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ml.bosstop.core.Main;
import ml.bosstop.core.util.Chat;

public class rules implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private Main plugin;
	
	public rules(Main plugin){
		this.plugin = plugin;
		plugin.getCommand("rule").setExecutor(this);
	}
	
	String[] rules = {
			
			"Be Kind", 
			"No Killing people repeatedly for no reason (Spawn Killing)", 
			"Have Fun! <3"
			};
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)){
			
			if(args.length == 0) {
				
				String rulesEmbed = "";
				
				for (int i = 0; i < rules.length; i++) {
					
					int rulenumber = i + 1;
					
					rulesEmbed +=  "&7" + rulenumber + ". " + rules[i] + "\n";
				}
				
				sender.sendMessage(Chat.Color(Chat.prefix + "&aRules\n" + rulesEmbed));
				
			} else if(args.length >= 1) {
				
				int rulenumber = Integer.parseInt(args[0]);
				
				String  ruletext = rules[rulenumber - 1];
				
				if(ruletext != null) {
					sender.sendMessage(Chat.Color(Chat.prefix + "&aRule: &7" + rules[rulenumber - 1]));
					return true;
				}
				
				sender.sendMessage(Chat.Color(Chat.prefix + "&cRule not found"));
				
			}
			return true;
		}
		
		Player p = (Player) sender;
		
        if(cmd.getName().equalsIgnoreCase("rules")) {
			
			if(args.length == 0) {
				
				String rulesEmbed = "";
				
				for (int i = 0; i < rules.length; i++) {
					
					int rulenumber = i + 1;
					
					rulesEmbed +=  "&7" + rulenumber + ". " + rules[i] + "\n";
				}
				
				Bukkit.getServer().broadcastMessage(Chat.Color(Chat.prefix + "&aRules\n" + rulesEmbed));
				
			} else if(args.length >= 1) {
				
				int rulenumber = Integer.parseInt(args[0]);
				
				String  ruletext = rules[rulenumber - 1];
				
				if(ruletext != null) {
					Bukkit.getServer().broadcastMessage(Chat.Color(Chat.prefix + "&aRule: &7" + rules[rulenumber - 1]));
					return true;
				}
				
				p.sendMessage(Chat.Color(Chat.prefix + "&cRule not found"));
				
			}
		}
		
		return false;
	}

}
