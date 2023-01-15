package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.manager.Scenario;
import me.imzomi.uhcscenarios.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class BloodLapis extends Scenario implements Listener {
    private Main plugin = Main.pl;
    private boolean enabled = false;

    public BloodLapis(){
        super("BloodLapis", new ItemStack(Material.LAPIS_ORE));
    }
    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){
            if (e.getBlock().getType() == Material.LAPIS_ORE){
                Player p = e.getPlayer();
                p.getWorld().playSound(p.getLocation(), Sound.ENTITY_PLAYER_HURT, 1, 1);

                if (p.getHealth() < 1){
                    p.setHealth(0);
                }else {
                    p.setHealth(p.getHealth() - 1);
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
