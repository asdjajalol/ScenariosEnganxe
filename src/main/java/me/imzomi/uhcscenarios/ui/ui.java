package me.imzomi.uhcscenarios.ui;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.manager.ScenarioManager;
import me.imzomi.uhcscenarios.utils.ItemBuilder;
import me.imzomi.uhcscenarios.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ui {
    public static String iname = Utils.chat("&9Scenarios Activated");
    public static void openInventory(Player player) {
        Inventory inv = Bukkit.createInventory(null, 2 * 9, iname);
        ScenarioManager.getInstance().getEnabledScenarios().forEach(s -> inv.addItem(new ItemBuilder(s.getIcon()).setDisplayName(ChatColor.AQUA + s.getName()).build()));
        player.openInventory(inv);
    }
}
