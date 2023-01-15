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

public class DamageParanoia extends Scenario implements Listener{
    private Main plugin = Main.pl;
    private boolean enabled = false;

    public DamageParanoia(){
        super("DamageParanoia", new ItemStack(Material.MAP));
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e){
            if (e.getEntity().getType() == EntityType.PLAYER){
                Player p = (Player) e.getEntity();
                int x = p.getLocation().getBlockX();
                int y = p.getLocation().getBlockY();
                int z = p.getLocation().getBlockZ();
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8[&5UHC&8] &7" + p.getDisplayName() + " perdio vida en las coordenadas X: " + x + " Y: " + y +  " Z: " + z));
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
