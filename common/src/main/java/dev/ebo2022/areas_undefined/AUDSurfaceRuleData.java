package dev.ebo2022.areas_undefined;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

public class AUDSurfaceRuleData {

    private static final SurfaceRules.RuleSource AIR = makeStateRule(Blocks.CAVE_AIR);
    private static final SurfaceRules.RuleSource BEDROCK = makeStateRule(Blocks.BEDROCK);
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource PACKED_ICE = makeStateRule(Blocks.PACKED_ICE);
    private static final SurfaceRules.RuleSource SAND = makeStateRule(Blocks.SAND);
    private static final SurfaceRules.RuleSource STONE = makeStateRule(Blocks.STONE);
    private static final SurfaceRules.RuleSource GRANITE = makeStateRule(Blocks.GRANITE);
    private static final SurfaceRules.RuleSource CALCITE = makeStateRule(Blocks.CALCITE);
    private static final SurfaceRules.RuleSource SANDSTONE = makeStateRule(Blocks.SANDSTONE);
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource PODZOL = makeStateRule(Blocks.PODZOL);
    private static final SurfaceRules.RuleSource COARSE_DIRT = makeStateRule(Blocks.COARSE_DIRT);
    private static final SurfaceRules.RuleSource GRAVEL = makeStateRule(Blocks.GRAVEL);
    private static final SurfaceRules.RuleSource SNOW_BLOCK = makeStateRule(Blocks.SNOW_BLOCK);
    private static final SurfaceRules.RuleSource WATER = makeStateRule(Blocks.WATER);
    private static final SurfaceRules.RuleSource VANILLA_MUD = makeStateRule(Blocks.MUD);
    private static final SurfaceRules.RuleSource ALPHA_DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource TERRACOTTA = makeStateRule(Blocks.TERRACOTTA);
    private static final SurfaceRules.RuleSource RED_SAND = makeStateRule(Blocks.RED_SAND);
    private static final SurfaceRules.RuleSource MYCELIUM = makeStateRule(Blocks.MYCELIUM);
    private static final SurfaceRules.RuleSource COBBLESTONE = makeStateRule(Blocks.COBBLESTONE);
    private static final SurfaceRules.RuleSource POWDER_SNOW = makeStateRule(Blocks.POWDER_SNOW);
    private static final SurfaceRules.RuleSource MOSSY_STONE = modStateRule("mossy_stone");
    private static final ResourceKey<NormalNoise.NoiseParameters> SHIELD_NOISE_KEY = ResourceKey.create(Registries.NOISE, new ResourceLocation("regions_unexplored", "shield"));

    public static SurfaceRules.RuleSource makeRules() {
        SurfaceRules.ConditionSource y62 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(62), 0);
        SurfaceRules.ConditionSource y63 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(63), 0);
        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR), SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(-1, 0), SurfaceRules.sequence(
                        // Swamp surface
                        SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.SWAMP), SurfaceRules.ifTrue(y62, SurfaceRules.ifTrue(SurfaceRules.not(y63), SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D)), VANILLA_MUD)))),
                        // Savanna surface
                        SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU), SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), TERRACOTTA), SurfaceRules.ifTrue(surfaceNoiseAbove(-0.5D), COARSE_DIRT), GRASS_BLOCK)),
                        // Taiga surface
                        SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.TAIGA, Biomes.SNOWY_TAIGA, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_HILLS), SurfaceRules.sequence(SurfaceRules.ifTrue(shieldNoise(1.65D), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.25D), STONE),SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), MOSSY_STONE),STONE)), SurfaceRules.ifTrue(shieldNoise(0.0D), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.25D), GRASS_BLOCK),SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, -0.25D), COARSE_DIRT),MOSSY_STONE))))
                 ))),
                SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), SurfaceRules.sequence(
                    // Savanna subsurface
                    SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.not(surfaceNoiseAbove(1.75D)), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),DIRT)), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 30, CaveSurface.FLOOR),TERRACOTTA))),
                    // Taiga subsurface
                    SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.TAIGA, Biomes.SNOWY_TAIGA, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_HILLS), SurfaceRules.ifTrue(shieldNoise(1.65D), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),STONE)))
            ))
        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }

    private static SurfaceRules.RuleSource modStateRule(String path) {
        return makeStateRule(PlatformHelper.getModBlock(path));
    }

    private static SurfaceRules.ConditionSource surfaceNoiseAbove(double noise) {
        return SurfaceRules.noiseCondition(Noises.SURFACE, noise / 8.25D, Double.MAX_VALUE);
    }

    private static SurfaceRules.ConditionSource shieldNoise(double noise) {
        return SurfaceRules.noiseCondition(SHIELD_NOISE_KEY, noise / 8.25D, Double.MAX_VALUE);
    }
}
