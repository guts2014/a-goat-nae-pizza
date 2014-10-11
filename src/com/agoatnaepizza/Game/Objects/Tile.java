package com.agoatnaepizza.Game.Objects;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

/**
 * User: nishad
 * Date: 10/10/14
 * Time: 23:22
 */
public class Tile{
	
    Image tile;
	public final boolean wall;
	static int size = 50;

	public Tile(Image tile, boolean wall) {
        this.tile = tile;
        this.wall = wall;
    }

    public void render(Graphics graphics, float x, float y) {
        graphics.drawImage(tile,x, y);
    }
    
    public Image getTile() {
		return tile;
	}

    public static int getSize() {
		return size;
	}
    
	public static void setSize(int size) {
		Tile.size = size;
	}
}
