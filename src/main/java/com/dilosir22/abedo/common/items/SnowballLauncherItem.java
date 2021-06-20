package com.dilosir22.abedo.common.items;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShootableItem;
import net.minecraft.util.*;
import net.minecraft.world.World;

import java.util.function.Predicate;

public class SnowballLauncherItem extends ShootableItem {

    /**
     * The cooldown of the launcher (in ticks)
     */
    private static final int COOLDOWN = 1;

    public SnowballLauncherItem(final Item.Properties properties) {
        super(properties);
    }

    /**
     * Get the cooldown of the launcher (in ticks).
     *
     * @param launcher The launcher
     * @return The cooldown of the launcher (in ticks), or 0 if there is none
     */
    protected int getCooldown(final ItemStack launcher) {
        return COOLDOWN;
    }

    /**
     * Does the player need ammunition to fire the launcher?
     *
     * @param stack  The launcher ItemStack
     * @param player The player to check
     * @return True if the player is not in creative mode and the launcher doesn't have the Infinity enchantment
     */
    private boolean isAmmoRequired(final ItemStack stack, final PlayerEntity player) {
        return !player.abilities.isCreativeMode && EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) == 0;
    }

    @Override
    public Predicate<ItemStack> getInventoryAmmoPredicate() {
        return stack -> stack.getItem() == Items.SNOWBALL;
    }

    /* getRange */
    @Override
    public int func_230305_d_() {
        return 20;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(final World world, final PlayerEntity player, final Hand hand) {
        final ItemStack heldItem = player.getHeldItem(hand);

        final boolean ammoRequired = isAmmoRequired(heldItem, player);
        final ItemStack ammo = player.findAmmo(heldItem);
        final boolean hasAmmo = !ammo.isEmpty();

        if (!ammoRequired || hasAmmo) {
            final int cooldown = getCooldown(heldItem);
            if (cooldown > 0) {
                player.getCooldownTracker().setCooldown(this, cooldown);
            }

            world.playSound(null, player.getPosX(), player.getPosY(), player.getPosZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5f, 0.4f / (random.nextFloat() * 0.4f + 0.8f));

            if (!world.isRemote) {
                final SnowballEntity entitySnowball = new SnowballEntity(world, player);
                entitySnowball./* shoot */func_234612_a_(player, player.rotationPitch, player.rotationYaw, 0.0f, 1.5f, 1.0f);
                world.addEntity(entitySnowball);
            }

            if (ammoRequired) {
                ammo.shrink(1);
                if (ammo.isEmpty()) {
                    player.inventory.deleteStack(ammo);
                }
            }

            return new ActionResult<>(ActionResultType.FAIL, heldItem);
        }

        return new ActionResult<>(ActionResultType.FAIL, heldItem);
    }
}