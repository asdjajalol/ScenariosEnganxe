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
import org.bukkit.event.block.BlockBreakEvent;

public class UltraParanoia implements Listener, CommandExecutor {

    private Main plugin;
    public UltraParanoia(Main plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onDamage(BlockBreakEvent e){
        if (plugin.UltraParanoia){
            Player p = e.getPlayer();
            int x = p.getLocation().getBlockX();
            int y = p.getLocation().getBlockY();
            int z = p.getLocation().getBlockZ();
            if (e.getBlock().getType() == Material.DIAMOND_ORE){
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8[&5UHC&8] &7" + p.getDisplayName() + " mino &bDiamante &7en las coordenadas &fX: " + x + " Y: " + y +  " Z: " + z));
            }else if (e.getBlock().getType() == Material.GOLD_ORE){
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8[&5UHC&8] &7" + p.getDisplayName() + " mino &6Oro &7en las coordenadas &fX: " + x + " Y: " + y +  " Z: " + z));
            }else if (e.getBlock().getType() == Material.ANCIENT_DEBRIS){
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8[&UHC&8] &7" + p.getDisplayName() + " mino &5Ancient Debris &7en las coordenadas &fX: " + x + " Y: " + y +  " Z: " + z));
            }
        }
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (sender.hasPermission("uhc.admin") && cmd.getName().equalsIgnoreCase("UltraParanoia")) {
            if (!plugin.UltraParanoia) {
                Bukkit.broadcastMessage(Utils.chat(Main.prefix + "&fTripleOres has been " + Main.enabled));
                plugin.UltraParanoia = Boolean.valueOf(true);
            } else {
                Bukkit.broadcastMessage(Utils.chat(Main.prefix + "&fTripleOres has been " + Main.disabled));
                plugin.UltraParanoia = Boolean.valueOf(false);
            }
        } else {
            p.sendMessage(ChatColor.RED + "No tienes permisos para utilizar este comando");
        }
        return false;
    }
}
