package net.why_not;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.why_not.block.whyblock;

public class ExampleClientMod implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(whyblock.PC_CASE_NORMAL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(whyblock.MONITOR_1, RenderLayer.getCutout());


    }

}
