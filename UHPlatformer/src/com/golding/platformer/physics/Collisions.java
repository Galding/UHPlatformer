
package com.golding.platformer.physics;

import com.golding.platformer.objects.Block;
import java.awt.Point;

public class Collisions
{
    public static boolean playerBlock(final Point p, final Block b) {
        return b.contains(p);
    }
}
