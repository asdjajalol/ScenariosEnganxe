package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;

public class NoClean
        implements Listener, CommandExecutor {

    private Main plugin;
    public NoClean
            (Main plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void noClean(EntityDeathEvent e){
        if (plugin.NoClean){
            if (e.getEntity().getType() == EntityType.PLAYER && e.getEntity().getKiller().getType() == EntityType.PLAYER){
                e.getEntity().getKiller().setInvulnerable(true);
                e.getEntity().getKiller().sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "Enganxe" + ChatColor.DARK_GRAY + "]" + ChatColor.RESET + "You are currently immune for 10 seconds unless you hit someone.");
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                    @Override
                    public void run() {
                        e.getEntity().getKiller().setInvulnerable(false);
                        Bukkit.broadcastMessage("This message is shown after one second");
                    }
                }, 600L);
            }
        }
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e){
        if (plugin.NoClean){
            if (e.getEntity().getType() == EntityType.PLAYER && e.getDamager().getType() == EntityType.PLAYER){
                if (e.getDamager().isInvulnerable()){
                    e.getDamager().setInvulnerable(false);
                }
            }
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (!(sender instanceof Player)) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "Enganxe" + ChatColor.DARK_GRAY + "]" + ChatColor.RED + " No puedes ejecutar comandos desde la consola");
        }
        if (sender.hasPermission("uhc.admin") && cmd.getName().equalsIgnoreCase("NoClean")) {
            if (!plugin.NoClean) {
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.DARK_GRAY+ "["+ChatColor.GOLD+"Enganxe"+ChatColor.DARK_GRAY+"]"+ " &0➤ &fNoClean has been &aenabled"));
                plugin.NoClean = Boolean.valueOf(true);
            } else {
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.DARK_GRAY+ "["+ChatColor.GOLD+"Enganxe"+ChatColor.DARK_GRAY+"]"+ " &0➤ &fNoClean has been &cdisabled"));
                plugin.NoClean = Boolean.valueOf(false);
            }
        } else {
            p.sendMessage(ChatColor.RED + "No tienes permisos para utilizar este comando");
        }
        return false;
    }
}
