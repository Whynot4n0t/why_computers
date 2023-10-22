package net.why_not.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.why_not.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.why_not.block.custom.glass_fiber_cable;
import net.why_not.block.custom.monitor_1;
import net.why_not.block.custom.pc_case_1;
import net.why_not.item.ModItemGroup;


public class whyblock {
    public static final Block PC_CASE_NORMAL = registerBlock("pc_case_normal"
            ,new pc_case_1(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()
                    .luminance((state) -> state.get(pc_case_1.CLICKED) ? 6 : 0)), ModItemGroup.WHY_NOT2);
    public static final Block MONITOR_1 = registerBlock("monitor_1"
            ,new monitor_1(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), ModItemGroup.WHY_NOT2);
    public static final Block OIL_BLOCK = registerBlock("oil_block"
            ,new Block(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), ModItemGroup.WHY_NOT2);
    public static final Block SILICA_SAND = registerBlock("silica_sand"
            ,new Block(FabricBlockSettings.of(Material.GLASS).strength(2f).requiresTool()), ModItemGroup.WHY_NOT2);

    public static final Block COMPRESSED_SAND = registerBlock("compressed_sand"
            ,new FallingBlockCustom(FabricBlockSettings.of(Material.STONE).strength(6f).requiresTool()), ModItemGroup.WHY_NOT2);
    public static final Block BLOCK_ENTITY = registerBlock("block_entity"
            ,new FallingBlockCustom(FabricBlockSettings.of(Material.STONE).strength(6f).requiresTool()), ModItemGroup.WHY_NOT2);
    public static final Block GLASS_FIBER_CABLE = registerBlock("glass_fiber_cable"
            ,new glass_fiber_cable(FabricBlockSettings.of(Material.REDSTONE_LAMP).strength(1f)), ModItemGroup.WHY_NOT);

    private static Block registerBlock(String name, Block block, ItemGroup group){
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(ExampleMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(ExampleMod.MOD_ID, name), new BlockItem(block, new FabricItemSettings().group(group)));

    }

    public static void registerwhyblock(){
        ExampleMod.LOGGER.info("Registering ModBlocks for " + ExampleMod.MOD_ID);
    }

}
