package com.agoatnaepizza.Game.Tiles;

import com.agoatnaepizza.Game.ImageOrDefault;
import com.agoatnaepizza.Game.Objects.Tile;

/**
 * User: nishad
 * Date: 11/10/14
 * Time: 11:16
 */
public class Wall extends Tile {
    public Wall() {
        super(ImageOrDefault.load("Resources/wall/wall_paper2.png"), true);
    }
}
