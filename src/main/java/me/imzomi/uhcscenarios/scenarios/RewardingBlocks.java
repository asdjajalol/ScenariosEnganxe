package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.manager.Scenario;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Skull;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;
import java.util.UUID;

public class RewardingBlocks extends Scenario implements Listener {
    private Main pl = Main.pl;
    private boolean enabled = false;

    public RewardingBlocks() {
        super("RewardingBlocks", new ItemStack(Material.DIAMOND_BLOCK));
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        final Player p = e.getEntity();
        final int PlayerLocX = p.getLocation().getBlockX();
        final int PlayerLocZ = p.getLocation().getBlockZ();
        final int PlayerY = p.getLocation().getBlockY();
        final int PlayerY1 = PlayerY + 1;
        final int PlayerY2 = PlayerY - 1;
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

    @Override
    protected void setEnabled(boolean b) {
        enabled = b;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
