package com.agoatnaepizza.Game.Tiles;

import com.agoatnaepizza.Game.ImageOrDefault;
import com.agoatnaepizza.Game.Objects.Tile;

/**
 * User: nishad
 * Date: 11/10/14
 * Time: 11:12
 */
public class Floor extends Tile {

    public Floor() {
        super(ImageOrDefault.load("Resources/Tile/floor50.jpg"), false);
    }
}
