package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class NoFall implements Listener, CommandExecutor {

    private Main plugin;
    public NoFall(Main plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void NoFall(EntityDamageEvent e){
        if (plugin.NoFall){
        if (e.getEntity().getType() != EntityType.PLAYER && !plugin.NoFall.booleanValue()) return;
        if (e.getCause() == EntityDamageEvent.DamageCause.FALL)
            e.setCancelled(true);
        }}
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (!(sender instanceof Player)) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "Enganxe" + ChatColor.DARK_GRAY + "]" + ChatColor.RED + " No puedes ejecutar comandos desde la consola");
        }
        if (sender.hasPermission("uhc.admin") && cmd.getName().equalsIgnoreCase("NoFall")) {
            if (!plugin.NoFall) {
                Bukkit.broadcastMessage( Utils.chat(Main.prefix + "&fNoFall has been " + Main.enabled));
                plugin.NoFall = Boolean.valueOf(true);
            } else {
                Bukkit.broadcastMessage( Utils.chat(Main.prefix + "&fNoFall has been " + Main.disabled));
                plugin.NoFall = Boolean.valueOf(false);
            }
        } else {
            p.sendMessage(ChatColor.RED + "No tienes permisos para utilizar este comando");
        }
        return false;
    }
}