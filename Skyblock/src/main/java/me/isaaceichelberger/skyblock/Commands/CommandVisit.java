package me.isaaceichelberger.skyblock.Commands;

import me.isaaceichelberger.skyblock.Skyblock;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class CommandVisit implements CommandExecutor {
    private Skyblock skyblock;

    public CommandVisit(Skyblock skyblock){
        this.skyblock = skyblock;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player){
            Player p = (Player) sender;
            try {
                if (skyblock.getCoopDataConfig().contains("Coop.UUID." + Bukkit.getOfflinePlayer(args[0]).getUniqueId())) { // dep ok
                    String partName = skyblock.getCoopDataConfig().getString("Coop.UUID." + Bukkit.getPlayer(args[0]).getUniqueId());
                    String worldName = partName + "skyworld";
                    WorldCreator.name(worldName).createWorld();
                    p.teleport(new Location(Bukkit.getWorld(worldName), 1, 70, 1));
                }
                else{
                    String worldName = Bukkit.getOfflinePlayer(args[0]).getUniqueId().toString() + "skyworld";
                    WorldCreator.name(worldName).createWorld(); // Load World
                    p.teleport(new Location(Bukkit.getWorld(worldName), 1, 70, 1));
                }

            }
            catch (NullPointerException e){
                p.sendMessage(ChatColor.RED + args[0] + ChatColor.YELLOW + " has not created a world before!");
            }

        }
        return true;
    }
}


