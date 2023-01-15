package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.manager.Scenario;
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

public class BetaZombies extends Scenario implements Listener {
    private Main pl = Main.pl;
    private boolean enabled = false;

    public BetaZombies() {
        super("BetaZombies", new ItemStack(Material.ZOMBIE_HEAD));
    }
    @EventHandler
    public void onDeath(EntityDeathEvent e) {
            if (e.getEntityType().equals(EntityType.ZOMBIE)) e.getDrops().add(new ItemStack(Material.FEATHER));
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
