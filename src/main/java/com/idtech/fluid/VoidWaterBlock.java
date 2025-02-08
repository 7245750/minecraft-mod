package com.idtech.fluid;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;

import java.util.function.Supplier;

public class VoidWaterBlock extends LiquidBlock {


    public VoidWaterBlock(Supplier<? extends FlowingFluid> p_54694_, Properties p_54695_) {
        super(p_54694_, p_54695_);
    }

    public boolean isRandomlyTicking(BlockState state){
        return state.getFluidState().isRandomlyTicking();
    }

    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random){
        state.getFluidState().randomTick(level,pos,random);
    }

    public void entityInside(BlockState state, Level level, BlockPos pos,Entity entity){
        if(!level.isClientSide()){
            if(entity instanceof LivingEntity){
                LivingEntity e = (LivingEntity) entity;
                e.addEffect(new MobEffectInstance(MobEffects.WITHER,80,2));
                e.addEffect(new MobEffectInstance(MobEffects.BLINDNESS,80,2));

            }
        }
    }
}
