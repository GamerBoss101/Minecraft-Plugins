package org.bosstop.fallenchant.Fall;

import org.bosstop.fallenchant.Main;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class FallListener implements Listener {
	
	private Main plugin;
	
	public FallListener(Main plugin) {
		this.plugin = plugin;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
    public void onEntityDamageEvent(final EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        Player p = (Player) e.getEntity();
        if (e.getCause() == DamageCause.FALL) {
        	
            ItemStack[] inventory = p.getInventory().getContents();
            List<Integer> slotswithitems = getSlotsWithItems(p.getInventory());
            Random rand = new Random();
            int listsize = slotswithitems.size();
            if (listsize > 0) {
                int randomslot = rand.nextInt(listsize);
                this.enchantInventory(inventory, this.plugin.getConfig().getBoolean("enchantfullinventory"), p, slotswithitems, randomslot);
            }
        }
    }

    public static List<Integer> getSlotsWithItems(Inventory inventory) {
		List<Integer> itemslots = new ArrayList<Integer>();

        for(int i = 0; i < inventory.getSize(); ++i) {
            if (inventory.getItem(i) != null) {
                itemslots.add(i);
            }
        }

        return itemslots;
    }

    public void enchantInventory(ItemStack[] inventory, Boolean configoption, Player p, List<Integer> slotswithitems, Integer randomslot) {
        if (configoption) {
            for(int i = 0; i < 40; ++i) {
                if (inventory[i] != null) {
                    ItemStack item = inventory[i];
                    ItemMeta meta = item.getItemMeta();
                    Enchantment randEnchant = Enchantment.values()[(int)(Math.random() * (double)Enchantment.values().length)];
                    boolean nosilktouch = true;
                    if (randEnchant.equals(Enchantment.SILK_TOUCH) && nosilktouch) {
                        randEnchant = Enchantment.CHANNELING;
                    }

                    Map<Enchantment, Integer> enchants = meta.getEnchants();
                    if (enchants.containsKey(randEnchant)) {
                        int enchvalue = (Integer)enchants.get(randEnchant) + 1;
                        if (this.plugin.getConfig().get("enchantlimit").equals(true)) {
                            meta.addEnchant(randEnchant, enchvalue, false);
                        } else if (this.plugin.getConfig().get("enchantlimit").equals(false)) {
                            try {
                                if (enchvalue >= (Integer)this.plugin.getConfig().get("maxenchant")) {
                                    enchvalue = (Integer)this.plugin.getConfig().get("maxenchant");
                                }
                            } catch (NullPointerException var16) {
                                var16.printStackTrace();
                            }

                            meta.addEnchant(randEnchant, enchvalue, true);
                        }
                    } else {
                        int enchvalue = 1;
                        Enchantment secondtry = Enchantment.values()[(int)(Math.random() * (double)Enchantment.values().length)];
                        if (secondtry.equals(Enchantment.SILK_TOUCH) && nosilktouch) {
                            secondtry = Enchantment.CHANNELING;
                        }

                        meta.addEnchant(secondtry, enchvalue, false);
                    }

                    item.setItemMeta(meta);
                }
            }
        } else {
            ItemStack item = inventory[(Integer)slotswithitems.get(randomslot)];
            ItemMeta meta = item.getItemMeta();
            Enchantment randEnchant = Enchantment.values()[(int)(Math.random() * (double)Enchantment.values().length)];
            boolean nosilktouch = this.plugin.getConfig().getBoolean("nosilktouch");
            if (randEnchant.equals(Enchantment.SILK_TOUCH) && nosilktouch) {
                randEnchant = Enchantment.CHANNELING;
            }

            Map<Enchantment, Integer> enchants = meta.getEnchants();
            if (enchants.containsKey(randEnchant)) {
                int enchvalue = (Integer)enchants.get(randEnchant) + 1;
                if (this.plugin.getConfig().get("enchantlimit").equals(true)) {
                    meta.addEnchant(randEnchant, enchvalue, false);
                } else if (this.plugin.getConfig().get("enchantlimit").equals(false)) {
                    try {
                        if (enchvalue >= (Integer)this.plugin.getConfig().get("maxenchant")) {
                            enchvalue = (Integer)this.plugin.getConfig().get("maxenchant");
                        }
                    } catch (NullPointerException var15) {
                        var15.printStackTrace();
                    }

                    meta.addEnchant(randEnchant, enchvalue, true);
                }
            } else {
                int enchvalue = 1;
                Enchantment secondtry = Enchantment.values()[(int)(Math.random() * (double)Enchantment.values().length)];
                if (secondtry.equals(Enchantment.SILK_TOUCH) && nosilktouch) {
                    secondtry = Enchantment.CHANNELING;
                }

                meta.addEnchant(secondtry, enchvalue, false);
            }

            item.setItemMeta(meta);
        }

    }
}


