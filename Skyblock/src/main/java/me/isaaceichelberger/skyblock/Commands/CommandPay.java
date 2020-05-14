package me.isaaceichelberger.skyblock.Commands;

import me.isaaceichelberger.skyblock.Skyblock;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

public class CommandPay implements CommandExecutor {
    private Skyblock skyblock;

    public CommandPay(Skyblock skyblock) {
        this.skyblock = skyblock;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        double bal = skyblock.getStatsDataConfig().getDouble(p.getUniqueId().toString() + ".Balance");
        if (args.length == 0 || args.length == 1 || args.length >= 3) {
            p.sendMessage(ChatColor.RED + "Please use the command as /pay (user) (amount)");
        }
        if (args.length == 2) {
            try {
                Player toPay = Bukkit.getPlayer(args[0]);

                if (toPay != p) {
                    double amount = Double.parseDouble(args[1]);
                    if (bal >= amount) {
                        double balToPay = skyblock.getStatsDataConfig().getDouble(toPay.getUniqueId().toString() + ".Balance");
                        skyblock.getStatsDataConfig().set(p.getUniqueId().toString() + ".Balance", bal - amount);
                        skyblock.getStatsDataConfig().set(toPay.getUniqueId().toString() + ".Balance", balToPay + amount);
                        try {
                            skyblock.getStatsDataConfig().save(skyblock.getStatsDataFile());
                            p.sendMessage(ChatColor.GREEN + "You have paid " + ChatColor.YELLOW + toPay.getDisplayName() + ChatColor.GREEN + " " + amount);
                            toPay.sendMessage(ChatColor.GREEN + "You have recieved " + amount + " from " + ChatColor.YELLOW + p.getDisplayName());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        p.sendMessage(ChatColor.RED + "That amount exceeds your balance.");
                    }
                }
                else
                {
                    p.sendMessage(ChatColor.RED + "You may not pay yourself");
                }
            } catch (NullPointerException e) {
                p.sendMessage(ChatColor.RED + "Player is offline.");
            }

        }
        return true;
    }
}