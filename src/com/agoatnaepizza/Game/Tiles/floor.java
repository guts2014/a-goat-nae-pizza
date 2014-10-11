package com.agoatnaepizza.Game.Tiles;

import com.agoatnaepizza.Game.Objects.Tile;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * User: nishad
 * Date: 11/10/14
 * Time: 11:12
 */
public class Floor extends Tile{

    public Floor() throws SlickException {
        super(new Image("Resources/Tile/floor50.jpg"), false);
    }
}
