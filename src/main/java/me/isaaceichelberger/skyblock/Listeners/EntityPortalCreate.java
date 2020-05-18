package me.isaaceichelberger.skyblock.Listeners;

import me.isaaceichelberger.skyblock.Skyblock;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityCreatePortalEvent;

public class EntityPortalCreate extends SBListener{
    private Skyblock skyblock;

    public EntityPortalCreate(Skyblock pl){
        super(pl);
        this.skyblock = pl;
    }

    @EventHandler
    public void onEntityPortalCreate(EntityCreatePortalEvent e){
        if (e.getEntityType() == EntityType.ENDER_DRAGON){
            e.setCancelled(true);
        }
    }
}
