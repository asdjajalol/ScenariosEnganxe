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
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class NoClean extends Scenario implements Listener{
    private Main plugin = Main.pl;
    private boolean enabled = false;
    public NoClean(){
        super("NoClean", new ItemStack(Material.DIAMOND_CHESTPLATE));
    }
    private List<Player> NoCleanList = new ArrayList<>();

    @EventHandler
    public void noClean(PlayerDeathEvent e){
            if (e.getEntity().getKiller().getType() == EntityType.PLAYER){
                Player p = e.getEntity();
                Player k = e.getEntity().getKiller();
                assert k != null;
                k.setInvulnerable(true);
                NoCleanList.add(k);
                k.sendMessage(Utils.chat("&c[NoClean] Tienes invunerabilidad por 20 segundos."));
                new BukkitRunnable() {
                    public void run() {
                        if (NoCleanList.contains(k)) {
                            k.setInvulnerable(false);
                            k.sendMessage(Utils.chat("&c[NoClean] Ya no eres invunerable."));
                            NoCleanList.remove(k);
                        }else{
                            cancel();
                        }
                    }
                }.runTaskLater(plugin, 20*20L);
            }
        }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e){
            if (e.getEntity().getType() == EntityType.PLAYER && e.getDamager().getType() == EntityType.PLAYER){
                if (NoCleanList.contains(e.getDamager())){
                    e.getDamager().setInvulnerable(false);
                    e.getDamager().sendMessage(Utils.chat("&c[NoClean] Ya no eres invunerable."));
                    NoCleanList.remove(e.getDamager());
                }
            }
            if (e.getEntity().getType() == EntityType.PLAYER && e.getDamager().getType() == EntityType.ARROW){
                Arrow arrow = (Arrow) e.getDamager();
                if (arrow.getShooter() instanceof Player) {
                    Player p = (Player) arrow.getShooter();
                    if (NoCleanList.contains(p)){
                        p.setInvulnerable(false);
                        p.sendMessage(Utils.chat("&c[NoClean] Ya no eres invunerable."));
                        NoCleanList.remove(p);
                    }
                }
            }
            if (e.getEntity().getType() == EntityType.PLAYER && e.getDamager().getType() == EntityType.TRIDENT){
                Trident trident = (Trident) e.getDamager();
                if (trident.getShooter() instanceof Player) {
                    Player p = (Player) trident.getShooter();
                    if (NoCleanList.contains(p)){
                        p.setInvulnerable(false);
                        p.sendMessage(Utils.chat("&c[NoClean] Ya no eres invunerable."));
                        NoCleanList.remove(p);
                    }
                }
            }
            if (e.getEntity().getType() == EntityType.PLAYER && e.getDamager().getType() == EntityType.SPECTRAL_ARROW){
                SpectralArrow arrow = (SpectralArrow) e.getDamager();
                if (arrow.getShooter() instanceof Player) {
                    Player p = (Player) arrow.getShooter();
                    if (NoCleanList.contains(p)){
                        p.setInvulnerable(false);
                        p.sendMessage(Utils.chat("&c[NoClean] Ya no eres invunerable."));
                        NoCleanList.remove(p);
                    }
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
