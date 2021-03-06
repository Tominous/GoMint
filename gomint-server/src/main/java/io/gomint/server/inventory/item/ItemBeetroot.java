package io.gomint.server.inventory.item;
import io.gomint.inventory.item.ItemType;

import io.gomint.server.registry.RegisterInfo;
import io.gomint.taglib.NBTTagCompound;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo( id = 457 )
public class ItemBeetroot extends ItemFood implements io.gomint.inventory.item.ItemBeetroot {



    @Override
    public float getSaturation() {
        return 0.6f;
    }

    @Override
    public float getHunger() {
        return 1;
    }

    @Override
    public ItemType getType() {
        return ItemType.BEETROOT;
    }

}
