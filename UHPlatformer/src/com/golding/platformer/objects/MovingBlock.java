package com.golding.platformer.objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.golding.platformer.gameStates.GameState;
import com.golding.platformer.ressources.Images;

public class MovingBlock extends Rectangle
{

	private static final long serialVersionUID = 1L;

	private int leftBound, rightBound;
	private int move = 1;
	private int id;
	
	public MovingBlock(int x, int y, int id, int lefBound, int rightBound)
	{
		setBounds(x, y, Block.BLOCK_SIZE, Block.BLOCK_SIZE);
		this.id = id;
		this.leftBound = lefBound;
		this.rightBound = rightBound;
	}
	
	public void tick() {
		
		if(this.x + this.width - GameState.xOffset >= this.rightBound - GameState.xOffset && this.move != 1)
		{
			this.move *= -1;
		}
		
		if(this.x - GameState.xOffset  <= this.leftBound - GameState.xOffset && this.move != 1)
		{
			this.move *= -1;
		}
		this.x += this.move;
	}
	
	public void draw(Graphics g)
	{
		if(this.id != 0)
		{
			g.drawImage(Images.blocks[this.id -1], this.x - (int)GameState.xOffset, this.y - (int)GameState.yOffset, this.width, this.height, null );
		}
	}
	
	public int getMove()
	{
		return this.move;
	}
	
	public int getId()
	{
		return this.id;
	}
}
