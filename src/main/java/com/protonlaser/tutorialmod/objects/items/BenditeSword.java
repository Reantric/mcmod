package com.protonlaser.tutorialmod.objects.items;

import com.protonlaser.tutorialmod.util.helpers.KeyboardHelper;
import javafx.scene.effect.Light;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.ModLoader;

import javax.annotation.Nullable;
import java.util.List;

public class BenditeSword extends SwordItem {

    public BenditeSword(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent("Bandi's " + "\u00A7e" + "God" + "\u00A77" + " Sword"));
        super.addInformation(stack,worldIn,tooltip,flagIn);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

        playerIn.getCooldownTracker().setCooldown(this, 20);
       // playerIn.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE,20,1));
        if (worldIn instanceof ServerWorld) {
            Vec3d blockHit = rayTrace(worldIn,playerIn, RayTraceContext.FluidMode.ANY).getHitVec();
            ServerWorld sw = (ServerWorld) worldIn;
            sw.addLightningBolt(new LightningBoltEntity(sw,blockHit.getX(),blockHit.getY(), blockHit.getZ(), false));
        }

        return super.onItemRightClick(worldIn,playerIn,handIn);
    }


}
