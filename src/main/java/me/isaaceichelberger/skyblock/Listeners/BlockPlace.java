package me.isaaceichelberger.skyblock.Listeners;

import me.isaaceichelberger.skyblock.Skyblock;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class BlockPlace extends SBListener {

    private Skyblock skyblock;

    public BlockPlace(Skyblock pl){
        super(pl);
        this.skyblock = pl;
    }

    @EventHandler
    public void onBlockPlaceEvent(BlockPlaceEvent e)
    {
        // if I want to disallow placement in the end
        if (e.getPlayer().getWorld() == Bukkit.getWorld("world_the_end") && !e.getPlayer().isOp()){
            // e.setCancelled(true);
            e.setCancelled(false);
            }

        else {
            try {
                if (skyblock.getCoopDataConfig().contains("Coop.UUID." + e.getPlayer().getUniqueId())) {
                    String partName = skyblock.getCoopDataConfig().getString("Coop.UUID." + e.getPlayer().getUniqueId());
                    String worldName = partName + "skyworld";
                    World world = WorldCreator.name(worldName).createWorld(); // make this into a world object for comp
                    if (e.getPlayer().getWorld() != world && !e.getPlayer().isOp()) {
                        e.setCancelled(true);
                    }
                } else {
                    String worldName = e.getPlayer().getUniqueId().toString() + "skyworld";
                    World world = WorldCreator.name(worldName).createWorld(); // make this into a world object for comp
                    if (e.getPlayer().getWorld() != world && !e.getPlayer().isOp()) {
                        e.setCancelled(true);
                    }
                }
            } catch (NullPointerException e1) {
                e1.printStackTrace();
            }
        }
    }
}
