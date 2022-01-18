package ml.bosstop.deathrun.util;

import org.bukkit.ChatColor;

public class Util {
	public static String prefix() {
		return "&f[&4DeathRun&f] "; 
	}
    public static String Color(String input) {
        return ChatColor.translateAlternateColorCodes('&', input);
    }
}
