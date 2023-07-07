package dev.ebo2022.areas_undefined.forge;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

public class PlatformHelperImpl {
    public static Block getModBlock(String path) {
        return ForgeRegistries.BLOCKS.getValue(new ResourceLocation("regions_unexplored", path));
    }
}
