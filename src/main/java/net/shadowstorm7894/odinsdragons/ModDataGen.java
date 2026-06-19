package net.shadowstorm7894.odinsdragons;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.shadowstorm7894.odinsdragons.datagen.ModModelProvider;

@EventBusSubscriber(modid = OdinsDragons.MOD_ID)
public class ModDataGen {
    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event){
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();

        generator.addProvider(true, new ModModelProvider(packOutput));
    }
}
