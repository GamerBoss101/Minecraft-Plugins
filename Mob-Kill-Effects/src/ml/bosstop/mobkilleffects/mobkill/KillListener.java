package ml.bosstop.mobkilleffects.mobkill;

import ml.bosstop.mobkilleffects.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import io.netty.util.internal.ThreadLocalRandom;

public class KillListener implements Listener {
	
	private Main plugin;
	
	public KillListener(Main plugin) {
		this.plugin = plugin;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onKill(EntityDeathEvent e) {
	    LivingEntity entity = e.getEntity();
	    Player killer = entity.getKiller();
	    
	    int rnd = ThreadLocalRandom.current().nextInt(PotionEffectType.values().length);
	    
	    String time = plugin.getConfig().getString("potionEffect_time");
	    
		 int i = Integer.parseInt(time);
		 
	    if (killer != null) {
	    	
			killer.addPotionEffect(new PotionEffect(PotionEffectType.values()[rnd], i, 1));
			
			killer.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou have gotten a Random Effect"));
			
	    } else {
	    	return;
	    }
	}
}
