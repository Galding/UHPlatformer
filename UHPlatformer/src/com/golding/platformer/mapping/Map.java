
package com.golding.platformer.mapping;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.golding.platformer.objects.Block;
import com.golding.platformer.objects.MovingBlock;

public class Map
{
    private String path;
    private int width;
    private int height;
    private Block[][] blocks;
    private ArrayList<MovingBlock> movingBlocks;
    private String line;
    
    public Map(final String loadPath) {
        this.path = loadPath;
        this.blocks = new Block[this.height][this.width];
        this.loadMap();
    }
    
    public void loadMap() {
        final InputStream is = this.getClass().getResourceAsStream(this.path);
        final BufferedReader br = new BufferedReader(new InputStreamReader(is));
        try {
            this.width = Integer.parseInt(br.readLine());
            this.height = Integer.parseInt(br.readLine());
            this.blocks = new Block[this.height][this.width];
            for (int y = 0; y < this.height; ++y) {
                 this.line = br.readLine();
                final String[] tokens = this.line.split("\\s+");
                for (int x = 0; x < this.width; ++x) {
                    this.blocks[y][x] = new Block(x * 64, y * 64, Integer.parseInt(tokens[x]));
                }
            }
            this.line = br.readLine();
            this.line = br.readLine();
            int length = Integer.parseInt(this.line);
            this.movingBlocks = new ArrayList<MovingBlock>();
            
            for(int i = 0; i < length; i++)
            {
            	this.line = br.readLine();
            	String[] tokens = this.line.split("\\s+");
            	
            	this.movingBlocks.add(new MovingBlock(Integer.parseInt(tokens[0]) * Block.BLOCK_SIZE, Integer.parseInt(tokens[1]) * Block.BLOCK_SIZE, Integer.parseInt(tokens[2]),
            				Integer.parseInt(tokens[3]) * Block.BLOCK_SIZE, Integer.parseInt(tokens[4]) * Block.BLOCK_SIZE));
            	
            	/* Explanation : Create a new moving block and read in the map file, at the 9th line, the x value, the y value, the id value, the leftbound value, the rightbound value*/
            }
        }
        catch (NumberFormatException | IOException e) {
          
            e.printStackTrace();
        }
    }
    
    public Block[][] getBlocks() {
        return this.blocks;
    }
    
    public void draw(final Graphics g) {
        for (int i = 0; i < this.blocks.length; ++i) {
            for (int j = 0; j < this.blocks[0].length; ++j) {
                this.blocks[i][j].draw(g);
            }
        }
        for(int i = 0;  i < this.movingBlocks.size(); i++)
        {
        	this.movingBlocks.get(i).draw(g);
        }
    }
    
    public void tick()
    {
    	for(int i = 0; i < this.movingBlocks.size(); i++)
    	{
    		this.movingBlocks.get(i).tick();
    	}
    }
    
    
    public ArrayList<MovingBlock> getMovingBlock()
    {
    	return this.movingBlocks;
    }
}
