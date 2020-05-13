package me.isaaceichelberger.skyblock;

import me.isaaceichelberger.skyblock.Commands.*;
import me.isaaceichelberger.skyblock.Listeners.*;
import me.isaaceichelberger.skyblock.World.SkyblockBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.util.ArrayList;


public final class Skyblock extends JavaPlugin {

    private File islandDataFile = new File(getDataFolder(), "islandData.yml");
    private FileConfiguration islandDataConfig = YamlConfiguration.loadConfiguration(islandDataFile);
    private File coopDataFile = new File(getDataFolder(), "coopData.yml");
    private FileConfiguration coopDataConfig = YamlConfiguration.loadConfiguration(coopDataFile);
    private File statsDataFile = new File(getDataFolder(), "statsData.yml");
    private FileConfiguration statsDataConfig = YamlConfiguration.loadConfiguration(statsDataFile);
    private File challengesFile = new File(getDataFolder(), "Challenges.yml");
    private FileConfiguration challengesConfig = YamlConfiguration.loadConfiguration(challengesFile);

    @Override
    public void onEnable() {
        getCommand("tpworld").setExecutor(new CommandTpWorld()); //testing command
        getCommand("island").setExecutor(new CommandIsland(this));
        getCommand("visit").setExecutor(new CommandVisit(this));
        getCommand("balance").setExecutor(new CommandBalance(this));
        getCommand("pay").setExecutor(new CommandPay(this));
        getCommand("challenges").setExecutor(new CommandChallenges(this));
        getCommand("trade").setExecutor(new CommandTrade(this));
        getCommand("shop").setExecutor(new CommandShop(this));
        registerListeners();
        getRecipes();
        if (!islandDataFile.exists()){
            saveResource("islandData.yml", false);
        }
        if (!coopDataFile.exists()){
            saveResource("coopData.yml", false);
        }
        if (!statsDataFile.exists()){
            saveResource("statsData.yml", false);
        }
        if (!challengesFile.exists()){
            saveResource("Challenges.yml", false);
        }
    }

