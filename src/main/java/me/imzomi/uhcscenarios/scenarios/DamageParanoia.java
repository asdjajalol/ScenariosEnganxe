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

public class DamageParanoia implements Listener, CommandExecutor {

    private Main plugin;
    public DamageParanoia(Main plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e){
        if (plugin.DamageParanoia){
            if (e.getEntity().getType() == EntityType.PLAYER){
                Player p = (Player) e.getEntity();
                int x = p.getLocation().getBlockX();
                int y = p.getLocation().getBlockY();
                int z = p.getLocation().getBlockZ();
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8[&5UHC&8] &7" + p.getDisplayName() + " perdio vida en las coordenadas X: " + x + " Y: " + y +  " Z: " + z));
            }
        }
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (sender.hasPermission("uhc.admin") && cmd.getName().equalsIgnoreCase("DamageParanoia")) {
            if (!plugin.DamageParanoia) {
                Bukkit.broadcastMessage(Utils.chat(Main.prefix + "&fDamageParanoia has been " + Main.enabled));
                plugin.DamageParanoia = Boolean.valueOf(true);
            } else {
                Bukkit.broadcastMessage(Utils.chat(Main.prefix + "&fDamageParanoia has been " + Main.disabled));
                plugin.DamageParanoia = Boolean.valueOf(false);
            }
        } else {
            p.sendMessage(ChatColor.RED + "No tienes permisos para utilizar este comando");
        }
        return false;
    }
}
