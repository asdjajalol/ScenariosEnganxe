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
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Cripple extends Scenario implements Listener{
    private Main plugin = Main.pl;
    private boolean enabled = false;

    public Cripple() {
        super("Cripple", new ItemStack(Material.LEATHER_BOOTS));
    }
    @EventHandler
    public void cripple(EntityDamageEvent e){
            if (e.getEntity().getType() == EntityType.PLAYER){
                if (e.getCause() == EntityDamageEvent.DamageCause.FALL){
                    Player p = (Player) e.getEntity();
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 600, 0, false, false));
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
