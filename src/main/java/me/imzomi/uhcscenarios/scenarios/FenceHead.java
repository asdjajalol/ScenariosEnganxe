package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.manager.Scenario;
import me.imzomi.uhcscenarios.manager.ScenarioManager;
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
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;
import java.util.UUID;

public class FenceHead extends Scenario implements Listener {
    private Main plugin = Main.pl;
    private boolean enabled = false;

    public FenceHead() {
        super("FenceHead", new ItemStack(Material.PLAYER_HEAD));
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
            final Player p = e.getEntity();
            final int PlayerLocX = p.getLocation().getBlockX();
            final int PlayerLocZ = p.getLocation().getBlockZ();
            final int PlayerY = p.getLocation().getBlockY();
            final int PlayerY1 = PlayerY + 1;
            final int PlayerY2 = PlayerY - 1;
            if (!ScenarioManager.getInstance().getScenario("RewardingBlocks").isEnabled()) {
                (new BukkitRunnable() {
                    public void run() {
                        Block skullBlock = p.getWorld().getBlockAt(PlayerLocX, PlayerY1, PlayerLocZ);
                        skullBlock.setType(Material.PLAYER_HEAD);
                        BlockState state = skullBlock.getState();
                        Skull skullState = (Skull) state;
                        UUID uuid = p.getUniqueId();
                        skullState.setOwningPlayer(Bukkit.getServer().getOfflinePlayer(uuid));
                        skullState.update();
                        if (!ScenarioManager.getInstance().getScenario("TimeBomb").isEnabled()) {
                            p.getWorld().getBlockAt(PlayerLocX, PlayerY, PlayerLocZ).setType(Material.NETHER_BRICK_FENCE);
                        }
                    }
                }).runTaskLater(this.plugin, 10L);
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