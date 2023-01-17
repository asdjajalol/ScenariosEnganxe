package me.imzomi.uhcscenarios.commands;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CobbleOnlyCommand implements CommandExecutor {
    private Main pl = Main.pl;

    public CobbleOnlyCommand() {
        pl.getCommand("cobbleonly").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player p) {
            if (!pl.config.getConfig().getBoolean("players." + p.getName() + ".cobbleonly",false)) {
                pl.config.getConfig().set("players." + p.getName() + ".cobbleonly", true);
                pl.config.saveConfig();
                p.sendMessage(Utils.chat(pl.prefix + "CobbleOnly &9On"));
            } else {
                pl.config.getConfig().set("players." + p.getName() + ".cobbleonly",false);
                pl.config.saveConfig();
                p.sendMessage(Utils.chat(pl.prefix + "CobbleOnly &9Off"));
            }
        }
        return false;
    }
}
