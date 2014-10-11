package com.agoatnaepizza.Game;

import com.agoatnaepizza.Game.Objects.Chair;
import com.agoatnaepizza.Game.Objects.Phone;
import com.agoatnaepizza.Game.Objects.Table;
import com.agoatnaepizza.Game.Objects.Tile;
import com.agoatnaepizza.Game.Tiles.Floor;
import com.agoatnaepizza.Game.Tiles.Wall;

/**
 * User: nishad
 * Date: 11/10/14
 * Time: 15:30
 */
public enum Buildable {
    wall("wall", new Wall()),
    floor("floor", new Floor()),
    table("table", new Table()),
    phone("phone", new Phone()),
    chair("chair", new Chair()),;

    private final String name;
    private final Tile tile;

    Buildable(String name, Tile tile) {
        this.name = name;
        this.tile = tile;
    }

}
