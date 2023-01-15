package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.manager.Scenario;
import me.imzomi.uhcscenarios.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

public class Blocked extends Scenario implements Listener {
    private Main pl = Main.pl;
    private boolean enabled = false;
    private final HashMap<String, ArrayList<Block>> blocks;

    public Blocked() {
        super("Blocked", new ItemStack(Material.BARRIER));
        blocks = new HashMap<>();
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
            Player p = e.getPlayer();
            Block b = e.getBlock();
            if (!p.getWorld().getName().equalsIgnoreCase("lobby")) {
                blocks.getOrDefault(p.getName(), new ArrayList<>()).add(b);
            }
        }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
            Player p = e.getPlayer();
            Block b = e.getBlock();
            if (!p.getWorld().getName().equalsIgnoreCase("lobby")) {
                if (blocks.getOrDefault(p.getName(), new ArrayList<>()).contains(b)) e.setCancelled(true);
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
