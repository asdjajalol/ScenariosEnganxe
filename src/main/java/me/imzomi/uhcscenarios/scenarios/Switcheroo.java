package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.manager.Scenario;
import me.imzomi.uhcscenarios.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class Switcheroo extends Scenario implements Listener {
    private Main plugin = Main.pl;
    private boolean enabled = false;

    public Switcheroo() {
        super("Switcheroo", new ItemStack(Material.ARROW));
    }

    @EventHandler
    public void onPlayerDamage(EntityDamageByEntityEvent e) {
            if (!(e.getEntity() instanceof Player)) {
                return;
            }

            Player player = ((Player) e.getEntity()).getPlayer();

            if (!(e.getDamager() instanceof Arrow)) {
                return;
            }

            Arrow arrow = (Arrow) e.getDamager();

            if (!(arrow.getShooter() instanceof Player)) {
                return;
            }

            Player shooter = ((Player) arrow.getShooter()).getPlayer();

            if (player.equals(shooter)) {
                return;
            }

            Location playerLoc = player.getLocation();
            Location shooterLoc = shooter.getLocation();

            player.teleport(shooterLoc);
            shooter.teleport(playerLoc);
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
