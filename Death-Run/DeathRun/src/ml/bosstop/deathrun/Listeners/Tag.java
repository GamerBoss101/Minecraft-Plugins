package ml.bosstop.deathrun.Listeners;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import ml.bosstop.deathrun.Main;
import ml.bosstop.deathrun.util.Util;

public class Tag implements Listener {
	
	@SuppressWarnings("unused")
	private Main plugin;
	
	public Tag(Main plugin) {
		this.plugin = plugin;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	static Logger log = Bukkit.getServer().getLogger();
	
    @EventHandler
    public static void onJoin (PlayerJoinEvent event) {  //event.getPlayer().getName()
    	Scoreboard s = Bukkit.getScoreboardManager().getMainScoreboard();
    	
    	 s.getTeam("nt- idk");
    	 s.addEntry(event.getPlayer().getName());
    }
    
    public static void init () {
        assert Bukkit.getScoreboardManager() != null;
        Scoreboard s = Bukkit.getScoreboardManager().getMainScoreboard();
        String name = "nt-" + "idk";
        s.registerNewTeam(name);
        Team t = s.getTeam(name);
        assert t != null;
        t.setPrefix("�6[TEST]");
    }
    
    public static void clean () {
        if (Bukkit.getScoreboardManager() == null ) {
        	log.info(Util.Color("Scoreboard manager is not defined!"));
            return;
        }
        for (Team t: Bukkit.getScoreboardManager().getMainScoreboard().getTeams()) if (t.getName().contains("nt-")) t.unregister();
    }

}