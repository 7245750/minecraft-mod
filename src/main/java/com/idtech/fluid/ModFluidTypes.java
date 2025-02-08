package com.idtech.fluid;

import com.idtech.BaseMod;
import com.mojang.math.Vector3f;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.SoundAction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
//import net.minecraftforge.fluids.FluidType;

public class ModFluidTypes {
    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("block/water_overlay");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
        DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, BaseMod.MODID);

    public static final RegistryObject<FluidType> VOID_WATER_FLUID_TYPE = register("void_water_fluid",
            FluidType.Properties.create().lightLevel(2).density(15).viscosity(5).sound(SoundAction.get("drink"), SoundEvents.HONEY_DRINK));

    private static RegistryObject<FluidType> register(String name, FluidType.Properties props){
        return FLUID_TYPES.register(name, () -> new BaseFluidType(WATER_STILL_RL,WATER_FLOWING_RL,WATER_OVERLAY_RL,
                0xFF000000, new Vector3f(0f/255f,0f/255f,0/255f), props));
    }
    public static void register(IEventBus eventBus){
        FLUID_TYPES.register(eventBus);
    }
}
