package ml.bosstop.deathrun;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
// import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import ml.bosstop.deathrun.Listeners.Tag;
import ml.bosstop.deathrun.commands.commands;
import ml.bosstop.deathrun.util.Util;


public class Main extends JavaPlugin {	
	
    public Main() {
    }
	
	Logger log = Bukkit.getServer().getLogger();
	
    @Override
    public void onEnable() {
    	
    	this.saveDefaultConfig();
    	
    	new commands(this);
    	
        this.getServer().getPluginManager().registerEvents(new Tag(this), this);
        this.getConfig().options().copyDefaults();
        
    	log.info(Util.Color(Util.prefix() + "&fStarting DeathRun v1.0"));
    	log.info(Util.Color(Util.prefix() + "&fDeathRun Active"));
    }

	@Override
    public void onDisable() {
    	
		// log.info(ChatColor.translateAlternateColorCodes('&', Util.prefix() + "&fDisabling DeathRun v1.0"));
		log.info(Util.Color(Util.prefix() + "&fDeathRun Disabled"));

    }
}