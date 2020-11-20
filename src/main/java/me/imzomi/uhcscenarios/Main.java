package me.imzomi.uhcscenarios;

import me.imzomi.uhcscenarios.links.links;
import me.imzomi.uhcscenarios.scenarios.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Iterator;

public class Main extends JavaPlugin{
    private final ShapelessRecipe diamond;

        public static Boolean NoFall = Boolean.valueOf(false);
        public static Boolean Fireless = Boolean.valueOf(false);
    public static Boolean Bowless = Boolean.valueOf(false);
    public static Boolean Timber = Boolean.valueOf(true);
    public static Boolean CutClean = Boolean.valueOf(true);
    public static Boolean HasteyBoys = Boolean.valueOf(true);
    public static Boolean HasteyBoysPlus = Boolean.valueOf(false);
    public static Boolean HasteyBabies = Boolean.valueOf(false);
    public static Boolean BloodAnvil = Boolean.valueOf(false);
    public static Boolean Coldweapons = Boolean.valueOf(false);
    public static Boolean BloodDiamonds = Boolean.valueOf(false);
    public static Boolean HeavyPockets = Boolean.valueOf(false);
    public static Boolean BleedingSweets = Boolean.valueOf(false);
    public static Boolean BlastMining = Boolean.valueOf(false);
    public static Boolean FastGetaway = Boolean.valueOf(false);
    public static Boolean NoClean = Boolean.valueOf(false);
    public static Boolean BloodGold = Boolean.valueOf(false);
    public static Boolean BloodLapis = Boolean.valueOf(false);
    public static Boolean AbsorptionLess = Boolean.valueOf(false);
    public static Boolean FenceHead = Boolean.valueOf(true);
    public static Boolean RewardingBlocks = Boolean.valueOf(false);
    public static Boolean EnchantedDeath = Boolean.valueOf(false);
    public static Boolean Switcheroo = Boolean.valueOf(false);
    public static Boolean CobwebLess = Boolean.valueOf(false);
    public static Boolean Cripple = Boolean.valueOf(false);
    public static Boolean GappleRoulette = Boolean.valueOf(false);
    public static Boolean GoldenRetriever = Boolean.valueOf(false);
    public static Boolean PermaKill = Boolean.valueOf(false);
    public static Boolean VengefulSpirits = Boolean.valueOf(false);
    public static Boolean SwordLess = Boolean.valueOf(false);
    public static Boolean ShieldLess = Boolean.valueOf(false);
    public static Boolean DamageParanoia = Boolean.valueOf(false);
    public static Boolean UltraParanoia = Boolean.valueOf(false);
    public static Boolean LuckyLeaves = Boolean.valueOf(false);
    public static Boolean DoubleOres = Boolean.valueOf(false);
    public static Boolean TripleOres = Boolean.valueOf(false);
    public static Boolean Krenzinator = Boolean.valueOf(false);
    public static Boolean DiamondLess = Boolean.valueOf(false);
    public static Boolean GoldLess = Boolean.valueOf(false);
    public Main() {
        diamond = new ShapelessRecipe(new ItemStack(Material.DIAMOND)).addIngredient(9, Material.REDSTONE_BLOCK);
    }

    PluginDescriptionFile pdffile = getDescription();
    public String version = pdffile.getVersion();

//ChatColor.DARK_GRAY+ "["+ChatColor.GOLD+"Enganxe"+ChatColor.DARK_GRAY+"]" (nombre)

    public void onEnable(){
        Bukkit.getConsoleSender().sendMessage((ChatColor.DARK_GRAY+ "["+ChatColor.GOLD+"Enganxe"+ChatColor.DARK_GRAY+"]"+ChatColor.GOLD+" ScenariosUHC has been enabled (version:"+ChatColor.GRAY+version+ChatColor.GOLD+")"));
        registrarComandos();
        registrarEvents();
        ItemStack head = new ItemStack(Material.GOLDEN_APPLE);
        ItemMeta headMeta = head.getItemMeta();
        headMeta.setDisplayName("§6Golden Head");
        head.setItemMeta(headMeta);


        NamespacedKey key = new NamespacedKey(this, "golden_head");
        ShapedRecipe recipe = new ShapedRecipe(key, head);
        recipe.shape("GGG", "GHG", "GGG");

        recipe.setIngredient('G', Material.GOLD_INGOT);
        recipe.setIngredient('H', Material.PLAYER_HEAD);

        Bukkit.addRecipe(recipe);
    }

