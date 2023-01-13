package me.imzomi.uhcscenarios.utils;

import org.bukkit.ChatColor;

import java.util.Random;

public class Utils {
    public static String chat (String s){
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static int getRandomInt(int i) {
        return new Random().nextInt(i) + 1;
    }
}
