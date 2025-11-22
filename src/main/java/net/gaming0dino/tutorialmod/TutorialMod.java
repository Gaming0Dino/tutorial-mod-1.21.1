package net.gaming0dino.tutorialmod;

import net.fabricmc.api.ModInitializer;

import net.gaming0dino.tutorialmod.block.ModBlocks;
import net.gaming0dino.tutorialmod.item.ModItemGroups;
import net.gaming0dino.tutorialmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorial-mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        LOGGER.info("Loading Tutorial Mod...");

        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModItemGroups.registerItemGroups();
	}
}