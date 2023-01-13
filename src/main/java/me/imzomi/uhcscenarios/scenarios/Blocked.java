package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.ArrayList;
import java.util.HashMap;

public class Blocked implements Listener, CommandExecutor {
    private Main pl = Main.pl;
    private final HashMap<String, ArrayList<Block>> blocks;

    public Blocked() {
        pl.getServer().getPluginManager().registerEvents(this,pl);
        pl.getCommand("blocked").setExecutor(this);
        blocks = new HashMap<>();
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        if (pl.blocked) {
            Player p = e.getPlayer();
            Block b = e.getBlock();
            switch (p.getWorld().getName()) {
                case "uhc", "nether" -> blocks.getOrDefault(p.getName(), new ArrayList<>()).add(b);
            }
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        if (pl.blocked) {
            Player p = e.getPlayer();
            Block b = e.getBlock();
            switch (p.getWorld().getName()) {
                case "uhc", "nether" -> {
                    if (blocks.getOrDefault(p.getName(), new ArrayList<>()).contains(b)) e.setCancelled(true);
                }
            }
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender.hasPermission("uhc.admin") && cmd.getName().equalsIgnoreCase("blocked")) {
            pl.blocked = !pl.blocked;
            Bukkit.broadcastMessage(Utils.chat(pl.prefix + "&fBlocked has been " + (pl.blocked ? Main.enabled : Main.disabled)));
        }
        return false;
    }
}
