package com.agoatnaepizza.Game.Objects;

import java.awt.*;

/**
 * User: nishad
 * Date: 10/10/14
 * Time: 23:22
 */
public class Tile {
    Image tile;
    boolean wall = true;

    public Tile(Image tile, boolean wall) {
        this.tile = tile;
        this.wall = wall;
    }
}
