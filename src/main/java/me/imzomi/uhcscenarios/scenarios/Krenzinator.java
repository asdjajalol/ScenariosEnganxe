package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.vehicle.VehicleEnterEvent;

public class Krenzinator implements Listener, CommandExecutor {

    private Main plugin;
    public Krenzinator(Main plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void nether(PlayerTeleportEvent e){
        if (plugin.Krenzinator){
            if (e.getCause() == PlayerTeleportEvent.TeleportCause.NETHER_PORTAL){
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void diamondSword(CraftItemEvent e){
        if (plugin.Krenzinator){
            Player p = (Player) e.getWhoClicked();
            if(e.getRecipe().getResult().getType() == Material.DIAMOND_SWORD){
                p.getWorld().playSound(p.getLocation(), Sound.ENTITY_PLAYER_HURT, 1, 1);
                if (p.getHealth() < 2){
                    p.setHealth(0);
                }else {
                    p.setHealth(p.getHealth() - 2);
                }
            }
        }
    }

    @EventHandler
    public void onMount(VehicleEnterEvent e) {
        if (plugin.Krenzinator) {
            if (e.getVehicle() instanceof Horse && e.getEntered() instanceof Player) {
                Horse horse = (Horse) e.getVehicle();
                if (horse.getType() == EntityType.DONKEY) { return; }
                ((Player) e.getEntered()).sendMessage(ChatColor.RED + "You can't mount horses in this gamemode!");
                e.setCancelled(true);
            }
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (sender.hasPermission("uhc.admin") && cmd.getName().equalsIgnoreCase("Krenzinator")) {
            if (!plugin.Krenzinator) {
                Bukkit.broadcastMessage(Utils.chat(Main.prefix + "&fKrenzinator has been " + Main.enabled));
                plugin.Krenzinator = Boolean.valueOf(true);
                plugin.addDiamondRecipe();
            } else {
                Bukkit.broadcastMessage( Utils.chat(Main.prefix + "&fKrenzinator has been " + Main.disabled));
                plugin.Krenzinator = Boolean.valueOf(false);
                plugin.removeDiamondRecipe();
            }
        } else {
            p.sendMessage(ChatColor.RED + "No tienes permisos para utilizar este comando");
        }
        return false;
    }
}
