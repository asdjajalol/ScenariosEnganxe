package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.manager.Scenario;
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

public class Bats extends Scenario implements Listener{
    private Main pl = Main.pl;
    private boolean enabled = false;

    public Bats() {
        super("Bats", new ItemStack(Material.BAT_SPAWN_EGG));
    }

    @EventHandler
    public void onKill(EntityDeathEvent e) {
            if (e.getEntity() instanceof Bat && e.getEntity().getKiller() != null) {
                int i = Utils.getRandomInt(100);
                if (i >= 95) {
                    e.getEntity().getKiller().damage(99999);
                } else {
                    e.getDrops().add(new ItemStack(Material.GOLDEN_APPLE));
                }
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
