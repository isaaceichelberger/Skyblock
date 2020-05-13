package me.isaaceichelberger.skyblock.Listeners;

import me.isaaceichelberger.skyblock.Skyblock;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockFromToEvent;

public class BlockForm extends SBListener {
    public BlockForm(Skyblock pl){
        super(pl);
    }

    @EventHandler
    public void onFormCobble(BlockFromToEvent e) {
        Block b = e.getBlock();
        if (b.isLiquid()) {
            Location loc = b.getLocation();
            World world = b.getWorld();

            /*
            Checking where the cobblestone actually is
             */
            if (b.getRelative(BlockFace.NORTH).getType() == Material.AIR)
            {
                loc = b.getRelative(BlockFace.NORTH).getLocation();
                Location newLoc = new Location(world, loc.getX(), loc.getY() - 1, loc.getZ());
                switch (newLoc.getBlock().getType()){
                    case IRON_ORE:
                        loc.getBlock().setType(Material.IRON_ORE);
                        break;
                    case GOLD_ORE:
                        loc.getBlock().setType(Material.GOLD_ORE);
                        break;
                    case LAPIS_ORE:
                        loc.getBlock().setType(Material.LAPIS_ORE);
                        break;
                    case REDSTONE_ORE:
                        loc.getBlock().setType(Material.REDSTONE_ORE);
                        break;
                    case DIAMOND_ORE:
                        loc.getBlock().setType(Material.DIAMOND_ORE);
                        break;
                }
            }
            if (b.getRelative(BlockFace.EAST).getType() == Material.AIR)
            {
                loc = b.getRelative(BlockFace.EAST).getLocation();
                Location newLoc = new Location(world, loc.getX(), loc.getY() - 1, loc.getZ());
                switch (newLoc.getBlock().getType()){
                    case IRON_ORE:
                        loc.getBlock().setType(Material.IRON_ORE);
                        break;
                    case GOLD_ORE:
                        loc.getBlock().setType(Material.GOLD_ORE);
                        break;
                    case LAPIS_ORE:
                        loc.getBlock().setType(Material.LAPIS_ORE);
                        break;
                    case REDSTONE_ORE:
                        loc.getBlock().setType(Material.REDSTONE_ORE);
                        break;
                    case DIAMOND_ORE:
                        loc.getBlock().setType(Material.DIAMOND_ORE);
                        break;
                }
            }
            if (b.getRelative(BlockFace.SOUTH).getType() == Material.AIR)
            {
                loc = b.getRelative(BlockFace.SOUTH).getLocation();
                Location newLoc = new Location(world, loc.getX(), loc.getY() - 1, loc.getZ());
                switch (newLoc.getBlock().getType()){
                    case IRON_ORE:
                        loc.getBlock().setType(Material.IRON_ORE);
                        break;
                    case GOLD_ORE:
                        loc.getBlock().setType(Material.GOLD_ORE);
                        break;
                    case LAPIS_ORE:
                        loc.getBlock().setType(Material.LAPIS_ORE);
                        break;
                    case REDSTONE_ORE:
                        loc.getBlock().setType(Material.REDSTONE_ORE);
                        break;
                    case DIAMOND_ORE:
                        loc.getBlock().setType(Material.DIAMOND_ORE);
                        break;
                }
            }
            if (b.getRelative(BlockFace.WEST).getType() == Material.AIR)
            {
                loc = b.getRelative(BlockFace.WEST).getLocation();
                Location newLoc = new Location(world, loc.getX(), loc.getY() - 1, loc.getZ());
                switch (newLoc.getBlock().getType()){
                    case IRON_ORE:
                        loc.getBlock().setType(Material.IRON_ORE);
                        break;
                    case GOLD_ORE:
                        loc.getBlock().setType(Material.GOLD_ORE);
                        break;
                    case LAPIS_ORE:
                        loc.getBlock().setType(Material.LAPIS_ORE);
                        break;
                    case REDSTONE_ORE:
                        loc.getBlock().setType(Material.REDSTONE_ORE);
                        break;
                    case DIAMOND_ORE:
                        loc.getBlock().setType(Material.DIAMOND_ORE);
                        break;
                }
            }

        }
    }
}

