package ml.bosstop.core.events;

import ml.bosstop.core.Main;

public class Event {
	
	public static void Listeners(Main plugin) {
		plugin.getServer().getPluginManager().registerEvents(new onPlayerJoin(plugin), plugin);
	}

}
