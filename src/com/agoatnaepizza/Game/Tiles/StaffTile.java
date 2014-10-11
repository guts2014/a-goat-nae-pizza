package com.agoatnaepizza.Game.Tiles;

import com.agoatnaepizza.Game.ImageOrDefault;
import com.agoatnaepizza.Game.Objects.Tile;

/**
 * User: nishad
 * Date: 11/10/14
 * Time: 19:49
 */
public class StaffTile extends Tile {

    public StaffTile() {
        super(ImageOrDefault.load("Resources/Staff/Staff.png"), false);
    }
}
