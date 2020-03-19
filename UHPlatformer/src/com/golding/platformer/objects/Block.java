
package com.golding.platformer.objects;

import com.golding.platformer.gameStates.GameState;
import com.golding.platformer.ressources.Images;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Block extends Rectangle
{
    private static final long serialVersionUID = 1L;
    public static final int BLOCK_SIZE = 64;
    private int id;
    
    public Block(final int x, final int y, final int id) {
        this.setBounds(x, y, 64, 64);
        this.id = id;
    }
    
    public void tick() {
    }
    
    public void draw(final Graphics g) {
        g.setColor(Color.BLUE);
        if (this.id != 0) {
            g.drawImage(Images.blocks[this.id - 1], this.x - (int)GameState.xOffset, this.y - (int)GameState.yOffset, this.width, this.height, null);
        }
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public int getId() {
        return this.id;
    }
}
