package com.idtech.block;


import com.idtech.BaseMod;
import com.idtech.fluid.ModFluids;
import com.idtech.fluid.VoidWaterBlock;
import com.idtech.item.ItemMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
//import net.minecraftforge.common.ToolType;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@Mod.EventBusSubscriber
public class BlockMod {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, BaseMod.MODID);
    //Basic Block
//    public static final Block CASTLE_WALL = BlockUtils.createBasicBlock("castlewall", Material.STONE);
//    public static final RegistryObject<Block> CASTLE_WALL_BLOCK = registerBlock("castlewall",
//            () -> CASTLE_WALL, CreativeModeTab.TAB_MISC);

    public static final RegistryObject<LiquidBlock> VOID_WATER = registerBlock("void_water", () ->
            new VoidWaterBlock(ModFluids.FLOWING_VOID_WATER, BlockBehaviour.Properties.of(Material.WATER)));

   private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name,toReturn,tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name,toReturn,CreativeModeTab.TAB_MISC);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ItemMod.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }



    public static void register(IEventBus eventBus){
      BLOCKS.register(eventBus);
    }
}





