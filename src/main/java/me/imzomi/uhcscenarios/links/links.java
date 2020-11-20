package me.imzomi.uhcscenarios.links;

import me.imzomi.uhcscenarios.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class links implements CommandExecutor{

    private Main plugin;

    public links(Main plugin){
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command comando, String label,String[] args) {
        if(!(sender instanceof Player)){
            Bukkit.getConsoleSender().sendMessage((ChatColor.DARK_GRAY+ "["+ChatColor.GOLD+"Enganxe"+ChatColor.DARK_GRAY+"]"+" No puedes ejecutar comandos desde la consola"));
            return false;
        }else{
            Player jugador = (Player) sender;
            jugador.sendMessage(ChatColor.BLUE+"Discord link: "+ChatColor.BLUE+"discord.enganxe.net");
            jugador.sendMessage(ChatColor.AQUA+"Twitter: "+ChatColor.AQUA+"@enganxe");
            jugador.sendMessage(ChatColor.GOLD+"Store: "+ChatColor.GOLD+"store.enganxe.net");
            jugador.sendMessage(ChatColor.GRAY+"Scenarios list: "+ChatColor.GRAY+"https://pastebin.com/6cQwHUWX");
            return true;

        }
    }

}
