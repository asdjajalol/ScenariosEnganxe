package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.manager.Scenario;
import me.imzomi.uhcscenarios.utils.Utils;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class Krenzinator extends Scenario implements Listener {
    private Main plugin = Main.pl;
    private boolean enabled = false;

    public Krenzinator(){
        super("Krenzinator", new ItemStack(Material.REDSTONE_BLOCK));
    }
    @EventHandler
    public void nether(PlayerTeleportEvent e){
            if (e.getCause() == PlayerTeleportEvent.TeleportCause.NETHER_PORTAL){
                e.setCancelled(true);
            }
        }

    @EventHandler
    public void diamondSword(CraftItemEvent e){
            Player p = (Player) e.getWhoClicked();
            if(e.getRecipe().getResult().getType() == Material.DIAMOND_SWORD){
                p.damage(1);
            }
        }


    @EventHandler
    public void onMount(VehicleEnterEvent e) {
        if (e.getVehicle() instanceof Horse && e.getEntered() instanceof Player) {
            Horse horse = (Horse) e.getVehicle();
            if (horse.getType() == EntityType.DONKEY) {
                return;
            }
            ((Player) e.getEntered()).sendMessage(ChatColor.RED + "You can't mount horses in this gamemode!");
            e.setCancelled(true);
        }
    }
    public static void addRecipe() {
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(Main.pl, "krenzinator"), new ItemStack(Material.DIAMOND));
        recipe.shape("aaa", "aaa", "aaa");
        recipe.setIngredient('a', Material.REDSTONE_BLOCK);
        Bukkit.getServer().addRecipe(recipe);
    }
    public static void removeRecipe() {
        Bukkit.getServer().removeRecipe(new NamespacedKey(Main.pl, "krenzinator"));
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
