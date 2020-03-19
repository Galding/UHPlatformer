// 
// Decompiled by Procyon v0.5.36
// 

package com.golding.platformer.gameStates;

import java.awt.Graphics;
import com.golding.platformer.mapping.Map;
import com.golding.platformer.entities.Player;

public class LevelOneState extends GameState
{
    private Player player;
    private Map map;
    
    public LevelOneState(final GameStateManager gsm) {
        super(gsm);
    }
    
    @Override
    public void init() {
        this.player = new Player(30, 30);
        this.map = new Map("/map1.UHP");
        LevelOneState.xOffset = -400.0;
        LevelOneState.yOffset = -600.0;
    }
    
    @Override
    public void tick() {
        this.player.tick(this.map.getBlocks());
    }
    
    @Override
    public void draw(final Graphics g) {
        this.player.draw(g);
        this.map.draw(g);
    }
    
    @Override
    public void keyPressed(final int k) {
        this.player.keyPressed(k);
    }
    
    @Override
    public void keyReleased(final int k) {
        this.player.keyReleased(k);
    }
}
