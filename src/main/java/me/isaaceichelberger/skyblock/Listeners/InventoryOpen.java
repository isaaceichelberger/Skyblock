package me.isaaceichelberger.skyblock.Listeners;

import me.isaaceichelberger.skyblock.Skyblock;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.block.*;
import org.bukkit.block.DoubleChest;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryOpenEvent;

public class InventoryOpen extends SBListener {

    private Skyblock skyblock;

    public InventoryOpen(Skyblock pl){
        super(pl);
        this.skyblock = pl;
    }

    @EventHandler
    public void onInventoryOpenEvent(InventoryOpenEvent e){
        if (e.getInventory().getHolder() instanceof Chest || e.getInventory().getHolder() instanceof DoubleChest || e.getInventory().getHolder() instanceof Furnace){
            try {
                if (skyblock.getCoopDataConfig().contains("Coop.UUID." + e.getPlayer().getUniqueId())) {
                    String partName = skyblock.getCoopDataConfig().getString("Coop.UUID." + e.getPlayer().getUniqueId());
                    String worldName = partName + "skyworld";
                    World world = WorldCreator.name(worldName).createWorld(); // make this into a world object for comp
                    if (e.getPlayer().getWorld() != world){
                        e.setCancelled(true);
                    }
                }
                else{
                    String worldName = e.getPlayer().getUniqueId().toString() + "skyworld";
                    World world = WorldCreator.name(worldName).createWorld(); // make this into a world object for comp
                    if (e.getPlayer().getWorld() != world){
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
