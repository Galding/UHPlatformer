
package com.golding.platformer.ressources;

import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Images
{
    public static BufferedImage[] blocks;
    
    public Images() {
        Images.blocks = new BufferedImage[1];
        try {
            Images.blocks[0] = ImageIO.read(this.getClass().getResourceAsStream("/block_brick.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
