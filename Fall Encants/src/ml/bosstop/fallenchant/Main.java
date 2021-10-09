package ml.bosstop.fallenchant;

import ml.bosstop.fallenchant.Fall.FallListener;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public Main() {
    }
    
	@Override
	public void onEnable(){
		
		this.saveDefaultConfig();
		
		String prefix = "&f[&3FallEnchants&f] ";
		
		System.out.println(ChatColor.translateAlternateColorCodes('&', prefix + "&aStarting Fall Enchants v1.1\n"
				+ prefix + "&aFall Enchants Active"
				));
		
        this.getServer().getPluginManager().registerEvents(new FallListener(this), this);
        this.getConfig().options().copyDefaults();
	}
	
	public void onDisable(){
		
		String prefix = "&f[&3FallEnchants&f] ";
		
		System.out.println(ChatColor.translateAlternateColorCodes('&', prefix + "&4Disabling Fall Enchants v1.1\n"
				+ prefix + "&4Fall Enchants Disabled"
				));
	}
	
}