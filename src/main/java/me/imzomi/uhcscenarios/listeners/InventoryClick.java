package me.imzomi.uhcscenarios.listeners;

import me.imzomi.uhcscenarios.Main;
import me.imzomi.uhcscenarios.ui.ui;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClick implements Listener {
    private Main plugin = Main.pl;

    public InventoryClick (){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void OnClick(InventoryClickEvent e){
        String title = e.getView().getTitle();
        if (title.equals(ui.iname)){
            e.setCancelled(true);
            if (e.getCurrentItem() == null){
                return;
            }
        }
    }
}

