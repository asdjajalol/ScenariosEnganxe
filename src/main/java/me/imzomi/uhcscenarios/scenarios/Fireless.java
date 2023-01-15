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
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class Fireless extends Scenario implements Listener {
    private Main plugin = Main.pl;
    private boolean enabled = false;

    public Fireless(){
        super("FireLess", new ItemStack(Material.FLINT_AND_STEEL));
    }
    @EventHandler
    public void onDamageFireless(EntityDamageEvent e){
            if (e.getEntity() instanceof Player){
            if (e.getCause() == EntityDamageEvent.DamageCause.LAVA || e.getCause() == EntityDamageEvent.DamageCause.FIRE ||e.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK ){
                e.setCancelled(true);
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
