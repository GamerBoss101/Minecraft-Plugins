package ml.bosstop.deathrun.commands;

import ml.bosstop.deathrun.Main;
import ml.bosstop.deathrun.util.Util;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class commands implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private Main plugin;
	
	public commands(Main plugin){
		this.plugin = plugin;
		plugin.getCommand("deathrun").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		String prefix = "&f[&DeathRun&f] ";
				
		if(!(sender instanceof Player)){
			sender.sendMessage(Util.Color(prefix + "&cOnly players Can execute this command"));
			return true;
		}		
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("deathrun")) {
			
			if(args.length == 0) {
				
				p.sendMessage(Util.Color(prefix + "&4Use /mke help for commands"));
				
			} else if(args.length == 1) {
				
				if(args[0].equalsIgnoreCase("help")) {
					
					p.sendMessage(Util.Color(
							  "&f==============================\n"
							+ "&aDeath Run &cHelp\n"
							+ "&a/mke help : &6Gives help on commands.\n"
							+ "&a/mke info : &6Shows plugin info and Version Number\n"
							+ "&a/mke clear : &6Clears all Potion Effects\n"
							+ "&f=============================="
							));
					
					return true;
					
				} else if(args[0].equalsIgnoreCase("info")) {
					
					p.sendMessage(Util.Color(
							  "&f=========================\n"
							+ "&aDeath Run v1.0\n"
							+ "&6Author: Sir_Blob_\n"
							+ "Description: First one to Die Wins\n"
							+ "effect\n"
							+ "&f========================="
							));
					
					return true;
					
				} else {
					p.sendMessage(Util.Color(prefix + "&4Could not find that command. Use /dr help for commands"));
				}	
			}
			return true;
		}
		return false;
	}
}