package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
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
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

public class CobwebLess implements Listener, CommandExecutor {

    private Main plugin;
    public CobwebLess(Main plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void onBreak(BlockBreakEvent e){
        if (plugin.CobwebLess){
            if (e.getBlock().getType() == Material.COBWEB){
                e.setCancelled(true);
                e.getBlock().setType(Material.AIR);
                e.getBlock().getState().update();
                if (e.getPlayer().getItemInHand().getType() == Material.SHEARS || e.getPlayer().getItemInHand().getType() == Material.WOODEN_SWORD || e.getPlayer().getItemInHand().getType() == Material.STONE_SWORD || e.getPlayer().getItemInHand().getType() == Material.IRON_SWORD || e.getPlayer().getItemInHand().getType() == Material.GOLDEN_SWORD || e.getPlayer().getItemInHand().getType() == Material.DIAMOND_SWORD || e.getPlayer().getItemInHand().getType() == Material.NETHERITE_SWORD) {
                    e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(Material.STRING));
                }
            }
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e){
        if (plugin.CobwebLess){
            if (e.getBlock().getType() == Material.COBWEB){
                e.setCancelled(true);
            }
        }
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (sender.hasPermission("uhc.admin") && cmd.getName().equalsIgnoreCase("CobwebLess")) {
            if (!plugin.CobwebLess) {
                Bukkit.broadcastMessage(Utils.chat(Main.prefix + "&fCobwebLess has been " + Main.enabled));
                plugin.CobwebLess = Boolean.valueOf(true);
            } else {
                Bukkit.broadcastMessage(Utils.chat(Main.prefix + "&fCobwebLess has been " + Main.disabled));
                plugin.CobwebLess = Boolean.valueOf(false);
            }
        } else {
            p.sendMessage(ChatColor.RED + "No tienes permisos para utilizar este comando");
        }
        return false;
    }
}
