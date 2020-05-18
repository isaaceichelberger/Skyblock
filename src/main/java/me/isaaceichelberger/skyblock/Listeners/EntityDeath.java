package me.isaaceichelberger.skyblock.Listeners;

import me.isaaceichelberger.skyblock.Skyblock;
import org.apache.commons.io.FileUtils;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EntityDeath extends SBListener {
    private Skyblock skyblock;

    public EntityDeath(Skyblock pl){
        super(pl);
        this.skyblock = pl;
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent e){
        int random = (int) (Math.random() * 100);
        if (e.getEntityType() == EntityType.ZOMBIE){
            if (random <= 2){
                ItemStack zombieEgg = new ItemStack(Material.MONSTER_EGG);
                zombieEgg.setDurability((short) 54); // Zombie Code
                e.getDrops().add(zombieEgg);
            }
        }
        if (e.getEntityType() == EntityType.SKELETON){
                if (random <= 2){
                    ItemStack zombieEgg = new ItemStack(Material.MONSTER_EGG);
                    zombieEgg.setDurability((short) 51); // Skeleton Code
                    e.getDrops().add(zombieEgg);
                }
            }

        if (e.getEntityType() == EntityType.SLIME){
            if (random <= 2){
                ItemStack egg = new ItemStack(Material.MONSTER_EGG);
                egg.setDurability((short) 55); // Slime Code
                e.getDrops().add(egg);
            }
        }
        if (e.getEntityType() == EntityType.CREEPER){
            if (random <= 2){
                ItemStack egg = new ItemStack(Material.MONSTER_EGG);
                egg.setDurability((short) 50); // Creeper Code
                e.getDrops().add(egg);
            }
        }
        if (e.getEntityType() == EntityType.ENDERMAN){
            if (random <= 2){
                ItemStack egg = new ItemStack(Material.MONSTER_EGG);
                egg.setDurability((short) 58); // Enderman Code
                e.getDrops().add(egg);
            }
        }
        if (e.getEntityType() == EntityType.SPIDER){
            if (random <= 2){
                ItemStack egg = new ItemStack(Material.MONSTER_EGG);
                egg.setDurability((short) 52); // Spider Code
                e.getDrops().add(egg);
            }

        }
        if (e.getEntityType() == EntityType.BLAZE){
            if (random <= 2){
                ItemStack egg = new ItemStack(Material.MONSTER_EGG);
                egg.setDurability((short) 61); // Blaze Code
                e.getDrops().add(egg);
            }
        }
        if (e.getEntityType() == EntityType.MAGMA_CUBE){
            if (random <= 2){
                ItemStack egg = new ItemStack(Material.MONSTER_EGG);
                egg.setDurability((short) 62); // Magma Cube Code
                e.getDrops().add(egg);
            }
        }
        if (e.getEntityType() == EntityType.PIG_ZOMBIE){
            if (random <= 2){
                ItemStack egg = new ItemStack(Material.MONSTER_EGG);
                egg.setDurability((short) 57); // Zombie PIgman Code
                e.getDrops().add(egg);
            }
        }

        if (e.getEntityType() == EntityType.ENDER_DRAGON){ // Special Drops for EnderDragon
            List<Player> players;
            // Sharp 6 Book (1)
            ItemStack sharpBook = new ItemStack(Material.ENCHANTED_BOOK);
            EnchantmentStorageMeta sharpMeta = (EnchantmentStorageMeta) sharpBook.getItemMeta();
            sharpMeta.addStoredEnchant(Enchantment.DAMAGE_ALL, 6, true);
            sharpBook.setItemMeta(sharpMeta);
            // Prot 5 Book (2)
            ItemStack protBook = new ItemStack(Material.ENCHANTED_BOOK);
            EnchantmentStorageMeta protMeta = (EnchantmentStorageMeta) protBook.getItemMeta();
            protMeta.addStoredEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
            protBook.setItemMeta(protMeta);
            // Proj Prot 5 (3)
            ItemStack ppBook = new ItemStack(Material.ENCHANTED_BOOK);
            EnchantmentStorageMeta ppMeta = (EnchantmentStorageMeta) ppBook.getItemMeta();
            ppMeta.addStoredEnchant(Enchantment.PROTECTION_PROJECTILE, 5, true);
            ppBook.setItemMeta(ppMeta);
            //Looting 4 (4)
            ItemStack lootBook = new ItemStack(Material.ENCHANTED_BOOK);
            EnchantmentStorageMeta lootMeta = (EnchantmentStorageMeta) lootBook.getItemMeta();
            lootMeta.addStoredEnchant(Enchantment.LOOT_BONUS_MOBS, 4, true);
            lootBook.setItemMeta(lootMeta);
            // Fortune 4 (5)
            ItemStack fortuneBook = new ItemStack(Material.ENCHANTED_BOOK);
            EnchantmentStorageMeta fortuneMeta = (EnchantmentStorageMeta) fortuneBook.getItemMeta();
            fortuneMeta.addStoredEnchant(Enchantment.LOOT_BONUS_BLOCKS, 4, true);
            fortuneBook.setItemMeta(fortuneMeta);

            // Dragon Head (6)
            ItemStack dragonEgg = new ItemStack(Material.DRAGON_EGG);

            World w = Bukkit.getWorld("end");
            players = w.getPlayers();
            Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "THE ENDER DRAGON HAS BEEN DEFEATED!");
            for (Player p : players){
                int random1 = (int) (Math.random() * 100);
                Inventory pInv = p.getInventory();
                if (random1 <= 1){ // replace with less than 1
                    w.dropItem(new Location(w, 10, 80, 15), sharpBook);
                    Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "A " + ChatColor.AQUA + "SHARPNESS VI BOOK" + ChatColor.GOLD + " dropped from the ender dragon!");
                }
                else if (random1 >= 1 && random1 <= 3){
                    w.dropItem(new Location(w, 20, 80, 19), protBook);
                    Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "A " + ChatColor.AQUA + "PROTECTION V BOOK" + ChatColor.GOLD + " dropped from the ender dragon!");
                }
                else if (random1 >= 3 && random1 <= 6){
                    w.dropItem(new Location(w, 5, 80, 0), ppBook);
                    Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "A " + ChatColor.AQUA + "PROJECTILE PROTECTION V BOOK" + ChatColor.GOLD + " dropped from the ender dragon!");
                }
                else if (random1 >= 6 && random1 <= 7){
                    w.dropItem(new Location(w, 22, 80, 5), fortuneBook);
                    Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "A " + ChatColor.AQUA + "FORTUNE 4 BOOK" + ChatColor.GOLD + " dropped from the ender dragon!");
                }
                else if (random1 >= 7 && random1 <= 9){
                    w.dropItem(new Location(w, 36, 80, 23), lootBook);
                    Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "A " + ChatColor.AQUA + "PROJECTILE PROTECTION V BOOK" + ChatColor.GOLD + " dropped from the ender dragon!");
                }
                else if (random1 >= 9 && random1 <= 15){
                    w.dropItem(new Location(w, 0, 80, 0), dragonEgg);
                    Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "A " + ChatColor.AQUA + "DRAGON EGG" + ChatColor.GOLD + " dropped from the ender dragon!");
                }

            }
            new BukkitRunnable() {
                @Override
                public void run() {
                    for (Player p : players){
                        Bukkit.getServer().dispatchCommand(p,"is tp");
                    }
                    if (Bukkit.getServer().unloadWorld(Bukkit.getServer().getWorld("end"), false)) {
                        skyblock.getLogger().info("Successfully unloaded the end");
                    } else {
                        skyblock.getLogger().severe("COULD NOT UNLOAD THE END");
                    }
                    World delete = Bukkit.getServer().getWorld("end");
                    File deleteFolder = delete.getWorldFolder();
                    try {
                        FileUtils.deleteDirectory(deleteFolder);
                    } catch (NullPointerException e) {
                        Bukkit.getServer().getLogger().info("deleted end");
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }.runTaskLater(skyblock, 600L); // tp players out

        }
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
