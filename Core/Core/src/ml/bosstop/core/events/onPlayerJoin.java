package ml.bosstop.core.events;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.permissions.PermissionAttachment;

import ml.bosstop.core.Main;
import ml.bosstop.core.util.Chat;

public class onPlayerJoin implements Listener {
	
	private static Main plugin;
	
	public onPlayerJoin(Main plugin) {
		onPlayerJoin.plugin = plugin;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	String[] greetings = {
			"Welcome Back !", 
			"Whats Cooken", 
			"HI",
			"Nice to see you again",
			"&oWave&r",
			"Hola"
			};
	
	@EventHandler
    public void onJoin(PlayerJoinEvent event) { 
    	
		Random random = new Random();
		int number = random.nextInt(greetings.length);
		
    	Player p = event.getPlayer();
    	
    	PermissionAttachment attachment = p.addAttachment(plugin);
    	attachment.setPermission("bukkit.command.tps", true);
    	attachment.unsetPermission("bukkit.command.plugins");
    
    	if(p.hasPlayedBefore()){
        	event.setJoinMessage(Chat.Color(Chat.prefix + "&f " + greetings[number] + " &3" + p.getName()));
    	}else{
        	event.setJoinMessage(Chat.Color(Chat.prefix + "&3" + p.getName() + " &fWelcome !"));
    	}
    }
}
