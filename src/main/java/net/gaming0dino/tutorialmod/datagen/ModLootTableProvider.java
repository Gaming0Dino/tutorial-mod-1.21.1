package net.gaming0dino.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.gaming0dino.tutorialmod.block.ModBlocks;
import net.gaming0dino.tutorialmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider(FabricDataOutput dataOutput,
                                CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {

        addDrop(ModBlocks.PINK_GARNET_BLOCK);
        addDrop(ModBlocks.RAW_PINK_GARNET_BLOCK);
        addDrop(ModBlocks.CHAIR);

        // Normal ore (vanilla-style)
        addDrop(ModBlocks.PINK_GARNET_ORE,
                oreDrops(ModBlocks.PINK_GARNET_ORE, ModItems.RAW_PINK_GARNET));

        // Custom min-max drops
        addDrop(ModBlocks.PINK_GARNET_DEEPSLATE_ORE,
                multipleOreDrops(ModBlocks.PINK_GARNET_DEEPSLATE_ORE,
                        ModItems.RAW_PINK_GARNET, 2, 5));
    }

    public LootTable.Builder multipleOreDrops(Block block, Item drop, float min, float max) {
        var enchants = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);

        return dropsWithSilkTouch(
                block,
                applyExplosionDecay(block,
                        ItemEntry.builder(drop)
                                .apply(SetCountLootFunction.builder(
                                        UniformLootNumberProvider.create(min, max)))
                                .apply(ApplyBonusLootFunction.oreDrops(
                                        enchants.getOrThrow(Enchantments.FORTUNE)
                                ))
                )
        );
    }
}
