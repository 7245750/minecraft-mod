package com.idtech.fluid;

import com.idtech.BaseMod;
import com.idtech.block.BlockMod;
import com.idtech.item.ItemMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {

    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS,BaseMod.MODID);

    public static final RegistryObject<FlowingFluid> FLOWING_VOID_WATER = FLUIDS.register("flowing_void_water",
            () -> new VoidWaterFluid.Flowing(
                    ModFlowingFluid.properties()
                            .supportsBoating(true)
                            .lightLevel(0)
                            .copyFluid(Fluids.FLOWING_WATER),
                    BlockMod.VOID_WATER
            ));

    public static final RegistryObject<FlowingFluid> VOID_WATER = FLUIDS.register("void_water",
            () -> new VoidWaterFluid.Source(
                    ModFlowingFluid.properties()
                            .supportsBoating(true)
                            .lightLevel(0)
                            .copyFluid(Fluids.FLOWING_WATER),
                    BlockMod.VOID_WATER
            ));

    public static void register(IEventBus eventBus){
        FLUIDS.register(eventBus);
    }
}
