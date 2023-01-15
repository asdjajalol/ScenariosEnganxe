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
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class BleedingSweets extends Scenario implements Listener {
    private Main plugin = Main.pl;
    private boolean enabled = false;

    public BleedingSweets(){
        super("BleedingSweets", new ItemStack(Material.STRING));
    }

    @EventHandler
    public void bleedingSweets(EntityDeathEvent e){
            if (ScenarioManager.getInstance().getScenario("TimeBomb").isEnabled()){
                return;
            }
            if (e.getEntity().getType() == EntityType.PLAYER){
                ItemStack diamond = new ItemStack(Material.DIAMOND, 1);
                ItemStack gold = new ItemStack (Material.GOLD_INGOT, 5);
                ItemStack arrow = new ItemStack(Material.ARROW, 16);
                ItemStack string = new ItemStack(Material.STRING, 2);
                ItemStack book = new ItemStack(Material.BOOK, 1);
                e.getDrops().add(diamond);
                e.getDrops().add(gold);
                e.getDrops().add(arrow);
                e.getDrops().add(string);
                e.getDrops().add(book);
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

