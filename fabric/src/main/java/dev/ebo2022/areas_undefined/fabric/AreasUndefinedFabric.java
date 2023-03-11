package dev.ebo2022.areas_undefined.fabric;

import dev.ebo2022.areas_undefined.AUDSurfaceRuleData;
import dev.ebo2022.areas_undefined.decorators.BirchPlacer;
import io.github.uhq_games.regions_unexplored.data.worldgen.noise.RuNoises;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class AreasUndefinedFabric implements ModInitializer, TerraBlenderApi {

    @Override
    public void onInitialize() {
        Registry.register(BuiltInRegistries.TREE_DECORATOR_TYPE, new ResourceLocation("areas_undefined", "birch_placer"), BirchPlacer.tdt);
    }

    @Override
    public void onTerraBlenderInitialized() {
        SurfaceRuleManager.addToDefaultSurfaceRulesAtStage(SurfaceRuleManager.RuleCategory.OVERWORLD, SurfaceRuleManager.RuleStage.AFTER_BEDROCK, 1001, AUDSurfaceRuleData.makeRules());
    }
}
