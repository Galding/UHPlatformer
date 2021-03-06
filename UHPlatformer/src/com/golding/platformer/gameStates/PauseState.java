package com.golding.platformer.gameStates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.golding.platformer.GamePanel;
import com.golding.platformer.ressources.Images;

public class PauseState extends GameState
{

    private String[] options;
    private int SelectedOption;
	
	public PauseState(GameStateManager gsm)
	{
		super(gsm);
		this.options = new String[] {"Continue", "Retry", "Help", "Main Menu", "Quit"};
		this.SelectedOption = 0;
		
	}

	@Override
	public void init()
	{
		
		
	}

	@Override
	public void tick()
	{
		
		
	}

	@Override
	public void draw(Graphics p)
	{
		p.setColor(new Color(252, 249, 253));
		p.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		p.drawImage(Images.gameBg[1], 0, 0, GamePanel.WIDTH, GamePanel.HEIGHT, null);
		p.drawImage(Images.titles[0],  GamePanel.WIDTH / 2 - 100 , GamePanel.HEIGHT / 18, 164, 90, null);
		int j = 75;
		  for (int i = 0; i < this.options.length; ++i) {
	            if (i == this.SelectedOption) {
	                p.setColor(new Color(0, 255, 128));
	            }
	            else {
	                p.setColor(new Color(64, 64, 64));
	            }
		 
		  p.setFont(new Font("Montserrat", 0, 70));
		  p.drawString(this.options[i], GamePanel.WIDTH / 2 - 100 - j, 250 + i * 150);
		  j = 0;
		  }
	}

	@Override
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
            	//Continue
                this.gsm1.getState().pop();
            }
            else if(this.SelectedOption == 1){
            	//Retry
            	this.gsm1.getState().push(new LevelOneState(this.gsm1));
            }
            else if (this.SelectedOption == 2 )
            {
            	//Help
            }
            else if (this.SelectedOption == 3 )
            {
            	//Main menu
            	this.gsm1.getState().push(new MenuState(this.gsm1));
            }
            else if (this.SelectedOption == 4 ) {
            	//Exit
                System.exit(0);
            }
        }
		
	}

	@Override
	public void keyReleased(int p)
	{
		
		
	}

}
