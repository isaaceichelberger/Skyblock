package me.isaaceichelberger.skyblock.Listeners;

import me.isaaceichelberger.skyblock.Skyblock;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.PortalType;
import org.bukkit.World;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class PortalEnter extends SBListener {
    Skyblock skyblock;

    public PortalEnter(Skyblock pl){
        super(pl);
        this.skyblock = pl;
    }

    @EventHandler
    public void PortalEnterEvent(PlayerPortalEvent e){
        if (e.getCause() == PlayerTeleportEvent.TeleportCause.NETHER_PORTAL){
            e.setCancelled(true);
            World w = Bukkit.getWorld("world_nether");
            if (e.getPlayer().getWorld() == w){
                Bukkit.getServer().dispatchCommand(e.getPlayer(), "is tp");
            }
            else {
                e.getPlayer().teleport(new Location(Bukkit.getWorld("world_nether"), 0, 130, 0));
            }
        }
    }
}
