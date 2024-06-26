package net.levim.dust.item;

import net.levim.dust.Dust;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Dust.MOD_ID);

    public static final RegistryObject<Item> DUST = ITEMS.register("dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EVIL_DUST = ITEMS.register("evil_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COMPACTED_DUST = ITEMS.register("compacted_dust", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
