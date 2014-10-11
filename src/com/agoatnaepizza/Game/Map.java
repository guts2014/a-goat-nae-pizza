package com.agoatnaepizza.Game;

import com.agoatnaepizza.Game.Objects.Tile;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;
import java.util.List;

/**
 * User: nishad
 * Date: 10/10/14
 * Time: 23:46
 */
public class Map {
    List<List<Tile>> floor;
    List<List<List<Tile>>> objects;


	public Map(final int width, final int height, Tile defaultFloor, Tile defaultWall) {
        this.floor = new ArrayList<>(width);
        this.objects = new ArrayList<>(width);

        for (int i = 0; i < width; i++) {
            List<Tile> floor = new ArrayList<>(height);
            List<List<Tile>> objects = new ArrayList<>(height);

            for (int j = 0; j < height; j++) {
                floor.add(defaultFloor);
                objects.add(new ArrayList<Tile>(1));
            }

            this.floor.add(floor);
            this.objects.add(objects);
        }

        for (int i = 0; i < width; i++) {
            this.floor.get(0).set(i, defaultWall);
            this.floor.get(this.floor.size() - 1).set(i, defaultWall);
        }

        for (int i = 0; i < height; i++) {
            this.floor.get(i).set(0, defaultWall);
            this.floor.get(i).set(this.floor.get(i).size() - 1, defaultWall);
        }
    }
    
    public void render(Graphics graphics) {
    	
    	int size = Tile.getSize();
    	
    	//render floor
    	for (int i = 0; i < floor.size(); i++) {
            for (int j = 0; j < floor.get(i).size(); j++) {
                graphics.drawImage(floor.get(i).get(j).getTile(), i*size, j*size);
                
                for (Tile tile: objects.get(i).get(j)) {
                    graphics.drawImage(tile.getTile(), i*size, j*size);
                }
            }
        }
    }
    
	public List<List<List<Tile>>> getObjects() {
		return objects;
	}
    
}
