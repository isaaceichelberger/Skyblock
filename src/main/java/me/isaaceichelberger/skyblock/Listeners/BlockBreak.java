package me.isaaceichelberger.skyblock.Listeners;

import me.isaaceichelberger.skyblock.Skyblock;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class BlockBreak extends SBListener {

    private Skyblock skyblock;

    public BlockBreak(Skyblock pl) {
        super(pl);
        this.skyblock = pl;
    }


    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent e)
    {
        if (e.getPlayer().getWorld() == Bukkit.getWorld("world_nether")){
            Block b = e.getBlock();
            Material bt = b.getType();
            int random = (int) (Math.random() * 100 + 15);
            // Allow glitch fixes
            if (b.getType() == Material.BEDROCK){
                if (e.getPlayer().isOp()){
                    b.setType(Material.AIR);
                }
            }
            // Make sure you are not destroying where netherwart grows
            else if (b.getType() == Material.SOUL_SAND && b.getRelative(BlockFace.UP).getType() == Material.NETHER_WARTS){
                e.setCancelled(true);
            }
            else {
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        b.setType(Material.BEDROCK);
                    }
                }.runTaskLater(skyblock, 1); // Allow player to get correct drops
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        b.setType(bt);
                    }
                }.runTaskLater(skyblock, random); // regenerate
            }

        }
        else{
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
}
