package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
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
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class GappleRoulette implements Listener, CommandExecutor {

    private Main plugin;

    public GappleRoulette(Main plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onConsume(PlayerItemConsumeEvent e){
        if (plugin.GappleRoulette){
            if (e.getItem().getType() == Material.GOLDEN_APPLE){
                Player p = (Player) e.getPlayer();
                Random random = new Random();
                int rand = random.nextInt(27);
                if (rand == 0){
                    p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 160, 0));
                }
                else if (rand == 1){
                    p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 160, 0));
                } else if (rand == 2){
                    p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 200, 1));
                } else if (rand == 3){
                    p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 160, 0));
                } else if (rand == 4){
                    p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 160, 0));
                } else if (rand == 5){
                    p.addPotionEffect(new PotionEffect(PotionEffectType.CONDUIT_POWER, 160, 0));
                } else if (rand == 6){
                    p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 160, 0));
                } else if (rand == 7){
                    p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 160, 0));
                } else if (rand == 8){
                    p.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 160, 0));
                } else if (rand == 9){
                    p.addPotionEffect(new PotionEffect(PotionEffectType.HARM, 160, 0));
                } else if (rand == 10){
                    p.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 160, 0));
                }else if (rand == 11){
                    p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 1200, 0));
                }else if (rand == 12){
                    p.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 160, 0));
                }else if (rand == 13){
                    p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 160, 0));
                }else if (rand == 14){
                    p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 160, 0));
                }else if (rand == 15){
                    p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 160, 2));
                }else if (rand == 16){
                    p.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 160, 0));
                }else if (rand == 17){
                    p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 160, 0));
                }else if (rand == 18){
                    p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 160, 0));
                }else if (rand == 19){
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 160, 0));
                }else if (rand == 20){
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 160, 0));
                }else if (rand == 21){
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 160, 1));
                }else if (rand == 22){
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 160, 0));
                }else if (rand == 23){
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 160, 0));
                }else if (rand == 24){
                    p.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 160, 0));
                }else if (rand == 25){
                    p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 160, 0));
                }else if (rand == 26){
                    p.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 160, 0));
                }
            }
        }
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (!(sender instanceof Player)) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "Enganxe" + ChatColor.DARK_GRAY + "]" + ChatColor.RED + " No puedes ejecutar comandos desde la consola");
        }
        if (sender.hasPermission("uhc.admin") && cmd.getName().equalsIgnoreCase("GappleRoulette")) {
            if (!plugin.GappleRoulette) {
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.DARK_GRAY+ "["+ChatColor.GOLD+"Enganxe"+ChatColor.DARK_GRAY+"]"+ " &0➤ &fGappleRoulette has been &aenabled"));
                plugin.GappleRoulette = Boolean.valueOf(true);
            } else {
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.DARK_GRAY+ "["+ChatColor.GOLD+"Enganxe"+ChatColor.DARK_GRAY+"]"+ " &0➤ &fGappleRoulette has been &cdisabled"));
                plugin.GappleRoulette = Boolean.valueOf(false);
            }
        } else {
            p.sendMessage(ChatColor.RED + "No tienes permisos para utilizar este comando");
        }
        return false;
    }
}

