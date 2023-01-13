package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.Objects;

public class CleanSlate implements Listener, CommandExecutor {
    private Main pl = Main.pl;

    public CleanSlate() {
        pl.getServer().getPluginManager().registerEvents(this,pl);
        pl.getCommand("cleanslate").setExecutor(this);
    }

    @EventHandler
    public void onKill(PlayerDeathEvent e) {
        if (pl.cleanslate) {
            Player k = e.getEntity().getKiller();
            if (k != null) {
                Arrays.stream(k.getInventory().getContents()).filter(Objects::nonNull).filter(i -> !i.getType().equals(Material.AIR)).forEach(i -> i.getEnchantments().keySet().forEach(i::removeEnchantment));
                Arrays.stream(k.getInventory().getArmorContents()).filter(Objects::nonNull).filter(i -> !i.getType().equals(Material.AIR)).forEach(i -> i.getEnchantments().keySet().forEach(i::removeEnchantment));
            }
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender.hasPermission("uhc.admin") && cmd.getName().equalsIgnoreCase("cleanslate")) {
            pl.cleanslate = !pl.cleanslate;
            Bukkit.broadcastMessage(Utils.chat(pl.prefix + "&fCleanSlate has been " + (pl.cleanslate ? Main.enabled : Main.disabled)));
        }
        return false;
    }
}
