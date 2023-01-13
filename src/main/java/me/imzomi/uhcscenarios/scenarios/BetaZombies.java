package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class BetaZombies implements Listener, CommandExecutor {
    private Main pl = Main.pl;

    public BetaZombies() {
        pl.getServer().getPluginManager().registerEvents(this,pl);
        pl.getCommand("betazombies").setExecutor(this);
    }
    @EventHandler
    public void onDeath(EntityDeathEvent e) {
        if (pl.betazombies) {
            if (e.getEntityType().equals(EntityType.ZOMBIE)) e.getDrops().add(new ItemStack(Material.FEATHER));
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender.hasPermission("uhc.admin") && cmd.getName().equalsIgnoreCase("betazombies")) {
            pl.betazombies = !pl.betazombies;
            Bukkit.broadcastMessage(Utils.chat(pl.prefix + "&fBetaZombies has been " + (pl.betazombies ? Main.enabled : Main.disabled)));
        }
        return false;
    }
}