    public void registrarComandos(){


        this.getCommand("links").setExecutor(new links(this));
        this.getCommand("cutclean").setExecutor(new CutClean(this));
        this.getCommand("hasteyboys").setExecutor(new HasteyBoys(this));
        this.getCommand("hasteyboysplus").setExecutor(new HasteyBoysPlus(this));
        this.getCommand("hasteybabies").setExecutor(new HasteyBabies(this));
        this.getCommand("timber").setExecutor(new Timber(this));
        this.getCommand("nofall").setExecutor(new NoFall(this));
        this.getCommand("fireless").setExecutor(new Fireless(this));
        this.getCommand("bowless").setExecutor(new Bowless(this));
        this.getCommand("bloodanvil").setExecutor(new BloodAnvil(this));
        this.getCommand("blooddiamonds").setExecutor(new BloodDiamonds(this));
        this.getCommand("absorptionless").setExecutor(new AbsorptionLess(this));
        this.getCommand("fencehead").setExecutor(new FenceHead(this));
        this.getCommand("rewardingblocks").setExecutor(new FenceHead(this));
        this.getCommand("coldweapons").setExecutor(new Coldweapons(this));
        this.getCommand("heavypockets").setExecutor(new HeavyPockets(this));
        this.getCommand("bleedingsweets").setExecutor(new BleedingSweets(this));
        this.getCommand("blastmining").setExecutor(new BlastMining(this));
        this.getCommand("fastgetaway").setExecutor(new FastGetaway(this));
        this.getCommand("noclean").setExecutor(new NoClean(this));
        this.getCommand("bloodgold").setExecutor(new BloodGold(this));
        this.getCommand("bloodlapis").setExecutor(new BloodLapis(this));
        this.getCommand("enchanteddeath").setExecutor(new EnchantedDeath(this));
        this.getCommand("switcheroo").setExecutor(new Switcheroo(this));
        this.getCommand("krenzinator").setExecutor(new Krenzinator(this));
        this.getCommand("cripple").setExecutor(new Cripple(this));
        this.getCommand("GappleRoulette").setExecutor(new GappleRoulette(this));
        this.getCommand("GoldenRetriever").setExecutor(new GoldenRetriever(this));
        this.getCommand("permakill").setExecutor(new PermaKill(this));
        this.getCommand("vengefulspirits").setExecutor(new VengefulSpirits(this));
        this.getCommand("damageparanoia").setExecutor(new DamageParanoia(this));
        this.getCommand("ultraparanoia").setExecutor(new UltraParanoia(this));
        this.getCommand("swordless").setExecutor(new SwordLess(this));
        this.getCommand("shieldless").setExecutor(new ShieldLess(this));;
        this.getCommand("luckyleaves").setExecutor(new LuckyLeaves(this));;
        this.getCommand("cobwebless").setExecutor(new CobwebLess(this));
        this.getCommand("doubleores").setExecutor(new DoubleOres(this));
        this.getCommand("tripleores").setExecutor(new TripleOres(this));
        this.getCommand("diamondless").setExecutor(new DiamondLess(this));
        this.getCommand("goldless").setExecutor(new GoldLess(this));

    }
    public void registrarEvents() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new Timber(this), this);
        pm.registerEvents(new HasteyBoys(this), this);
        pm.registerEvents(new HasteyBoysPlus(this), this);
        pm.registerEvents(new HasteyBabies(this), this);
        pm.registerEvents(new CutClean(this), this);
        pm.registerEvents(new NoFall(this), this);
        pm.registerEvents(new Fireless(this), this);
        pm.registerEvents(new Bowless(this), this);
        pm.registerEvents(new BloodAnvil(this), this);
        pm.registerEvents(new BloodDiamonds(this), this);
        pm.registerEvents(new AbsorptionLess(this), this);
        pm.registerEvents(new FenceHead(this), this);
        pm.registerEvents(new Coldweapons(this), this);
        pm.registerEvents(new HeavyPockets(this), this);
        pm.registerEvents(new BleedingSweets(this), this);
        pm.registerEvents(new BlastMining(this), this);
        pm.registerEvents(new FastGetaway(this), this);
        pm.registerEvents(new NoClean(this), this);
        pm.registerEvents(new BloodGold(this), this);
        pm.registerEvents(new BloodLapis(this), this);
        pm.registerEvents(new EnchantedDeath(this), this);
        pm.registerEvents(new Switcheroo(this), this);
        pm.registerEvents(new Cripple(this), this);
        pm.registerEvents(new GappleRoulette(this), this);
        pm.registerEvents(new PermaKill(this), this);
        pm.registerEvents(new VengefulSpirits(this), this);
        pm.registerEvents(new SwordLess(this), this);
        pm.registerEvents(new ShieldLess(this), this);
        pm.registerEvents(new DamageParanoia(this), this);
        pm.registerEvents(new UltraParanoia(this), this);
        pm.registerEvents(new LuckyLeaves(this), this);
        pm.registerEvents(new Krenzinator(this), this);
        pm.registerEvents(new CobwebLess(this), this);
        pm.registerEvents(new DoubleOres(this), this);
        pm.registerEvents(new TripleOres(this), this);
        pm.registerEvents(new DiamondLess(this), this);
        pm.registerEvents(new GoldLess(this), this);
    }
    public void addDiamondRecipe() {
        getServer().addRecipe(diamond);
    }

    public void removeDiamondRecipe() {

        Iterator<Recipe> iterator = getServer().recipeIterator();

        while (iterator.hasNext()) {
            Recipe recipe = iterator.next();
            if (recipe.getResult().equals(new ItemStack(Material.DIAMOND))) {

                iterator.remove();
                break;
            }
        }
    }
}

