package com.agoatnaepizza.Game.Objects;

import org.newdawn.slick.Image;

/**
 * User: nishad
 * Date: 10/10/14
 * Time: 23:22
 */
public class Tile {
	
    Image tile;
	boolean wall = true;
	static int size = 10;


	public Tile(Image tile, boolean wall) {
        this.tile = tile;
        this.wall = wall;
    }
    
    public Image getTile() {
		return tile;
	}

    public static int getSize() {
		return size;
	}
}
