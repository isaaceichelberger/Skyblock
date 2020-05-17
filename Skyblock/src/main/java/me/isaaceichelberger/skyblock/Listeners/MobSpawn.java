package me.isaaceichelberger.skyblock.Listeners;

import me.isaaceichelberger.skyblock.Skyblock;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.CreatureSpawnEvent;

import java.util.Random;

public class MobSpawn extends SBListener {
    Skyblock skyblock;

    public MobSpawn(Skyblock pl){
        super(pl);
        this.skyblock = pl;
    }

    @EventHandler
    public void onMobSpawn(CreatureSpawnEvent e){
        if (e.getEntityType() == EntityType.SKELETON){
            int random = (int) (Math.random() * 100);
            if (random <= 3){
                Skeleton skeleton = (Skeleton) e.getEntity();
                skeleton.setSkeletonType(Skeleton.SkeletonType.WITHER);
            }
        }
    }
}
