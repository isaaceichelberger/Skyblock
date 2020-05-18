package me.isaaceichelberger.skyblock.Listeners;

import me.isaaceichelberger.skyblock.Skyblock;
import me.isaaceichelberger.skyblock.World.SkyblockBuilder;
import net.minecraft.server.v1_8_R3.WorldGenerator;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.world.PortalCreateEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class PortalEnter extends SBListener {
    Skyblock skyblock;

    public PortalEnter(Skyblock pl) {
        super(pl);
        this.skyblock = pl;
    }

    @EventHandler
    public void PortalEnterEvent(PlayerPortalEvent e) {
        if (e.getCause() == PlayerTeleportEvent.TeleportCause.NETHER_PORTAL) {
            e.setCancelled(true);
            World w = Bukkit.getWorld("world_nether");
            if (e.getPlayer().getWorld() == w) {
                Bukkit.getServer().dispatchCommand(e.getPlayer(), "is tp");
            } else {
                e.getPlayer().teleport(new Location(Bukkit.getWorld("world_nether"), 0, 130, 0));
            }
        }
        if (e.getCause() == PlayerTeleportEvent.TeleportCause.END_PORTAL){
            WorldCreator worldCreator = new WorldCreator("end");
            worldCreator.environment(World.Environment.THE_END);
            World w = worldCreator.createWorld();
            List players = w.getPlayers();
            if (players.size()  + 1 > 8){
                e.setCancelled(true);
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        e.getPlayer().sendMessage(ChatColor.RED + "The end is full. Wait for another dragon spawn.");

                    }
                }.runTaskLater(skyblock, 150L); // send message not often to avoid spam

            }
           else {
                Bukkit.getServer().broadcastMessage(ChatColor.RED + "A player has entered the end. (" +
                        ChatColor.YELLOW + String.valueOf(players.size() + 1) + "/ 8" + ChatColor.RED + ")");
                e.getPlayer().teleport(new Location(w, 0, 70, 0));
            }
        }
    }
}

