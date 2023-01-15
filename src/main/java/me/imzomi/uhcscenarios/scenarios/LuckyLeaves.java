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
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class LuckyLeaves extends Scenario implements Listener{
    private Main plugin = Main.pl;
    private boolean enabled = false;

    public LuckyLeaves(){
        super("LuckyLeaves", new ItemStack(Material.OAK_LEAVES));
    }
    @EventHandler
    public void leaveDeacay(LeavesDecayEvent e){
            if(new Random().nextInt(100) == 99){
                e.getBlock().getWorld().dropItem(e.getBlock().getLocation().add(0.5,0,0.5),new ItemStack(Material.GOLDEN_APPLE));
            }
        }

    @EventHandler
    public void breackLeave(BlockBreakEvent e) {
        switch (e.getBlock().getType()) {
            case ACACIA_LEAVES, BIRCH_LEAVES, DARK_OAK_LEAVES, JUNGLE_LEAVES, OAK_LEAVES, SPRUCE_LEAVES -> {
                if (new Random().nextInt(100) == 99) {
                    e.getBlock().getWorld().dropItem(e.getBlock().getLocation().add(0.5, 0, 0.5), new ItemStack(Material.GOLDEN_APPLE));
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