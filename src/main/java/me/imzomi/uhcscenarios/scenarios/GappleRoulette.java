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
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class GappleRoulette extends Scenario implements Listener {
    private Main plugin = Main.pl;
    private boolean enabled = false;

    public GappleRoulette() {
        super("GappleRoulette", new ItemStack(Material.GOLDEN_APPLE));
    }
    @EventHandler
    public void onConsume(PlayerItemConsumeEvent e){
            if (e.getItem().getType() == Material.GOLDEN_APPLE){
                Player p = e.getPlayer();
                switch (Utils.getRandomInt(27)) {
                    case 1 -> p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE,160,0));
                    case 2 -> p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,160,0));
                    case 3 -> p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION,200,1));
                    case 4 -> p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION,160,0));
                    case 5 -> p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,160,0));
                    case 6 -> p.addPotionEffect(new PotionEffect(PotionEffectType.CONDUIT_POWER,160,0));
                    case 7 -> p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION,160,0));
                    case 8 -> p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING,160,0));
                    case 9 -> p.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING,160,0));
                    case 10 -> p.addPotionEffect(new PotionEffect(PotionEffectType.HARM,160,0));
                    case 11 -> p.addPotionEffect(new PotionEffect(PotionEffectType.HEAL,160,0));
                    case 12 -> p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST,1200,0));
                    case 13 -> p.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER,160,0));
                    case 14 -> p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,160,0));
                    case 15 -> p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,160,0));
                    case 16 -> p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,160,2));
                    case 17 -> p.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION,160,0));
                    case 18 -> p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION,160,0));
                    case 19 -> p.addPotionEffect(new PotionEffect(PotionEffectType.POISON,160,0));
                    case 20 -> p.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION,160,0));
                    case 21 -> p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,160,0));
                    case 22 -> p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING,160,1));
                    case 23 -> p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING,160,0));
                    case 24 -> p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,160,0));
                    case 25 -> p.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING,160,0));
                    case 26 -> p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS,160,0));
                    case 27 -> p.addPotionEffect(new PotionEffect(PotionEffectType.WITHER,160,0));
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

