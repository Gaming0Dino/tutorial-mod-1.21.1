package net.gaming0dino.tutorialmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.gaming0dino.tutorialmod.entity.ModEntities;
import net.gaming0dino.tutorialmod.entity.client.ChairRenderer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class TutorialModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.DYNAMITE_ENTITY_TYPE, FlyingItemEntityRenderer::new);

        EntityRendererRegistry.register(ModEntities.CHAIR, ChairRenderer::new);
    }
}
