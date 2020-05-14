package me.isaaceichelberger.skyblock.Listeners;

import me.isaaceichelberger.skyblock.Skyblock;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class OnChat extends SBListener {
    private Skyblock skyblock;

    public OnChat(Skyblock pl){
        super(pl);
        this.skyblock = pl;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        String message = e.getMessage();
        int islandLevel = skyblock.getStatsDataConfig().getInt(e.getPlayer().getUniqueId().toString() + ".IslandLevel");
        String prefix = "";
        if (islandLevel >=0 && islandLevel <= 9){
            prefix = ChatColor.GRAY + String.valueOf(islandLevel);
        }
        else if (islandLevel >= 10 && islandLevel <= 19){
            prefix = ChatColor.GREEN + String.valueOf(islandLevel);
        }
        else if (islandLevel >= 20 && islandLevel <= 29){
            prefix = ChatColor.DARK_BLUE + String.valueOf(islandLevel);
        }
        else if (islandLevel >= 30 && islandLevel <= 39){
            prefix = ChatColor.DARK_PURPLE + String.valueOf(islandLevel);
        }
        else if (islandLevel >= 40 && islandLevel <= 49){
            prefix = ChatColor.AQUA + String.valueOf(islandLevel);
        }
        else if (islandLevel >= 50 && islandLevel <= 59){
            prefix = ChatColor.DARK_AQUA + String.valueOf(islandLevel);
        }
        else if (islandLevel >= 60 && islandLevel <= 69){
            prefix = ChatColor.DARK_GREEN + String.valueOf(islandLevel);
        }
        else if (islandLevel >= 70 && islandLevel <= 79){
            prefix = ChatColor.BLUE + String.valueOf(islandLevel);
        }
        else if (islandLevel >= 80 && islandLevel <= 89){
            prefix = ChatColor.GOLD + String.valueOf(islandLevel);
        }
        else if (islandLevel >= 90) {
            prefix = ChatColor.AQUA + "" + ChatColor.MAGIC + "|" + ChatColor.GOLD + String.valueOf(islandLevel) + ChatColor.AQUA + "" + ChatColor.MAGIC +  "|";
        }
        e.setFormat(ChatColor.DARK_GRAY + "[" + prefix + ChatColor.DARK_GRAY + "] "  + ChatColor.WHITE +
                e.getPlayer().getDisplayName() + ChatColor.GOLD + ": " + ChatColor.WHITE + message);

    }
}
