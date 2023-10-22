package net.why_not.util;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.why_not.ExampleMod;
import net.why_not.item.whyitem;

public class ModRegistries {
    public static void  registerModStuffs(){
        registerFuels();
    }


    private static void registerFuels() {
        ExampleMod.LOGGER.info("Registering Fuels for " + ExampleMod.MOD_ID);
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(whyitem.OIL_INGOT, 600);
    }
}
