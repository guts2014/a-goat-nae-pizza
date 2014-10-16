package com.agoatnaepizza.Game.maps;

import com.agoatnaepizza.Game.Entities.Staff;
import com.agoatnaepizza.Game.Tiles.Objects.TaskProvider;
import com.agoatnaepizza.Game.Tiles.Tile;
import com.agoatnaepizza.Game.Tiles.GroundTile;
import com.agoatnaepizza.Game.maps.Atmospherics.Atmosphere;
import com.agoatnaepizza.Game.Utilities.IPredicate;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.util.pathfinding.PathFindingContext;
import org.newdawn.slick.util.pathfinding.TileBasedMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

import static java.lang.Math.sqrt;

/**
 * User: nishad
 * Date: 10/10/14
 * Time: 23:46
 */
public class Map implements TileBasedMap {
    private List<List<GroundTile>> floor;
    private List<List<List<Tile>>> objects;
    private List<List<Staff>> staff;
    Atmosphere atmosphere;

    java.util.Map<Tile, TaskProvider> taskProviders;

    public final int x, y;

	public Map(final int width, final int height, GroundTile defaultFloor, GroundTile defaultWall) {
        this.floor = new ArrayList<>(width);
        this.objects = new ArrayList<>(width);
        this.staff = new ArrayList<>(width);
        this.taskProviders = new HashMap<>();

        this.x = width;
        this.y = height;

        for (int i = 0; i < width; i++) {
            List<GroundTile> floor = new ArrayList<>(height);
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
            this.setFloor(0, i, defaultWall);
            this.setFloor(height - 1, i, defaultWall);
        }

        for (int i = 0; i < height; i++) {
            this.setFloor(i, 0, defaultWall);
            this.setFloor(i, width - 1, defaultWall);
        }

        this.atmosphere = new Atmosphere(this);
    }

    public void Tick() {
        for (int i = 0; i < this.floor.size(); i++) {
            for (int j = 0; j < this.floor.get(i).size(); j++) {

                if (this.getStaff(i, j) != null) {
                    this.getStaff(i, j).tick(this);
                }
            }
        }

        atmosphere.tick();
    }

    public PriorityQueue<Vector2f> findAllInstancesOf(IPredicate predicate) {
        PriorityQueue<Tile> out = new PriorityQueue<>();

        for (int i = 0; i < this.objects.size(); i++) {
            for (int j = 0; j < this.objects.get(i).size(); j++) {
                for (Tile tile: this.objects.get(i).get(j)) {
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
    	for (int i = 0; i < this.floor.size(); i++) {
            for (int j = 0; j < this.floor.get(i).size(); j++) {
                graphics.drawImage(this.floor.get(i).get(j).getTile(), i*size, j*size);
                
                for (Tile tile: this.objects.get(i).get(j)) {
                    graphics.drawImage(tile.getTile(), i*size, j*size);
                }
            }
        }

        for (int i = 0; i < this.floor.size(); i++) {
            for (int j = 0; j < this.floor.get(i).size(); j++) {

                if (this.staff.get(i).get(j) != null) {
                    Staff staffmember = this.staff.get(i).get(j);
                    staffmember.render(graphics, i*size, j*size);
                    graphics.drawString(staffmember.getState().toString(), i * size, j * size);
                }
            }
        }

        atmosphere.render(graphics, 0, 0);
    }

    @Override
    public int getWidthInTiles() {
        return this.floor.size();
    }

    @Override
    public int getHeightInTiles() {
        return this.floor.get(0).size();
    }

    @Override
    public void pathFinderVisited(int i, int i2) {

    }

    @Override
    public boolean blocked(PathFindingContext pathFindingContext, int i, int i2) {
        return this.floor.get(i).get(i2).impassible;
    }

    @Override
    public float getCost(PathFindingContext pathFindingContext, int i, int i2) {
        return (float) sqrt(i * i + i2 * i2);
    }

    public Staff getStaff(int x, int y) {
        return this.staff.get(x).get(y);
    }

    public void setStaff(int x, int y, Staff oneStaff) {
        this.staff.get(x).set(y, oneStaff);
    }

    public List<Tile> getObjects(int x, int y) {
        return this.objects.get(x).get(y);
    }

    public void addObject(int x, int y, Tile tile) {
        this.objects.get(x).get(y).add(tile);
    }

    public void setObject(int x, int y, List<Tile> tiles) {
        this.objects.get(x).set(y, tiles);
    }

    public Tile getFloor(int x, int y) {
        return this.floor.get(x).get(y);
    }

    public void setFloor(int x, int y, GroundTile tile) {
        this.floor.get(x).set(y, tile);
    }

}
