
package com.golding.platformer.gameStates;

import java.awt.Graphics;
import com.golding.platformer.mapping.Map;
import com.golding.platformer.entities.Player;

public class LevelOneState extends GameState
{
    private Player player;
    private Map map;
    
    public LevelOneState(GameStateManager gsm) {
        super(gsm);
    }
    
    
    public void init() {
        this.player = new Player(30, 30);
        this.map = new Map("/map1.UHP");
        LevelOneState.xOffset = -400.0;
        LevelOneState.yOffset = -600.0;
    }
    
    
    public void tick() {
        this.player.tick(this.map.getBlocks());
    }
    
    
    public void draw(Graphics g) {
        this.player.draw(g);
        this.map.draw(g);
    }
    
    
    public void keyPressed(int k) {
        this.player.keyPressed(k);
    }
    
    
    public void keyReleased(int k) {
        this.player.keyReleased(k);
    }
}
