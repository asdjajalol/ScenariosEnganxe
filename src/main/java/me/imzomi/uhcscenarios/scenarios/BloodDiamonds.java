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
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class BloodDiamonds extends Scenario implements Listener{
    private Main plugin = Main.pl;
    private boolean enabled = false;

    public BloodDiamonds(){
        super("BloodDiamonds", new ItemStack(Material.DIAMOND));
    }
    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        if (e.getBlock().getType() == Material.DIAMOND_ORE) {
            Player p = e.getPlayer();
            p.damage(1);
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