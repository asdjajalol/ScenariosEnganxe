package me.imzomi.uhcscenarios.commands;

import me.imzomi.uhcscenarios.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.imzomi.uhcscenarios.ui.ui.*;

public class scen implements CommandExecutor {
    private Main plugin;

    public scen(Main plugin){
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command comando, String label, String[] args) {
    Player p = (Player) sender;
    openInventory(p);
    return false;
    }
}
