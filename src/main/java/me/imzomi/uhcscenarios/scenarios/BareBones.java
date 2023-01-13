package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

public class BareBones implements Listener, CommandExecutor {
    private Main pl = Main.pl;

    public BareBones() {
        pl.getServer().getPluginManager().registerEvents(this,pl);
        pl.getCommand("barebones").setExecutor(this);
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        if (pl.bareBones) {
            Player p = e.getPlayer();
            Block b = e.getBlock();
            ItemStack replaced = new ItemStack(pl.CutClean ? Material.IRON_INGOT : Material.IRON_ORE);
            if (pl.DoubleOres) {
                replaced.setAmount(2);
            } else if (pl.TripleOres) {
                replaced.setAmount(3);
            }
            switch (b.getType()) {
                case GOLD_ORE, DIAMOND_ORE -> {
                    if (b.getDrops(p.getInventory().getItemInMainHand()).isEmpty()) return;
                    e.setDropItems(false);
                    b.getWorld().dropItemNaturally(b.getLocation(), replaced);
                }
            }
        }
    }

    @EventHandler
    public void onCraft(CraftItemEvent e) {
        if (pl.bareBones) {
            switch (e.getRecipe().getResult().getType()) {
                case ENCHANTING_TABLE, ANVIL, GOLDEN_APPLE -> e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        if (pl.bareBones) {
            e.getDrops().add(new ItemStack(Material.DIAMOND));
            e.getDrops().add(new ItemStack(Material.GOLDEN_APPLE));
            e.getDrops().add(new ItemStack(Material.ARROW,12));
            e.getDrops().add(new ItemStack(Material.STRING,2));
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender.hasPermission("uhc.admin") && cmd.getName().equalsIgnoreCase("barebones")) {
            pl.bareBones = !pl.bareBones;
            Bukkit.broadcastMessage(Utils.chat(pl.prefix + "&fBareBones has been " + (pl.bareBones ? Main.enabled : Main.disabled)));
        }
        return false;
    }
}
