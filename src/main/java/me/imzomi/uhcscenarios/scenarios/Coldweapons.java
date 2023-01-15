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
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class Coldweapons extends Scenario implements Listener{
    private Main plugin = Main.pl;
    private boolean enabled = false;

    public Coldweapons(){
        super("ColdWeapons", new ItemStack(Material.SNOWBALL));
    }
    private static final Enchantment ENCHANTMENT = Enchantment.FIRE_ASPECT;

    @EventHandler
    public void on(EnchantItemEvent event) {
        Map<Enchantment, Integer> toAdd = event.getEnchantsToAdd();

        if (!toAdd.containsKey(ENCHANTMENT)) {
            return;
        }

        toAdd.remove(ENCHANTMENT);
        event.getEnchanter().sendMessage(Utils.chat(Main.prefix + "&cEl UHC es ColdWeapons"));

        if (toAdd.containsKey(Enchantment.DAMAGE_ALL) || toAdd.containsKey(Enchantment.DAMAGE_UNDEAD) || toAdd.containsKey(Enchantment.DAMAGE_ARTHROPODS)) {
            return;
        }

        toAdd.put(Enchantment.DAMAGE_ALL, 1);
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
