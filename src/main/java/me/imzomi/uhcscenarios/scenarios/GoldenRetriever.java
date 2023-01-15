package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.manager.Scenario;
import me.imzomi.uhcscenarios.manager.ScenarioManager;
import me.imzomi.uhcscenarios.utils.ItemBuilder;
import me.imzomi.uhcscenarios.utils.Utils;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GoldenRetriever extends Scenario implements Listener {
    private Main plugin = Main.pl;
    private boolean enabled = false;

    public GoldenRetriever() {
        super("GoldenRetriever", new ItemStack(Material.GOLDEN_APPLE));
    }
    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        if (ScenarioManager.getInstance().getScenario("TimeBomb").isEnabled()){
            return;
        }
            Player p = e.getEntity();
            Location loc = p.getLocation();
            World w = p.getWorld();
            w.dropItem(loc, new ItemBuilder(Material.GOLDEN_APPLE).setDisplayName(Utils.chat("&6Golden Head")).build());
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