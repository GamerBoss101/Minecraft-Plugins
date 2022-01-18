package ml.bosstop.deathrun.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import ml.bosstop.deathrun.Main;
import ml.bosstop.deathrun.util.Util;

public class onDeath implements Listener {
	
	@SuppressWarnings("unused")
	private Main plugin;
	
	public onDeath(Main plugin) {
		this.plugin = plugin;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
    @EventHandler
    public static void onJoin(PlayerJoinEvent event) { 
    	
    	Player p = event.getPlayer();
    	
    	Util.console(p.getName());
    
    	
    }

}
