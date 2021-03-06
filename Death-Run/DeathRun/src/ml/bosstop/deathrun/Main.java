package ml.bosstop.deathrun;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import ml.bosstop.deathrun.listeners.onDeath;
import ml.bosstop.deathrun.commands.commands;
import ml.bosstop.deathrun.util.Util;


public class Main extends JavaPlugin implements Listener {	
	
    public Main() {
    }
	
	Logger log = Bukkit.getServer().getLogger();
	
    @Override
    public void onEnable() {
    	
    	this.saveDefaultConfig();
    	
    	new commands(this);
    	
       this.getServer().getPluginManager().registerEvents(new onDeath(this), this);
       this.getConfig().options().copyDefaults();
        
        Util.console("&fStarting DeathRun v1.0");
        Util.console("&fDeathRun Active");
        
    }


	@Override
    public void onDisable() {
    	
		Util.console("&fDeathRun Disabled");

    }
}
