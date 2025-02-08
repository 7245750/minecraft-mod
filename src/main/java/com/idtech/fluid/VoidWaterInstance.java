package com.idtech.fluid;

import com.idtech.item.ItemMod;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class VoidWaterInstance extends VoidWaterFluid{
    public VoidWaterInstance(Properties props, Supplier<? extends LiquidBlock> block) {
        super(props, block);
    }

    @Override
    public ModFluidRenderProperties createRenderProperties() {
        return new VoidFluidRenderer(
                res("block/void_water"),
                res("block/void_water_flowing"),
                -1,
                res("block/void_water_flowing"),
                res("block/void_water_flowing"),
                new Vec3(20,20,20)
        );
    }

    @NotNull
    public Fluid getFlowing(){
        return ModFluids.FLOWING_VOID_WATER.get();
    }

    @NotNull
    public Fluid getSource(){
        return ModFluids.VOID_WATER.get();
    }

    @NotNull
    public Item getBucket(){
        return ItemMod.VOID_WATER_BUCKET.get();
    }

    public static class Flowing extends VoidWaterInstance {

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

    public static class Source extends VoidWaterInstance {

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
