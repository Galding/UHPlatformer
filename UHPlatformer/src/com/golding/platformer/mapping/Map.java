
package com.golding.platformer.mapping;

import java.awt.Graphics;
import java.io.InputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import com.golding.platformer.objects.Block;

public class Map
{
    private String path;
    private int width;
    private int height;
    private Block[][] blocks;
    
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
                final String line = br.readLine();
                final String[] tokens = line.split("\\s+");
                for (int x = 0; x < this.width; ++x) {
                    this.blocks[y][x] = new Block(x * 64, y * 64, Integer.parseInt(tokens[x]));
                }
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
    }
}
