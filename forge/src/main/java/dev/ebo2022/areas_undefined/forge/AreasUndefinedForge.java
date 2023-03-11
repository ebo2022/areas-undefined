package dev.ebo2022.areas_undefined.forge;

import dev.ebo2022.areas_undefined.AUDSurfaceRuleData;
import dev.ebo2022.areas_undefined.decorators.BirchPlacer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import terrablender.api.SurfaceRuleManager;

@Mod("areas_undefined")
public class AreasUndefinedForge {


    public AreasUndefinedForge() {
        ForgeRegistries.TREE_DECORATOR_TYPES.register("birch_placer", BirchPlacer.tdt);
        FMLJavaModLoadingContext.get().getModEventBus().<FMLCommonSetupEvent>addListener(this::onCommonSetup);
    }

    public void onCommonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> SurfaceRuleManager.addToDefaultSurfaceRulesAtStage(SurfaceRuleManager.RuleCategory.OVERWORLD, SurfaceRuleManager.RuleStage.AFTER_BEDROCK, 1001, AUDSurfaceRuleData.makeRules()));
    }
}
