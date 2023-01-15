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
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class BattleParanoia extends Scenario implements Listener {
    private Main pl = Main.pl;
    private boolean enabled = false;

    public BattleParanoia() {
        super("BattleParanoia", new ItemStack(Material.IRON_AXE));
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
            if (e.getEntity() instanceof Player p && e.getDamager() instanceof Player d && !p.getWorld().getName().equalsIgnoreCase("lobby")) {
                int x = p.getLocation().getBlockX();
                int y = p.getLocation().getBlockY();
                int z = p.getLocation().getBlockZ();
                if (Utils.getRandomInt(100) <= 30) {
                    Bukkit.broadcastMessage(Utils.chat(pl.prefix + "&b" + p.getName() + " &fperdió vida contra &b" + d.getName() +
                            " &fen las coordenadas X: &b" + x + " &8| &fY: &b" + y + " &8| &fZ: &b" + z));
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
