package me.isaaceichelberger.skyblock.Commands;

import me.isaaceichelberger.skyblock.Skyblock;
import me.isaaceichelberger.skyblock.World.SkyblockBuilder;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.block.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class CommandIsland implements CommandExecutor {

    private HashMap<Player, Boolean> canDelete = new HashMap<Player, Boolean>();
    private Skyblock skyblock;

    public CommandIsland(Skyblock skyblock){
        this.skyblock = skyblock;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (sender instanceof Player) {
            boolean hasIsland = skyblock.getIslandDataConfig().getBoolean("Islands.UUID." + p.getUniqueId().toString() + ".hasIsland");
            if (args.length == 0) {
                p.sendMessage(ChatColor.RED + "Invalid arguments. Do /island help for help");
            } else if (args.length == 1) {
                /*
                 * Create Island
                 */
                if (args[0].equalsIgnoreCase("create")) {
                    if (!hasIsland) {
                        p.sendMessage(ChatColor.GREEN + "Creating your island!");
                        String worldName = p.getUniqueId().toString() + "skyworld";
                        WorldCreator worldCreator = new WorldCreator(worldName);
                        worldCreator.generator(new SkyblockBuilder());
                        worldCreator.createWorld();
                        skyblock.getIslandDataConfig().set("Islands.UUID." + p.getUniqueId().toString() + ".hasIsland", true);
                        skyblock.getIslandDataConfig().set("Islands.UUID." + p.getUniqueId().toString() + ".Members", 1);
                        try {
                            skyblock.getIslandDataConfig().save(skyblock.getIslandDataFile());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        for (int x = 0; x <= 7; x++) {
                            for (int z = 0; z <= 7; z++) {
                                if (!(x >= 4 && z >= 4)) {
                                    Block block = Bukkit.getWorld(worldName).getBlockAt(x, 68, z);
                                    block.setType(Material.STONE);
                                    block = Bukkit.getWorld(worldName).getBlockAt(x, 69, z);
                                    block.setType(Material.DIRT);
                                    block = Bukkit.getWorld(worldName).getBlockAt(x, 70, z);
                                    block.setType(Material.GRASS);
                                }
                            }
                        }
                        Block block = Bukkit.getWorld(worldName).getBlockAt(6, 71, 1);
                        ItemStack ice = new ItemStack(Material.ICE, 2);
                        ItemStack bonemeal = new ItemStack(Material.BONE, 2);
                        ItemStack sugarcane = new ItemStack(Material.SUGAR_CANE, 1);
                        ItemStack seeds = new ItemStack(Material.SEEDS);
                        ItemStack carrot = new ItemStack(Material.CARROT);
                        ItemStack potato = new ItemStack(Material.POTATO);
                        ItemStack pumpkin = new ItemStack(Material.PUMPKIN_SEEDS);
                        ItemStack melon = new ItemStack(Material.MELON_SEEDS);
                        ItemStack mushroom = new ItemStack(Material.RED_MUSHROOM);
                        ItemStack mushroom2 = new ItemStack(Material.BROWN_MUSHROOM);
                        ItemStack cactus = new ItemStack(Material.CACTUS);
                        ItemStack sand = new ItemStack(Material.SAND, 1);
                        ItemStack lava_bucket = new ItemStack(Material.LAVA_BUCKET);
                        ItemStack sapling = new ItemStack(Material.SAPLING);
                        block.setType(Material.CHEST);

                        Chest chest = (Chest) block.getState();
                        chest.getInventory().clear(); // Clear from previous worlds
                        Inventory inv = chest.getInventory();
                        inv.addItem(potato, ice, lava_bucket, bonemeal, sugarcane, seeds, pumpkin, melon, mushroom, mushroom2, cactus, sand, sapling, carrot);
                        Bukkit.getWorld(p.getUniqueId().toString() + "skyworld").generateTree(new Location(Bukkit.getWorld(p.getUniqueId().toString() + "skyworld"), 1, 71, 6), TreeType.BIG_TREE);
                        p.teleport(new Location(Bukkit.getWorld(worldName), 1, 70, 1));
                        p.sendMessage(ChatColor.GREEN + "Sending you to your island!");
                    } else {
                        p.sendMessage(ChatColor.RED + "You already have an island.");
                    }
                }


                /*
                 * Island Delete
                 */
                if (args[0].equalsIgnoreCase("delete")) {
                    if (hasIsland) {
                        if (!(canDelete.containsKey(p))) {
                            canDelete.put(p, true);
                            p.sendMessage(ChatColor.RED + "Are you sure? You will lose all progress.");
                            p.sendMessage(ChatColor.YELLOW + "Type /island delete to confirm.");
                        } else {
                            canDelete.remove(p);
                            p.teleport(new Location(Bukkit.getServer().getWorld("world"), 0, 100, 0));
                            String worldName = p.getUniqueId().toString() + "skyworld";
                            if (Bukkit.getServer().unloadWorld(Bukkit.getServer().getWorld(worldName), false)) {
                                skyblock.getLogger().info("Successfully unloaded " + worldName);
                            } else {
                                skyblock.getLogger().severe("COULD NOT UNLOAD " + worldName);
                            }
                            skyblock.getIslandDataConfig().set("Islands.UUID." + p.getUniqueId().toString() + ".hasIsland", false);
                            try {
                                skyblock.getIslandDataConfig().save(skyblock.getIslandDataFile());
                                World delete = Bukkit.getServer().getWorld(worldName);
                                File deleteFolder = delete.getWorldFolder();
                                deleteWorld(deleteFolder);
                                p.sendMessage(ChatColor.RED + "World deleted!");
                            } catch (NullPointerException e) {
                                p.sendMessage("World doesn't exist.");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }
                /*
                 * Teleport Argument, teleports player to own island
                 */
                if ((args[0].equalsIgnoreCase("tp")) || (args[0].equalsIgnoreCase("teleport"))) {
                    if (hasIsland) {
                        p.sendMessage(ChatColor.GREEN + "Teleporting!");
                        if (skyblock.getCoopDataConfig().contains("Coop.UUID." + p.getUniqueId())) {
                            String partName = skyblock.getCoopDataConfig().getString("Coop.UUID." + p.getUniqueId());
                            String worldName = partName + "skyworld";
                            WorldCreator.name(worldName).createWorld();
                            p.teleport(new Location(Bukkit.getWorld(worldName), 1, 70, 1));
                        } else {
                            String worldName = p.getUniqueId().toString() + "skyworld";
                            WorldCreator.name(worldName).createWorld();
                            p.teleport(new Location(Bukkit.getWorld(worldName), 1, 70, 1));
                        }
                    } else {
                        p.sendMessage(ChatColor.RED + "You don't have an island! Create one with /island create");
                    }

                }

                if (args[0].equalsIgnoreCase("help")) {
                    p.sendMessage(ChatColor.GRAY + "-------------------------");
                    p.sendMessage(ChatColor.AQUA + "/island create " + ChatColor.DARK_AQUA + "Create an island!");
                    p.sendMessage(ChatColor.AQUA + "/island tp " + ChatColor.DARK_AQUA + "Teleport to your island!");
                    p.sendMessage(ChatColor.AQUA + "/island delete " + ChatColor.DARK_AQUA + "Delete your island and start over.");
                    p.sendMessage(ChatColor.AQUA + "/island help " + ChatColor.DARK_AQUA + "Show this menu");
                    p.sendMessage(ChatColor.AQUA + "/island add (name) " + ChatColor.DARK_AQUA + "Add a player to your island. (Max 5)");
                    p.sendMessage(ChatColor.AQUA + "/island remove (name) " + ChatColor.DARK_AQUA + "Remove a player from your island. (Max 5)");
                    p.sendMessage(ChatColor.AQUA + "/visit " + ChatColor.DARK_AQUA + "Visit another player's island!");
                    p.sendMessage(ChatColor.AQUA + "/challenges " + ChatColor.DARK_AQUA + "Show challenges menu!");
                    p.sendMessage(ChatColor.AQUA + "/trades " + ChatColor.DARK_AQUA + "Show available trades!");
                    p.sendMessage(ChatColor.AQUA + "/shop  " + ChatColor.DARK_AQUA + "Show items available for purchase.");
                    p.sendMessage(ChatColor.GRAY + "-------------------------");
                }
            }

            else if (args.length == 2) {
                /*
                 * Add and Remove
                 */
                if ((args[0]).equalsIgnoreCase("add")) {
                    try {
                        Player toAdd = Bukkit.getPlayer(args[1]);
                        boolean pHasIsland = skyblock.getIslandDataConfig().getBoolean("Islands.UUID." + p.getUniqueId().toString() + ".hasIsland");
                        if (pHasIsland) {
                            boolean hasIslandToAdd = skyblock.getIslandDataConfig().getBoolean("Islands.UUID." + toAdd.getUniqueId().toString() + ".hasIsland");
                            if (hasIslandToAdd) {
                                p.sendMessage(ChatColor.RED + "This player already has an island or has not logged on.");
                            } else {

                                int members = skyblock.getIslandDataConfig().getInt("Islands.UUID." + p.getUniqueId().toString() + ".Members");
                                if (members <= 4) // max of 5
                                {
                                    skyblock.getIslandDataConfig().set("Islands.UUID." + toAdd.getUniqueId().toString() + ".hasIsland", true);
                                    skyblock.getIslandDataConfig().set("Islands.UUID." + p.getUniqueId().toString() + ".Members", members + 1);
                                    // In the file, player's UUID will be set to Owner's UUID
                                    skyblock.getCoopDataConfig().set("Coop.UUID." + toAdd.getUniqueId().toString(), p.getUniqueId().toString());
                                    try {
                                        skyblock.getIslandDataConfig().save(skyblock.getIslandDataFile());
                                        skyblock.getCoopDataConfig().save(skyblock.getCoopDataFile());
                                        p.sendMessage(ChatColor.GREEN + "Player added!");
                                        if (toAdd.isOnline()) {
                                            toAdd.sendMessage(ChatColor.GREEN + "You have been added to " + ChatColor.WHITE + p + "'s" + ChatColor.GREEN + "island!");
                                        }
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }

                                }
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You don't have an island to add anyone to.");
                        }

                    } catch (NullPointerException e){
                        p.sendMessage(ChatColor.RED + args[1] + ChatColor.YELLOW + " is not a player, or they haven't logged on!");
                    }

                }

                if (args[0].equalsIgnoreCase("remove")){
                    Player toRemove = Bukkit.getPlayer(args[1]);
                    boolean pHasIsland = skyblock.getIslandDataConfig().getBoolean("Islands.UUID." + p.getUniqueId().toString() + ".hasIsland");
                    if (pHasIsland) {
                        if (skyblock.getIslandDataConfig().contains("Islands.UUID." + p.getUniqueId().toString() + ".Members")) {
                            int members = skyblock.getIslandDataConfig().getInt("Islands.UUID." + p.getUniqueId().toString() + ".Members");
                            try {

                                skyblock.getCoopDataConfig().set("Coop.UUID." + toRemove.getUniqueId().toString(), null);
                                skyblock.getIslandDataConfig().set("Islands.UUID." + toRemove.getUniqueId().toString() + ".hasIsland", false);
                                skyblock.getIslandDataConfig().set("Islands.UUID." + p.getUniqueId().toString() + ".Members", members - 1);
                                try {
                                    skyblock.getIslandDataConfig().save(skyblock.getIslandDataFile());
                                    skyblock.getCoopDataConfig().save(skyblock.getCoopDataFile());
                                    p.sendMessage(ChatColor.RED + "Player removed.");
                                    if (toRemove.isOnline()) {
                                        toRemove.teleport(new Location(Bukkit.getWorld("world"), 1, 70, 1));
                                        toRemove.sendMessage(ChatColor.RED + "You have been removed from " + ChatColor.WHITE + p + "'s" + ChatColor.RED + "island!");
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                            } catch (NullPointerException e) {
                                e.printStackTrace();
                            }
                        }else {
                            p.sendMessage(ChatColor.RED + "You do not own the island!");
                        }
                    }
                    else
                    {
                        p.sendMessage(ChatColor.RED + "You don't have an island to remove anyone from.");
                    }


                }
            }
        }
        return true;
    }

    private boolean deleteWorld(File path) {
        if(path.exists()) {
            File files[] = path.listFiles();
            for(int i=0; i<files.length; i++) {
                if(files[i].isDirectory()) {
                    deleteWorld(files[i]);
                } else {
                    files[i].delete();
                }
            }
        }
        return(path.delete());
    }

}

