package net.why_not.block.custom;


import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.why_not.block.FallingBlockCustom;

public class compressed_sand extends FallingBlockCustom {
    private final int color;

    public compressed_sand(int color, AbstractBlock.Settings settings) {
        super(settings);
        this.color = color;
    }

    @Override
    public int getColor(BlockState state, BlockView world, BlockPos pos) {
        return this.color;
    }
}
