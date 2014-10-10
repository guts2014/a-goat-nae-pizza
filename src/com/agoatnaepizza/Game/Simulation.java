package com.agoatnaepizza.Game;

import com.agoatnaepizza.Game.Objects.Staff;
import com.agoatnaepizza.Game.Objects.Tile;

import java.util.ArrayList;
import java.util.List;

/**
 * User: nishad
 * Date: 10/10/14
 * Time: 23:29
 */
public class Simulation {
    Map map;
    List<Staff> staff;

    public Simulation(final int width, final int height, Tile defaultFloor, Tile defaultWall) {
        this.map = new Map(width, height, defaultFloor, defaultWall);
        this.staff = new ArrayList<>(10);
    }

    public void tick() {

    }
}
