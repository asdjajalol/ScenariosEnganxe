package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.manager.Scenario;
import me.imzomi.uhcscenarios.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class VengefulSpirits extends Scenario implements Listener {
    private Main plugin = Main.pl;
    private boolean enabled = false;

    public VengefulSpirits(){
        super("VengefulSpirits", new ItemStack(Material.GHAST_TEAR));
    }
    @EventHandler
    public void onDeath(EntityDeathEvent e){
            if (e.getEntity().getType() == EntityType.PLAYER){
                if (e.getEntity().getLocation().getBlockY() >= 60){
                    e.getEntity().getWorld().spawn(e.getEntity().getLocation().add(0, 2, 0), Ghast.class);
                }else if (e.getEntity().getLocation().getBlockY() < 60){
                    e.getEntity().getWorld().spawn(e.getEntity().getLocation().add(0, 2, 0), Blaze.class);
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

