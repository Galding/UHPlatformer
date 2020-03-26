
package com.golding.platformer.physics;

import java.awt.Point;

import com.golding.platformer.objects.Block;
import com.golding.platformer.objects.MovingBlock;

public class Collisions
{
    public static boolean playerBlock(final Point p, final Block b) {
        return b.contains(p);
    }
    
    public static boolean playerMovingBlock(Point p, MovingBlock b)
    {
    	return b.contains(p);
    }
}
