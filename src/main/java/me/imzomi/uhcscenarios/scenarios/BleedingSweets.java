package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class BleedingSweets
        implements Listener, CommandExecutor {

    private Main plugin;
    public BleedingSweets
            (Main plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void bleedingSweets(EntityDeathEvent e){
        if (plugin.BleedingSweets){
            if (e.getEntity().getType() == EntityType.PLAYER){
                ItemStack diamond = new ItemStack(Material.DIAMOND, 1);
                ItemStack gold = new ItemStack (Material.GOLD_INGOT, 5);
                ItemStack arrow = new ItemStack(Material.ARROW, 16);
                ItemStack string = new ItemStack(Material.STRING, 2);
                ItemStack book = new ItemStack(Material.BOOK, 1);
                e.getDrops().add(diamond);
                e.getDrops().add(gold);
                e.getDrops().add(arrow);
                e.getDrops().add(string);
                e.getDrops().add(book);
            }
        }
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (!(sender instanceof Player)) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "Enganxe" + ChatColor.DARK_GRAY + "]" + ChatColor.RED + " No puedes ejecutar comandos desde la consola");
        }
        if (sender.hasPermission("uhc.admin") && cmd.getName().equalsIgnoreCase("BleedingSweets")) {
            if (!plugin.BleedingSweets) {
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.DARK_GRAY+ "["+ChatColor.GOLD+"Enganxe"+ChatColor.DARK_GRAY+"]"+ " &0➤ &fBleedingSweets has been &aenabled"));
                plugin.BleedingSweets = Boolean.valueOf(true);
            } else {
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.DARK_GRAY+ "["+ChatColor.GOLD+"Enganxe"+ChatColor.DARK_GRAY+"]"+ " &0➤ &fBleedingSweets has been &cdisabled"));
                plugin.BleedingSweets = Boolean.valueOf(false);
            }
        } else {
            p.sendMessage(ChatColor.RED + "No tienes permisos para utilizar este comando");
        }
        return false;
    }
}

