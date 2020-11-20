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
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Cripple implements Listener, CommandExecutor {

    private Main plugin;

    public Cripple(Main plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void cripple(EntityDamageEvent e){
        if (plugin.Cripple){
            if (e.getEntity().getType() == EntityType.PLAYER){
                if (e.getCause() == EntityDamageEvent.DamageCause.FALL){
                    Player p = (Player) e.getEntity();
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 600, 0, false, false));
                }
            }
        }
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (sender.hasPermission("uhc.admin") && cmd.getName().equalsIgnoreCase("Cripple")) {
            if (!plugin.Cripple) {
                Utils.chat(Main.prefix + "&fCripple has been " + Main.enabled);
                plugin.Cripple = Boolean.valueOf(true);
            } else {
                Utils.chat(Main.prefix + "&fCripple has been " + Main.disabled);
                plugin.Cripple = Boolean.valueOf(false);
            }
        } else {
            p.sendMessage(ChatColor.RED + "No tienes permisos para utilizar este comando");
        }
        return false;
    }
}
