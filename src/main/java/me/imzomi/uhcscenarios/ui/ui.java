package me.imzomi.uhcscenarios.ui;

import me.imzomi.uhcscenarios.Main;
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
    public static String iname = Utils.chat("&6Scenarios Activated");
    public static void openInventory(Player player) {
        Inventory inv = Bukkit.createInventory(null, 2 * 9, iname);
        if (Main.AbsorptionLess){
            ItemStack a = new ItemStack(Material.APPLE, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&eAbsorptionLess"));
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
            e.setDisplayName(Utils.chat("&eBlastMining"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.BleedingSweets){
            ItemStack a = new ItemStack(Material.STRING, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&eBleedingSweets"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.BloodAnvil){
            ItemStack a = new ItemStack(Material.ANVIL, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&eBloodAnvil"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.BloodDiamonds){
            ItemStack a = new ItemStack(Material.DIAMOND, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&eBloodDiamonds"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.BloodGold){
            ItemStack a = new ItemStack(Material.GOLD_INGOT, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&eBloodGold"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.BloodLapis){
            ItemStack a = new ItemStack(Material.LAPIS_LAZULI, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&eBloodLapis"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.Bowless){
            ItemStack a = new ItemStack(Material.BOW, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&eBowless"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.CobwebLess){
            ItemStack a = new ItemStack(Material.COBWEB, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&eCobwebLess"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.Coldweapons){
            ItemStack a = new ItemStack(Material.IRON_SWORD, 1);
            a.addEnchantment(Enchantment.FIRE_ASPECT, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&eColdweapons"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.Cripple){
            ItemStack a = new ItemStack(Material.LEATHER_BOOTS, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&eCripple"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.CutClean){
            ItemStack a = new ItemStack(Material.IRON_INGOT, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&eCutClean"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.DamageParanoia){
            ItemStack a = new ItemStack(Material.MAP, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&eDamageParanoia"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.DiamondLess){
            ItemStack a = new ItemStack(Material.DIAMOND_ORE, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&eDiamondLess"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.DoubleOres){
            ItemStack a = new ItemStack(Material.IRON_INGOT, 2);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&eDoubleOres"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.EnchantedDeath){
            ItemStack a = new ItemStack(Material.ENCHANTING_TABLE, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&eEnchantedDeath"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.FastGetaway){
            ItemStack a = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&eFastGetaway"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.FenceHead){
            ItemStack a = new ItemStack(Material.PLAYER_HEAD, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&eFenceHead"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.Fireless){
            ItemStack a = new ItemStack(Material.FLINT_AND_STEEL, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&eFireless"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.GappleRoulette){
            ItemStack a = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&eGappleRoulette"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.GoldenRetriever){
            ItemStack a = new ItemStack(Material.GOLDEN_APPLE, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&eGoldenRetriever"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.GoldLess){
            ItemStack a = new ItemStack(Material.GOLD_ORE, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&eGoldLess"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.HasteyBabies){
            ItemStack a = new ItemStack(Material.IRON_PICKAXE, 1);
            a.addEnchantment(Enchantment.DIG_SPEED, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&eHasteyBabies"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.HasteyBoys){
            ItemStack a = new ItemStack(Material.DIAMOND_PICKAXE, 1);
            a.addEnchantment(Enchantment.DIG_SPEED, 3);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&eHasteyBoys"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.HasteyBoysPlus){
            ItemStack a = new ItemStack(Material.NETHERITE_PICKAXE, 1);
            a.addEnchantment(Enchantment.DIG_SPEED, 5);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&eHasteyBoysPlus"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.HeavyPockets){
            ItemStack a = new ItemStack(Material.NETHERITE_SCRAP, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&eHeavyPockets"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.Krenzinator){
            ItemStack a = new ItemStack(Material.REDSTONE_BLOCK, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&eKrenzinator"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.LuckyLeaves){
            ItemStack a = new ItemStack(Material.OAK_LEAVES, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&eLuckyLeaves"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.NoClean){
            ItemStack a = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&eNoClean"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.NoFall){
            ItemStack a = new ItemStack(Material.FEATHER, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&eNoFall"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.PermaKill){
            ItemStack a = new ItemStack(Material.CLOCK, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&ePermaKill"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.ShieldLess){
            ItemStack a = new ItemStack(Material.SHIELD, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&eShieldLess"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.Switcheroo){
            ItemStack a = new ItemStack(Material.ARROW, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&eSwitcheroo"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.SwordLess){
            ItemStack a = new ItemStack(Material.DIAMOND_SWORD, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&eSwordLess"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.Timber){
            ItemStack a = new ItemStack(Material.OAK_LOG, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&eTimber"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.TripleOres){
            ItemStack a = new ItemStack(Material.IRON_INGOT, 3);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&eTripleOres"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.UltraParanoia){
            ItemStack a = new ItemStack(Material.PAPER, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&eUltraParanoia"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.VengefulSpirits){
            ItemStack a = new ItemStack(Material.GHAST_TEAR, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&eVengefulSpirits"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        if (Main.TimeBomb){
            ItemStack a = new ItemStack(Material.TNT, 1);
            ItemMeta e = a.getItemMeta();
            e.setDisplayName(Utils.chat("&eTimebomb"));
            a.setItemMeta(e);
            inv.addItem(a);
        }
        player.openInventory(inv);
    }
}
