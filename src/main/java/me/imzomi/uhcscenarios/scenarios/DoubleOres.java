package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.manager.Scenario;
import me.imzomi.uhcscenarios.manager.ScenarioManager;
import me.imzomi.uhcscenarios.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class DoubleOres extends Scenario implements Listener{
    private Main plugin = Main.pl;
    private boolean enabled = false;

    public DoubleOres(){
        super("DoubleOres", new ItemStack(Material.IRON_INGOT,2));
    }
    @EventHandler
    public void doubleOres(BlockBreakEvent e) {
        ScenarioManager scen = ScenarioManager.getInstance();
        if (!scen.getScenario("BareBones").isEnabled()) {
            Block block = e.getBlock();
            if (e.getBlock().getType() == Material.COAL_ORE) {
                e.setCancelled(true);
                block.setType(Material.AIR);
                block.getState().update();
                block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.COAL, 2));
                ExperienceOrb exp = (ExperienceOrb) e.getBlock().getWorld().spawn(e.getBlock().getLocation().add(0, 1, 0), ExperienceOrb.class);
                exp.setExperience(6);
            } else if (e.getBlock().getType() == Material.IRON_ORE) {
                if (e.getPlayer().getItemInHand().getType() == Material.STONE_PICKAXE || e.getPlayer().getItemInHand().getType() == Material.IRON_PICKAXE || e.getPlayer().getItemInHand().getType() == Material.DIAMOND_PICKAXE || e.getPlayer().getItemInHand().getType() == Material.NETHERITE_PICKAXE) {
                    e.setCancelled(true);
                    block.setType(Material.AIR);
                    block.getState().update();
                    block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.IRON_INGOT, 2));
                    ExperienceOrb exp = (ExperienceOrb) e.getBlock().getWorld().spawn(e.getBlock().getLocation().add(0, 1, 0), ExperienceOrb.class);
                    exp.setExperience(6);
                }
            } else if (e.getBlock().getType() == Material.GOLD_ORE) {
                if (e.getPlayer().getItemInHand().getType() == Material.IRON_PICKAXE || e.getPlayer().getItemInHand().getType() == Material.DIAMOND_PICKAXE || e.getPlayer().getItemInHand().getType() == Material.NETHERITE_PICKAXE) {
                    e.setCancelled(true);
                    block.setType(Material.AIR);
                    block.getState().update();
                    block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.GOLD_INGOT, 2));
                    ExperienceOrb exp = (ExperienceOrb) e.getBlock().getWorld().spawn(e.getBlock().getLocation().add(0, 1, 0), ExperienceOrb.class);
                    exp.setExperience(10);
                }
            }else if (e.getBlock().getType() == Material.DIAMOND_ORE){
                if (e.getPlayer().getItemInHand().getType() == Material.IRON_PICKAXE || e.getPlayer().getItemInHand().getType() == Material.DIAMOND_PICKAXE || e.getPlayer().getItemInHand().getType() == Material.NETHERITE_PICKAXE) {
                    e.setCancelled(true);
                    block.setType(Material.AIR);
                    block.getState().update();
                    block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.DIAMOND, 2));
                    ExperienceOrb exp = (ExperienceOrb) e.getBlock().getWorld().spawn(e.getBlock().getLocation().add(0, 1, 0), ExperienceOrb.class);
                    exp.setExperience(10);
                }
            }else if (e.getBlock().getType() == Material.EMERALD_ORE) {
                if (e.getPlayer().getItemInHand().getType() == Material.IRON_PICKAXE || e.getPlayer().getItemInHand().getType() == Material.DIAMOND_PICKAXE || e.getPlayer().getItemInHand().getType() == Material.NETHERITE_PICKAXE) {
                    e.setCancelled(true);
                    block.setType(Material.AIR);
                    block.getState().update();
                    block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.EMERALD, 2));
                    ExperienceOrb exp = (ExperienceOrb) e.getBlock().getWorld().spawn(e.getBlock().getLocation().add(0, 1, 0), ExperienceOrb.class);
                    exp.setExperience(10);
                }
            }else if (e.getBlock().getType() == Material.ANCIENT_DEBRIS){
                if (e.getPlayer().getItemInHand().getType() == Material.DIAMOND_PICKAXE || e.getPlayer().getItemInHand().getType() == Material.NETHERITE_PICKAXE){
                    e.setCancelled(true);
                    block.setType(Material.AIR);
                    block.getState().update();
                    block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.NETHERITE_SCRAP, 2));
                    ExperienceOrb exp = (ExperienceOrb) e.getBlock().getWorld().spawn(e.getBlock().getLocation().add(0, 1, 0), ExperienceOrb.class);
                    exp.setExperience(12);
                }
            }
            else if (e.getBlock().getType() == Material.GRAVEL) {
                e.setCancelled(true);
                block.setType(Material.AIR);
                block.getState().update();
                block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.FLINT));
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
