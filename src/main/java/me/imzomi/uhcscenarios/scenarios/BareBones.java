package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.manager.Scenario;
import me.imzomi.uhcscenarios.manager.ScenarioManager;
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
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

public class BareBones extends Scenario implements Listener{
    private Main pl = Main.pl;
    private boolean enabled = false;

    public BareBones() {
        super("BareBones", new ItemStack(Material.BONE_BLOCK));
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
            Player p = e.getPlayer();
            Block b = e.getBlock();
            ScenarioManager scen = ScenarioManager.getInstance();
            ItemStack replaced = new ItemStack(scen.getScenario("CutClean").isEnabled() ? Material.IRON_INGOT : Material.IRON_ORE);
            if (scen.getScenario("DoubleOres").isEnabled()) {
                replaced.setAmount(2);
            } else if (scen.getScenario("TripleOres").isEnabled()) {
                replaced.setAmount(3);
            }
            switch (b.getType()) {
                case GOLD_ORE, DIAMOND_ORE -> {
                    if (b.getDrops(p.getInventory().getItemInMainHand()).isEmpty()) return;
                    e.setDropItems(false);
                    b.getWorld().dropItemNaturally(b.getLocation(), replaced);
                }
            }
        }

    @EventHandler
    public void onCraft(CraftItemEvent e) {
            switch (e.getRecipe().getResult().getType()) {
                case ENCHANTING_TABLE, ANVIL, GOLDEN_APPLE -> e.setCancelled(true);
            }
        }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
            e.getDrops().add(new ItemStack(Material.DIAMOND));
            e.getDrops().add(new ItemStack(Material.GOLDEN_APPLE));
            e.getDrops().add(new ItemStack(Material.ARROW,12));
            e.getDrops().add(new ItemStack(Material.STRING,2));
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
