package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class Fireless implements Listener, CommandExecutor {

    private Main plugin;
    public Fireless(Main plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void onDamageFireless(EntityDamageEvent e){
        if (plugin.Fireless){
            if (e.getEntity() instanceof Player){
            if (e.getCause() == EntityDamageEvent.DamageCause.LAVA || e.getCause() == EntityDamageEvent.DamageCause.FIRE ||e.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK ){
                e.setCancelled(true);
            }
        }
    }}
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (sender.hasPermission("uhc.admin") && cmd.getName().equalsIgnoreCase("Fireless")) {
            if (!plugin.Fireless) {
                Bukkit.broadcastMessage(Utils.chat(Main.prefix + "&fFireless has been " + Main.enabled));
                plugin.Fireless = Boolean.valueOf(true);
            } else {
                Bukkit.broadcastMessage(Utils.chat(Main.prefix + "&fFireless has been " + Main.disabled));
                plugin.Fireless = Boolean.valueOf(false);
            }
        } else {
            p.sendMessage(ChatColor.RED + "No tienes permisos para utilizar este comando");
        }
        return false;
    }
}
