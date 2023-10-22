package net.why_not.painting;

import net.minecraft.entity.decoration.painting.PaintingMotive;
import net.minecraft.util.Identifier;
import net.why_not.ExampleMod;
import net.minecraft.util.registry.Registry;

public class whyPainting {
    public static final PaintingMotive GRAFFITI_1 = registerPainting("graffiti_1", new PaintingMotive(16, 16));

    private static PaintingMotive registerPainting(String name, PaintingMotive paintingMotive){
        return Registry.register(Registry.PAINTING_MOTIVE, new Identifier(ExampleMod.MOD_ID, name), paintingMotive);
    }

    public static void registerPaintings(){
        ExampleMod.LOGGER.info("Registering for paintings" + ExampleMod.MOD_ID);
    }
}
