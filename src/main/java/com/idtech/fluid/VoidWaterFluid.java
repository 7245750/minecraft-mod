package com.idtech.fluid;

import com.idtech.BaseMod;
import com.idtech.item.ItemMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fluids.FluidType;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class VoidWaterFluid extends ModFlowingFluid{

    public VoidWaterFluid(Properties props, Supplier<? extends LiquidBlock> block){
        super(props,block);
    }
    public static ResourceLocation res(String name) {
        return new ResourceLocation(BaseMod.MODID, name);
    }
    @Override
    public Fluid getSource() {
        return ModFluids.VOID_WATER.get();
    }

    @Override
    public Fluid getFlowing() {
        return ModFluids.FLOWING_VOID_WATER.get();
    }

    @Override
    public FluidType getFluidType(){
        return ModFluidTypes.VOID_WATER_FLUID_TYPE.get();
    }

    @Override
    public ModFluidRenderProperties createRenderProperties() {
        return new VoidFluidRenderer(
                res("block/texture"),
                res("block/texture_flowing"),
                -1,
                res("block/texture_flowing"),
                res("block/texture_flowing"),
                new Vec3(20,20,20)
        );
    }

    @Override
    protected boolean canConvertToSource() {
        return true;
    }

    @Override
    protected int getSlopeFindDistance(LevelReader p_76074_) {
        return 2;
    }

    @Override
    protected int getDropOff(LevelReader p_76087_) {
        return 2;
    }

    @Override
    public Item getBucket() {
        return ItemMod.VOID_WATER_BUCKET.get();
    }

    @Override
    public int getTickDelay(LevelReader p_76120_) {
        return 20;
    }

    @Override
    protected float getExplosionResistance() {
        return 100;
    }

    @Override
    public boolean isSource(FluidState p_76140_) {
        return false;
    }

    @Override
    public int getAmount(FluidState p_164509_) {
        return 0;
    }
    public static class Flowing extends VoidWaterFluid {

        public Flowing(Properties props, Supplier<? extends LiquidBlock> block) {
            super(props, block);
        }

        @Override
        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder){
            super.createFluidStateDefinition(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getAmount(@NotNull FluidState state){
            return state.getValue(LEVEL);
        }

        @Override
        public boolean isSource(@NotNull FluidState state){
            return false;
        }
    }

    public static class Source extends VoidWaterFluid {

        public Source(Properties props, Supplier<? extends LiquidBlock> block) {
            super(props, block);
        }



        @Override
        public int getAmount(@NotNull FluidState state){
            return 8;
        }

        @Override
        public boolean isSource(@NotNull FluidState state){
            return true;
        }
    }
}
