package com.agoatnaepizza.Game.Objects;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * User: nishad
 * Date: 11/10/14
 * Time: 00:03
 */
public class Chair extends Tile {
    public Chair() throws IOException {
        super(ImageIO.read(new File("resources/chair.bmp")), false);
    }
}
