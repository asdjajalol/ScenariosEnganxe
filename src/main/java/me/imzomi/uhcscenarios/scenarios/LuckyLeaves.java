package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
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

public class LuckyLeaves implements Listener, CommandExecutor {

    private Main plugin;
    public LuckyLeaves(Main plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void leaveDeacay(LeavesDecayEvent e){
        if (plugin.LuckyLeaves){
            if(new Random().nextInt(100) == 99){
                e.getBlock().getWorld().dropItem(e.getBlock().getLocation().add(0.5,0,0.5),new ItemStack(Material.GOLDEN_APPLE));
            }
        }
    }

    @EventHandler
    public void breackLeave(BlockBreakEvent e) {
        if (plugin.LuckyLeaves) {
            if (e.getBlock().getType() == Material.ACACIA_LEAVES || e.getBlock().getType() == Material.BIRCH_LEAVES || e.getBlock().getType() == Material.DARK_OAK_LEAVES || e.getBlock().getType() == Material.JUNGLE_LEAVES || e.getBlock().getType() == Material.OAK_LEAVES || e.getBlock().getType() == Material.SPRUCE_LEAVES) {
                if (new Random().nextInt(100) == 99) {
                    e.getBlock().getWorld().dropItem(e.getBlock().getLocation().add(0.5, 0, 0.5), new ItemStack(Material.GOLDEN_APPLE));
                }
            }
        }
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (!(sender instanceof Player)) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "Enganxe" + ChatColor.DARK_GRAY + "]" + ChatColor.RED + " No puedes ejecutar comandos desde la consola");
        }
        if (sender.hasPermission("uhc.admin") && cmd.getName().equalsIgnoreCase("LuckyLeaves")) {
            if (!plugin.LuckyLeaves) {
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "Enganxe" + ChatColor.DARK_GRAY + "]" + " &0➤ &fLuckyLeaves has been &aenabled"));
                plugin.LuckyLeaves = Boolean.valueOf(true);
            } else {
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "Enganxe" + ChatColor.DARK_GRAY + "]" + " &0➤ &fLuckyLeaves has been &cdisabled"));
                plugin.LuckyLeaves = Boolean.valueOf(false);
            }
        } else {
            p.sendMessage(ChatColor.RED + "No tienes permisos para utilizar este comando");
        }
        return false;
    }
}