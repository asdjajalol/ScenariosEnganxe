package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.manager.Scenario;
import me.imzomi.uhcscenarios.manager.ScenarioManager;
import me.imzomi.uhcscenarios.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Chest;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Directional;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

import static org.bukkit.Material.ENCHANTING_TABLE;
import static org.bukkit.Material.GOLDEN_APPLE;

public class TimeBomb extends Scenario implements Listener {
    private Main plugin = Main.pl;
    private boolean enabled = false;

    public TimeBomb (){
        super("TimeBomb", new ItemStack(Material.TNT));
    }

    @EventHandler
    public void on(PlayerDeathEvent event) {
        ScenarioManager scen = ScenarioManager.getInstance();
            final Player player = event.getEntity();
            final Location loc = player.getLocation().clone();

            Block leftSide = loc.getBlock();
            Block rightSide = loc.clone().add(-1, 0, 0).getBlock();

            leftSide.setType(Material.CHEST);
            rightSide.setType(Material.CHEST);

            BlockData leftData = leftSide.getBlockData();
            ((Directional) leftData).setFacing(BlockFace.NORTH);
            leftSide.setBlockData(leftData);

            org.bukkit.block.data.type.Chest chestDataLeft = (org.bukkit.block.data.type.Chest) leftData;
            chestDataLeft.setType(org.bukkit.block.data.type.Chest.Type.RIGHT);
            leftSide.setBlockData(chestDataLeft);

            Chest chest = (Chest) leftSide.getState();

            BlockData rightData = rightSide.getBlockData();
            ((Directional) rightData).setFacing(BlockFace.NORTH);
            rightSide.setBlockData(rightData);

            org.bukkit.block.data.type.Chest chestDataRight = (org.bukkit.block.data.type.Chest) rightData;
            chestDataRight.setType(org.bukkit.block.data.type.Chest.Type.LEFT);
            rightSide.setBlockData(chestDataRight);

            for (ItemStack item : event.getDrops()) {
                if (item == null || item.getType() == Material.AIR) {
                    continue;
                }
                chest.getInventory().addItem(item);
            }
            ItemStack a = new ItemStack(Material.NETHERITE_SCRAP, 2);
            if (scen.getScenario("BleedingSweets").isEnabled()) {
                ItemStack diamond = new ItemStack(Material.DIAMOND, 1);
                ItemStack gold = new ItemStack(Material.GOLD_INGOT, 5);
                ItemStack arrow = new ItemStack(Material.ARROW, 16);
                ItemStack string = new ItemStack(Material.STRING, 2);
                ItemStack book = new ItemStack(Material.BOOK, 1);
                chest.getInventory().addItem(diamond);
                chest.getInventory().addItem(gold);
                chest.getInventory().addItem(arrow);
                chest.getInventory().addItem(string);
                chest.getInventory().addItem(book);
            }
            if (scen.getScenario("HeavyPockets").isEnabled()) {
                chest.getInventory().addItem(a);
            }

            ItemStack ghead = new ItemStack(GOLDEN_APPLE, 1);
            ItemMeta gheadMeta = ghead.getItemMeta();

            assert gheadMeta != null;
            gheadMeta.setDisplayName(Utils.chat("&6Golden Head"));
            ghead.setItemMeta(gheadMeta);
            if (scen.getScenario("GoldenRetriever").isEnabled()) {
                chest.getInventory().addItem(ghead);
            }
            if (scen.getScenario("EnchantedDeath").isEnabled()) {
                ItemStack e = new ItemStack(ENCHANTING_TABLE, 1);
                chest.getInventory().addItem(e);
            }


            event.getDrops().clear();

            final ArmorStand stand = player.getWorld().spawn(chest.getLocation().clone().add(0.5, 1, 0), ArmorStand.class);

            stand.setCustomNameVisible(true);
            stand.setSmall(true);
            stand.setGravity(false);
            stand.setVisible(false);

            stand.setMarker(true);

            new BukkitRunnable() {
                private int time = 30;

                public void run() {
                    time--;

                    if (time == 0) {
                        Bukkit.broadcastMessage(Main.prefix + player.getName() + "'s §7corpse has exploded!");
                        loc.getBlock().setType(Material.AIR);
                        loc.getWorld().createExplosion(loc.getBlockX() + 0.5, loc.getBlockY() + 0.5, loc.getBlockZ() + 0.5, 3, false, true);
                        loc.getWorld().strikeLightning(loc);
                        stand.remove();
                        cancel();
                        return;
                    } else if (time == 1) {
                        stand.setCustomName("§4" + time + "s");
                    } else if (time == 2) {
                        stand.setCustomName("§c" + time + "s");
                    } else if (time == 3) {
                        stand.setCustomName("§6" + time + "s");
                    } else if (time <= 15) {
                        stand.setCustomName("§e" + time + "s");
                    } else {
                        stand.setCustomName("§a" + time + "s");
                    }
                }
            }.runTaskTimer(plugin, 0, 20);
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
