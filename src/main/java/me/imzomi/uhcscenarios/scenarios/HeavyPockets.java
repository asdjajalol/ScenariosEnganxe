package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class HeavyPockets
        implements Listener, CommandExecutor {

    private Main plugin;
    public HeavyPockets
            (Main plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void heavyPockets(EntityDeathEvent e){
        if (Main.TimeBomb){
            return;
        }
        if (plugin.HeavyPockets){
            if (e.getEntity().getType() == EntityType.PLAYER){
                ItemStack netherite = new ItemStack(Material.NETHERITE_SCRAP, 2);
                e.getDrops().add(netherite);
            }
        }
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (sender.hasPermission("uhc.admin") && cmd.getName().equalsIgnoreCase("HeavyPockets")) {
            if (!plugin.HeavyPockets) {
                Bukkit.broadcastMessage( Utils.chat(Main.prefix + "&fHeavyPockets has been " + Main.enabled));
                plugin.HeavyPockets = Boolean.valueOf(true);
            } else {
                Bukkit.broadcastMessage(Utils.chat(Main.prefix + "&fHeavyPockets has been " + Main.disabled));
                plugin.HeavyPockets = Boolean.valueOf(false);
            }
        } else {
            p.sendMessage(ChatColor.RED + "No tienes permisos para utilizar este comando");
        }
        return false;
    }
}

