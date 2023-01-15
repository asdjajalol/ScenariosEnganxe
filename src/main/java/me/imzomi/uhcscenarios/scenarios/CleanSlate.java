package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.manager.Scenario;
import me.imzomi.uhcscenarios.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.Objects;

public class CleanSlate extends Scenario implements Listener {
    private Main pl = Main.pl;
    private boolean enabled = false;

    public CleanSlate() {
        super("CleanSlate", new ItemStack(Material.GRINDSTONE));
    }

    @EventHandler
    public void onKill(PlayerDeathEvent e) {
            Player k = e.getEntity().getKiller();
            if (k != null) {
                Arrays.stream(k.getInventory().getContents()).filter(Objects::nonNull).filter(i -> !i.getType().equals(Material.AIR)).forEach(i -> i.getEnchantments().keySet().forEach(i::removeEnchantment));
                Arrays.stream(k.getInventory().getArmorContents()).filter(Objects::nonNull).filter(i -> !i.getType().equals(Material.AIR)).forEach(i -> i.getEnchantments().keySet().forEach(i::removeEnchantment));
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
