package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
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
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class CutClean implements Listener, CommandExecutor {

    private Main plugin;
    public CutClean(Main plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        if (plugin.CutClean && !plugin.bareBones) {
            Block block = e.getBlock();
            if (block.getType() == Material.IRON_ORE) {
                if (e.getPlayer().getItemInHand().getType() == Material.STONE_PICKAXE || e.getPlayer().getItemInHand().getType() == Material.IRON_PICKAXE || e.getPlayer().getItemInHand().getType() == Material.DIAMOND_PICKAXE || e.getPlayer().getItemInHand().getType() == Material.NETHERITE_PICKAXE) {
                    e.setCancelled(true);
                    block.setType(Material.AIR);
                    block.getState().update();
                    block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.IRON_INGOT));
                    ExperienceOrb exp = (ExperienceOrb) e.getBlock().getWorld().spawn(e.getBlock().getLocation().add(0, 1, 0), ExperienceOrb.class);
                    exp.setExperience(3);
                }
            }
            if (block.getType() == Material.GOLD_ORE) {
                if (e.getPlayer().getItemInHand().getType() == Material.IRON_PICKAXE || e.getPlayer().getItemInHand().getType() == Material.DIAMOND_PICKAXE || e.getPlayer().getItemInHand().getType() == Material.NETHERITE_PICKAXE){
                    e.setCancelled(true);
                    block.setType(Material.AIR);
                    block.getState().update();
                    block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.GOLD_INGOT));
                    ExperienceOrb exp = (ExperienceOrb) e.getBlock().getWorld().spawn(e.getBlock().getLocation().add(0, 1, 0), ExperienceOrb.class);
                    exp.setExperience(5);
                }
            }
            if (block.getType() == Material.ANCIENT_DEBRIS) {
                if (e.getPlayer().getItemInHand().getType() == Material.DIAMOND_PICKAXE || e.getPlayer().getItemInHand().getType() == Material.NETHERITE_PICKAXE){
                    e.setCancelled(true);
                    block.setType(Material.AIR);
                    block.getState().update();
                    block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.NETHERITE_SCRAP));
                    ExperienceOrb exp = (ExperienceOrb) e.getBlock().getWorld().spawn(e.getBlock().getLocation().add(0, 1, 0), ExperienceOrb.class);
                    exp.setExperience(7);
                }
            }
            if (block.getType() == Material.COAL_ORE) {
                e.setCancelled(true);
                block.setType(Material.AIR);
                block.getState().update();
                block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.TORCH, 2));
                ExperienceOrb exp = (ExperienceOrb) e.getBlock().getWorld().spawn(e.getBlock().getLocation().add(0, 1, 0), ExperienceOrb.class);
                exp.setExperience(3);
            }
        }
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if (plugin.CutClean) {
            for (ItemStack drops : event.getDrops()) {
                if (drops.getType() == Material.PORKCHOP) {
                    drops.setType(Material.COOKED_PORKCHOP);
                } else if (drops.getType() == Material.BEEF) {
                    drops.setType(Material.COOKED_BEEF);
                } else if (drops.getType() == Material.CHICKEN) {
                    drops.setType(Material.COOKED_CHICKEN);
                } else if (drops.getType() == Material.MUTTON) {
                    drops.setType(Material.COOKED_MUTTON);
                } else if (drops.getType() == Material.COD) {
                    drops.setType(Material.COOKED_COD);
                } else if (drops.getType() == Material.SALMON){
                    drops.setType(Material.COOKED_SALMON);
                } else if (drops.getType() == Material.RABBIT){
                    drops.setType(Material.COOKED_RABBIT);
                }
            }
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (sender.hasPermission("uhc.admin") && cmd.getName().equalsIgnoreCase("CutClean")) {
            if (!plugin.CutClean) {
                Bukkit.broadcastMessage(Utils.chat(Main.prefix + "&fCutClean has been " + Main.enabled));
                plugin.CutClean = Boolean.valueOf(true);
            } else {
                Bukkit.broadcastMessage(Utils.chat(Main.prefix + "&fCutClean has been " + Main.disabled));
                plugin.CutClean = Boolean.valueOf(false);
            }
        } else {
            p.sendMessage(ChatColor.RED + "No tienes permisos para utilizar este comando");
        }
        return false;
    }
}

