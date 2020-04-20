package com.protonlaser.tutorialmod.init;

import com.protonlaser.tutorialmod.TutorialMod;
import com.protonlaser.tutorialmod.TutorialMod.*;
import com.protonlaser.tutorialmod.objects.items.BenditeSword;
import com.protonlaser.tutorialmod.objects.items.SpecialItem;
import com.protonlaser.tutorialmod.util.helpers.ModArmorMaterial;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID,bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(TutorialMod.MOD_ID)
public class ItemInit {

    public static final Item bendy = null;
    public static final Item special_item = null;
    //Tools
    public static final Item bendy_sword = null;
    public static final Item bendy_pick = null;
    public static final Item example_axe = null;
    public static final Item example_shovel = null;
    public static final Item example_hoe = null;
    //Armor
    public static final Item bendy_helmet = null, bendy_chestplate = null,bendy_leggings = null,bendy_boots = null;


    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event){
        event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("bendy"));
        event.getRegistry().register(new SpecialItem(new Item.Properties().group(TutorialItemGroup.instance)).setRegistryName("special_item"));
        //Tools
        event.getRegistry().register(new BenditeSword(ModItemTier.EXAMPLE,7,-1.4f,new Item.Properties().group(TutorialItemGroup.instance)).setRegistryName("bendy_sword"));
        //event.getRegistry().register(new SwordItem(ModItemTier.EXAMPLE,7,-1.4f,new Item.Properties().group(TutorialItemGroup.instance)).setRegistryName("bendy_sword"));
        event.getRegistry().register(new PickaxeItem(ModItemTier.EXAMPLE,3,-1.8f,new Item.Properties().group(TutorialItemGroup.instance)).setRegistryName("bendy_pick"));

        //Armor
       event.getRegistry().register(new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.HEAD,
				new Item.Properties().group(TutorialItemGroup.instance)).setRegistryName("bendy_helmet")); // next make these their own class tom!
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.CHEST,
				new Item.Properties().group(TutorialItemGroup.instance)).setRegistryName("bendy_chestplate"));
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.LEGS,
				new Item.Properties().group(TutorialItemGroup.instance)).setRegistryName("bendy_leggings"));
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.FEET,
				new Item.Properties().group(TutorialItemGroup.instance)).setRegistryName("bendy_boots"));
    }

    public enum ModItemTier implements IItemTier {
        EXAMPLE(3,3000, 15,2, 30, () -> {
            return Ingredient.fromItems(ItemInit.bendy);
        });
        //harvestLevel, maxUses, efficiency, baseDmg, enchantability,repairMaterial
        private final int harvestLevel, maxuses, enchantability;
        private final float efficiency, attackDamage;
        private final LazyValue<Ingredient> repairMaterial;

        private ModItemTier(int harvestLevel, int maxUses, float efficiency, float baseDmg, int enchantibility, Supplier<Ingredient> repairMaterial) {
            this.harvestLevel = harvestLevel;
            this.maxuses = maxUses;
            this.efficiency = efficiency;
            this.attackDamage = baseDmg;
            this.enchantability = enchantibility;
            this.repairMaterial = new LazyValue<>(repairMaterial);
        }

        @Override
        public int getMaxUses() {
            return maxuses;
        }

        @Override
        public float getEfficiency() {
            return efficiency;
        }

        @Override
        public float getAttackDamage() {
            return attackDamage;
        }

        @Override
        public int getHarvestLevel() {
            return harvestLevel;
        }

        @Override
        public int getEnchantability() {
            return enchantability;
        }

        @Override
        public Ingredient getRepairMaterial() {
          return this.repairMaterial.getValue();
        }
    }
}
