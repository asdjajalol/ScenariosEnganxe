package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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

public class BloodAnvil implements Listener, CommandExecutor {

    private Main plugin;
    public BloodAnvil(Main plugin){
        this.plugin = plugin;
    }
    @EventHandler(priority = EventPriority.MONITOR)
    public void onInventoryClick(InventoryClickEvent e){
        if(!e.isCancelled()){
            if (plugin.BloodAnvil){
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
                                    if (p.getHealth() < 1){
                                        p.setHealth(0);
                                    }else {
                                        p.setHealth(p.getHealth() - 1);
                                    }
                                    p.getWorld().playSound(p.getLocation(), Sound.ENTITY_PLAYER_HURT, 1,1);
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (sender.hasPermission("uhc.admin") && cmd.getName().equalsIgnoreCase("BloodAnvil")) {
            if (!plugin.BloodAnvil) {
                Bukkit.broadcastMessage(Utils.chat(Main.prefix + "&fBloodAnvil has been " + Main.enabled));
                plugin.BloodAnvil = Boolean.valueOf(true);
            } else {
                Bukkit.broadcastMessage(Utils.chat(Main.prefix + "&fBloodAnvil has been " + Main.disabled));
                plugin.BloodAnvil = Boolean.valueOf(false);
            }
        } else {
            p.sendMessage(ChatColor.RED + "No tienes permisos para utilizar este comando");
        }
        return false;
    }
}


