package dev.ebo2022.areas_undefined.fabric;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class PlatformHelperImpl {
    public static Block getModBlock(String path) {
        return BuiltInRegistries.BLOCK.get(new ResourceLocation("regions_unexplored", path));
    }
}
