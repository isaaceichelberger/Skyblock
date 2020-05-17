package me.isaaceichelberger.skyblock.Commands;

import me.isaaceichelberger.skyblock.Skyblock;
import me.isaaceichelberger.skyblock.Utils.EasyGUI;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;


public class CommandChallenges implements CommandExecutor {

    private Skyblock skyblock;

    public CommandChallenges(Skyblock skyblock) {
        this.skyblock = skyblock;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            if (sender instanceof Player){
            Player p = (Player) sender;
            //TODO GIVE PLAYER MONEY REWARDS
            if (args.length == 0) {
                EasyGUI ChallengesGUI = new EasyGUI("Challenges").setSlots(54);
                for (int i = 1; i <= 36; i++) {
                    int islandLevel = skyblock.getStatsDataConfig().getInt(p.getUniqueId().toString() + ".IslandLevel");
                    if (islandLevel < i) {
                        ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.RED.getData());
                        String title = skyblock.getChallangesConfig().getString(i + ".Title");
                        String mission = skyblock.getChallangesConfig().getString(i + ".Mission");
                        Boolean collect = skyblock.getChallangesConfig().getBoolean(i + ".Collect");
                        ItemMeta itemMeta = item.getItemMeta();
                        itemMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + title);
                        ArrayList<String> itemLore = new ArrayList<>();
                        itemLore.add(ChatColor.GRAY + mission);
                        if (collect == true) {
                            itemLore.add(ChatColor.RED + "Items taken on completion.");
                        }
                        itemMeta.setLore(itemLore);
                        item.setItemMeta(itemMeta);
                        ChallengesGUI.setItem(i - 1, item);
                    } else {
                        ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.GREEN.getData());
                        String title = skyblock.getChallangesConfig().getString(i + ".Title");
                        String mission = skyblock.getChallangesConfig().getString(i + ".Mission");
                        ItemMeta itemMeta = item.getItemMeta();
                        itemMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + title);
                        ArrayList<String> itemLore = new ArrayList<>();
                        itemLore.add(ChatColor.GRAY + mission);
                        itemLore.add(ChatColor.RED + "You have already completed this challenge.");
                        itemMeta.setLore(itemLore);
                        item.setItemMeta(itemMeta);
                        ChallengesGUI.setItem(i - 1, item);
                    }
                }
                ItemStack back = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.RED.getData());
                ItemMeta backMeta = back.getItemMeta();
                backMeta.setDisplayName(ChatColor.RED + "Back");
                ItemStack forward = new ItemStack(Material.ARROW);
                ItemMeta forwardMeta = forward.getItemMeta();
                forwardMeta.setDisplayName(ChatColor.GREEN + "Next Page");
                back.setItemMeta(backMeta);
                forward.setItemMeta(forwardMeta);
                ChallengesGUI.setItem(48, back);
                ChallengesGUI.setItem(50, forward);
                ChallengesGUI.openGUIFor(p);
            }
            if (args.length == 1){
                if (args[0].equalsIgnoreCase("two")){
                    EasyGUI ChallengesGUI = new EasyGUI("Challenges (2)").setSlots(54);
                    for (int i = 37; i <= 72; i++) {
                        int islandLevel = skyblock.getStatsDataConfig().getInt(p.getUniqueId().toString() + ".IslandLevel");
                        if (islandLevel < i) {
                            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.RED.getData());
                            String title = skyblock.getChallangesConfig().getString(i + ".Title");
                            String mission = skyblock.getChallangesConfig().getString(i + ".Mission");
                            Boolean collect = skyblock.getChallangesConfig().getBoolean(i + ".Collect");
                            ItemMeta itemMeta = item.getItemMeta();
                            itemMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + title);
                            ArrayList<String> itemLore = new ArrayList<>();
                            itemLore.add(ChatColor.GRAY + mission);
                            if (collect == true) {
                                itemLore.add(ChatColor.RED + "Items taken on completion.");
                            }
                            itemMeta.setLore(itemLore);
                            item.setItemMeta(itemMeta);
                            ChallengesGUI.setItem(i - 1 - 36, item);
                        } else {
                            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.GREEN.getData());
                            String title = skyblock.getChallangesConfig().getString(i + ".Title");
                            String mission = skyblock.getChallangesConfig().getString(i + ".Mission");
                            ItemMeta itemMeta = item.getItemMeta();
                            itemMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + title);
                            ArrayList<String> itemLore = new ArrayList<>();
                            itemLore.add(ChatColor.GRAY + mission);
                            itemLore.add(ChatColor.RED + "You have already completed this challenge.");
                            itemMeta.setLore(itemLore);
                            item.setItemMeta(itemMeta);
                            ChallengesGUI.setItem(i - 1 - 36, item);
                        }
                    }
                    ItemStack back = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.RED.getData());
                    ItemMeta backMeta = back.getItemMeta();
                    backMeta.setDisplayName(ChatColor.RED + "Back");
                    ItemStack forward = new ItemStack(Material.ARROW);
                    ItemMeta forwardMeta = forward.getItemMeta();
                    forwardMeta.setDisplayName(ChatColor.GREEN + "Next Page");
                    back.setItemMeta(backMeta);
                    forward.setItemMeta(forwardMeta);
                    ChallengesGUI.setItem(48, back);
                    ChallengesGUI.setItem(50, forward);
                    ChallengesGUI.openGUIFor(p);
                }

                if (args[0].equalsIgnoreCase("three")){
                    EasyGUI ChallengesGUI = new EasyGUI("Challenges (3)").setSlots(54);
                    for (int i = 73; i <= 100; i++) {
                        int islandLevel = skyblock.getStatsDataConfig().getInt(p.getUniqueId().toString() + ".IslandLevel");
                        if (islandLevel < i) {
                            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.RED.getData());
                            String title = skyblock.getChallangesConfig().getString(i + ".Title");
                            String mission = skyblock.getChallangesConfig().getString(i + ".Mission");
                            Boolean collect = skyblock.getChallangesConfig().getBoolean(i + ".Collect");
                            ItemMeta itemMeta = item.getItemMeta();
                            itemMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + title);
                            ArrayList<String> itemLore = new ArrayList<>();
                            itemLore.add(ChatColor.GRAY + mission);
                            if (collect == true) {
                                itemLore.add(ChatColor.RED + "Items taken on completion.");
                            }
                            itemMeta.setLore(itemLore);
                            item.setItemMeta(itemMeta);
                            ChallengesGUI.setItem(i - 1 - 72, item);
                        } else {
                            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.GREEN.getData());
                            String title = skyblock.getChallangesConfig().getString(i + ".Title");
                            String mission = skyblock.getChallangesConfig().getString(i + ".Mission");
                            ItemMeta itemMeta = item.getItemMeta();
                            itemMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + title);
                            ArrayList<String> itemLore = new ArrayList<>();
                            itemLore.add(ChatColor.GRAY + mission);
                            itemLore.add(ChatColor.RED + "You have already completed this challenge.");
                            itemMeta.setLore(itemLore);
                            item.setItemMeta(itemMeta);
                            ChallengesGUI.setItem(i - 1 - 72, item);
                        }
                    }
                    ItemStack back = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.RED.getData());
                    ItemMeta backMeta = back.getItemMeta();
                    backMeta.setDisplayName(ChatColor.RED + "Back");
                    ItemStack forward = new ItemStack(Material.ARROW);
                    ItemMeta forwardMeta = forward.getItemMeta();
                    forwardMeta.setDisplayName(ChatColor.GREEN + "Next Page");
                    back.setItemMeta(backMeta);
                    forward.setItemMeta(forwardMeta);
                    ChallengesGUI.setItem(48, back);
                    ChallengesGUI.setItem(50, forward);
                    ChallengesGUI.openGUIFor(p);
                }
            }

        }
        return true;
    }
}
