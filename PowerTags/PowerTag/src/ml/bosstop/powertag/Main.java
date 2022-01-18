package ml.bosstop.powertag;


import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.nametagedit.plugin.NametagEdit;

import nl.svenar.PowerRanks.api.PowerRanksAPI;
import nl.svenar.PowerRanks.Data.PowerRanksChatColor;
import nl.svenar.PowerRanks.addons.PowerRanksAddon;
import nl.svenar.PowerRanks.addons.PowerRanksPlayer;

public class Main extends PowerRanksAddon {
	
	Logger log = Bukkit.getServer().getLogger();
	
	PowerRanksAPI api = new PowerRanksAPI();
	
	public String getAuthor() {
		return "sirblob";
	}

	public String getIdentifier() {
		return "PowerTag";
	}

	public String getVersion() {
		return "1.0";
	}


	public String minimalPowerRanksVersion() {
		return "1.9.8";
	}

	public void setup() {        
		if(Bukkit.getServer().getPluginManager().getPlugin("NametagEdit") == null) {
			log.info(Color("&f[&bPowerTag&f]&r" + " &cNametagEdit is not found in your plugins list. Please download and restart your server. PowerTag addon requires this plugin to work properly."));
		}
	}
	
	// SEED [9175471070282087012] , [-4324585655814732927]
	public void onPlayerJoin(PowerRanksPlayer prPlayer) {
		
		Player player = prPlayer.getPlayer();
		
		if(pluginCheck()) {
			
			NametagEdit.getApi().setPrefix(player, PowerRanksChatColor.colorize(api.getPrefix(prPlayer.getRank()), true) + " ");
			
			log.info(Color("Player Logged IN " + player.getName()));
			log.info(Color(player.getName() + " has " + prPlayer.getRank()));
			log.info(Color("Rank Prefix: " + PowerRanksChatColor.colorize(api.getPrefix(prPlayer.getRank()), true)));
			
		} else {
			if(player.isOp()) player.sendMessage(Color("&f[&bPowerTag&f]&r" + " &cNametagEdit is not found in your plugins list. Please download and restart your server. PowerTag addon requires this plugin to work properly."));
		}		
	}
	
	public void onPlayerRankChange(PowerRanksPlayer prPlayer, String oldRank, String newRank, RankChangeCause cause, boolean isPlayerOnline) {
		
		Player player = prPlayer.getPlayer();
		
		if(pluginCheck()) {
			
			NametagEdit.getApi().setPrefix(player, PowerRanksChatColor.colorize(api.getPrefix(newRank), true) + " ");
			
			log.info(Color(player.getName() + " " + oldRank + " => " + newRank));
			
		} else {
			return;
		}			
	}
	
	public boolean pluginCheck() {
		if(Bukkit.getServer().getPluginManager().getPlugin("NametagEdit") == null) {
			return false;
		} else {
			return true;
		}
	}
	
    public static String Color(String input) {
        return ChatColor.translateAlternateColorCodes('&', input);
    }
    
	/*
    public void sendOps(String input) { 	
    	for (Player player: Bukkit.getOnlinePlayers()) {
    		if(player.isOp()) player.sendMessage(Color(input));	
    	}
    }
    
	@Override
	public boolean onPowerRanksCommand(PowerRanksPlayer prPlayer, boolean sendAsPlayer, String command, String[] arguments) {
		return false;
	}
	*/

}
