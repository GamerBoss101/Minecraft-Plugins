package ml.bosstop.deathrun.util;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Util {
	
	static Logger log = Bukkit.getServer().getLogger();
	
	public static String prefix() {
		return "&f[&4DeathRun&f] "; 
	}
    public static String Color(String input) {
        return ChatColor.translateAlternateColorCodes('&', input);
    }
    public static void console(String input) {
    	log.info(Color(prefix() + input));
    }
    
}