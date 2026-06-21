package net.shadowstorm7894.odinsdragons.item.customitems;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.shadowstorm7894.odinsdragons.item.ModItems;
import net.shadowstorm7894.odinsdragons.item.datacomponents.ModDataComponents;
import java.awt.event.InputEvent;

public class FireSwordItem extends Item {
    public FireSwordItem(Properties properties) {
        super(properties.component(ModDataComponents.LIT_STATE, false));
    }



    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Player player = context.getPlayer();
        BlockPos blockpos = context.getClickedPos();
        ItemStack item = context.getItemInHand();

        if(!level.isClientSide()){
            level.playSound(null, blockpos, SoundEvents.AMETHYST_BLOCK_CHIME, SoundSource.BLOCKS, 1.5f, 1.5f);

            if(item.get(ModDataComponents.LIT_STATE) == null) {
                item.set(ModDataComponents.LIT_STATE, false);
            }
            if(item.get(ModDataComponents.LIT_STATE)) {
                player.sendSystemMessage(Component.literal("Lit"));
            } else{
                player.sendSystemMessage(Component.literal("unLit"));
                item.set(ModDataComponents.LIT_STATE, true);
            }
        }
        return InteractionResult.SUCCESS;
    }

}
