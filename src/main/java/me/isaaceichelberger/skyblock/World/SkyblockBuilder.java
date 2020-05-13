package me.isaaceichelberger.skyblock.World;

import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.block.*;

import java.util.Random;

public class SkyblockBuilder extends ChunkGenerator {
    @Override
    public ChunkData generateChunkData(World world, Random random, int chunkX, int chunkZ, BiomeGrid biome) {
        ChunkData chunk = createChunkData(world);
        return chunk;
    }
}
