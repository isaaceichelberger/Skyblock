package me.isaaceichelberger.skyblock.Commands;

import me.isaaceichelberger.skyblock.Skyblock;
import me.isaaceichelberger.skyblock.Utils.EasyGUI;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CommandTrade implements CommandExecutor {

    private Skyblock skyblock;

    public CommandTrade(Skyblock skyblock) {
        this.skyblock = skyblock;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            EasyGUI tradesGUI = new EasyGUI("Trades").setSlots(54);
            ItemStack birch = new ItemStack(Material.SAPLING, 1, (byte) 2);
            ItemStack spruce = new ItemStack(Material.SAPLING, 1, (byte) 1);
            ItemStack acacia = new ItemStack(Material.SAPLING, 1, (byte) 4);
            ItemStack jungle = new ItemStack(Material.SAPLING, 1, (byte) 3);
            ItemStack dark_oak = new ItemStack(Material.SAPLING, 1, (byte) 5);
            tradesGUI.setItem(11, spruce);
            tradesGUI.setItem(12, birch);
            tradesGUI.setItem(13, acacia);
            tradesGUI.setItem(14, jungle);
            tradesGUI.setItem(15, dark_oak);
            tradesGUI.openGUIFor(p);
        }
        return true;
    }

}
