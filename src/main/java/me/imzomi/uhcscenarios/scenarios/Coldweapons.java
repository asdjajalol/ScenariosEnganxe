package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;

import java.util.Map;

public class Coldweapons implements Listener, CommandExecutor {

    private Main plugin;
    public Coldweapons(Main plugin){
        this.plugin = plugin;
    }
    private static final Enchantment ENCHANTMENT = Enchantment.FIRE_ASPECT;

    @EventHandler
    public void on(EnchantItemEvent event) {
        if (plugin.Coldweapons){
        Map<Enchantment, Integer> toAdd = event.getEnchantsToAdd();

        if (!toAdd.containsKey(ENCHANTMENT)) {
            return;
        }

        toAdd.remove(ENCHANTMENT);

        if (toAdd.containsKey(Enchantment.DAMAGE_ALL) || toAdd.containsKey(Enchantment.DAMAGE_UNDEAD) || toAdd.containsKey(Enchantment.DAMAGE_ARTHROPODS)) {
            return;
        }

        toAdd.put(Enchantment.DAMAGE_ALL, 1);
    }}
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (!(sender instanceof Player)) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "Enganxe" + ChatColor.DARK_GRAY + "]" + ChatColor.RED + " No puedes ejecutar comandos desde la consola");
        }
        if (sender.hasPermission("uhc.admin") && cmd.getName().equalsIgnoreCase("Coldweapons")) {
            if (!plugin.Coldweapons) {
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.DARK_GRAY+ "["+ChatColor.GOLD+"Enganxe"+ChatColor.DARK_GRAY+"]"+ " &0➤ &fColdweapons has been &aenabled"));
                plugin.Coldweapons = Boolean.valueOf(true);
            } else {
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.DARK_GRAY+ "["+ChatColor.GOLD+"Enganxe"+ChatColor.DARK_GRAY+"]"+ " &0➤ &fColdweapons has been &cdisabled"));
                plugin.Coldweapons = Boolean.valueOf(false);
            }
        } else {
            p.sendMessage(ChatColor.RED + "No tienes permisos para utilizar este comando");
        }
        return false;
    }
}
