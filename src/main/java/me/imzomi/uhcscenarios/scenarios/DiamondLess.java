package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.manager.Scenario;
import me.imzomi.uhcscenarios.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class DiamondLess extends Scenario implements Listener {
    private Main plugin = Main.pl;
    private boolean enabled = false;

    public DiamondLess(){
        super("DiamondLess", new ItemStack(Material.DIAMOND));
    }
    @EventHandler
    public void onBreak(BlockBreakEvent e) {
            Block block = e.getBlock();
            if (block.getType() == Material.DIAMOND_ORE) {
                e.setCancelled(true);
                block.setType(Material.AIR);
                block.getState().update();
                block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.IRON_INGOT));
                ExperienceOrb exp = (ExperienceOrb) e.getBlock().getWorld().spawn(e.getBlock().getLocation().add(0, 1, 0), ExperienceOrb.class);
                exp.setExperience(3);
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
