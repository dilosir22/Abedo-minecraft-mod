package com.dilosir22.abedo.common.items;

import com.dilosir22.abedo.Abedo;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.function.Predicate;

public class SpecialItem extends ShootableItem {

    public SpecialItem(Properties properties) { super(properties); }

    @Override
    public Predicate<ItemStack> getInventoryAmmoPredicate() {
        return null;
    }

    @Override
    public int func_230305_d_() { return 15; }

    /*public int tcount=0;

    @SubscribeEvent
    public void ontick(TickEvent.ServerTickEvent event){
        tcount++;
    }*/

 //   @Override
 //   public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
  //      if (!playerIn.getCooldownTracker().hasCooldown(this)) {
      //      playerIn.getCooldownTracker().setCooldown(this, 40);
  //          Vector3d v3 = playerIn.getLook(1);
  //          for (tcount = 0; tcount <= 40;) {
               // if (tcount%10 == 0 && tcount!= 40) {
                    //final SmallFireballEntity entitysmallfireball = new SmallFireballEntity(playerIn.getEntityWorld(), playerIn.getPosX(), playerIn.getPosY() + playerIn.getEyeHeight() - 0.4, playerIn.getPosZ(), v3.x + playerIn.getRNG().nextGaussian() * 0.05, v3.y, v3.z);
                    //entitysmallfireball./* shoot */func_234612_a_(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0f, 1.5f, 1.0f);
                    //worldIn.addEntity(entitysmallfireball);
       //         }
     //       }
     //   tcount = 0;
    //    return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
  //      }
 //       return ActionResult.resultFail(playerIn.getHeldItem(handIn));
  //  }

}
