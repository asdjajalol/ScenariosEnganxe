package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.manager.Scenario;
import me.imzomi.uhcscenarios.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;

public class EmeraldFever extends Scenario implements Listener {
    private Main pl = Main.pl;
    private boolean enabled = false;

    public EmeraldFever() {
        super("EmeraldFever", new ItemStack(Material.EMERALD));
    }

    public static void addRecipe() {
        Main pl = Main.pl;
        if (pl.getServer().getRecipe(new NamespacedKey(pl, "emeraldfever")) != null) {
            return;
        }
        ShapelessRecipe diamond = new ShapelessRecipe(new NamespacedKey(pl, "emeraldfever"), new ItemStack(Material.DIAMOND))
                .addIngredient(1, Material.EMERALD);
        ShapedRecipe scrap = new ShapedRecipe(new NamespacedKey(pl, "emeraldfever2"), new ItemStack(Material.NETHERITE_SCRAP,2));
        scrap.shape(" a ", " b ", " a ");
        scrap.setIngredient('a', Material.EMERALD);
        scrap.setIngredient('b', Material.EMERALD_BLOCK);

        pl.getServer().addRecipe(diamond);
        pl.getServer().addRecipe(scrap);
    }
    public static void removeRecipe() {
        Main pl = Main.pl;
        pl.getServer().removeRecipe(new NamespacedKey(pl, "emeraldfever"));
        pl.getServer().removeRecipe(new NamespacedKey(pl, "emeraldfever2"));
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
