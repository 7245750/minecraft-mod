package com.idtech.fluid;

import net.minecraft.world.level.material.FlowingFluid;

import java.util.function.Supplier;

public class VoidWater extends VoidWaterBlock {


    public VoidWater(Supplier<? extends FlowingFluid> p_54694_, Properties p_54695_) {
        super(p_54694_, p_54695_);
    }
//    public static final RegistryObject<FlowingFluid> VOID_WATER_FLUID
//            = FLUIDS.register("void_water_fluid",
//            () -> new ForgeFlowingFluid.Source(ModFluids.VOID_WATER_PROPERTIES));
//
//    public static final RegistryObject<FlowingFluid> VOID_WATER_FLOWING
//            = FLUIDS.register("void_water_flowing",
//            () -> new ForgeFlowingFluid.Flowing(ModFluids.VOID_WATER_PROPERTIES));
//
//    public static final ForgeFlowingFluid.Properties VOID_WATER_PROPERTIES = new ForgeFlowingFluid.Properties(
//            () -> VOID_WATER_FLUID.get(), () -> VOID_WATER_FLOWING.get(), FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL)
//            .density(15).luminosity(5).viscosity(5).sound(SoundEvents.ELDER_GUARDIAN_CURSE).overlay(WATER_OVERLAY_RL)
//            .color(0x000000FF)).slopeFindDistance(2).levelDecreasePerBlock(3)
//            .block(() -> ModFluids.VOID_WATER_BLOCK).bucket(() -> ItemMod.VOID_WATER_BUCKET);
   /* public ModFluidRenderProperties createRenderProperties(){
        return new VoidFluidRenderer(
                new ResourceLocation("void_water_fluid"),
                new ResourceLocation("void_water_flowing"),
                -1,
                new ResourceLocation("void_water_flowing"),
                new ResourceLocation("void_water_flowing"),
                new Vec3(133,0,0)
        );
    }
    @Override
    public Fluid getFlowing() {
        return null;
    }

    @Override
    public Fluid getSource() {
        return null;
    }

    @Override
    protected boolean canConvertToSource() {
        return false;
    }

    @Override
    protected void beforeDestroyingBlock(LevelAccessor p_76002_, BlockPos p_76003_, BlockState p_76004_) {

    }

    @Override
    protected int getSlopeFindDistance(LevelReader p_76074_) {
        return 0;
    }

    @Override
    protected int getDropOff(LevelReader p_76087_) {
        return 0;
    }

    @Override
    public Item getBucket() {
        return null;
    }

    @Override
    protected boolean canBeReplacedWith(FluidState p_76127_, BlockGetter p_76128_, BlockPos p_76129_, Fluid p_76130_, Direction p_76131_) {
        return false;
    }

    @Override
    public int getTickDelay(LevelReader p_76120_) {
        return 0;
    }

    @Override
    protected float getExplosionResistance() {
        return 0;
    }

    @Override
    protected BlockState createLegacyBlock(FluidState p_76136_) {
        return null;
    }

    @Override
    public boolean isSource(FluidState p_76140_) {
        return false;
    }

    @Override
    public int getAmount(FluidState p_164509_) {
        return 0;
    }

*/
}
