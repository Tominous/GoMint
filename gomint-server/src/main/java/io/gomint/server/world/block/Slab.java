package io.gomint.server.world.block;

import io.gomint.math.AxisAlignedBB;
import io.gomint.server.world.block.state.BooleanBlockState;
import io.gomint.world.block.BlockSlab;

import java.util.Collections;
import java.util.List;

/**
 * @author geNAZt
 * @version 1.0
 */
public abstract class Slab extends Block implements BlockSlab {

    private BooleanBlockState top = new BooleanBlockState( this, states -> true, 3 );

    @Override
    public void setTop( boolean top ) {
        this.top.setState( top );
    }

    @Override
    public boolean isTop() {
        return this.top.getState();
    }

    @Override
    public List<AxisAlignedBB> getBoundingBox() {
        if ( this.top.getState() ) {
            return Collections.singletonList( new AxisAlignedBB(
                this.location.getX(),
                this.location.getY() + 0.5f,
                this.location.getZ(),
                this.location.getX() + 1,
                this.location.getY() + 1,
                this.location.getZ() + 1
            ) );
        } else {
            return Collections.singletonList( new AxisAlignedBB(
                this.location.getX(),
                this.location.getY(),
                this.location.getZ(),
                this.location.getX() + 1,
                this.location.getY() + 0.5f,
                this.location.getZ() + 1
            ) );
        }
    }

}
