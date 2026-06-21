package net.shadowstorm7894.odinsdragons.item.customitems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.network.ClientPacketDistributor;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import net.shadowstorm7894.odinsdragons.OdinsDragons;
import net.shadowstorm7894.odinsdragons.client.KeymapHandler;
import net.shadowstorm7894.odinsdragons.item.ModItems;
import net.shadowstorm7894.odinsdragons.item.datacomponents.ModDataComponents;
import net.shadowstorm7894.odinsdragons.payloads.ModPayloads;

import javax.annotation.Nullable;

@EventBusSubscriber(modid = OdinsDragons.MOD_ID)
public class FireSwordItem extends Item {
    public FireSwordItem(Properties properties) {
        super(properties.component(ModDataComponents.LIT_ANI_0, true).component(ModDataComponents.FUEL, 4800));
    }
    public static int animateOnThisTick = 0;

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        if(slotChanged) {
            return true;
        }
        return (!ItemStack.isSameItem(oldStack, newStack) || oldStack.getDamageValue() == newStack.getDamageValue()) && super.shouldCauseReequipAnimation(oldStack, newStack, slotChanged);
    }

    @SubscribeEvent
    public static void prePlayerTick(PlayerTickEvent.Pre event){
        if(event.getEntity().level().isClientSide()) return;
        final Player player = event.getEntity();
        final ItemStack heldItem = player.getMainHandItem();
        for (ItemStack item : player.inventoryMenu.getItems()) {
            if (item.is(ModItems.FIRE_SWORD) && item != heldItem) {
                item.remove(ModDataComponents.LIT_STATE);
            }
        }
        if (animateOnThisTick % 5 == 0) {
            animateOnThisTick = 0;
            if (heldItem.is(ModItems.FIRE_SWORD) && Boolean.TRUE.equals(heldItem.get(ModDataComponents.LIT_STATE))) {
                Integer fuelLeft = heldItem.get(ModDataComponents.FUEL);
                if (fuelLeft <= 0) {
                    heldItem.set(ModDataComponents.LIT_ANI_0, true);
                    heldItem.remove(ModDataComponents.LIT_STATE);
                } else if (fuelLeft == null){
                    System.out.println("fuel is null");
                } else {
                    fuelLeft -= 1;
                    heldItem.set(ModDataComponents.FUEL, fuelLeft);
                    int safeDamgage = Math.min(4800 - fuelLeft, heldItem.getMaxDamage() - 1);
                    heldItem.setDamageValue(safeDamgage);

                    if (Boolean.TRUE.equals(heldItem.get(ModDataComponents.LIT_ANI_0))) {
                        heldItem.remove(ModDataComponents.LIT_ANI_0);
                        heldItem.set(ModDataComponents.LIT_ANI_1, true);
                    } else if (Boolean.TRUE.equals(heldItem.get(ModDataComponents.LIT_ANI_1))) {
                        heldItem.remove(ModDataComponents.LIT_ANI_1);
                        heldItem.set(ModDataComponents.LIT_ANI_2, true);
                    } else if (Boolean.TRUE.equals(heldItem.get(ModDataComponents.LIT_ANI_2))) {
                        heldItem.remove(ModDataComponents.LIT_ANI_2);
                        heldItem.set(ModDataComponents.LIT_ANI_3, true);
                    } else if (Boolean.TRUE.equals(heldItem.get(ModDataComponents.LIT_ANI_3))) {
                        heldItem.remove(ModDataComponents.LIT_ANI_3);
                        heldItem.set(ModDataComponents.LIT_ANI_0, true);
                    }
                }
            }
        }
        animateOnThisTick += 1;
    }

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Post event){
        while (KeymapHandler.IGNITE_KEY.get().consumeClick()) {
            final LocalPlayer player = Minecraft.getInstance().player;
            final ItemStack item = player.getMainHandItem();
            if(item.is(ModItems.FIRE_SWORD) && !Boolean.TRUE.equals(item.get(ModDataComponents.LIT_STATE))){
                item.set(ModDataComponents.LIT_STATE, true);
                ClientPacketDistributor.sendToServer(new ModPayloads.IGNITE_SWORD_DATA(true));
            } else if (item.is(ModItems.FIRE_SWORD)) {
                item.remove(ModDataComponents.LIT_STATE);
                ClientPacketDistributor.sendToServer(new ModPayloads.IGNITE_SWORD_DATA(false));
            }
        }
    }
}
