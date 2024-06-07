package net.levim.dust.block;

import com.mojang.serialization.MapCodec;
import net.levim.dust.Dust;
import net.levim.dust.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Dust.MOD_ID);

    public static final RegistryObject<Block> DUST_BLOCK = registerBlock("dust_block", () -> new FallingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL).sound(SoundType.COBWEB).pushReaction(PushReaction.DESTROY).strength(0.4F)) {
        @Override
        protected MapCodec<? extends FallingBlock> codec() {
            return null;
        }
    });
    public static final RegistryObject<Block> DUSTY_CRAFTING_TABLE = registerBlock("dusty_crafting_table", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE)));
    public static final RegistryObject<Block> DUST_LAYER = registerBlock("dust_layer", () -> new SnowLayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW).sound(SoundType.COBWEB)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
