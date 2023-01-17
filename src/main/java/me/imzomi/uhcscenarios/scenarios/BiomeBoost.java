package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.manager.Scenario;
import me.imzomi.uhcscenarios.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BiomeBoost extends Scenario implements Listener{
    private Main pl = Main.pl;
    private boolean enabled = false;

    public BiomeBoost() {
        super("BiomeBoost", new ItemStack(Material.SAND));
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        Biome biome = p.getLocation().getBlock().getBiome();
        String b = biome.name();
        if (!p.getWorld().getName().equals("lobby")) {
            if (b.contains("DESERT") || b.contains("SAVANNA") || b.contains("BADLANDS") || biome.equals(Biome.BASALT_DELTAS)) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 40, 0));
            }
            if (b.contains("PLAINS") || biome.equals(Biome.SOUL_SAND_VALLEY)) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 40, 0));
            }
            if (b.contains("MOUNTAINS") || biome.equals(Biome.NETHER_WASTES)) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 0));
            }
            if (b.contains("RIVER") || b.contains("OCEAN") || b.contains("SWAMP")) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 40, 0));
            }
            if (b.contains("FOREST")) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 40, 0));
            }
            if (p.getWorld().getEnvironment().equals(World.Environment.THE_END)) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 40, 0));
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
