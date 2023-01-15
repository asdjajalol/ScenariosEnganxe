package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.manager.Scenario;
import me.imzomi.uhcscenarios.utils.Utils;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class PermaKill extends Scenario implements Listener{
    private Main plugin = Main.pl;
    private boolean enabled = false;

    public PermaKill(){
        super("PermaKill", new ItemStack(Material.CLOCK));
    }
        @EventHandler
        public void onPlayerDeath(EntityDeathEvent e) {
                if (e.getEntity().getType() == EntityType.PLAYER) {
                    Player p = (Player) e.getEntity();
                    World world = p.getWorld();
                    world.setTime(world.getTime() + 12000);
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

