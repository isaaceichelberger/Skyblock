package me.isaaceichelberger.skyblock.Listeners;

import me.isaaceichelberger.skyblock.Skyblock;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.IOException;

public class PlayerJoin extends SBListener {
    private Skyblock skyblock;

    public PlayerJoin(Skyblock pl) {
        super(pl);
        this.skyblock = pl;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        if (!e.getPlayer().hasPlayedBefore())
        {
            e.setJoinMessage(ChatColor.BLUE + e.getPlayer().getDisplayName() + ChatColor.WHITE + " has joined for the first time!");
            skyblock.getIslandDataConfig().set("Islands.UUID." + e.getPlayer().getUniqueId().toString() + ".hasIsland", false);
            skyblock.getStatsDataConfig().set(e.getPlayer().getUniqueId().toString() + ".Balance", 0.00);
            skyblock.getStatsDataConfig().set(e.getPlayer().getUniqueId().toString() + ".IslandLevel", 0);
            try {
                skyblock.getIslandDataConfig().save(skyblock.getIslandDataFile());
                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
            }
            catch (IOException e1)
            {
                e1.printStackTrace();
            }
        }
        else
        {
            e.setJoinMessage(ChatColor.BLUE + e.getPlayer().getDisplayName() + ChatColor.WHITE + " has joined");
        }
    }


}
