package com.dilosir22.abedo.common.entities;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import javax.annotation.Nullable;

public class Cockatrice extends AnimalEntity implements IAnimatable {
    public Cockatrice(EntityType<? extends Cockatrice> type, World worldIn) {
        super(type, worldIn);
    }

    private EatGrassGoal eatGrassGoal;
    private int exampleTimer;

    private AnimationFactory factory = new AnimationFactory(this);


    @Nullable
    @Override
    public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        return null;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.eatGrassGoal = new EatGrassGoal(this);
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.3D, true));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, WolfEntity.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, false));
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes()
    {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 35.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.4D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 5)
                .createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 1.5D)
                .createMutableAttribute(Attributes.ATTACK_SPEED, 2.0D);
    }


    @Override
    protected void updateAITasks() {
        this.exampleTimer = this.eatGrassGoal.getEatingGrassTimer();
        super.updateAITasks();
    }

    @Override
    public void livingTick() {
        if (this.world.isRemote) {
            this.exampleTimer = Math.max(0, this.exampleTimer - 1);
        }
        super.livingTick();
    }


    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 10) {
            this.exampleTimer = 40;
        } else {
            super.handleStatusUpdate(id);
        }

    }



    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event)
    {

        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.abedo.cockatricewalk", true));
            return PlayState.CONTINUE;
        } else {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.abedo.cockatriceidle", true));
            return PlayState.CONTINUE;
        }
    }


    @Override
    public void registerControllers(AnimationData data) {
        AnimationController controller = new AnimationController(this, "controller", 10, this::predicate);
        data.addAnimationController(controller);
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }
}
