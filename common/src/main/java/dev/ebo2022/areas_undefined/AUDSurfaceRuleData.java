package dev.ebo2022.areas_undefined;

import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;

public class AUDSurfaceRuleData {

    public static SurfaceRules.RuleSource makeRules() {
        SurfaceRules.ConditionSource y62 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(62), 0);
        SurfaceRules.ConditionSource y63 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(63), 0);
        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.SWAMP),
                        SurfaceRules.ifTrue(y62,
                                SurfaceRules.ifTrue(SurfaceRules.not(y63),
                                        SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D)), SurfaceRules.state(Blocks.MUD.defaultBlockState()))
                        )
                )
        ));
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }

    private static SurfaceRules.ConditionSource surfaceNoiseAbove(double noise) {
        return SurfaceRules.noiseCondition(Noises.SURFACE, noise / 8.25D, Double.MAX_VALUE);
    }
}
