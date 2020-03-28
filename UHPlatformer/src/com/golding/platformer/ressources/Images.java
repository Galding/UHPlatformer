
package com.golding.platformer.ressources;

import java.io.IOException;
import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;

public class Images
{
    public static BufferedImage[] blocks;
	public static BufferedImage[] basicSprite;
	public static BufferedImage[] gameBg;
	public static BufferedImage[] titles;
    
    public Images() {
        Images.blocks = new BufferedImage[2];
        Images.basicSprite = new BufferedImage[10];
        Images.gameBg = new BufferedImage[2];
        Images.titles = new BufferedImage[3];
        try {
            Images.blocks[0] = ImageIO.read(this.getClass().getResourceAsStream("/block_brick.png"));
            Images.blocks[1] = ImageIO.read(this.getClass().getResourceAsStream("/stoneTexture.png"));
            
            Images.basicSprite[0] = ImageIO.read(this.getClass().getResourceAsStream("/basic_sprite.png"));
            Images.basicSprite[1] = ImageIO.read(this.getClass().getResourceAsStream("/PlayerJump.png"));
            Images.basicSprite[2] = ImageIO.read(this.getClass().getResourceAsStream("/PlayerFall.png"));
            Images.basicSprite[3] = ImageIO.read(this.getClass().getResourceAsStream("/PlayerRight.png"));
            Images.basicSprite[4] = ImageIO.read(this.getClass().getResourceAsStream("/PlayerLeft.png"));
            Images.basicSprite[5] = ImageIO.read(this.getClass().getResourceAsStream("/PlayerJumpLeft.png"));
            Images.basicSprite[6] = ImageIO.read(this.getClass().getResourceAsStream("/PlayerFallLeft.png"));
            
            Images.gameBg[0] = ImageIO.read(this.getClass().getResourceAsStream("/gamebg.png"));
            Images.gameBg[1] = ImageIO.read(this.getClass().getResourceAsStream("/pausebg.png"));
            
            Images.titles[0] = ImageIO.read(this.getClass().getResourceAsStream("/PauseTitle.png"));
            Images.titles[1] = ImageIO.read(this.getClass().getResourceAsStream("/DeadTitle.png"));
            Images.titles[2] = ImageIO.read(this.getClass().getResourceAsStream("/WinTitle.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
