// 
// Decompiled by Procyon v0.5.36
// 

package com.golding.platformer.entities;

import java.awt.Graphics;
import com.golding.platformer.physics.Collisions;
import com.golding.platformer.ressources.Images;

import java.awt.Point;
import com.golding.platformer.gameStates.GameState;
import com.golding.platformer.objects.Block;

public class Player
{
    private double x;
    private double y;
    private int width;
    private int height;
    private boolean right;
    private boolean left;
    private boolean jumping;
    private boolean falling;
    private boolean topCollision;
    private double maxJumpSpeed;
    private double currentJumpSpeed;
    private double maxFallSpeed;
    private double currentFallSpeed;
    private double moveSpeed;
   
    
    public Player(final int width, final int height) {
        this.right = false;
        this.left = false;
        this.jumping = false;
        this.falling = false;
        this.topCollision = false;
        this.maxJumpSpeed = 5.0;
        this.currentJumpSpeed = this.maxJumpSpeed;
        this.maxFallSpeed = 5.0;
        this.currentFallSpeed = 0.1;
        this.moveSpeed = 2.5;
        this.x = 640.0;
        this.y = 360.0;
        this.width = width;
        this.height = height;
     
    }
    
    public void tick(final Block[][] b) {
        final int iX = (int)this.x;
        final int iY = (int)this.y;
        for (int i = 0; i < b.length; ++i) {
            for (int j = 0; j < b[0].length; ++j) {
                if (b[i][j].getId() != 0) {
                	//right collision
                    if (Collisions.playerBlock(new Point(iX + this.width + (int)GameState.xOffset, iY + (int)GameState.yOffset + 2), b[i][j]) 
                    		|| Collisions.playerBlock(new Point(iX + this.width + (int)GameState.xOffset, iY + this.height + (int)GameState.yOffset - 1), b[i][j])) {
                        this.right = false;
                    }
                    //left collision
                    if (Collisions.playerBlock(new Point(iX + (int)GameState.xOffset - 1, iY + (int)GameState.yOffset + 2), b[i][j]) 
                    		|| Collisions.playerBlock(new Point(iX + (int)GameState.xOffset - 1, iY + this.height + (int)GameState.yOffset - 1), b[i][j])) {
                        this.left = false;
                    }
                    //top collision
                    if (Collisions.playerBlock(new Point(iX + (int)GameState.xOffset + 1, iY + (int)GameState.yOffset), b[i][j]) 
                    		|| Collisions.playerBlock(new Point(iX + this.width + (int)GameState.xOffset - 2, iY + (int)GameState.yOffset), b[i][j])) {
                        this.jumping = false;
                        this.falling = true;
                    }
                    //bottom collision
                    if (Collisions.playerBlock(new Point(iX + (int)GameState.xOffset + 2, iY + this.height + (int)GameState.yOffset + 1), b[i][j])
                    		|| Collisions.playerBlock(new Point(iX + this.width + (int)GameState.xOffset - 2, iY + this.height + (int)GameState.yOffset + 1), b[i][j])) {
                        this.y = b[i][j].getY() - this.height - GameState.yOffset;
                        this.falling = false;
                        this.topCollision = true;
                    }
                    else if (!this.topCollision && !this.jumping) {
                        this.falling = true;
                    }
                }
            }
        }
        this.topCollision = false;
        if (this.right) {
            GameState.xOffset += this.moveSpeed;
        }
        if (this.left) {
            GameState.xOffset -= this.moveSpeed;
        }
        if (this.jumping) {
            GameState.yOffset -= this.currentJumpSpeed;
            this.currentJumpSpeed -= 0.1;
            if (this.currentJumpSpeed <= 0.0) {
                this.currentJumpSpeed = this.maxJumpSpeed;
                this.jumping = false;
                this.falling = true;
            }
        }
        if (this.falling) {
            GameState.yOffset += this.currentFallSpeed;
            if (this.currentFallSpeed < this.maxFallSpeed) {
                this.currentFallSpeed += 0.1;
            }
        }
        if (!this.falling) {
            this.currentFallSpeed = 0.1;
        }
    }
    
    public void draw(final Graphics g) {
    	if(this.jumping)
    	{
    		if(this.left)
    		{
    			g.drawImage(Images.basicSprite[5], (int)this.x, (int)this.y, this.width, this.height, null);
    		}
    		else
    		{
    			g.drawImage(Images.basicSprite[1], (int)this.x, (int)this.y, this.width, this.height, null);
    		}
    		
    	}
    	else if(this.falling)
    	{
    		if(this.left)
    		{
    			g.drawImage(Images.basicSprite[6], (int)this.x, (int)this.y, this.width, this.height, null);
    		}
    		else
    		{
    			g.drawImage(Images.basicSprite[2], (int)this.x, (int)this.y, this.width, this.height, null);
    		}
    	}
    	else if(this.right)
    	{
    		g.drawImage(Images.basicSprite[3], (int)this.x, (int)this.y, this.width, this.height, null);
    	}
    	else if(this.left)
    	{
    		g.drawImage(Images.basicSprite[4], (int)this.x, (int)this.y, this.width, this.height, null);
    	}
    	else 
    	{
    		g.drawImage(Images.basicSprite[0], (int)this.x, (int)this.y, this.width, this.height, null);
    	}
    }
    
    public void keyPressed(final int k) {
        if (k == 68 || k == 39) {
            this.right = true;
        }
        if (k == 81 || k == 37) {
            this.left = true;
        }
        if (k == 32 && !this.jumping && !this.falling) {
            this.jumping = true;
        }
    }
    
    public void keyReleased(final int k) {
        if (k == 68 || k == 39) {
            this.right = false;
        }
        if (k == 81 || k == 37) {
            this.left = false;
        }
    }
}
