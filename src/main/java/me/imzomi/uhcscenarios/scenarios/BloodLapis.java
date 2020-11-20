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
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BloodLapis implements Listener, CommandExecutor {

    private Main plugin;
    public BloodLapis(Main plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){
        if (plugin.BloodLapis){
            if (e.getBlock().getType() == Material.LAPIS_ORE){
                Player p = e.getPlayer();
                p.getWorld().playSound(p.getLocation(), Sound.ENTITY_PLAYER_HURT, 1, 1);

                if (p.getHealth() < 1){
                    p.setHealth(0);
                }else {
                    p.setHealth(p.getHealth() - 1);
                }
            }
        }
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (sender.hasPermission("uhc.admin") && cmd.getName().equalsIgnoreCase("BloodLapis")) {
            if (!plugin.BloodLapis) {
                Bukkit.broadcastMessage(Utils.chat(Main.prefix + "&fBloodLapis has been " + Main.enabled));
                plugin.BloodLapis = Boolean.valueOf(true);
            } else {
                Bukkit.broadcastMessage(Utils.chat(Main.prefix + "&fBloodLapis has been " + Main.disabled));
                plugin.BloodLapis = Boolean.valueOf(false);
            }
        } else {
            p.sendMessage(ChatColor.RED + "No tienes permisos para utilizar este comando");
        }
        return false;
    }
}
