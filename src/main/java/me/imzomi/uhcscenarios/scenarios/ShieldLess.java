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
import org.bukkit.event.inventory.CraftItemEvent;

public class ShieldLess implements Listener, CommandExecutor {

    private Main plugin;
    public ShieldLess(Main plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void cancelShield(CraftItemEvent e){
        if (plugin.ShieldLess){
            if (e.getRecipe().getResult().getType() == Material.SHIELD){
                e.setCancelled(true);
            }
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (sender.hasPermission("uhc.admin") && cmd.getName().equalsIgnoreCase("ShieldLess")) {
            if (!plugin.ShieldLess) {
                Bukkit.broadcastMessage(Utils.chat(Main.prefix + "&fShieldLess has been " + Main.enabled));
                plugin.ShieldLess = Boolean.valueOf(true);
            } else {
                Bukkit.broadcastMessage(Utils.chat(Main.prefix + "&fShieldLess has been " + Main.disabled));
                plugin.ShieldLess = Boolean.valueOf(false);
            }
        } else {
            p.sendMessage(ChatColor.RED + "No tienes permisos para utilizar este comando");
        }
        return false;
    }
}
