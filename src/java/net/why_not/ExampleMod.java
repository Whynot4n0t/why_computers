package net.why_not;

import net.fabricmc.api.ModInitializer;
import net.why_not.block.whyblock;
import net.why_not.item.whyitem;
import net.why_not.painting.whyPainting;
import net.why_not.util.ModRegistries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
	public static final String	MOD_ID = "why_not_mc_mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {


		whyitem.registerModItem();
		whyblock.registerwhyblock();
		whyPainting.registerPaintings();

		ModRegistries.registerModStuffs();
	}
}