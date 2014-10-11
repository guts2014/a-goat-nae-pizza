package com.agoatnaepizza.Game.Objects;

import javax.imageio.ImageIO;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.io.File;
import java.io.IOException;

/**
 * User: nishad
 * Date: 11/10/14
 * Time: 00:03
 */
public class Chair extends Tile {
    public Chair() throws IOException, SlickException {
        super(new Image("resources/chair.bmp"), false);
    }
}
