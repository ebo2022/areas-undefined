package dev.ebo2022.areas_undefined;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.level.block.Block;

public class PlatformHelper {

    @ExpectPlatform
    public static Block getModBlock(String path) {
        throw new AssertionError();
    }
}
