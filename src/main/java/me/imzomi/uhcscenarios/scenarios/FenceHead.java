package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Skull;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;
import java.util.UUID;

public class FenceHead implements Listener, CommandExecutor {
    private Main plugin;

    public FenceHead(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        if (plugin.FenceHead) {
            final Player p = e.getEntity();
            final int PlayerLocX = p.getLocation().getBlockX();
            final int PlayerLocZ = p.getLocation().getBlockZ();
            final int PlayerY = p.getLocation().getBlockY();
            final int PlayerY1 = PlayerY + 1;
            final int PlayerY2 = PlayerY - 1;
            if (!plugin.RewardingBlocks) {
                (new BukkitRunnable() {
                    public void run() {
                        Block skullBlock = p.getWorld().getBlockAt(PlayerLocX, PlayerY1, PlayerLocZ);
                        skullBlock.setType(Material.PLAYER_HEAD);
                        BlockState state = skullBlock.getState();
                        Skull skullState = (Skull) state;
                        UUID uuid = p.getUniqueId();
                        skullState.setOwningPlayer(Bukkit.getServer().getOfflinePlayer(uuid));
                        skullState.update();
                        p.getWorld().getBlockAt(PlayerLocX, PlayerY, PlayerLocZ).setType(Material.NETHER_BRICK_FENCE);
                    }
                }).runTaskLater(this.plugin, 10L);
            } else if (plugin.RewardingBlocks) {
                (new BukkitRunnable() {
                    public void run() {
                        Block skullBlock = p.getWorld().getBlockAt(PlayerLocX, PlayerY1, PlayerLocZ);
                        skullBlock.setType(Material.PLAYER_HEAD);
                        BlockState state = skullBlock.getState();
                        Skull skullState = (Skull) state;
                        UUID uuid = p.getUniqueId();
                        skullState.setOwningPlayer(Bukkit.getServer().getOfflinePlayer(uuid));
                        skullState.update();
                        p.getWorld().getBlockAt(PlayerLocX, PlayerY, PlayerLocZ).setType(Material.NETHER_BRICK_FENCE);
                        switch (new Random().nextInt(4)) {
                            case 0:
                                p.getWorld().getBlockAt(PlayerLocX, PlayerY2, PlayerLocZ).setType(Material.DIAMOND_BLOCK);
                            case 1:
                                p.getWorld().getBlockAt(PlayerLocX, PlayerY2, PlayerLocZ).setType(Material.GOLD_BLOCK);
                            case 2:
                                p.getWorld().getBlockAt(PlayerLocX, PlayerY2, PlayerLocZ).setType(Material.IRON_BLOCK);
                            case 3:
                                p.getWorld().getBlockAt(PlayerLocX, PlayerY2, PlayerLocZ).setType(Material.EMERALD_BLOCK);
                        }
                    }
                }).runTaskLater(this.plugin, 10L);
            }
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (sender.hasPermission("uhc.admin")) {
            if (cmd.getName().equalsIgnoreCase("FenceHead")) {
                if (!plugin.FenceHead) {
                    Bukkit.broadcastMessage(Utils.chat(Main.prefix + "&fFenceHead has been " + Main.enabled));
                    plugin.FenceHead = Boolean.valueOf(true);
                } else {
                    Bukkit.broadcastMessage(Utils.chat(Main.prefix + "&fFenceHead has been " + Main.disabled));
                    plugin.FenceHead = Boolean.valueOf(false);
                }
            } else if (cmd.getName().equalsIgnoreCase("RewardingBlocks")) {
                if (!plugin.RewardingBlocks) {
                    Bukkit.broadcastMessage(Utils.chat(Main.prefix + "&fRewardingBlocks has been " + Main.enabled));
                    plugin.RewardingBlocks = Boolean.valueOf(true);
                } else {
                    Bukkit.broadcastMessage(Utils.chat(Main.prefix + "&fRewardingBlocks has been " + Main.disabled));
                    plugin.RewardingBlocks = Boolean.valueOf(false);
                }
            }
        }else{
            p.sendMessage(ChatColor.RED + "No tienes permisos para utilizar este comando");
        }
        return false;
    }
}