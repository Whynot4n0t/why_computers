package net.why_not.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.why_not.ExampleMod;

public class whyitem {

    public static final Item OIL_INGOT = registerItem("oil_ingot",
    new Item(new FabricItemSettings().group(ModItemGroup.WHY_NOT)));
    public static final Item MOTHER_BOARD = registerItem("mother_board",
            new Item(new FabricItemSettings().group(ModItemGroup.WHY_NOT)));
    public static final Item MOTHER_BOARD1 = registerItem("mother_board_1",
            new Item(new FabricItemSettings().group(ModItemGroup.WHY_NOT)));
    public static final Item MOTHER_BOARD2 = registerItem("mother_board_2",
            new Item(new FabricItemSettings().group(ModItemGroup.WHY_NOT)));
    public static final Item GLASS_FIBER = registerItem("glass_fiber",
            new Item(new FabricItemSettings().group(ModItemGroup.WHY_NOT)));
    public static final Item PLASTIC = registerItem("plastic",
            new Item(new FabricItemSettings().group(ModItemGroup.WHY_NOT)));
    public static final Item COMPRESSED_GLASS_FIBER = registerItem("compressed_glass_fiber",
            new Item(new FabricItemSettings().group(ModItemGroup.WHY_NOT)));
    public static final Item COMPRESSED_PLASTIC = registerItem("compressed_plastic",
            new Item(new FabricItemSettings().group(ModItemGroup.WHY_NOT)));
    public static final Item PRINTED_CIRCUIT_BOARD = registerItem("pcb",
            new Item(new FabricItemSettings().group(ModItemGroup.WHY_NOT)));
    public static final Item PROCESSOR_DIE = registerItem("processor_die",
            new Item(new FabricItemSettings().group(ModItemGroup.WHY_NOT)));
    public static final Item PROCESSOR_TOP = registerItem("processor_top",
            new Item(new FabricItemSettings().group(ModItemGroup.WHY_NOT)));
    public static final Item PROCESSOR_BOTTOM = registerItem("processor_bottom",
            new Item(new FabricItemSettings().group(ModItemGroup.WHY_NOT)));
    public static final Item PROCESSOR = registerItem("processor",
            new Item(new FabricItemSettings().group(ModItemGroup.WHY_NOT)));
    public static final Item FAN_BLADE = registerItem("fan_blade",
            new Item(new FabricItemSettings().group(ModItemGroup.WHY_NOT)));
    public static final Item PC_SIDE_PANELS = registerItem("pc_side_panels",
            new Item(new FabricItemSettings().group(ModItemGroup.WHY_NOT)));
    public static final Item SILICON = registerItem("silicon",
            new Item(new FabricItemSettings().group(ModItemGroup.WHY_NOT)));
    public static final Item ARM_PROCESSOR = registerItem("arm_processor",
            new Item(new FabricItemSettings().group(ModItemGroup.WHY_NOT)));
    public static final Item GPU_DIE = registerItem("graphic_die",
            new Item(new FabricItemSettings().group(ModItemGroup.WHY_NOT)));
    public static final Item HEATSINK = registerItem("heatsink",
            new Item(new FabricItemSettings().group(ModItemGroup.WHY_NOT)));
    public static final Item TRANZISTOR = registerItem("tranzistor",
            new Item(new FabricItemSettings().group(ModItemGroup.WHY_NOT)));
    public static final Item CAPACITOR = registerItem("capacitor",
            new Item(new FabricItemSettings().group(ModItemGroup.WHY_NOT)));
    public static final Item INDUCTOR = registerItem("inductor",
            new Item(new FabricItemSettings().group(ModItemGroup.WHY_NOT)));
    public static final Item REZISTOR = registerItem("rezistor",
            new Item(new FabricItemSettings().group(ModItemGroup.WHY_NOT)));
    public static final Item FANS = registerItem("fans",
            new Item(new FabricItemSettings().group(ModItemGroup.WHY_NOT)));
    public static final Item DIE = registerItem("die",
            new Item(new FabricItemSettings().group(ModItemGroup.WHY_NOT)));
    public static final Item IRON_ROD = registerItem("iron_rod",
            new Item(new FabricItemSettings().group(ModItemGroup.WHY_NOT)));
    public static final Item COPPER_COIL = registerItem("copper_coil",
            new Item(new FabricItemSettings().group(ModItemGroup.WHY_NOT)));
    public static final Item CPU_SOCKET = registerItem("cpu_socket",
            new Item(new FabricItemSettings().group(ModItemGroup.WHY_NOT)));
    public static final Item FAN_CASING = registerItem("fan_casing",
            new Item(new FabricItemSettings().group(ModItemGroup.WHY_NOT)));


    private static Item registerItem(String name, Item item){
       return Registry.register(Registry.ITEM,new Identifier(ExampleMod.MOD_ID, name), item);
    }
    public static void registerModItem() {
        ExampleMod.LOGGER.info("registernig mod items for why_not_mc_mod");
    }
}
