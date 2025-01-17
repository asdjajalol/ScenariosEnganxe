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
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class BlastMining extends Scenario implements Listener{
    private Main plugin = Main.pl;
    private boolean enabled = false;

    public BlastMining(){
        super("BlastMining", new ItemStack(Material.CREEPER_SPAWN_EGG));
    }

    @EventHandler
    public void BlastMining(EntityDeathEvent e){
            if (e.getEntity().getType() == EntityType.PLAYER){
                ItemStack diamond = new ItemStack(Material.DIAMOND, 3);
                ItemStack gold = new ItemStack (Material.GOLD_INGOT, 5);
                ItemStack arrow = new ItemStack(Material.ARROW, 16);
                ItemStack string = new ItemStack(Material.STRING, 1);
                e.getDrops().add(diamond);
                e.getDrops().add(gold);
                e.getDrops().add(arrow);
                e.getDrops().add(string);
            }
    }
    @EventHandler
    public void creeperSpawn(BlockBreakEvent e){
            if (e.getBlock().getType() == Material.COAL_ORE || e.getBlock().getType() == Material.IRON_ORE || e.getBlock().getType() == Material.GOLD_ORE || e.getBlock().getType() == Material.DIAMOND_ORE || e.getBlock().getType() == Material.EMERALD_ORE || e.getBlock().getType() == Material.NETHER_QUARTZ_ORE ||
                    e.getBlock().getType() == Material.ANCIENT_DEBRIS) {
                Random rand = new Random();
                if (rand.nextInt(100) <= 4) {
                    e.getBlock().getWorld().spawn(e.getBlock().getLocation().add(0, 1, 0), Creeper.class);
                }
            }
    }
    @EventHandler
    public void creeperSpawn(CreatureSpawnEvent e){
            if (e.getEntity().getType() == EntityType.CREEPER){
                if (e.getSpawnReason() == CreatureSpawnEvent.SpawnReason.CUSTOM){
                    Creeper c = (Creeper) e.getEntity();
                    c.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 40, 0));
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
