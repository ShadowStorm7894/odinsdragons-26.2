package net.shadowstorm7894.odinsdragons.item.customitems;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class FireSwordItem extends Item {
    public FireSwordItem(Properties properties) {
        super(properties);
    }

    public static final BooleanProperty LITSTATE = BooleanProperty.create("litstate");


}
