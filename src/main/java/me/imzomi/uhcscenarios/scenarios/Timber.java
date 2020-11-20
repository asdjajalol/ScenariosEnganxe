package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
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
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.Objects;

public class Timber implements Listener, CommandExecutor {

    private Main plugin;
    public Timber(Main plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void onBreak(BlockBreakEvent e){
        if (plugin.Timber){
            if (e.getBlock().getType() == Material.OAK_LOG || e.getBlock().getType() == Material.BIRCH_LOG || e.getBlock().getType() == Material.SPRUCE_LOG || e.getBlock().getType() == Material.JUNGLE_LOG || e.getBlock().getType() == Material.ACACIA_LOG || e.getBlock().getType() == Material.DARK_OAK_LOG || e.getBlock().getType() == Material.CRIMSON_STEM || e.getBlock().getType() == Material.WARPED_STEM) {
                Block b = e.getBlock();
                if (b.getType() != Material.OAK_LOG && b.getType() != Material.BIRCH_LOG && b.getType() != Material.SPRUCE_LOG && b.getType() != Material.JUNGLE_LOG && b.getType() != Material.ACACIA_LOG && b.getType() != Material.DARK_OAK_LOG && b.getType() != Material.CRIMSON_STEM && b.getType() != Material.WARPED_STEM)
                    return;
                b = b.getRelative(BlockFace.UP);
                while (b.getType() == Material.OAK_LOG || b.getType() == Material.BIRCH_LOG || b.getType() == Material.SPRUCE_LOG || b.getType() == Material.JUNGLE_LOG || b.getType() == Material.ACACIA_LOG || b.getType() == Material.DARK_OAK_LOG || b.getType() == Material.CRIMSON_STEM || b.getType() == Material.WARPED_STEM) {
                    b.breakNaturally();
                    Objects.requireNonNull(b.getLocation().getWorld()).playEffect(b.getLocation(), Effect.STEP_SOUND, Material.OAK_LOG);
                    b = b.getRelative(BlockFace.UP);
                }
            }
        }
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (sender.hasPermission("uhc.admin") && cmd.getName().equalsIgnoreCase("Timber")) {
            if (!plugin.Timber) {
                Bukkit.broadcastMessage(Utils.chat(Main.prefix + "&fTimber has been " + Main.enabled));
                plugin.Timber = Boolean.valueOf(true);
            } else {
                Bukkit.broadcastMessage(Utils.chat(Main.prefix + "&fTimber has been " + Main.disabled));
                plugin.Timber = Boolean.valueOf(false);
            }
        } else {
            p.sendMessage(ChatColor.RED + "No tienes permisos para utilizar este comando");
        }
        return false;
    }
}
