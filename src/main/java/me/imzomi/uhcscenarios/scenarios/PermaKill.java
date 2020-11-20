package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class PermaKill implements Listener, CommandExecutor {

    private Main plugin;
    public PermaKill(Main plugin){
        this.plugin = plugin;
    }
        @EventHandler
        public void onPlayerDeath(EntityDeathEvent e) {
            if (plugin.PermaKill) {
                if (e.getEntity().getType() == EntityType.PLAYER) {
                    Player p = (Player) e.getEntity();
                    World world = p.getWorld();
                    world.setTime(world.getTime() + 12000);
                }
            }
        }
        @Override
        public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            Player p = (Player) sender;
            if (!(sender instanceof Player)) {
                Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "Enganxe" + ChatColor.DARK_GRAY + "]" + ChatColor.RED + " No puedes ejecutar comandos desde la consola");
            }
            if (sender.hasPermission("uhc.admin") && cmd.getName().equalsIgnoreCase("PermaKill")) {
                if (!plugin.PermaKill) {
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "Enganxe" + ChatColor.DARK_GRAY + "]" + " &0➤ &fPermaKill has been &aenabled"));
                    plugin.PermaKill = Boolean.valueOf(true);
                    p.getWorld().setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
                } else {
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "Enganxe" + ChatColor.DARK_GRAY + "]" + " &0➤ &fPermaKill has been &cdisabled"));
                    plugin.PermaKill = Boolean.valueOf(false);
                    p.getWorld().setGameRule(GameRule.DO_DAYLIGHT_CYCLE, true);
                }
            } else {
                p.sendMessage(ChatColor.RED + "No tienes permisos para utilizar este comando");
            }
            return false;
        }
    }

