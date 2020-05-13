package me.isaaceichelberger.skyblock.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTpWorld implements CommandExecutor {
    // testing command, irrelevant to skyblock
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player){
            Player p = (Player) sender;
            p.teleport(new Location(Bukkit.getWorld(args[0]), 0, 70, 0));
        }
        return true;
    }
}
