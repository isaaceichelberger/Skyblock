package me.isaaceichelberger.skyblock.Commands;

import me.isaaceichelberger.skyblock.Skyblock;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandBalance implements CommandExecutor {
    private Skyblock skyblock;

    public CommandBalance(Skyblock skyblock) {
        this.skyblock = skyblock;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        double bal = skyblock.getStatsDataConfig().getDouble(p.getUniqueId().toString() + ".Balance");
        p.sendMessage(ChatColor.GRAY + "Your balance is: " + ChatColor.GREEN + bal);

        return true;
    }
}

