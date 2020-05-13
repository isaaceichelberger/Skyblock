package me.isaaceichelberger.skyblock.Listeners;

import me.isaaceichelberger.skyblock.Skyblock;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlace extends SBListener {

    private Skyblock skyblock;

    public BlockPlace(Skyblock pl) {
        super(pl);
        this.skyblock = pl;
    }


    @EventHandler
    public void onBlockPlaceEvent(BlockPlaceEvent e)
    {
        try {
            if (skyblock.getCoopDataConfig().contains("Coop.UUID." + e.getPlayer().getUniqueId())) {
                String partName = skyblock.getCoopDataConfig().getString("Coop.UUID." + e.getPlayer().getUniqueId());
                String worldName = partName + "skyworld";
                World world = WorldCreator.name(worldName).createWorld(); // make this into a world object for comp
                if (e.getPlayer().getWorld() != world && !e.getPlayer().isOp()){
                    e.setCancelled(true);
                }
            }
            else{
                String worldName = e.getPlayer().getUniqueId().toString() + "skyworld";
                World world = WorldCreator.name(worldName).createWorld(); // make this into a world object for comp
                if (e.getPlayer().getWorld() != world && !e.getPlayer().isOp()){
                    e.setCancelled(true);
                }
            }
        }
        catch (NullPointerException e1){
            e1.printStackTrace();
        }

    }
}
