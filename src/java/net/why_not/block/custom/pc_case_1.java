package net.why_not.block.custom;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


import java.util.stream.Stream;

public class pc_case_1 extends Block {
    public static final BooleanProperty CLICKED = BooleanProperty.of("clicked");
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public pc_case_1(Settings settings) {
        super(settings);
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.createCuboidShape(5.75, 0.5, 0, 6, 11, 2),
            Block.createCuboidShape(10.5, 0, 0, 11.5, 11.5, 16),
            Block.createCuboidShape(4.5, 0, 0, 5.5, 11.5, 16),
            Block.createCuboidShape(5.5, 0.5, 1.5, 10.5, 11, 1.75),
            Block.createCuboidShape(5.5, 0, 15.5, 10.5, 11, 16),
            Block.createCuboidShape(5.5, 11, 0, 10.5, 11.25, 16),
            Block.createCuboidShape(5.5, 0, 0, 10.5, 0.5, 16),
            Block.createCuboidShape(9.75, 0.5, 0, 10, 11, 2),
            Block.createCuboidShape(8.75, 0.5, 0, 9, 11, 2),
            Block.createCuboidShape(7.75, 0.5, 0, 8, 11, 2),
            Block.createCuboidShape(6.75, 0.5, 0, 7, 11, 2)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.createCuboidShape(0, 0.5, 10, 2, 11, 10.25),
            Block.createCuboidShape(0, 0, 4.5, 16, 11.5, 5.5),
            Block.createCuboidShape(0, 0, 10.5, 16, 11.5, 11.5),
            Block.createCuboidShape(1.5, 0.5, 5.5, 1.75, 11, 10.5),
            Block.createCuboidShape(15.5, 0, 5.5, 16, 11, 10.5),
            Block.createCuboidShape(0, 11, 5.5, 16, 11.25, 10.5),
            Block.createCuboidShape(0, 0, 5.5, 16, 0.5, 10.5),
            Block.createCuboidShape(0, 0.5, 6, 2, 11, 6.25),
            Block.createCuboidShape(0, 0.5, 7, 2, 11, 7.25),
            Block.createCuboidShape(0, 0.5, 8, 2, 11, 8.25),
            Block.createCuboidShape(0, 0.5, 9, 2, 11, 9.25)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.createCuboidShape(10, 0.5, 14, 10.25, 11, 16),
            Block.createCuboidShape(4.5, 0, 0, 5.5, 11.5, 16),
            Block.createCuboidShape(10.5, 0, 0, 11.5, 11.5, 16),
            Block.createCuboidShape(5.5, 0.5, 14.25, 10.5, 11, 14.5),
            Block.createCuboidShape(5.5, 0, 0, 10.5, 11, 0.5),
            Block.createCuboidShape(5.5, 11, 0, 10.5, 11.25, 16),
            Block.createCuboidShape(5.5, 0, 0, 10.5, 0.5, 16),
            Block.createCuboidShape(6, 0.5, 14, 6.25, 11, 16),
            Block.createCuboidShape(7, 0.5, 14, 7.25, 11, 16),
            Block.createCuboidShape(8, 0.5, 14, 8.25, 11, 16),
            Block.createCuboidShape(9, 0.5, 14, 9.25, 11, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.createCuboidShape(14, 0.5, 5.75, 16, 11, 6),
            Block.createCuboidShape(0, 0, 10.5, 16, 11.5, 11.5),
            Block.createCuboidShape(0, 0, 4.5, 16, 11.5, 5.5),
            Block.createCuboidShape(14.25, 0.5, 5.5, 14.5, 11, 10.5),
            Block.createCuboidShape(0, 0, 5.5, 0.5, 11, 10.5),
            Block.createCuboidShape(0, 11, 5.5, 16, 11.25, 10.5),
            Block.createCuboidShape(0, 0, 5.5, 16, 0.5, 10.5),
            Block.createCuboidShape(14, 0.5, 9.75, 16, 11, 10),
            Block.createCuboidShape(14, 0.5, 8.75, 16, 11, 9),
            Block.createCuboidShape(14, 0.5, 7.75, 16, 11, 8),
            Block.createCuboidShape(14, 0.5, 6.75, 16, 11, 7)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch (state.get(FACING)){
            case NORTH:
                return SHAPE_N;
            case WEST:
                return SHAPE_W;
            case SOUTH:
                return SHAPE_S;
            case EAST:
                return SHAPE_E;
            default:
                return SHAPE_N;
        }
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient() && hand == Hand.MAIN_HAND){
            boolean currentState = state.get(CLICKED);
            world.setBlockState(pos, state.with(CLICKED, !currentState), Block.NOTIFY_ALL);
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        builder.add(CLICKED);
    }
}
