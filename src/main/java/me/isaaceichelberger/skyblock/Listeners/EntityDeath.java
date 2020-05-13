package me.isaaceichelberger.skyblock.Listeners;

import me.isaaceichelberger.skyblock.Skyblock;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

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
    }

    @EventHandler
    public void onEntitySpawn(CreatureSpawnEvent e){
        if (e.getSpawnReason() == CreatureSpawnEvent.SpawnReason.SPAWNER){
            if (e.getEntityType() == EntityType.PIG){
                e.setCancelled(true);
            }
        }
    }
}
