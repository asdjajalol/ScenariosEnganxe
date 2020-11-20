package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.utils.Utils;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GoldenRetriever implements Listener, CommandExecutor {

    private Main plugin;

    public GoldenRetriever(Main plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        if (Main.TimeBomb){
            return;
        }
        if (Main.GoldenRetriever){
            Player p = e.getEntity();
            ItemStack gHead = new ItemStack(Material.GOLDEN_APPLE);
            ItemMeta HeadMeta = gHead.getItemMeta();
            HeadMeta.setDisplayName("§6Golden Head");
            gHead.setItemMeta(HeadMeta);
            Location loc = p.getLocation();
            World w = p.getWorld();
            w.dropItem(loc, gHead);
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (sender.hasPermission("uhc.admin") && cmd.getName().equalsIgnoreCase("GoldenRetriever")) {
            if (!plugin.GoldenRetriever) {
                Bukkit.broadcastMessage(Utils.chat(Main.prefix + "&fGoldenRetriever has been " + Main.enabled));
                plugin.GoldenRetriever = Boolean.valueOf(true);
            } else {
                Bukkit.broadcastMessage(Utils.chat(Main.prefix + "&fGappleRoulette has been " + Main.disabled));
                plugin.GoldenRetriever = Boolean.valueOf(false);
            }
        } else {
            p.sendMessage(ChatColor.RED + "No tienes permisos para utilizar este comando");
        }
        return false;
    }
}