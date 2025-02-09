package com.idtech.item;

import com.idtech.BaseMod;
import com.idtech.fluid.ModFluids;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber
public class ItemMod {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BaseMod.MODID);
    //BASIC ITEMS
//    public static final Item STRUCTURE_GEL = ItemUtils.buildBasicItem("structuregel", CreativeModeTab.TAB_MISC);
//    public static final RegistryObject<Item> STRUCTURE_GEL_ITEM = ITEMS.register("structuregel",
//            () -> STRUCTURE_GEL);
//public static final Item CHAOS_GEM = ItemUtils.buildBasicItem("chaosgem",CreativeModeTab.TAB_MISC);
//    public static final RegistryObject<Item> CHAOS_GEM_ITEM = ITEMS.register("chaosgem",
//            () -> CHAOS_GEM);
//    public static final Item VOID_WATER_BUCKET= new BucketItem(ModsFluids.VOID_WATER_FLUID,
//            new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(1)).setRegistryName("void_water_bucket.json");
    public static final RegistryObject<Item> VOID_WATER_BUCKET = ITEMS.register("void_water_bucket",
        () -> new BucketItem(ModFluids.VOID_WATER,
                new Item.Properties().tab(CreativeModeTab.TAB_MISC).craftRemainder(Items.BUCKET).stacksTo(1)));
    //FOODS


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
