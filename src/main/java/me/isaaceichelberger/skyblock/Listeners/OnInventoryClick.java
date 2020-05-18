package me.isaaceichelberger.skyblock.Listeners;

import me.isaaceichelberger.skyblock.Skyblock;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.Material;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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
                    double balance = skyblock.getStatsDataConfig().getDouble(p.getUniqueId().toString() + ".Balance");
                    int islandLevel = skyblock.getStatsDataConfig().getInt(p.getUniqueId().toString() + ".IslandLevel");
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Next Page")) {
                        Bukkit.getServer().dispatchCommand(p, "c two");
                    } //need c 3 and back etc
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Get wood!") && islandLevel == 0) {
                        ItemStack woodStack = new ItemStack(Material.LOG, 64);
                        if (pInv.contains(woodStack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }

                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }

                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Cobblestone") && islandLevel == 1) {
                        ItemStack cobbleStack = new ItemStack(Material.COBBLESTONE, 64);
                        if (pInv.contains(cobbleStack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Create a coal generator") && islandLevel == 2) {
                        ItemStack stack = new ItemStack(Material.COAL_ORE, 1);
                        ItemMeta stackMeta = stack.getItemMeta();
                        ArrayList<String> stackLore = new ArrayList<>();
                        stackLore.add(ChatColor.GRAY + "Place this under where cobbblestone would generate");
                        stackLore.add(ChatColor.GRAY + "to generate coal ore");
                        stackMeta.setDisplayName(ChatColor.DARK_GRAY + "COAL GEN");
                        stackMeta.setLore(stackLore);
                        stack.setItemMeta(stackMeta);
                        if (pInv.contains(stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Coal!") && islandLevel == 3) {
                        ItemStack stack = new ItemStack(Material.COAL, 64);
                        if (pInv.contains(stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Create an Iron Generator") && islandLevel == 4) {
                        ItemStack stack = new ItemStack(Material.IRON_ORE, 1);
                        ItemMeta stackMeta = stack.getItemMeta();
                        ArrayList<String> stackLore = new ArrayList<>();
                        stackLore.add(ChatColor.GRAY + "Place this under where cobbblestone would generate");
                        stackLore.add(ChatColor.GRAY + "to generate iron ore");
                        stackMeta.setDisplayName(ChatColor.GRAY + "IRON GEN");
                        stackMeta.setLore(stackLore);
                        stack.setItemMeta(stackMeta);
                        if (pInv.contains(stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Iron!") && islandLevel == 5) {
                        ItemStack iron_ore_stack = new ItemStack(Material.IRON_ORE, 64);
                        if (pInv.contains(iron_ore_stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Iron Gear") && islandLevel == 6) {
                        ItemStack iron_pick = new ItemStack(Material.IRON_PICKAXE, 1);
                        ItemStack iron_axe = new ItemStack(Material.IRON_AXE, 1);
                        ItemStack iron_shovel = new ItemStack(Material.IRON_SPADE, 1);
                        ItemStack iron_sword = new ItemStack(Material.IRON_SWORD, 1);
                        if (pInv.contains(iron_axe) && pInv.contains(iron_pick) && pInv.contains(iron_shovel) && pInv.contains(iron_sword)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("More dirt") && islandLevel == 7) {
                        ItemStack dirtStack = new ItemStack(Material.DIRT, 64);
                        if (pInv.contains(dirtStack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Gravel") && islandLevel == 8) {
                        ItemStack gravelStack = new ItemStack(Material.GRAVEL, 4);
                        if (pInv.contains(gravelStack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Sand") && islandLevel == 9) {
                        ItemStack sandStack = new ItemStack(Material.SAND, 4);
                        if (pInv.contains(sandStack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Farming") && islandLevel == 10) {
                        ItemStack wheatStack = new ItemStack(Material.WHEAT, 64);
                        if (pInv.contains(wheatStack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Farming Part 2") && islandLevel == 11) {
                        ItemStack stack = new ItemStack(Material.CARROT, 64);
                        if (pInv.contains(stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Farming Part 3") && islandLevel == 12) {
                        ItemStack stack = new ItemStack(Material.POTATO, 64);
                        if (pInv.contains(stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Striking gold!") && islandLevel == 13) {
                        ItemStack stack = new ItemStack(Material.GOLD_ORE, 1);
                        ItemMeta stackMeta = stack.getItemMeta();
                        ArrayList<String> stackLore = new ArrayList<>();
                        stackLore.add(ChatColor.GRAY + "Place this under where cobbblestone would generate");
                        stackLore.add(ChatColor.GRAY + "to generate gold ore");
                        stackMeta.setDisplayName(ChatColor.GOLD + "GOLD GEN");
                        stackMeta.setLore(stackLore);
                        stack.setItemMeta(stackMeta);
                        if (pInv.contains(stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("We're rich!") && islandLevel == 14) {
                        ItemStack stack = new ItemStack(Material.GOLD_BLOCK, 16);
                        if (pInv.contains(stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Time for Lapis") && islandLevel == 15) {
                        ItemStack stack = new ItemStack(Material.LAPIS_ORE, 1);
                        ItemMeta stackMeta = stack.getItemMeta();
                        ArrayList<String> stackLore = new ArrayList<>();
                        stackLore.add(ChatColor.GRAY + "Place this under where cobbblestone would generate");
                        stackLore.add(ChatColor.GRAY + "to generate lapis ore");
                        stackMeta.setDisplayName(ChatColor.BLUE + "LAPIS GEN");
                        stackMeta.setLore(stackLore);
                        stack.setItemMeta(stackMeta);
                        if (pInv.contains(stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("More saplings??") && islandLevel == 16) {
                        ItemStack birch = new ItemStack(Material.SAPLING, 1, (byte) 2);
                        ItemStack spruce = new ItemStack(Material.SAPLING, 1, (byte) 1);
                        ItemStack acacia = new ItemStack(Material.SAPLING, 1, (byte) 4);
                        ItemStack jungle = new ItemStack(Material.SAPLING, 1, (byte) 3);
                        ItemStack dark_oak = new ItemStack(Material.SAPLING, 1, (byte) 5);
                        if (pInv.contains(birch) || pInv.contains(spruce) || pInv.contains(acacia) || pInv.contains(jungle) || pInv.contains(dark_oak)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("New wood!") && islandLevel == 17) {
                        ItemStack birch = new ItemStack(Material.LOG, 64, (byte) 2);
                        ItemStack spruce = new ItemStack(Material.LOG, 64, (byte) 1);
                        ItemStack acacia = new ItemStack(Material.LOG_2, 64);
                        ItemStack jungle = new ItemStack(Material.LOG, 64, (byte) 3);
                        ItemStack dark_oak = new ItemStack(Material.LOG_2, 64, (byte) 1);
                        if (pInv.contains(birch) || pInv.contains(spruce) || pInv.contains(acacia) || pInv.contains(jungle) || pInv.contains(dark_oak)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Clay") && islandLevel == 18) {
                        ItemStack stack = new ItemStack(Material.CLAY, 1);
                        if (pInv.contains(stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("More lava!") && islandLevel == 19) {
                        ItemStack stack = new ItemStack(Material.LAVA_BUCKET, 1);
                        if (pInv.contains(stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Farming part 4") && islandLevel == 20) {
                        ItemStack stack = new ItemStack(Material.SUGAR_CANE, 64);
                        if (pInv.contains(stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Farming Part 5") && islandLevel == 21) {
                        ItemStack stack = new ItemStack(Material.PUMPKIN, 64);
                        if (pInv.contains(stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Farming Part 6") && islandLevel == 22) {
                        ItemStack stack = new ItemStack(Material.MELON, 64);
                        if (pInv.contains(stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Redstone") && islandLevel == 23) {
                        ItemStack stack = new ItemStack(Material.REDSTONE_ORE, 1);
                        ItemMeta stackMeta = stack.getItemMeta();
                        ArrayList<String> stackLore = new ArrayList<>();
                        stackLore.add(ChatColor.GRAY + "Place this under where cobbblestone would generate");
                        stackLore.add(ChatColor.GRAY + "to generate redstone ore");
                        stackMeta.setDisplayName(ChatColor.RED + "REDSTONE GEN");
                        stackMeta.setLore(stackLore);
                        stack.setItemMeta(stackMeta);
                        if (pInv.contains(stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Diamonds!!") && islandLevel == 24) {
                        ItemStack stack = new ItemStack(Material.DIAMOND_ORE, 1);
                        ItemMeta stackMeta = stack.getItemMeta();
                        ArrayList<String> stackLore = new ArrayList<>();
                        stackLore.add(ChatColor.GRAY + "Place this under where cobbblestone would generate");
                        stackLore.add(ChatColor.GRAY + "to generate diamond ore");
                        stackMeta.setDisplayName(ChatColor.AQUA + "DIAMOND GEN");
                        stackMeta.setLore(stackLore);
                        stack.setItemMeta(stackMeta);
                        if (pInv.contains(stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Even Richer") && islandLevel == 25) {
                        ItemStack stack = new ItemStack(Material.DIAMOND_BLOCK, 16);
                        if (pInv.contains(stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Obsidian") && islandLevel == 26) {
                        ItemStack stack = new ItemStack(Material.OBSIDIAN, 16);
                        if (pInv.contains(stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Obsidian") && islandLevel == 26) {
                        ItemStack stack = new ItemStack(Material.OBSIDIAN, 16);
                        if (pInv.contains(stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Livestock") && islandLevel == 27) {
                        ItemStack stack = new ItemStack(Material.RAW_BEEF, 64);
                        if (pInv.contains(stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Livestock Part 2") && islandLevel == 28) {
                        ItemStack stack = new ItemStack(Material.RAW_CHICKEN, 64);
                        if (pInv.contains(stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Livestock Part 3") && islandLevel == 29) {
                        ItemStack stack = new ItemStack(Material.MUTTON, 64);
                        if (pInv.contains(stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Enchanting") && islandLevel == 30) {
                        ItemStack stack = new ItemStack(Material.ENCHANTMENT_TABLE, 1);
                        if (pInv.contains(stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("The Nether") && islandLevel == 31) {
                        ItemStack stack = new ItemStack(Material.NETHERRACK, 64);
                        if (pInv.contains(stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Precious Materials") && islandLevel == 32) {
                        ItemStack stack = new ItemStack(Material.QUARTZ, 64);
                        if (pInv.contains(stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Nether Mobs") && islandLevel == 33) {
                        ItemStack stack = new ItemStack(Material.BLAZE_ROD, 1);
                        ItemStack stack1 = new ItemStack(Material.GHAST_TEAR);
                        ItemStack stack2 = new ItemStack(Material.MAGMA_CREAM);
                        if (pInv.contains(stack) && pInv.contains(stack1) && pInv.contains(stack2)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Nether Farming?!") && islandLevel == 34) {
                        ItemStack stack = new ItemStack(Material.NETHER_WARTS, 64);
                        if (pInv.contains(stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("The local brewery") && islandLevel == 35) {
                        ItemStack stack = new ItemStack(Material.POTION, 1);
                        if (pInv.contains(stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    e.setCancelled(true);
                }
            }
            if (e.getInventory().getName() == "Challenges (2)") {
                if (e.getCurrentItem() != null) {
                    Player p = (Player) e.getWhoClicked();
                    Inventory pInv = p.getInventory();
                    int islandLevel = skyblock.getStatsDataConfig().getInt(p.getUniqueId().toString() + ".IslandLevel");
                    double balance = skyblock.getStatsDataConfig().getDouble(p.getUniqueId().toString() + ".Balance");
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Next Page")) {
                        Bukkit.getServer().dispatchCommand(p, "c three");
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Back")) {
                        Bukkit.getServer().dispatchCommand(p, "c");
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Mob Spawning Part 1") && islandLevel == 36) {
                        ItemStack stack = new ItemStack(Material.MONSTER_EGG, 1);
                        stack.setDurability((short) 54);
                        if (pInv.contains(stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Spawners Part 1") && islandLevel == 37) {
                        ItemStack stack = new ItemStack(Material.ROTTEN_FLESH, 64);
                        if (pInv.contains(stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Mob Spawning Part 2") && islandLevel == 38) {
                        ItemStack stack = new ItemStack(Material.MONSTER_EGG, 1);
                        stack.setDurability((short) 51);
                        if (pInv.contains(stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Spawners Part 2") && islandLevel == 39) {
                        ItemStack stack = new ItemStack(Material.BONE, 64);
                        if (pInv.contains(stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Mob Spawning Part 3") && islandLevel == 40) {
                        ItemStack stack = new ItemStack(Material.MONSTER_EGG, 1);
                        stack.setDurability((short) 50);
                        if (pInv.contains(stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Spawners Part 3") && islandLevel == 41) {
                        ItemStack stack = new ItemStack(Material.SULPHUR, 64);
                        if (pInv.contains(stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Mob Spawning Part 4") && islandLevel == 42) {
                        ItemStack stack = new ItemStack(Material.MONSTER_EGG, 1);
                        stack.setDurability((short) 52);
                        if (pInv.contains(stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Spawners Part 4") && islandLevel == 43) {
                        ItemStack stack = new ItemStack(Material.STRING, 64);
                        if (pInv.contains(stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Mob Spawning Part 5") && islandLevel == 44) {
                        ItemStack stack = new ItemStack(Material.MONSTER_EGG, 1);
                        stack.setDurability((short) 58);
                        if (pInv.contains(stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Spawners Part 5") && islandLevel == 45) {
                        ItemStack stack = new ItemStack(Material.ENDER_PEARL, 64);
                        if (pInv.contains(stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Mob Spawning Part 6") && islandLevel == 46) {
                        ItemStack stack = new ItemStack(Material.MONSTER_EGG, 1);
                        stack.setDurability((short) 61);
                        if (pInv.contains(stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Spawners Part 6") && islandLevel == 47) {
                        ItemStack stack = new ItemStack(Material.BLAZE_ROD, 64);
                        if (pInv.contains(stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Mob Spawning Part 7") && islandLevel == 48) {
                        ItemStack stack = new ItemStack(Material.MONSTER_EGG, 1);
                        stack.setDurability((short) 57);
                        if (pInv.contains(stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Spawners Part 7") && islandLevel == 49) {
                        ItemStack stack = new ItemStack(Material.GOLD_BLOCK, 64);
                        if (pInv.contains(stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Mob Spawning Part 8") && islandLevel == 50) {
                        ItemStack stack = new ItemStack(Material.SKULL, 1);
                        if (pInv.contains(stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Eventually a wither") && islandLevel == 51) {
                        ItemStack stack = new ItemStack(Material.SKULL, 3);
                        if (pInv.contains(stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Nether Star") && islandLevel == 52) {
                        ItemStack stack = new ItemStack(Material.NETHER_STAR, 1);
                        if (pInv.contains(stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Beacon") && islandLevel == 53) {
                        ItemStack stack = new ItemStack(Material.BEACON, 1);
                        if (pInv.contains(stack)) {
                            p.sendMessage(ChatColor.GREEN + "Challenge completed!");
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S" + ChatColor.GREEN +
                                    " ISLAND LEVEL UP! " + "" + ChatColor.AQUA + "" + ChatColor.MAGIC + "S");
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".IslandLevel", islandLevel + 1);
                            skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", balance + 1000);
                            try {
                                skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "You do not have the required materials.");
                        }
                    }
                }
                e.setCancelled(true);
            }
            if (e.getInventory().getName() == "Challenges (3)") {
                if (e.getCurrentItem() != null) {
                    Player p = (Player) e.getWhoClicked();
                    Inventory pInv = p.getInventory();
                    int islandLevel = skyblock.getStatsDataConfig().getInt(p.getUniqueId().toString() + ".IslandLevel");
                    double balance = skyblock.getStatsDataConfig().getDouble(p.getUniqueId().toString() + ".Balance");
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Next Page")) {
                        p.sendMessage("No more challenges created.");
                    }
                    if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Back")) {
                        Bukkit.getServer().dispatchCommand(p, "c two");
                    }
                }
                e.setCancelled(true);
            }

            /*
            TRADES GUI
             */

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

            /*
            SHOP
             */
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


                /*
                UNSAFE BOOK ENCHANTS, ANVILINV
                 */
                if (e.getInventory() instanceof AnvilInventory){
                    if(e.getInventory().getItem(0) != null && e.getInventory().getItem(1) != null)
                    {
                        ItemStack result = new ItemStack(e.getInventory().getItem(0));
                            // Enchant meta of item 1
                            EnchantmentStorageMeta bookmeta = (EnchantmentStorageMeta) e.getInventory().getItem(1).getItemMeta();
                            HashMap<Enchantment, Integer> enchantments = new HashMap<>();
                            enchantments = (HashMap) bookmeta.getStoredEnchants();
                            result.addUnsafeEnchantments(enchantments);
                            result.addUnsafeEnchantments(e.getInventory().getItem(1).getEnchantments());
                        e.getInventory().setItem(2, result);
                    }
                }
            }
        }
    }

