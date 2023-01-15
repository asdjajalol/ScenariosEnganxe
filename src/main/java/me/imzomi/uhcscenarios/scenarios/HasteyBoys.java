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
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class HasteyBoys extends Scenario implements Listener{
    private Main plugin = Main.pl;
    private boolean enabled = false;

    public HasteyBoys(){
        super("HasteyBoys", new ItemStack(Material.DIAMOND_PICKAXE));
    }
    @EventHandler
    public void OnInventoryClick(InventoryClickEvent e) {
            if (e.getClickedInventory() != null) {
                if (e.getCurrentItem() != null) {
                    ItemStack item = e.getCurrentItem();
                    Material type = item.getType();
                    if (type == Material.WOODEN_AXE || type == Material.WOODEN_PICKAXE || type == Material.WOODEN_SHOVEL || type == Material.WOODEN_HOE ||
                            type == Material.STONE_AXE || type == Material.STONE_PICKAXE || type == Material.STONE_SHOVEL || type == Material.STONE_HOE ||
                            type == Material.IRON_AXE || type == Material.IRON_PICKAXE || type == Material.IRON_SHOVEL || type == Material.IRON_HOE ||
                            type == Material.GOLDEN_AXE || type == Material.GOLDEN_PICKAXE || type == Material.GOLDEN_SHOVEL || type == Material.GOLDEN_HOE ||
                            type == Material.DIAMOND_AXE || type == Material.DIAMOND_PICKAXE || type == Material.DIAMOND_SHOVEL || type == Material.DIAMOND_HOE ||
                            type == Material.NETHERITE_AXE || type == Material.NETHERITE_PICKAXE || type == Material.NETHERITE_SHOVEL || type == Material.NETHERITE_HOE || type == Material.SHEARS) {
                        item.addEnchantment(Enchantment.DIG_SPEED, 3);
                        item.addEnchantment(Enchantment.DURABILITY, 1);
                    }
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
