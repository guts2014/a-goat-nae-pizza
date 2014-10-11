package com.agoatnaepizza.Game.Objects;

import com.agoatnaepizza.Game.ImageOrDefault;

/**
 * User: nishad
 * Date: 11/10/14
 * Time: 00:03
 */
public class Chair extends Tile {

    static {

    }

    public Chair() {
        super(ImageOrDefault.load("resources/chair.bmp"), false);
    }
}
