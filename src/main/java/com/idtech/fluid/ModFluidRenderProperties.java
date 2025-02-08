package com.idtech.fluid;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.math.Vector3f;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.material.FluidState;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class ModFluidRenderProperties {
    private final ResourceLocation flowing;
    private final ResourceLocation still;
    private final int tint;

    public ModFluidRenderProperties(ResourceLocation still,ResourceLocation flowing,int tint){
        this.flowing =flowing;
        this.still = still;
        this.tint = tint;
    }
    public int getTintColor() {
        return this.tint;
    }

    public @NotNull ResourceLocation getStillTexture() {
        return this.still;
    }

    public @NotNull ResourceLocation getFlowingTexture() {
        return this.flowing;
    }

    public @Nullable ResourceLocation getOverlayTexture() {
        return null;
    }
    public void modifyFogRender(Camera camera, FogRenderer.FogMode mode, float renderDistance, float partialTick, float nearDistance, float farDistance, FogShape shape) {
    }

    public @NotNull Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
        return fluidFogColor;
    }

    public @Nullable ResourceLocation getRenderOverlayTexture(Minecraft mc) {
        return null;
    }

    public ResourceLocation getStillTexture(FluidState state, BlockAndTintGetter getter, BlockPos pos) {
        return this.getStillTexture();
    }

    public ResourceLocation getFlowingTexture(FluidState state, BlockAndTintGetter getter, BlockPos pos) {
        return this.getFlowingTexture();
    }

    public ResourceLocation getOverlayTexture(FluidState state, BlockAndTintGetter getter, BlockPos pos) {
        return this.getOverlayTexture();
    }

    public int getTintColor(FluidState state, BlockAndTintGetter getter, BlockPos pos) {
        return this.getTintColor();
    }
}

