package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.manager.Scenario;
import me.imzomi.uhcscenarios.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

public class AbsorptionLess extends Scenario implements Listener{

    private Main plugin = Main.pl;
    private boolean enabled = false;
    public AbsorptionLess(){
        super("AbsortionLess", new ItemStack(Material.GOLDEN_APPLE));
    }
    @EventHandler
    public void on(PlayerItemConsumeEvent e) {
            if (e.getItem().getType() == Material.GOLDEN_APPLE || e.getItem().getType() == Material.ENCHANTED_GOLDEN_APPLE) {
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                    @Override
                    public void run() {
                        e.getPlayer().removePotionEffect(PotionEffectType.ABSORPTION);
                    }
                }, 1L);
            }
        }

    @Override
    protected void setEnabled(boolean b) {
        enabled = b;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}