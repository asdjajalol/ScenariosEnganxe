package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class FastGetaway
        implements Listener, CommandExecutor {

    private Main plugin;
    public FastGetaway
            (Main plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void FastGetaway(EntityDeathEvent e){
        if (plugin.FastGetaway){
            if (e.getEntity().getType() == EntityType.PLAYER && e.getEntity().getKiller().getType() == EntityType.PLAYER){
                e.getEntity().getKiller().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200, 1, false, false));
            }
        }
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (sender.hasPermission("uhc.admin") && cmd.getName().equalsIgnoreCase("FastGetaway")) {
            if (!plugin.FastGetaway) {
                Bukkit.broadcastMessage(Utils.chat(Main.prefix + "&fFastGetaway has been " + Main.enabled));
                plugin.FastGetaway = Boolean.valueOf(true);
            } else {
                Bukkit.broadcastMessage(Utils.chat(Main.prefix + "&fFastGetaway has been " + Main.disabled));
                plugin.FastGetaway = Boolean.valueOf(false);
            }
        } else {
            p.sendMessage(ChatColor.RED + "No tienes permisos para utilizar este comando");
        }
        return false;
    }
}

