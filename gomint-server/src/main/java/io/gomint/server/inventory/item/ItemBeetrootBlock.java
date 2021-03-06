package io.gomint.server.inventory.item;
import io.gomint.inventory.item.ItemType;

import io.gomint.server.registry.RegisterInfo;
import io.gomint.taglib.NBTTagCompound;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo( id = 244 )
 public class ItemBeetrootBlock extends ItemStack implements io.gomint.inventory.item.ItemBeetrootBlock {



    @Override
    public String getBlockId() {
        return "minecraft:beetroot";
    }

    @Override
    public ItemType getType() {
        return ItemType.BEETROOT_BLOCK;
    }

}
