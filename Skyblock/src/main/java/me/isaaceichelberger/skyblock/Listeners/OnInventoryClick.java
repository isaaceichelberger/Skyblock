package me.isaaceichelberger.skyblock.Listeners;

import me.isaaceichelberger.skyblock.Skyblock;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;

public class OnInventoryClick extends SBListener {
    private Skyblock skyblock;

    public OnInventoryClick(Skyblock pl) {
        super(pl);
        this.skyblock = pl;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getWhoClicked() instanceof Player) {
            if (e.getInventory().getName() == "Challenges") {
                if (e.getCurrentItem() != null) {
                    Player p = (Player) e.getWhoClicked();
                    Inventory pInv = p.getInventory();
                    int islandLevel = skyblock.getStatsDataConfig().getInt(p.getUniqueId().toString() + ".IslandLevel");
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Next Page")) {
                        Bukkit.getServer().dispatchCommand(p, "c two");
                    } //need c 3 and back etc
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Get wood!") && islandLevel < 1) {
                        ItemStack woodStack = new ItemStack(Material.WOOD, 64);
                        if (pInv.contains(woodStack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }

                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }

                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Cobblestone") && islandLevel < 2) {
                        ItemStack cobbleStack = new ItemStack(Material.COBBLESTONE, 64);
                        if (pInv.contains(cobbleStack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Create an Iron Generator") && islandLevel < 3) {
                        ItemStack iron_ore = new ItemStack(Material.IRON_ORE, 1);
                        if (pInv.contains(iron_ore)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Iron!") && islandLevel < 4) {
                        ItemStack iron_ore_stack = new ItemStack(Material.IRON_ORE, 64);
                        if (pInv.contains(iron_ore_stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Iron Gear") && islandLevel < 5) {
                        ItemStack iron_pick = new ItemStack(Material.IRON_PICKAXE, 1);
                        ItemStack iron_axe = new ItemStack(Material.IRON_AXE, 1);
                        ItemStack iron_shovel = new ItemStack(Material.IRON_SPADE, 1);
                        ItemStack iron_sword = new ItemStack(Material.IRON_SWORD, 1);
                        if (pInv.contains(iron_axe)  && pInv.contains(iron_pick) && pInv.contains(iron_shovel) && pInv.contains(iron_sword)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("More dirt") && islandLevel < 6) {
                        ItemStack dirtStack = new ItemStack(Material.DIRT, 64);
                        if (pInv.contains(dirtStack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    //Todo more challenges
                }
                e.setCancelled(true);
            }
            if (e.getInventory().getName() == "Challenges (2)") {
                if (e.getCurrentItem() != null) {
                    Player p = (Player) e.getWhoClicked();
                    Inventory pInv = p.getInventory();
                    int islandLevel = skyblock.getStatsDataConfig().getInt(p.getUniqueId().toString() + ".IslandLevel");
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Next Page")) {
                        Bukkit.getServer().dispatchCommand(p, "c three");
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Back")) {
                        Bukkit.getServer().dispatchCommand(p, "c");
                    }


                }
                e.setCancelled(true);
            }
            if (e.getInventory().getName() == "Challenges (3)") {
                if (e.getCurrentItem() != null) {
                    Player p = (Player) e.getWhoClicked();
                    Inventory pInv = p.getInventory();
                    int islandLevel = skyblock.getStatsDataConfig().getInt(p.getUniqueId().toString() + ".IslandLevel");
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Next Page")) {
                        p.sendMessage("No more challenges created.");
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Back")) {
                        Bukkit.getServer().dispatchCommand(p, "c two");
                    }
                }
                e.setCancelled(true);
            }

            if (e.getInventory().getName() == "Trades") {
                if (e.getCurrentItem() != null) {
                    Player p = (Player) e.getWhoClicked();
                    Inventory pInv = p.getInventory();
                    ItemStack birch = new ItemStack(Material.SAPLING, 1, (byte) 2);
                    ItemStack spruce = new ItemStack(Material.SAPLING, 1, (byte) 1);
                    ItemStack acacia = new ItemStack(Material.SAPLING, 1, (byte) 4);
                    ItemStack jungle = new ItemStack(Material.SAPLING, 1, (byte) 3);
                    ItemStack dark_oak = new ItemStack(Material.SAPLING, 1, (byte) 5);
                    if (e.getSlot() == 11) {
                        if (pInv.contains(new ItemStack(Material.SAPLING))) {
                            pInv.remove(new ItemStack(Material.SAPLING, 1));
                            pInv.addItem(birch);
                            p.sendMessage(ChatColor.GREEN + "Traded 1 Oak Sapling for 1 Birch Sapling!");
                        }
                    }
                    if (e.getSlot() == 12) {
                        if (pInv.contains(new ItemStack(Material.SAPLING))) {
                            pInv.remove(new ItemStack(Material.SAPLING, 1));
                            pInv.addItem(spruce);
                            p.sendMessage(ChatColor.GREEN + "Traded 1 Oak Sapling for 1 Spruce Sapling!");
                        }
                    }
                    if (e.getSlot() == 13) {
                        if (pInv.contains(new ItemStack(Material.SAPLING))) {
                            pInv.remove(new ItemStack(Material.SAPLING, 1));
                            pInv.addItem(acacia);
                            p.sendMessage(ChatColor.GREEN + "Traded 1 Oak Sapling for 1 Acacia Sapling!");
                        }
                    }
                    if (e.getSlot() == 14) {
                        if (pInv.contains(new ItemStack(Material.SAPLING))) {
                            pInv.remove(new ItemStack(Material.SAPLING, 1));
                            pInv.addItem(jungle);
                            p.sendMessage(ChatColor.GREEN + "Traded 1 Oak Sapling for 1 Jungle Sapling!");
                        }
                    }
                    if (e.getSlot() == 15) {
                        if (pInv.contains(new ItemStack(Material.SAPLING))) {
                            pInv.remove(new ItemStack(Material.SAPLING, 1));
                            pInv.addItem(dark_oak);
                            p.sendMessage(ChatColor.GREEN + "Traded 1 Oak Sapling for 1 Dark Oak Sapling!");
                        }
                    }
                    e.setCancelled(true);
                }
            }
            if (e.getInventory().getName() == "Shop") {
                if (e.getCurrentItem() != null) {
                    Player p = (Player) e.getWhoClicked();
                    Inventory pInv = p.getInventory();
                    Double balance = skyblock.getStatsDataConfig().getDouble(p.getUniqueId() + ".Balance");

                    if (e.getSlot() == 12) {
                        ItemStack cowEgg = new ItemStack(Material.MONSTER_EGG);
                        cowEgg.setDurability((short) 92);
                        pInv.addItem(cowEgg);
                        skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance - 1000);
                        try {
                            skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }

                    }
                    if (e.getSlot() == 13) {
                        ItemStack chickenEgg = new ItemStack(Material.MONSTER_EGG);
                        chickenEgg.setDurability((short) 93);
                        pInv.addItem(chickenEgg);
                        skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance - 1000);
                        try {
                            skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }

                    }
                    if (e.getSlot() == 14) {
                        ItemStack sheepEgg = new ItemStack(Material.MONSTER_EGG);
                        sheepEgg.setDurability((short) 91);
                        pInv.addItem(sheepEgg);
                        skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance - 1000);
                        try {
                            skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }

                    }
                    e.setCancelled(true);
                }
                }
            }
        }
    }

