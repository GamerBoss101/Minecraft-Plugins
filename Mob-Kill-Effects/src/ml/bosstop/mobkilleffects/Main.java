package ml.bosstop.mobkilleffects;

import ml.bosstop.mobkilleffects.commands.BaseCommands;
import ml.bosstop.mobkilleffects.mobkill.KillListener;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable(){
		
		saveDefaultConfig();
		
		String prefix = "&f[&3MobKillEffects&f] ";
		
		System.out.println(ChatColor.translateAlternateColorCodes('&', prefix + "&aStarting Mob Kill Effects v1.4\n"
				+ prefix + "&aMob Kill Effects Active"
				));
		
		new BaseCommands(this);
		
		new KillListener(this);
		
		getServer().getPluginManager().registerEvents(this, this);
	}

}