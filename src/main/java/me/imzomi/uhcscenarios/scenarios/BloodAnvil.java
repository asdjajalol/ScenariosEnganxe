package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.manager.Scenario;
import me.imzomi.uhcscenarios.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

public class BloodAnvil extends Scenario implements Listener {
    private Main plugin = Main.pl;
    private boolean enabled = false;

    public BloodAnvil(){
        super("BloodAnvil", new ItemStack(Material.ANVIL));
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onInventoryClick(InventoryClickEvent e){
        if(!e.isCancelled()){
                HumanEntity ent = e.getWhoClicked();
                if(ent instanceof Player){
                    Player p = (Player)ent;
                    Inventory inv = e.getInventory();
                    if(inv instanceof AnvilInventory){
                        InventoryView view = e.getView();
                        int rawSlot = e.getRawSlot();
                        if(rawSlot == view.convertSlot(rawSlot)){
                            if(rawSlot == 2){
                                ItemStack item = e.getCurrentItem();
                                if(item != null) {
                                    p.damage(1);
                                }
                            }
                        }
                    }
                }
            }
        }

    @Override
    protected void setEnabled(boolean b) {
        enabled = b;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}


