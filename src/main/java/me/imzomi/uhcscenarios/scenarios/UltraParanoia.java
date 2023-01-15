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
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class UltraParanoia extends Scenario implements Listener {
    private Main plugin = Main.pl;
    private boolean enabled = false;

    public UltraParanoia(){
        super("UltraParanoia", new ItemStack(Material.PAPER));
    }

    @EventHandler
    public void onDamage(BlockBreakEvent e){
            Player p = e.getPlayer();
            int x = p.getLocation().getBlockX();
            int y = p.getLocation().getBlockY();
            int z = p.getLocation().getBlockZ();
            if (e.getBlock().getType() == Material.DIAMOND_ORE){
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8[&5UHC&8] &7" + p.getDisplayName() + " mino &bDiamante &7en las coordenadas &fX: " + x + " Y: " + y +  " Z: " + z));
            }else if (e.getBlock().getType() == Material.GOLD_ORE){
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8[&5UHC&8] &7" + p.getDisplayName() + " mino &6Oro &7en las coordenadas &fX: " + x + " Y: " + y +  " Z: " + z));
            }else if (e.getBlock().getType() == Material.ANCIENT_DEBRIS){
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8[&UHC&8] &7" + p.getDisplayName() + " mino &5Ancient Debris &7en las coordenadas &fX: " + x + " Y: " + y +  " Z: " + z));
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
