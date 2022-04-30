package ml.bosstop.core;

import org.bukkit.plugin.java.JavaPlugin;

import ml.bosstop.core.comands.comand;
import ml.bosstop.core.events.Event;
import ml.bosstop.core.util.Chat;

public class Main extends JavaPlugin {	

	public Main() {
    }
	
	
    @Override
    public void onEnable() {
    	
    	/*
        this.saveDefaultConfig();
        
        if (!util.file.exists()) {
			util.saveHomesFile();
        }*/
    	
    	Event.Listeners(this);
    	comand.enable(this);
        
    	Chat.console("&fStarting Core v1.5");
    	Chat.console("&Core Active");
        
    }


	@Override
    public void onDisable() {
    	
		Chat.console("&Core Disabled");

    }
}
