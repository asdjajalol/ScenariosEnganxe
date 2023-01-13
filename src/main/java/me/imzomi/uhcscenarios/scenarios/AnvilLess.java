package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

public class AnvilLess implements Listener, CommandExecutor {
    private Main pl = Main.pl;

    public AnvilLess() {
        pl.getServer().getPluginManager().registerEvents(this, pl);
        pl.getCommand("anvilless").setExecutor(this);
    }

    @EventHandler
    public void onInteract(InventoryClickEvent e) {
        if (pl.anvilLess) {
            if (!e.isCancelled()) {
                if (e.getWhoClicked() instanceof Player p) {
                    if (e.getInventory() instanceof AnvilInventory) {
                        InventoryView view = e.getView();
                        int rawSlot = e.getRawSlot();
                        if (rawSlot == view.convertSlot(rawSlot)) {
                            if (rawSlot == 2) {
                                ItemStack item = e.getCurrentItem();
                                if (item != null) {
                                    p.sendMessage(pl.prefix + "&cEl UHC es &lAnvilLess");
                                    e.setCancelled(true);
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
        if (sender.hasPermission("uhc.admin") && cmd.getName().equalsIgnoreCase("anvilless")) {
            pl.anvilLess = !pl.anvilLess;
            Bukkit.broadcastMessage(Utils.chat(pl.prefix + "&fAnvilLess has been " + (pl.anvilLess ? Main.enabled : Main.disabled)));
        }
        return false;
    }
}
