package ml.bosstop.core.comands;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ml.bosstop.core.Main;
import ml.bosstop.core.util.Chat;

public class tpa implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private Main plugin;
	
	public tpa(Main plugin){
		this.plugin = plugin;
		plugin.getCommand("tpa").setExecutor(this);
	}
	
	private static HashMap<UUID, UUID> requests = new HashMap<>();
	private static HashMap<String, Long> cooldowns = new HashMap<String, Long>();
	private static HashMap<Player, Location> back = new HashMap<Player, Location>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)){
			sender.sendMessage(Chat.Color(Chat.prefix + "&cOnly players Can execute this command"));
			return true;
		}
		
		Player p = (Player) sender;
		
        int cooldownTime = 5; // Get number of seconds from wherever you want
        if(cooldowns.containsKey(p.getName())) {
            long secondsLeft = ((cooldowns.get(p.getName()) / 1000) + cooldownTime) - (System.currentTimeMillis() / 1000);
            if(secondsLeft > 0) {
                p.sendMessage(Chat.Color(Chat.prefix +"&7You cant use that commands for another "+ secondsLeft +" seconds!"));
                return true;
            }
        }
        
        cooldowns.put(p.getName(), System.currentTimeMillis());
		
		if(cmd.getName().equalsIgnoreCase("tpa")) {
			
			if(args.length == 0) {
				
				p.sendMessage(Chat.Color(Chat.prefix + "&7Use /tpa help for commands"));
				
			} else if(args.length >= 1) {
				
				if(args[0].equalsIgnoreCase("help")) {
					
					p.sendMessage(Chat.Color(
							  "&f==============================\n"
							+ "&aCore TPA &cHelp\n"
							+ "&a/tpa help : &6Gives help on commands.\n"
							+ "&a/tpa <USER> : &6 Asks the User if they can teleport to U\n"
							+ "&a/tpa accept : &6Accepts TP request\n"
							+ "&a/tpa deny : &6Denies TP request\n"
							+ "&a/tpa back : &6Sends you to your most previous position\n"
							+ "&f=============================="
							));
					
					return true;
					
				} else if(args[0].equalsIgnoreCase("accept")) {
					
					//p.sendMessage(requests.toString());
	                
		            if (requests.containsKey(p.getUniqueId())) {
		                p.sendMessage(Chat.Color(Chat.prefix + "&7You accepted the teleport request."));
		                Bukkit.getPlayer(requests.get(p.getUniqueId())).sendMessage(Chat.Color(Chat.prefix + "&3" +  p.getName() + " &7accepted the teleport request."));
		                Bukkit.getPlayer(requests.get(p.getUniqueId())).teleport(p);
		                requests.remove(p.getUniqueId());
		            } else {
			            p.sendMessage(Chat.Color(Chat.prefix + "&cThere's no request to accept."));
		            }
					
					return true;
					
				} else if(args[0].equalsIgnoreCase("deny")) {
					
		            if (requests.containsKey(p.getUniqueId())) {
		                p.sendMessage(Chat.Color(Chat.prefix + "&7You denied the teleport request."));
		                Bukkit.getPlayer(requests.get(p.getUniqueId())).sendMessage(Chat.Color(Chat.prefix + "&3" +  p.getName() + " &7denied the teleport request."));
		                requests.remove(p.getUniqueId());
		                return true;
		            } else {
			            p.sendMessage(Chat.Color(Chat.prefix + "&cThere's no request to deny."));
		            }
					
					return true;
					
				} else if(args[0].equalsIgnoreCase("back")) {
					
		            if (back.containsKey(p)) {
		            	p.teleport(back.get(p));
		                p.sendMessage(Chat.Color(Chat.prefix + "&aYou have teleported back"));
		                back.remove(p);
		                //back.put(p, p.getLocation());
		                return true;
		            } else {
			            p.sendMessage(Chat.Color(Chat.prefix + "&cYour Previous Position was not set"));
		            }
					
					return true;
					
				} else {
					
		            Player target = Bukkit.getPlayer(args[0]);
		            
		            if (target != null) {
		                back.put(p, p.getLocation());
		                requests.put(target.getUniqueId(), p.getUniqueId());
		                p.sendMessage(Chat.Color(Chat.prefix +"You sent a teleport request to &3" + target.getName() + "&f."));
		                target.sendMessage(Chat.Color(Chat.prefix + "&3" + p.getName() + " &fsent a teleport request to you.\n"
		                		+ "Use /tpa accept or deny"));   
		                return true;
		            } 
					
					p.sendMessage(Chat.Color(Chat.prefix + "&7Could not find that Player. Use /tpa help for commands"));
					
				}	
			}
			return true;
		}
		return false;
	}
}
