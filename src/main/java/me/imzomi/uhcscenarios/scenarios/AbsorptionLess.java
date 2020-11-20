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
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffectType;

public class AbsorptionLess implements Listener, CommandExecutor {

    private Main plugin;
    public AbsorptionLess(Main plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void on (PlayerItemConsumeEvent e) {
        if (plugin.AbsorptionLess){
            if (e.getItem().getType() == Material.GOLDEN_APPLE || e.getItem().getType() == Material.ENCHANTED_GOLDEN_APPLE) {
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                    @Override
                    public void run() {
                        e.getPlayer().removePotionEffect(PotionEffectType.ABSORPTION);
                    }
                }, 1L);
            }
        }
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (!(sender instanceof Player)) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "Enganxe" + ChatColor.DARK_GRAY + "]" + ChatColor.RED + " No puedes ejecutar comandos desde la consola");
        }
        if (sender.hasPermission("uhc.admin") && cmd.getName().equalsIgnoreCase("AbsorptionLess")) {
            if (!plugin.AbsorptionLess) {
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.DARK_GRAY+ "["+ChatColor.GOLD+"Enganxe"+ChatColor.DARK_GRAY+"]"+ " &0➤ &fAbsorptionLess has been &aenabled"));
                plugin.AbsorptionLess = Boolean.valueOf(true);
            } else {
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.DARK_GRAY+ "["+ChatColor.GOLD+"Enganxe"+ChatColor.DARK_GRAY+"]"+ " &0➤ &fAbsorptionLess has been &cdisabled"));
                plugin.AbsorptionLess = Boolean.valueOf(false);
            }
        } else {
            p.sendMessage(ChatColor.RED + "No tienes permisos para utilizar este comando");
        }
        return false;
    }
}