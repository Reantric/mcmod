package com.protonlaser.tutorialmod.init;

import com.protonlaser.tutorialmod.TutorialMod;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(TutorialMod.MOD_ID)
@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID,bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockInit {

    public static final Block bendite_block = null;
    public static final Block bendite_ore = null;

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event){
        event.getRegistry().register(new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(10).harvestLevel(3).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE)).setRegistryName("bendite_block"));

        /* Ore */
        event.getRegistry().register(new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(10).harvestLevel(3).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE)).setRegistryName("bendite_ore"));
    }

    @SubscribeEvent
    public static void registerBlockItems(final RegistryEvent.Register<Item> event){
        event.getRegistry().register(new BlockItem(bendite_block,new Item.Properties().maxStackSize(32).group(ItemGroup.MATERIALS)).setRegistryName("bendite_block"));

        /* Ore */
        event.getRegistry().register(new BlockItem(bendite_ore,new Item.Properties().maxStackSize(32).group(ItemGroup.MATERIALS)).setRegistryName("bendite_ore"));
    }

}
