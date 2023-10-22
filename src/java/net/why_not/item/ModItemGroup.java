package net.why_not.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.why_not.ExampleMod;

public class ModItemGroup {

    public static final ItemGroup WHY_NOT = FabricItemGroupBuilder.build(new Identifier(ExampleMod.MOD_ID, "why_not"), () -> new ItemStack(whyitem.OIL_INGOT));
    public static final ItemGroup WHY_NOT2 = FabricItemGroupBuilder.build(new Identifier(ExampleMod.MOD_ID, "why_not2"), () -> new ItemStack(whyitem.OIL_INGOT));

}
