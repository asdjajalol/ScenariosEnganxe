package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class Switcheroo implements Listener, CommandExecutor {

    private Main plugin;

    public Switcheroo(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDamage(EntityDamageByEntityEvent e) {
        if (plugin.Switcheroo) {
            if (!(e.getEntity() instanceof Player)) {
                return;
            }

            Player player = ((Player) e.getEntity()).getPlayer();

            if (!(e.getDamager() instanceof Arrow)) {
                return;
            }

            Arrow arrow = (Arrow) e.getDamager();

            if (!(arrow.getShooter() instanceof Player)) {
                return;
            }

            Player shooter = ((Player) arrow.getShooter()).getPlayer();

            if (player.equals(shooter)) {
                return;
            }

            Location playerLoc = player.getLocation();
            Location shooterLoc = shooter.getLocation();

            player.teleport(shooterLoc);
            shooter.teleport(playerLoc);
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (sender.hasPermission("uhc.admin") && cmd.getName().equalsIgnoreCase("Switcheroo")) {
            if (!plugin.Switcheroo) {
                Bukkit.broadcastMessage(Utils.chat(Main.prefix + "&fSwitcheroo has been " + Main.enabled));
                plugin.Switcheroo = Boolean.valueOf(true);
            } else {
                Bukkit.broadcastMessage( Utils.chat(Main.prefix + "&fSwitcheroo has been " + Main.disabled));
                plugin.Switcheroo = Boolean.valueOf(false);
            }
        } else {
            p.sendMessage(ChatColor.RED + "No tienes permisos para utilizar este comando");
        }
        return false;
    }
}
