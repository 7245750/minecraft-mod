package com.idtech.fluid;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.function.Supplier;

public abstract class ModFlowingFluid extends FlowingFluid {
    private final @Nullable Supplier<? extends LiquidBlock> block;
    private final boolean convertsToSource;

    protected ModFlowingFluid(Properties props,Supplier<? extends LiquidBlock> block){
        this.block=block;
        this.convertsToSource = props.canConvertToSource;
    }
    public static Properties properties() {
        return new Properties();
    }

    protected boolean canConvertToSource(Level level) {
        return this.convertsToSource;
    }
    protected void beforeDestroyingBlock(LevelAccessor worldIn, BlockPos pos, BlockState state) {
        BlockEntity blockEntity = state.hasBlockEntity() ? worldIn.getBlockEntity(pos) : null;
        Block.dropResources(state, worldIn, pos, blockEntity);
    }

    protected boolean canBeReplacedWith(FluidState state, BlockGetter level, BlockPos pos, Fluid fluidIn, Direction direction) {
        return direction == Direction.DOWN && !this.isSame(fluidIn);
    }

    protected BlockState createLegacyBlock(FluidState state) {
        return this.block != null ? (BlockState)((LiquidBlock)this.block.get()).defaultBlockState().setValue(LiquidBlock.LEVEL, getLegacyLevel(state)) : Blocks.AIR.defaultBlockState();
    }

    public boolean isSame(Fluid fluidIn) {
        return fluidIn == this.getSource() || fluidIn == this.getFlowing();
    }

    public abstract Fluid getSource();

    public abstract Fluid getFlowing();

    public abstract ModFluidRenderProperties createRenderProperties();



    public static final class Properties {
        public String descriptionId;
        public double motionScale = 0.014;
        public boolean canPushEntity = true;
        public boolean canSwim = true;
        public boolean canDrown = true;
        public float fallDistanceModifier = 0.5F;
        public boolean canExtinguish = false;
        public boolean supportsBoating = false;
        public boolean canConvertToSource = false;
        public @Nullable BlockPathTypes pathType;
        public @Nullable
        BlockPathTypes adjacentPathType;
        public boolean canHydrate;
        public int lightLevel;
        public int density;
        public int temperature;
        public int viscosity;
        public Rarity rarity;
        public Map<String, SoundEvent> sounds;
        public Fluid copyFluid;

        public Properties() {
            this.pathType = BlockPathTypes.WATER;
            this.adjacentPathType = BlockPathTypes.WATER_BORDER;
            this.canHydrate = false;
            this.lightLevel = 0;
            this.density = 1000;
            this.temperature = 300;
            this.viscosity = 1000;
            this.rarity = Rarity.COMMON;
            this.copyFluid = null;
        }

        public Properties copyFluid(Fluid fluid) {
            this.copyFluid = fluid;
            return this;
        }

        public Properties descriptionId(String descriptionId) {
            this.descriptionId = descriptionId;
            return this;
        }

        public Properties motionScale(double motionScale) {
            this.motionScale = motionScale;
            return this;
        }

        public Properties setCanConvertToSource(boolean canConvertToSource) {
            this.canConvertToSource = canConvertToSource;
            return this;
        }

        public Properties canPushEntity(boolean canPushEntity) {
            this.canPushEntity = canPushEntity;
            return this;
        }

        public Properties canSwim(boolean canSwim) {
            this.canSwim = canSwim;
            return this;
        }
        public Properties canDrown(boolean canDrown) {
            this.canDrown = canDrown;
            return this;
        }

        public Properties fallDistanceModifier(float fallDistanceModifier) {
            this.fallDistanceModifier = fallDistanceModifier;
            return this;
        }

        public Properties canExtinguish(boolean canExtinguish) {
            this.canExtinguish = canExtinguish;
            return this;
        }

        public Properties supportsBoating(boolean supportsBoating) {
            this.supportsBoating = supportsBoating;
            return this;
        }

        public Properties pathType(@Nullable BlockPathTypes pathType) {
            this.pathType = pathType;
            return this;
        }

        public Properties adjacentPathType(@Nullable BlockPathTypes adjacentPathType) {
            this.adjacentPathType = adjacentPathType;
            return this;
        }

        public Properties sound(String soundActionId, SoundEvent sound) {
            this.sounds.put(soundActionId, sound);
            return this;
        }

        public Properties canHydrate(boolean canHydrate) {
            this.canHydrate = canHydrate;
            return this;
        }
        public Properties lightLevel(int lightLevel) {
            this.lightLevel = lightLevel;
            return this;
        }

        public Properties density(int density) {
            this.density = density;
            return this;
        }

        public Properties temperature(int temperature) {
            this.temperature = temperature;
            return this;
        }

        public Properties viscosity(int viscosity) {
            this.viscosity = viscosity;
            return this;
        }

        public Properties rarity(Rarity rarity) {
            this.rarity = rarity;
            return this;
        }
    }
}
