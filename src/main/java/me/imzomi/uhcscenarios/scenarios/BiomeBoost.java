package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BiomeBoost implements Listener, CommandExecutor {
    private Main pl = Main.pl;

    public BiomeBoost() {
        pl.getServer().getPluginManager().registerEvents(this,pl);
        pl.getCommand("biomeboost").setExecutor(this);
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        Biome biome = p.getLocation().getBlock().getBiome();
        String b = biome.name();
        if (pl.biomeboost) {
            switch (p.getWorld().getName()) {
                case "uhc", "nether" -> {
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
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender.hasPermission("uhc.admin") && cmd.getName().equalsIgnoreCase("biomeboost")) {
            pl.biomeboost = !pl.biomeboost;
            Bukkit.broadcastMessage(Utils.chat(pl.prefix + "&fBiomeBoost has been " + (pl.biomeboost ? Main.enabled : Main.disabled)));
        }
        return false;
    }
}
