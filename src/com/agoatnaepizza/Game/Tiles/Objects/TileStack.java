package com.agoatnaepizza.Game.Tiles.Objects;


import com.agoatnaepizza.Game.Tiles.Tile;

import java.util.ArrayList;
import java.util.List;

/**
 * User: nishad
 * Date: 11/10/14
 * Time: 01:00
 */
public class TileStack extends Tile {
    private List<Tile> stack;

    public TileStack(List<Tile> stack) {
        super(null, false);
        this.stack = new ArrayList<>(stack);
    }


}
