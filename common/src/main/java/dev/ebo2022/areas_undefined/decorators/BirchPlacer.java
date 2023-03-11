package dev.ebo2022.areas_undefined.decorators;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;

public class BirchPlacer extends TrunkVineDecorator {
	public static final BirchPlacer INSTANCE = new BirchPlacer();
	public static com.mojang.serialization.Codec<BirchPlacer> codec;
	public static TreeDecoratorType<?> tdt;

	static {
		codec = com.mojang.serialization.Codec.unit(() -> INSTANCE);
		tdt = new TreeDecoratorType<>(codec);
	}

	@Override
	protected TreeDecoratorType<?> type() {
		return tdt;
	}

	@Override
	public void place(TreeDecorator.Context context) {
		BlockPos newpos = context.logs().get(context.logs().size()-1);
		BlockPos px1 = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ());
		context.setBlock(px1, Blocks.BIRCH_LEAVES.defaultBlockState());
	}
}