package io.gomint.entity.passive;

import io.gomint.GoMint;
import io.gomint.entity.EntityAgeable;
import io.gomint.entity.EntityLiving;

public interface EntitySheep extends EntityAgeable {

    /**
     * Create a new entity sheep with no config
     *
     * @return empty, fresh sheep
     */
    static EntitySheep create() {
        return GoMint.instance().createEntity( EntitySheep.class );
    }

}
