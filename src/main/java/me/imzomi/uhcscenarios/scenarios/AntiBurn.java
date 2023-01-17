package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.manager.Scenario;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class AntiBurn extends Scenario implements Listener {
    private boolean enabled = false;

    public AntiBurn() {
        super("AntiBurn", new ItemStack(Material.FLINT_AND_STEEL));
    }

    @EventHandler
    public void onBurn(EntityDamageEvent e) {
        if (e.getEntity() instanceof Item i) {
            switch (e.getCause()) {
                case FIRE, LAVA, FIRE_TICK -> {
                    i.setInvulnerable(true);
                    e.setCancelled(true);
                }
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