    @Override
    public void onDisable() {
        try {
            this.getIslandDataConfig().save(this.getIslandDataFile());
            this.getCoopDataConfig().save(this.getCoopDataFile());
            this.getStatsDataConfig().save(this.getStatsDataFile());
            this.getChallangesConfig().save(this.getChallengesFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void registerListeners(){
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PlayerJoin(this), this);
        pm.registerEvents(new PlayerQuit(this), this);
        pm.registerEvents(new PlayerRespawn(this), this);
        pm.registerEvents(new BlockBreak(this), this);
        pm.registerEvents(new BlockPlace(this), this);
        pm.registerEvents(new InventoryOpen(this), this);
        pm.registerEvents(new BlockForm(this), this);
        pm.registerEvents(new OnChat(this), this);
        pm.registerEvents(new OnInventoryClick(this), this);
        pm.registerEvents(new EntityDeath(this), this);
        pm.registerEvents(new PortalEnter(this), this);
        pm.registerEvents(new MobSpawn(this), this);
    }

    private void getRecipes()
    {
        // Iron Ore Recipe for Iron Gen
        ItemStack iron = new ItemStack(Material.IRON_ORE);
        ItemMeta ironMeta = iron.getItemMeta();
        ArrayList<String> ironLore = new ArrayList<>();
        ironLore.add(ChatColor.GRAY + "Place this under where cobbblestone would generate");
        ironLore.add(ChatColor.GRAY + "to generate iron ore");
        ironMeta.setDisplayName(ChatColor.GRAY + "IRON GEN");
        ironMeta.setLore(ironLore);
        iron.setItemMeta(ironMeta);
        ShapedRecipe iron_ore_block = new ShapedRecipe(iron);
        iron_ore_block.shape("CCC", "CCC", "CCC");
        iron_ore_block.setIngredient('C', Material.COBBLESTONE);
        getServer().addRecipe(iron_ore_block);

        // Gold Ore Recipe for Gold Gen
        ItemStack gold = new ItemStack(Material.GOLD_ORE);
        ItemMeta goldMeta = gold.getItemMeta();
        ArrayList<String> goldLore = new ArrayList<>();
        goldLore.add(ChatColor.GRAY + "Place this under where cobbblestone would generate");
        goldLore.add(ChatColor.GRAY + "to generate gold ore");
        goldMeta.setDisplayName(ChatColor.GOLD + "GOLD GEN");
        goldMeta.setLore(goldLore);
        gold.setItemMeta(goldMeta);
        ShapedRecipe gold_ore_block = new ShapedRecipe(gold);
        gold_ore_block.shape("III", "III", "III");
        gold_ore_block.setIngredient('I', Material.IRON_ORE);
        getServer().addRecipe(gold_ore_block);

        // Lapis Ore Recipe for Lapis Gen
        ItemStack lapis = new ItemStack(Material.LAPIS_ORE);
        ItemMeta lapisMeta = lapis.getItemMeta();
        ArrayList<String> lapisLore = new ArrayList<>();
        lapisLore.add(ChatColor.GRAY + "Place this under where cobbblestone would generate");
        lapisLore.add(ChatColor.GRAY + "to generate lapis ore");
        lapisMeta.setDisplayName(ChatColor.BLUE + "LAPIS GEN");
        lapisMeta.setLore(lapisLore);
        lapis.setItemMeta(lapisMeta);
        ShapedRecipe lapis_ore_block = new ShapedRecipe(lapis);
        lapis_ore_block.shape("III", "III", "III");
        lapis_ore_block.setIngredient('I', Material.GOLD_ORE);
        getServer().addRecipe(lapis_ore_block);

        // Redstone Ore Recipe for Redstone Gen
        ItemStack redstone = new ItemStack(Material.REDSTONE_ORE);
        ItemMeta redstoneMeta = redstone.getItemMeta();
        ArrayList<String> redstoneLore = new ArrayList<>();
        redstoneLore.add(ChatColor.GRAY + "Place this under where cobbblestone would generate");
        redstoneLore.add(ChatColor.GRAY + "to generate redstone ore");
        redstoneMeta.setDisplayName(ChatColor.RED + "REDSTONE GEN");
        redstoneMeta.setLore(redstoneLore);
        redstone.setItemMeta(redstoneMeta);
        ShapedRecipe redstone_ore_block = new ShapedRecipe(redstone);
        redstone_ore_block.shape("III", "III", "III");
        redstone_ore_block.setIngredient('I', Material.LAPIS_BLOCK);
        getServer().addRecipe(redstone_ore_block);

        // Diamond Ore Recipe for diamond Gen
        ItemStack diamond = new ItemStack(Material.DIAMOND_ORE);
        ItemMeta diamondMeta = diamond.getItemMeta();
        ArrayList<String> diamondLore = new ArrayList<>();
        diamondLore.add(ChatColor.GRAY + "Place this under where cobbblestone would generate");
        diamondLore.add(ChatColor.GRAY + "to generate diamond ore");
        diamondMeta.setDisplayName(ChatColor.AQUA + "DIAMOND GEN");
        diamondMeta.setLore(diamondLore);
        diamond.setItemMeta(diamondMeta);
        ShapedRecipe diamond_ore_block = new ShapedRecipe(diamond);
        diamond_ore_block.shape("III", "III", "III");
        diamond_ore_block.setIngredient('I', Material.REDSTONE_BLOCK);
        getServer().addRecipe(diamond_ore_block);

        // Gravel Recipe from dirt
        ItemStack gravel = new ItemStack(Material.GRAVEL, 4);
        ShapelessRecipe gravelRecipe = new ShapelessRecipe(gravel);
        gravelRecipe.addIngredient(Material.DIRT);
        gravelRecipe.addIngredient(Material.DIRT);
        gravelRecipe.addIngredient(Material.DIRT);
        gravelRecipe.addIngredient(Material.DIRT);
        getServer().addRecipe(gravelRecipe);

        // Sand Recipe from gravel
        ItemStack sand = new ItemStack(Material.SAND, 4);
        ShapelessRecipe sandRecipe = new ShapelessRecipe(sand);
        sandRecipe.addIngredient(Material.GRAVEL);
        sandRecipe.addIngredient(Material.GRAVEL);
        sandRecipe.addIngredient(Material.GRAVEL);
        sandRecipe.addIngredient(Material.GRAVEL);
        getServer().addRecipe(sandRecipe);

        // Dirt Recipe from Saplings
        ItemStack dirt2 = new ItemStack(Material.DIRT);
        ShapelessRecipe dirtRecipe2 = new ShapelessRecipe(dirt2);
        dirtRecipe2.addIngredient(Material.SAPLING);
        dirtRecipe2.addIngredient(Material.SAPLING);
        dirtRecipe2.addIngredient(Material.SAPLING);
        dirtRecipe2.addIngredient(Material.SAPLING);
        getServer().addRecipe(dirtRecipe2);

        // Dirt Recipe from seeds
        ItemStack dirt3 = new ItemStack(Material.DIRT);
        ShapelessRecipe dirtRecipe3 = new ShapelessRecipe(dirt3);
        dirtRecipe3.addIngredient(Material.SEEDS);
        dirtRecipe3.addIngredient(Material.SEEDS);
        dirtRecipe3.addIngredient(Material.SEEDS);
        dirtRecipe3.addIngredient(Material.SEEDS);
        getServer().addRecipe(dirtRecipe3);

        ItemStack dirt4 = new ItemStack(Material.DIRT);
        ShapelessRecipe dirtRecipe4 = new ShapelessRecipe(dirt4);
        dirtRecipe4.addIngredient(Material.WHEAT);
        dirtRecipe4.addIngredient(Material.WHEAT);
        dirtRecipe4.addIngredient(Material.WHEAT);
        dirtRecipe4.addIngredient(Material.WHEAT);
        getServer().addRecipe(dirtRecipe4);

        ItemStack dirt1 = new ItemStack(Material.DIRT);
        ShapelessRecipe dirtRecipe1 = new ShapelessRecipe(dirt1);
        dirtRecipe1.addIngredient(Material.CARROT);
        dirtRecipe1.addIngredient(Material.CARROT);
        dirtRecipe1.addIngredient(Material.CARROT);
        dirtRecipe1.addIngredient(Material.CARROT);
        getServer().addRecipe(dirtRecipe1);

        ItemStack dirt5 = new ItemStack(Material.DIRT);
        ShapelessRecipe dirtRecipe5 = new ShapelessRecipe(dirt5);
        dirtRecipe5.addIngredient(Material.POTATO);
        dirtRecipe5.addIngredient(Material.POTATO);
        dirtRecipe5.addIngredient(Material.POTATO);
        dirtRecipe5.addIngredient(Material.POTATO);
        getServer().addRecipe(dirtRecipe5);

        // Spawner Recipe
        ItemStack spawner = new ItemStack(Material.MOB_SPAWNER);
        ShapedRecipe spawnerRecipe = new ShapedRecipe(spawner);
        spawnerRecipe.shape("III", "I I", "III");
        spawnerRecipe.setIngredient('I', Material.IRON_FENCE);
        getServer().addRecipe(spawnerRecipe);

        // Lava bucket Recipe
        ItemStack lavaBucket = new ItemStack(Material.LAVA_BUCKET);
        ShapedRecipe lavaRecipe = new ShapedRecipe(lavaBucket);
        lavaRecipe.shape("CCC", "CBC", "CCC");
        lavaRecipe.setIngredient('C', Material.COAL);
        lavaRecipe.setIngredient('B', Material.BUCKET);
        getServer().addRecipe(lavaRecipe);

    }

    @Override
    public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
        return new SkyblockBuilder();
    }


    public FileConfiguration getIslandDataConfig(){
        return islandDataConfig;
    }

    public File getIslandDataFile(){
        return islandDataFile;
    }

    public FileConfiguration getCoopDataConfig(){
        return coopDataConfig;
    }

    public File getCoopDataFile(){
        return coopDataFile;
    }

    public FileConfiguration getStatsDataConfig(){
        return statsDataConfig;
    }

    public File getStatsDataFile(){
        return statsDataFile;
    }

    public FileConfiguration getChallangesConfig(){
        return challengesConfig;
    }

    public File getChallengesFile(){
        return challengesFile;
    }

}
