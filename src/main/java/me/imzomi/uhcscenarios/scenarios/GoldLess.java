package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class GoldLess implements Listener, CommandExecutor {

    private Main plugin;
    public GoldLess(Main plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        if (plugin.GoldLess) {
            Block block = e.getBlock();
            if (block.getType() == Material.GOLD_ORE)
                e.setCancelled(true);
            block.setType(Material.AIR);
            block.getState().update();
        }
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (sender.hasPermission("uhc.admin") && cmd.getName().equalsIgnoreCase("GoldLess")) {
            if (!plugin.GoldLess) {
                Bukkit.broadcastMessage(Utils.chat(Main.prefix + "&fGoldLess has been " + Main.enabled));
                plugin.GoldLess = Boolean.valueOf(true);
            } else {
                Bukkit.broadcastMessage(Utils.chat(Main.prefix + "&fGoldLess has been " + Main.disabled));
                plugin.GoldLess = Boolean.valueOf(false);
            }
        } else {
            p.sendMessage(ChatColor.RED + "No tienes permisos para utilizar este comando");
        }
        return false;
    }
}
