package com.golding.platformer.gameStates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.golding.platformer.GamePanel;
import com.golding.platformer.ressources.Images;

public class WinState extends GameState
{
	 private String[] options;
	 private int SelectedOption;
	
	public WinState(GameStateManager gsm)
	{
		super(gsm);
		this.SelectedOption = 0;
		this.options = new String[] {"Continue", "Quit"};
	}

	
	public void init()
	{
		
		
	}

	
	public void tick()
	{
		
		
	}

	
	public void draw(Graphics g)
	{
		g.drawImage(Images.gameBg[0], 0, 0, GamePanel.WIDTH, GamePanel.HEIGHT, null);
		g.drawImage(Images.titles[2], GamePanel.WIDTH / 2 - 300 , GamePanel.HEIGHT / 18, 639, 99, null);
		int j = 75;
		for (int i = 0; i < this.options.length; ++i) {
            if (i == this.SelectedOption) {
                g.setColor(new Color(0, 255, 128));
            }
            else {
                g.setColor(new Color(64, 64, 64));
            }
	 
	  g.setFont(new Font("Montserrat", 0, 70));
	  g.drawString(this.options[i], GamePanel.WIDTH / 2 - 100 - j, 250 + i * 150);
	  j = 0;
		}
		
	}

	
	public void keyPressed(int k)
	{
		 if (k == 40 || k == 83) {
	            ++this.SelectedOption;
	            if (this.SelectedOption >= this.options.length) {
	                this.SelectedOption = 0;
	            }
	        }
	        else if (k == 38 || k == 90) {
	            --this.SelectedOption;
	            if (this.SelectedOption < 0) {
	                this.SelectedOption = this.options.length - 1;
	            }
	        }
	        if (k == 10) {
	            if (this.SelectedOption == 0) {
	                this.gsm1.getState().push(new MenuState(this.gsm1));
	            }
	            else if (this.SelectedOption == 1 ) {
	                System.exit(0);
	            }
	        }
		
	}

	
	public void keyReleased(int k)
	{
		
		
	}

}
