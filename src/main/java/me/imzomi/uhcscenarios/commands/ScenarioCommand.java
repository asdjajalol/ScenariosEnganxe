package me.imzomi.uhcscenarios.commands;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.manager.Scenario;
import me.imzomi.uhcscenarios.manager.ScenarioManager;
import me.imzomi.uhcscenarios.scenarios.EmeraldFever;
import me.imzomi.uhcscenarios.scenarios.Krenzinator;
import me.imzomi.uhcscenarios.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.ArrayList;
import java.util.List;

public class ScenarioCommand implements CommandExecutor, TabExecutor {
    private Main pl = Main.pl;

    public ScenarioCommand() {
        pl.getCommand("scenarios").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        ScenarioManager scen = ScenarioManager.getInstance();
        if (sender.hasPermission("uhc.admin")) {
            if (args.length == 0) {
                sender.sendMessage(Utils.chat(pl.prefix + "Usage: &c/scenarios <scenario>"));
            } else {
                Scenario s = scen.getScenario(args[0]);
                if (s == null) {
                    sender.sendMessage(Utils.chat(pl.prefix + ChatColor.RED + s.getName() + " no existe"));
                } else {
                    if (s.isEnabled()) {
                        s.disable();
                        if (s.getName().equals("EmeraldFever")) {
                            EmeraldFever.removeRecipe();
                        }
                        if (s.getName().equals("Krenzinator")) {
                            Krenzinator.removeRecipe();
                        }
                        Bukkit.broadcastMessage(pl.prefix + s.getName() + " has been &9disable");
                    } else {
                        s.enable();
                        if (s.getName().equals("EmeraldFever")) {
                            EmeraldFever.addRecipe();
                        }
                        if (s.getName().equals("Krenzinator")) {
                            Krenzinator.addRecipe();
                        }
                        Bukkit.broadcastMessage(pl.prefix + s.getName() + " has been &9enable");
                    }
                }
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args) {
        ScenarioManager scen = ScenarioManager.getInstance();
        List<String> list = new ArrayList<>();
        if (args.length == 1) {
            if (!sender.hasPermission("uhc.admin")) {
                return null;
            }
            if (args[0].equals("")) {
                scen.getScenarios().forEach(s -> list.add(s.getName()));
            } else {
                scen.getScenarios().stream().filter(s -> s.getName().toLowerCase().startsWith(args[0].toLowerCase())).forEach(s -> list.add(s.getName()));
            }
        }
        return list;
    }
}
