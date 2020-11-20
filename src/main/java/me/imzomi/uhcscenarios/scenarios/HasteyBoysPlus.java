package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
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

public class HasteyBoysPlus implements Listener, CommandExecutor {

    private Main plugin;
    public HasteyBoysPlus(Main plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void OnInventoryClick(InventoryClickEvent e) {
        if (plugin.HasteyBoysPlus) {
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
                        item.addEnchantment(Enchantment.DIG_SPEED, 5);
                        item.addEnchantment(Enchantment.DURABILITY, 3);
                    }
                }
            }
        }
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (sender.hasPermission("uhc.admin") && cmd.getName().equalsIgnoreCase("HasteyBoysPlus")) {
            if (!plugin.HasteyBoysPlus) {
                Bukkit.broadcastMessage(Utils.chat(Main.prefix + "&fHasteyBoys+ has been " + Main.enabled));
                plugin.HasteyBoysPlus = Boolean.valueOf(true);
            } else {
                Bukkit.broadcastMessage(Utils.chat(Main.prefix + "&fHasteyBoys+ has been " + Main.disabled));
                plugin.HasteyBoysPlus = Boolean.valueOf(false);
            }
        } else {
            p.sendMessage(ChatColor.RED + "No tienes permisos para utilizar este comando");
        }
        return false;
    }
}