package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo( id = -159 )
public class ItemTurtleEgg extends ItemStack implements io.gomint.inventory.item.ItemTurtleEgg {

    @Override
    public String getBlockId() {
        return "minecraft:turtle_egg";
    }

    @Override
    public ItemType getType() {
        return ItemType.TURTLE_EGG;
    }

}
