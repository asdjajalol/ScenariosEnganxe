package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.manager.Scenario;
import me.imzomi.uhcscenarios.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

public class AnvilLess extends Scenario implements Listener {
    private Main pl = Main.pl;
    private boolean enabled = false;

    public AnvilLess() {
        super("AnvilLess", new ItemStack(Material.ANVIL));
    }

    @EventHandler
    public void onInteract(InventoryClickEvent e) {
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

    @Override
    protected void setEnabled(boolean b) {
        enabled = b;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
