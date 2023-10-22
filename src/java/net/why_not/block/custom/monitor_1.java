package net.why_not.block.custom;

import net.minecraft.block.*;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.*;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class monitor_1 extends Block {
    public static final BooleanProperty CLICKED = BooleanProperty.of("clicked");
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public monitor_1(Settings settings) {
        super(settings);
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.createCuboidShape(6.25, 0, 7.25, 9.75, 0.25, 9),
            Block.createCuboidShape(7, 0.25, 8.25, 9, 2.25, 8.75),
            Block.createCuboidShape(0, 2.25, 8.25, 16, 11.25, 9),
            Block.createCuboidShape(0, 2.25, 8, 0.25, 11.25, 8.25),
            Block.createCuboidShape(15.75, 2.25, 8, 16, 11.25, 8.25),
            Block.createCuboidShape(0.25, 2.25, 8, 15.75, 2.5, 8.25),
            Block.createCuboidShape(0.25, 11, 8, 15.75, 11.25, 8.25)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.createCuboidShape(7.25, 0, 6.25, 9, 0.25, 9.75),
            Block.createCuboidShape(8.25, 0.25, 7, 8.75, 2.25, 9),
            Block.createCuboidShape(8.25, 2.25, 0, 9, 11.25, 16),
            Block.createCuboidShape(8, 2.25, 15.75, 8.25, 11.25, 16),
            Block.createCuboidShape(8, 2.25, 0, 8.25, 11.25, 0.25),
            Block.createCuboidShape(8, 2.25, 0.25, 8.25, 2.5, 15.75),
            Block.createCuboidShape(8, 11, 0.25, 8.25, 11.25, 15.75)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.createCuboidShape(6.25, 0, 7, 9.75, 0.25, 8.75),
            Block.createCuboidShape(7, 0.25, 7.25, 9, 2.25, 7.75),
            Block.createCuboidShape(0, 2.25, 7, 16, 11.25, 7.75),
            Block.createCuboidShape(15.75, 2.25, 7.75, 16, 11.25, 8),
            Block.createCuboidShape(0, 2.25, 7.75, 0.25, 11.25, 8),
            Block.createCuboidShape(0.25, 2.25, 7.75, 15.75, 2.5, 8),
            Block.createCuboidShape(0.25, 11, 7.75, 15.75, 11.25, 8)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.createCuboidShape(7, 0, 6.25, 8.75, 0.25, 9.75),
            Block.createCuboidShape(7.25, 0.25, 7, 7.75, 2.25, 9),
            Block.createCuboidShape(7, 2.25, 0, 7.75, 11.25, 16),
            Block.createCuboidShape(7.75, 2.25, 0, 8, 11.25, 0.25),
            Block.createCuboidShape(7.75, 2.25, 15.75, 8, 11.25, 16),
            Block.createCuboidShape(7.75, 2.25, 0.25, 8, 2.5, 15.75),
            Block.createCuboidShape(7.75, 11, 0.25, 8, 11.25, 15.75)
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
