
package com.golding.platformer.gameStates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.golding.platformer.mapping.Map;
import com.golding.platformer.ressources.Images;
import com.golding.platformer.GamePanel;
import com.golding.platformer.entities.Player;

public class LevelOneState extends GameState
{
    private Player player;
    private Map map;
    
    public LevelOneState(GameStateManager gsm) {
        super(gsm);
    }
    
    
    public void init() {
        this.player = new Player(50, 50);
        this.map = new Map("/map1.UHP");
        LevelOneState.xOffset = -650;
        LevelOneState.yOffset = -600.0;
        
    }
    
    
    public void tick() {
        this.player.tick(this.map.getBlocks(), this.map.getMovingBlock());
        this.map.tick();
        if(GameState.yOffset > -75)
        {
        	this.gsm1.getState().push(new DeathState(this.gsm1));
        }
        
    }
    
    
    public void draw(Graphics g) {
    	g.drawImage(Images.gameBg[0], 0, 0, GamePanel.WIDTH, GamePanel.HEIGHT, null);
        this.player.draw(g);
        this.map.draw(g);
    }
    
    
    public void keyPressed(int k) {
        this.player.keyPressed(k);
        if(k == KeyEvent.VK_ESCAPE)
        {
        	double x1 = xOffset;
        	double y1 = yOffset;
        	this.gsm1.getState().push(new PauseState(this.gsm1));

        	LevelOneState.xOffset = x1;		
        	LevelOneState.yOffset = y1;		
        }
    }
    
    
    public void keyReleased(int k) {
        this.player.keyReleased(k);
    }
}
