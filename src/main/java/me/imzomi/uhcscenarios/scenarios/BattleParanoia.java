package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class BattleParanoia implements Listener, CommandExecutor {
    private Main pl = Main.pl;

    public BattleParanoia() {
        pl.getServer().getPluginManager().registerEvents(this,pl);
        pl.getCommand("battleparanoia").setExecutor(this);
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if (pl.battleParanoia) {
            if (e.getEntity() instanceof Player p && e.getDamager() instanceof Player d) {
                int x = p.getLocation().getBlockX();
                int y = p.getLocation().getBlockY();
                int z = p.getLocation().getBlockZ();
                if (Utils.getRandomInt(100) <= 30) {
                    Bukkit.broadcastMessage(Utils.chat(pl.prefix + "&b" + p.getName() + " &fperdió vida contra &b" + d.getName() +
                            " &fen las coordenadas X: &b" + x + " &8| &fY: &b" + y + " &8| &fZ: &b" + z));
                }
            }
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender.hasPermission("uhc.admin") && cmd.getName().equalsIgnoreCase("battleparanoia")) {
            pl.battleParanoia = !pl.battleParanoia;
            Bukkit.broadcastMessage(Utils.chat(pl.prefix + "&fBattleParanoia has been " + (pl.battleParanoia ? Main.enabled : Main.disabled)));
        }
        return false;
    }
}
