package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.manager.Scenario;
import me.imzomi.uhcscenarios.manager.ScenarioManager;
import me.imzomi.uhcscenarios.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

public class HeavyPockets extends Scenario implements Listener{
    private Main plugin = Main.pl;
    private boolean enabled = false;

    public HeavyPockets(){
        super("HeavyPockets", new ItemStack(Material.NETHERITE_SCRAP));
    }


    @EventHandler
    public void heavyPockets(EntityDeathEvent e) {
        if (ScenarioManager.getInstance().getScenario("TimeBomb").isEnabled()) {
            return;
        }
        if (e.getEntity().getType() == EntityType.PLAYER) {
            ItemStack netherite = new ItemStack(Material.NETHERITE_SCRAP, 2);
            e.getDrops().add(netherite);
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

