package me.isaaceichelberger.skyblock.Commands;

import me.isaaceichelberger.skyblock.Skyblock;
import me.isaaceichelberger.skyblock.Utils.EasyGUI;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class CommandShop implements CommandExecutor {

    private Skyblock skyblock;

    public CommandShop(Skyblock skyblock) {
        this.skyblock = skyblock;
    }

        EasyGUI shopGUI = new EasyGUI("Shop").setSlots(54);

        @Override
        public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            if (sender instanceof Player) {
                ItemStack cowEgg = new ItemStack(Material.MONSTER_EGG, 1);
                cowEgg.setDurability((short) 92);
                ItemMeta cowEggItemMeta = cowEgg.getItemMeta();
                ArrayList<String> cowEggLore = new ArrayList<>();
                cowEggLore.add(ChatColor.RED + "$1000");
                cowEggItemMeta.setDisplayName(ChatColor.BLACK + "Cow Spawn Egg");
                cowEggItemMeta.setLore(cowEggLore);
                cowEgg.setItemMeta(cowEggItemMeta);
                ItemStack chickenEgg = new ItemStack(Material.MONSTER_EGG, 1);
                chickenEgg.setDurability((short) 93);
                ItemMeta chickenEggItemMeta = chickenEgg.getItemMeta();
                ArrayList<String> chickenEggLore = new ArrayList<>();
                chickenEggLore.add(ChatColor.RED + "$1000");
                chickenEggItemMeta.setDisplayName(ChatColor.RED + "Chicken Spawn Egg");
                chickenEggItemMeta.setLore(chickenEggLore);
                chickenEgg.setItemMeta(chickenEggItemMeta);
                ItemStack sheepEgg = new ItemStack(Material.MONSTER_EGG, 1);
                sheepEgg.setDurability((short) 91);
                ItemMeta sheepEggItemMeta = sheepEgg.getItemMeta();
                ArrayList<String> sheepEggLore = new ArrayList<>();
                sheepEggLore.add(ChatColor.RED + "$1000");
                sheepEggItemMeta.setDisplayName(ChatColor.RED + "Sheep Spawn Egg");
                sheepEggItemMeta.setLore(sheepEggLore);
                sheepEgg.setItemMeta(sheepEggItemMeta);
                shopGUI.setItem(12, cowEgg);
                shopGUI.setItem(13, chickenEgg);
                shopGUI.setItem(14, sheepEgg);
                shopGUI.openGUIFor((Player) sender);
                }
            return true;
    }
}

