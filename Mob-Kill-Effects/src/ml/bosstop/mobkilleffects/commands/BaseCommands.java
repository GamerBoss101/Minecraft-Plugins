package ml.bosstop.mobkilleffects.commands;

import java.util.Collection;

import ml.bosstop.mobkilleffects.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

public class BaseCommands implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private Main plugin;
	
	public BaseCommands(Main plugin){
		this.plugin = plugin;
		plugin.getCommand("modkilleffect").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		String prefix = "&f[&3MobKillEffects&f] ";
				
		if(!(sender instanceof Player)){
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&cOnly players Can execute this command"));
			return true;
		}		
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("modkilleffect")) {
			
			if(args.length == 0) {
				
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&4Use /mke help for commands"));
				
			} else if(args.length == 1) {
				
				if(args[0].equalsIgnoreCase("help")) {
					
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', 
							"&f==============================\n"
							+ prefix + "&cHelp\n"
							+ "&a/mke help : &6Gives help on commands.\n"
							+ "&a/mke info : &6Shows plugin info and Version Number\n"
							+ "&a/mke clear : &6Clears all Potion Effects\n"
							+ "&f=============================="
							));
					
					return true;
					
				} else if(args[0].equalsIgnoreCase("clear")) {
					
					Collection<PotionEffect> effects = p.getActivePotionEffects();
					
					  effects.stream()
					    .map(PotionEffect::getType)
					    .forEach(p::removePotionEffect);
					
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&aAll Effects have been cleared"));
					
					return true;
					
				} else if(args[0].equalsIgnoreCase("info")) {
					
					p.sendMessage(ChatColor.translateAlternateColorCodes('&',
							"&f=========================\n"
							+ "&aMob Kill Effects v1.4\n"
							+ "&6Author: GamerBoss101\n"
							+ "Description: Everytime you kill a Mob you get a potion\n"
							+ "effect\n"
							+ "&f========================="
							));
					
					return true;
					
				} else {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&4Could not find that command. Use /mke help for commands"));
				}	
			}
			return true;
		}
		return false;
	}
}
