package com.agoatnaepizza.Game;

import com.agoatnaepizza.Game.Objects.Staff;
import com.agoatnaepizza.Game.Objects.Tile;
import com.agoatnaepizza.IPredicate;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.util.pathfinding.PathFindingContext;
import org.newdawn.slick.util.pathfinding.TileBasedMap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import static java.lang.Math.sqrt;

/**
 * User: nishad
 * Date: 10/10/14
 * Time: 23:46
 */
public class Map implements TileBasedMap {
    List<List<Tile>> floor;
    List<List<List<Tile>>> objects;
    List<List<Staff>> staff;

	public Map(final int width, final int height, Tile defaultFloor, Tile defaultWall) {
        this.floor = new ArrayList<>(width);
        this.objects = new ArrayList<>(width);
        this.staff = new ArrayList<>(width);

        for (int i = 0; i < width; i++) {
            List<Tile> floor = new ArrayList<>(height);
            List<List<Tile>> objects = new ArrayList<>(height);
            List<Staff> staff = new ArrayList<>(height);

            for (int j = 0; j < height; j++) {
                floor.add(defaultFloor);
                objects.add(new ArrayList<Tile>(1));
                staff.add(null);
            }

            this.floor.add(floor);
            this.objects.add(objects);
            this.staff.add(staff);
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

    public PriorityQueue<Vector2f> findAllInstancesOf(IPredicate predicate) {
        PriorityQueue<Tile> out = new PriorityQueue<>();

        for (int i = 0; i < objects.size(); i++) {
            for (int j = 0; j < objects.get(i).size(); j++) {
                for (Tile tile: objects.get(i).get(j)) {
                    if (predicate.apply(tile)) {
                        out.add(tile);
                    }
                }
            }
        }

        return null; //TODO implement if needed.
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

                if (staff.get(i).get(j) != null) {
                    graphics.drawImage(staff.get(i).get(j).getTile().getTile(), i * size, j * size);
                }
            }
        }
    }
    
	public List<List<List<Tile>>> getObjects() {
		return objects;
	}

    @Override
    public int getWidthInTiles() {
        return floor.size();
    }

    @Override
    public int getHeightInTiles() {
        return floor.get(0).size();
    }

    @Override
    public void pathFinderVisited(int i, int i2) {

    }

    @Override
    public boolean blocked(PathFindingContext pathFindingContext, int i, int i2) {
        return floor.get(i).get(i2).wall;
    }

    @Override
    public float getCost(PathFindingContext pathFindingContext, int i, int i2) {
        return (float) sqrt(i * i + i2 * i2);
    }

    public Staff getStaff(int x, int y) {
        return staff.get(x).get(y);
    }

    public void setStaff(int x, int y, Staff oneStaff) {
        this.staff.get(x).set(y, oneStaff);
    }
}
