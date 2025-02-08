package com.idtech.fluid;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;

public class VoidFluidRenderer extends ModFluidRenderProperties {
    private final ResourceLocation overlay;
    private final ResourceLocation renderOverlay;
    private final Vec3 fogColor;

    public VoidFluidRenderer(ResourceLocation still,ResourceLocation flowing,int tint,
                             ResourceLocation overlay, ResourceLocation renderOverlay,Vec3 fogColor){
        super(still,flowing,tint);
        this.overlay = overlay;
        this.renderOverlay = renderOverlay;
        this.fogColor =fogColor;

    }

    public ResourceLocation getOverlayTexture() {
        return overlay;
    }
    public ResourceLocation getOverlayTexture(FluidState state, BlockAndTintGetter getter, BlockPos pos) {
        return this.getOverlayTexture();

    }

    public ResourceLocation getRenderOverlayTexture() {
        return renderOverlay;
    }

    public ResourceLocation getRenderOverlayTexture(FluidState state, BlockAndTintGetter getter, BlockPos pos) {
        return this.getRenderOverlayTexture();

    }

    public Vec3 modifyFogColor() {
        return fogColor;
    }
    public Vec3 modifyFogColor(FluidState state, BlockAndTintGetter getter, BlockPos pos) {
        return this.modifyFogColor();

    }
}
