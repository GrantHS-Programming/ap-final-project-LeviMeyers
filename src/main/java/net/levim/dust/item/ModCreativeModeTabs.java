package net.levim.dust.item;

import net.levim.dust.Dust;
import net.levim.dust.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Dust.MOD_ID);

    public static final RegistryObject<CreativeModeTab> DUST_TAB = CREATIVE_MODE_TABS.register("dust_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.DUST.get()))
            .title(Component.translatable("creativetab.dust_tab"))
            .displayItems((pParameters, pOutput) -> {
                pOutput.accept(ModItems.DUST.get());
                pOutput.accept(ModItems.COMPACTED_DUST.get());
                pOutput.accept(ModItems.EVIL_DUST.get());

                pOutput.accept(ModBlocks.DUST_BLOCK.get());
                pOutput.accept(ModBlocks.DUSTY_CRAFTING_TABLE.get());
            })
            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
