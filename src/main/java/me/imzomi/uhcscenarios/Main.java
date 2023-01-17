package me.imzomi.uhcscenarios;

import me.imzomi.uhcscenarios.Files.ConfigFile;
import me.imzomi.uhcscenarios.commands.CobbleOnlyCommand;
import me.imzomi.uhcscenarios.commands.ScenarioCommand;
import me.imzomi.uhcscenarios.commands.scen;
import me.imzomi.uhcscenarios.listeners.CobbleOnly;
import me.imzomi.uhcscenarios.listeners.InventoryClick;
import me.imzomi.uhcscenarios.manager.ScenarioManager;
import me.imzomi.uhcscenarios.utils.ItemBuilder;
import me.imzomi.uhcscenarios.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {
    public static Main pl;

    public String prefix = Utils.chat("&9&lUHC &8» &r");

    public ConfigFile config;

    public void onEnable() {
        pl = this;
        config = new ConfigFile(this);
        new InventoryClick();
        new CobbleOnly();
        new scen();
        ScenarioManager.getInstance().setup();
        new ScenarioCommand();
        new CobbleOnlyCommand();
        Bukkit.getConsoleSender().sendMessage("ScenariosUHC has been enabled");

        NamespacedKey key = new NamespacedKey(this, "golden_head");
        ShapedRecipe recipe = new ShapedRecipe(key, new ItemBuilder(Material.GOLDEN_APPLE).setDisplayName(Utils.chat("&6Golden Head")).build());
        recipe.shape("GGG", "GHG", "GGG");

        recipe.setIngredient('G', Material.GOLD_INGOT);
        recipe.setIngredient('H', Material.PLAYER_HEAD);

        Bukkit.addRecipe(recipe);
    }
}



