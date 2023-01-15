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
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

public class EnchantedDeath extends Scenario implements Listener{
    private Main plugin = Main.pl;
    private boolean enabled = false;

    public EnchantedDeath(){
        super("EnchantedDeath", new ItemStack(Material.ENCHANTING_TABLE));
    }

    @EventHandler
    public void EnchantedDeath(EntityDeathEvent e){
            if (e.getEntity().getType() == EntityType.PLAYER){
                if (ScenarioManager.getInstance().getScenario("TimeBomb").isEnabled()){
                    return;
                }
                ItemStack Enchants = new ItemStack(Material.ENCHANTING_TABLE, 1);
                e.getDrops().add(Enchants);
            }
        }
    @EventHandler
    public void enchantedDeath(CraftItemEvent e){
            if (e.getRecipe().getResult().getType() == Material.ENCHANTING_TABLE){
                e.setCancelled(true);
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
