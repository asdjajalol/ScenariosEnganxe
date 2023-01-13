package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Bat;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class Bats implements Listener, CommandExecutor {
    private Main pl = Main.pl;

    public Bats() {
        pl.getServer().getPluginManager().registerEvents(this,pl);
        pl.getCommand("bats").setExecutor(this);
    }

    @EventHandler
    public void onKill(EntityDeathEvent e) {
        if (pl.bats) {
            if (e.getEntity() instanceof Bat && e.getEntity().getKiller() != null) {
                int i = Utils.getRandomInt(100);
                if (i >= 95) {
                    e.getEntity().getKiller().damage(99999);
                } else {
                    e.getDrops().add(new ItemStack(Material.GOLDEN_APPLE));
                }
            }
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender.hasPermission("uhc.admin") && cmd.getName().equalsIgnoreCase("bats")) {
            pl.bats = !pl.bats;
            Bukkit.broadcastMessage(Utils.chat(pl.prefix + "&fBats has been " + (pl.bats ? Main.enabled : Main.disabled)));
        }
        return false;
    }
}
