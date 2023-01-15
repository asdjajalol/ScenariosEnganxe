package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.manager.Scenario;
import me.imzomi.uhcscenarios.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

public class SwordLess extends Scenario implements Listener {
    private Main plugin = Main.pl;
    private boolean enabled = false;

    public SwordLess(){
        super("SwordLess", new ItemStack(Material.DIAMOND_SWORD));
    }
    @EventHandler
    public void cancelSword(CraftItemEvent e){
            if (e.getRecipe().getResult().getType() == Material.DIAMOND_SWORD || e.getRecipe().getResult().getType() == Material.IRON_SWORD || e.getRecipe().getResult().getType() == Material.GOLDEN_SWORD || e.getRecipe().getResult().getType() == Material.NETHERITE_SWORD || e.getRecipe().getResult().getType() == Material.STONE_SWORD || e.getRecipe().getResult().getType() == Material.WOODEN_SWORD){
                e.setCancelled(true);
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