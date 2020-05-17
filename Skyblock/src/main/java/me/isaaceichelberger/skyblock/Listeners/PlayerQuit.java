package me.isaaceichelberger.skyblock.Listeners;

import me.isaaceichelberger.skyblock.Skyblock;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit extends SBListener {
    private Skyblock skyblock;

    public PlayerQuit(Skyblock pl) {
        super(pl);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e){
        Bukkit.getServer().unloadWorld(Bukkit.getServer().getWorld(e.getPlayer().getUniqueId().toString() + "skyworld"), true);
        e.setQuitMessage(ChatColor.BLUE + e.getPlayer().getDisplayName()  + ChatColor.WHITE + " has quit");
    }
}
