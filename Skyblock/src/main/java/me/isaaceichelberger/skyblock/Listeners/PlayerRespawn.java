package me.isaaceichelberger.skyblock.Listeners;

import me.isaaceichelberger.skyblock.Skyblock;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerRespawn extends SBListener {

    private Skyblock skyblock;

    public PlayerRespawn(Skyblock pl) {
        super(pl);
        this.skyblock = pl;
    }


    @EventHandler
    public void onPlayerRespawnEvent(PlayerRespawnEvent e)
    {
        String worldName = e.getPlayer().getUniqueId().toString() + "skyworld";
        new BukkitRunnable() {
            @Override
            public void run () {
                e.getPlayer().teleport(new Location(Bukkit.getServer().getWorld(worldName), 1, 70, 1));
            }
        }.runTaskLater(skyblock, 1);

    }
}
