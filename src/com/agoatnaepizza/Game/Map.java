package com.agoatnaepizza.Game;

import com.agoatnaepizza.Game.Objects.Tile;

import java.util.ArrayList;
import java.util.List;

/**
 * User: nishad
 * Date: 10/10/14
 * Time: 23:46
 */
public class Map {
    List<List<Tile>> floor;
    List<List<Tile>> objects;

    public Map(final int width, final int height, Tile defaultFloor, Tile defaultWall) {
        this.floor = new ArrayList<>(width);
        this.objects = new ArrayList<>(width);

        for (int i = 0; 0 < width; i++) {
            List<Tile> floor = new ArrayList<Tile>(height);
            for (int j = 0; j < height; j++) {
                floor.add(defaultFloor);
            }
            this.floor.add(floor);
            objects.add(new ArrayList<Tile>(height));
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
}