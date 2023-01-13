package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;

public class BloodEnchant implements Listener, CommandExecutor {
    private Main pl = Main.pl;

    public BloodEnchant() {
        pl.getServer().getPluginManager().registerEvents(this,pl);
        pl.getCommand("bloodenchant").setExecutor(this);
    }

    @EventHandler
    public void onEnchant(EnchantItemEvent e) {
        if (pl.bloodenchant) e.getEnchanter().damage(1);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender.hasPermission("uhc.admin") && cmd.getName().equalsIgnoreCase("bloodenchant")) {
            pl.bloodenchant = !pl.bloodenchant;
            Bukkit.broadcastMessage(Utils.chat(pl.prefix + "&fBloodEnchant has been " + (pl.bloodenchant ? Main.enabled : Main.disabled)));
        }
        return false;
    }
}
