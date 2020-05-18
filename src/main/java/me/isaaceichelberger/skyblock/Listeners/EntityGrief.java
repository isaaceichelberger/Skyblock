package me.isaaceichelberger.skyblock.Listeners;

import me.isaaceichelberger.skyblock.Skyblock;
import net.minecraft.server.v1_8_R3.EntityComplexPart;
import org.bukkit.Material;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

public class EntityGrief extends SBListener {
    private Skyblock skyblock;

    public EntityGrief(Skyblock pl){
        super(pl);
        this.skyblock = pl;
    }

    @EventHandler
    public void onEntityGrief(EntityChangeBlockEvent e){
        if (e.getEntityType() == EntityType.ENDER_DRAGON){
            e.setCancelled(true);
        }
    }


}
