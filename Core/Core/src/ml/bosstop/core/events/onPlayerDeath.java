package ml.bosstop.core.events;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import ml.bosstop.core.Main;
import ml.bosstop.core.util.Chat;

public class onPlayerDeath implements Listener {
	
	@SuppressWarnings("unused")
	private static Main plugin;
	
	public onPlayerDeath(Main plugin) {
		onPlayerDeath.plugin = plugin;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	String[] killphases = {
			" Get Good Kid ", 
			" SMH no Skill ", 
			" That Must have hurt ",
			" Your Trash Kid "
			};
	
	@EventHandler
    public void onDeath(EntityDeathEvent event) { 
    	
		Random random = new Random();
		int number = random.nextInt(killphases.length);
		
		LivingEntity entity = event.getEntity();
	    Player killer = entity.getKiller();
	    
	    if (killer != null) {
	    	
		    if (entity instanceof Player) {
		    	entity.sendMessage(Chat.Color(Chat.prefix + "&cYou were killed by" + killer.getName() + killphases[number]));
		    	if (killer instanceof Player) {
					killer.sendMessage(Chat.Color(Chat.prefix + "&aGood Job you killed " + entity.getName()));
		    	}
		    }
			
	    } else {
	    	entity.sendMessage(Chat.Color(Chat.prefix + "&cYou died" + killphases[number]));
	    	return;
	    }
    	
    
    }
	
}
