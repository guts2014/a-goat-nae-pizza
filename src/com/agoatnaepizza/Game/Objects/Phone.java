package com.agoatnaepizza.Game.Objects;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * User: nishad
 * Date: 10/10/14
 * Time: 23:55
 */
public class Phone extends TaskProvider {
    public Phone() throws IOException {
        super(ImageIO.read(new File("Resources/phone.bmp")), null); //TODO Implement me!!
    }
}
