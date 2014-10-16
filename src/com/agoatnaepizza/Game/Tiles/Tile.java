package com.agoatnaepizza.Game.Tiles;

import com.agoatnaepizza.Game.GameUI.Renderable;
import com.agoatnaepizza.Game.Utilities.AssetLoader;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

/**
 * User: nishad
 * Date: 10/10/14
 * Time: 23:22
 */
public class Tile implements Renderable {
	
    Image tile;
	public final boolean impassible;
	static int size = 50;

	public Tile(String path, boolean impassible) {
        this.tile = AssetLoader.loadImage(path);
        this.impassible = impassible;
    }

    @Override
    public void render(Graphics graphics, float x, float y) {
        graphics.drawImage(tile, x, y);
    }

    @Override
    public void render(Graphics graphics, float x, float y, float dx, float dy) {
        graphics.drawImage(tile, x, y, x+dx, y+dy, 0, 0, dx, dy);
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
