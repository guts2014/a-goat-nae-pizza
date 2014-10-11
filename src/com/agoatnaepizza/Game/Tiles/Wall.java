package com.agoatnaepizza.Game.Tiles;

import com.agoatnaepizza.Game.Objects.Tile;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * User: nishad
 * Date: 11/10/14
 * Time: 11:16
 */
public class Wall extends Tile {
    public Wall() throws SlickException {
        super(new Image("Resources/wall/wall_paper.png"), true);
    }
}
