package me.imzomi.uhcscenarios.manager;

import me.imzomi.uhcscenarios.Main;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public abstract class Scenario {
    private String name;
    private ItemStack icon;

    protected Scenario(String name, ItemStack icon) {
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public ItemStack getIcon() {
        return icon;
    }
    public void enable() {
        if (this instanceof Listener) {
            Bukkit.getPluginManager().registerEvents((Listener) this, Main.pl);
        }
        setEnabled(true);
    }

    public void disable() {
        if (this instanceof Listener) {
            HandlerList.unregisterAll((Listener) this);
        }
        setEnabled(false);
    }

    protected abstract void setEnabled(boolean b);
    public abstract boolean isEnabled();
}
