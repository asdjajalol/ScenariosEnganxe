package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.Objects;

public class VengefulSpirits implements Listener, CommandExecutor {

    private Main plugin;
    public VengefulSpirits(Main plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void onDeath(EntityDeathEvent e){
        if (plugin.VengefulSpirits){
            if (e.getEntity().getType() == EntityType.PLAYER){
                if (e.getEntity().getLocation().getBlockY() >= 60){
                    e.getEntity().getWorld().spawn(e.getEntity().getLocation().add(0, 2, 0), Ghast.class);
                }else if (e.getEntity().getLocation().getBlockY() < 60){
                    e.getEntity().getWorld().spawn(e.getEntity().getLocation().add(0, 2, 0), Blaze.class);
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
        if (sender.hasPermission("uhc.admin") && cmd.getName().equalsIgnoreCase("VengefulSpirits")) {
            if (!plugin.VengefulSpirits) {
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "Enganxe" + ChatColor.DARK_GRAY + "]" + " &0➤ &fVengefulSpirits has been &aenabled"));
                plugin.VengefulSpirits = Boolean.valueOf(true);
            } else {
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "Enganxe" + ChatColor.DARK_GRAY + "]" + " &0➤ &fVengefulSpirits has been &cdisabled"));
                plugin.VengefulSpirits = Boolean.valueOf(false);
            }
        } else {
            p.sendMessage(ChatColor.RED + "No tienes permisos para utilizar este comando");
        }
        return false;
    }
}

