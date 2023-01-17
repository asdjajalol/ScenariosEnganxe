package me.imzomi.uhcscenarios.listeners;

import me.imzomi.uhcscenarios.Main;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class CobbleOnly implements Listener {
    private Main pl = Main.pl;

    public CobbleOnly() {
        pl.getServer().getPluginManager().registerEvents(this,pl);
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        Block block = event.getBlock();
        Player p = event.getPlayer();
        String name = p.getItemInHand().getType().name();
        if (pl.config.getConfig().getBoolean("players." + p.getName() + ".cobbleonly",false)) {
            if (name.contains("PICKAXE")) {
                switch (block.getType()) {
                    case DIORITE, GRANITE, ANDESITE -> {
                        event.setDropItems(false);
                        block.setType(Material.AIR);
                        block.getState().update();
                        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.COBBLESTONE));
                    }
                }
            }
        }
    }
}
