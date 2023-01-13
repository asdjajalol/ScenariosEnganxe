package me.imzomi.uhcscenarios.ui;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.utils.ItemBuilder;
import me.imzomi.uhcscenarios.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ui {
    public static String iname = Utils.chat("&9Scenarios Activated");
    public static void openInventory(Player player) {
        Main pl = Main.pl;
        Inventory inv = Bukkit.createInventory(null, 2 * 9, iname);
        if (Main.AbsorptionLess){
            ItemStack a = new ItemStack(Material.APPLE, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&bAbsorptionLess"));
            List<String> loresList = new ArrayList<String>();
            loresList.add(Utils.chat(""));
            loresList.add(Utils.chat(""));
            e.setLore(loresList);
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.BlastMining){
            ItemStack a = new ItemStack(Material.CREEPER_SPAWN_EGG, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&bBlastMining"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.BleedingSweets){
            ItemStack a = new ItemStack(Material.STRING, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&bBleedingSweets"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.BloodAnvil){
            ItemStack a = new ItemStack(Material.ANVIL, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&bBloodAnvil"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.BloodDiamonds){
            ItemStack a = new ItemStack(Material.DIAMOND, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&bBloodDiamonds"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.BloodGold){
            ItemStack a = new ItemStack(Material.GOLD_INGOT, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&bBloodGold"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.BloodLapis){
            ItemStack a = new ItemStack(Material.LAPIS_LAZULI, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&bBloodLapis"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.Bowless){
            ItemStack a = new ItemStack(Material.BOW, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&bBowless"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.CobwebLess){
            ItemStack a = new ItemStack(Material.COBWEB, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&bCobwebLess"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.Coldweapons){
            ItemStack a = new ItemStack(Material.IRON_SWORD, 1);
            a.addEnchantment(Enchantment.FIRE_ASPECT, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&bColdweapons"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.Cripple){
            ItemStack a = new ItemStack(Material.LEATHER_BOOTS, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&bCripple"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.CutClean){
            ItemStack a = new ItemStack(Material.IRON_INGOT, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&bCutClean"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.DamageParanoia){
            ItemStack a = new ItemStack(Material.MAP, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&bDamageParanoia"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.DiamondLess){
            ItemStack a = new ItemStack(Material.DIAMOND_ORE, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&bDiamondLess"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.DoubleOres){
            ItemStack a = new ItemStack(Material.IRON_INGOT, 2);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&bDoubleOres"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.EnchantedDeath){
            ItemStack a = new ItemStack(Material.ENCHANTING_TABLE, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&bEnchantedDeath"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.FastGetaway){
            ItemStack a = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&bFastGetaway"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.FenceHead){
            ItemStack a = new ItemStack(Material.PLAYER_HEAD, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&bFenceHead"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.Fireless){
            ItemStack a = new ItemStack(Material.FLINT_AND_STEEL, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&bFireless"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.GappleRoulette){
            ItemStack a = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&bGappleRoulette"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.GoldenRetriever){
            ItemStack a = new ItemStack(Material.GOLDEN_APPLE, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&bGoldenRetriever"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.GoldLess){
            ItemStack a = new ItemStack(Material.GOLD_ORE, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&bGoldLess"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.HasteyBabies){
            ItemStack a = new ItemStack(Material.IRON_PICKAXE, 1);
            a.addEnchantment(Enchantment.DIG_SPEED, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&bHasteyBabies"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.HasteyBoys){
            ItemStack a = new ItemStack(Material.DIAMOND_PICKAXE, 1);
            a.addEnchantment(Enchantment.DIG_SPEED, 3);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&bHasteyBoys"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.HasteyBoysPlus){
            ItemStack a = new ItemStack(Material.NETHERITE_PICKAXE, 1);
            a.addEnchantment(Enchantment.DIG_SPEED, 5);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&bHasteyBoysPlus"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.HeavyPockets){
            ItemStack a = new ItemStack(Material.NETHERITE_SCRAP, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&bHeavyPockets"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.Krenzinator){
            ItemStack a = new ItemStack(Material.REDSTONE_BLOCK, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&bKrenzinator"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.LuckyLeaves){
            ItemStack a = new ItemStack(Material.OAK_LEAVES, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&bLuckyLeaves"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.NoClean){
            ItemStack a = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&bNoClean"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.NoFall){
            ItemStack a = new ItemStack(Material.FEATHER, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&bNoFall"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.PermaKill){
            ItemStack a = new ItemStack(Material.CLOCK, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&bPermaKill"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.ShieldLess){
            ItemStack a = new ItemStack(Material.SHIELD, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&bShieldLess"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.Switcheroo){
            ItemStack a = new ItemStack(Material.ARROW, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&bSwitcheroo"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.SwordLess){
            ItemStack a = new ItemStack(Material.DIAMOND_SWORD, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&bSwordLess"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.Timber){
            ItemStack a = new ItemStack(Material.OAK_LOG, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&bTimber"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.TripleOres){
            ItemStack a = new ItemStack(Material.IRON_INGOT, 3);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&bTripleOres"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.UltraParanoia){
            ItemStack a = new ItemStack(Material.PAPER, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&bUltraParanoia"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.VengefulSpirits){
            ItemStack a = new ItemStack(Material.GHAST_TEAR, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&bVengefulSpirits"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.TimeBomb){
            ItemStack a = new ItemStack(Material.TNT, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&bTimebomb"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (pl.anvilLess) inv.addItem(new ItemBuilder(Material.ANVIL).setDisplayName(Utils.chat("&bAnvilLess")).build());
        if (pl.bareBones) inv.addItem(new ItemBuilder(Material.BONE_BLOCK).setDisplayName(Utils.chat("&bBareBones")).build());
        if (pl.bats) inv.addItem(new ItemBuilder(Material.BAT_SPAWN_EGG).setDisplayName(Utils.chat("&bBats")).build());
        if (pl.battleParanoia) inv.addItem(new ItemBuilder(Material.IRON_AXE).setDisplayName(Utils.chat("&bBattleParanoia")).build());
        if (pl.betazombies) inv.addItem(new ItemBuilder(Material.ZOMBIE_HEAD).setDisplayName(Utils.chat("&bBetaZombies")).build());
        if (pl.biomeboost) inv.addItem(new ItemBuilder(Material.SAND).setDisplayName(Utils.chat("&bBiomeBoost")).build());
        if (pl.blocked) inv.addItem(new ItemBuilder(Material.BARRIER).setDisplayName(Utils.chat("&bBlocked")).build());
        if (pl.bloodenchant) inv.addItem(new ItemBuilder(Material.ENCHANTING_TABLE).setDisplayName(Utils.chat("&bBloodEnchant")).build());
        if (pl.cleanslate) inv.addItem(new ItemBuilder(Material.GRINDSTONE).setDisplayName(Utils.chat("&bCleanSlate")).build());
        if (pl.emeraldfever) inv.addItem(new ItemBuilder(Material.EMERALD).setDisplayName(Utils.chat("&bEmeraldFever")).build());
        player.openInventory(inv);
    }
}
