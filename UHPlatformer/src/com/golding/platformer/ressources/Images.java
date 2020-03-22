
package com.golding.platformer.ressources;

import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Images
{
    public static BufferedImage[] blocks;
	public static BufferedImage[] basicSprite;
    
    public Images() {
        Images.blocks = new BufferedImage[1];
        Images.basicSprite = new BufferedImage[2];
        try {
            Images.blocks[0] = ImageIO.read(this.getClass().getResourceAsStream("/block_brick.png"));
            Images.basicSprite[0] = ImageIO.read(this.getClass().getResourceAsStream("/basic_sprite.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
