package com.agoatnaepizza.Game.NonGameUI;

import com.agoatnaepizza.Game.Tiles.Objects.*;
import com.agoatnaepizza.Game.Tiles.Floor;
import com.agoatnaepizza.Game.Tiles.Tile;
import com.agoatnaepizza.Game.Tiles.Wall;

import java.util.*;

/**
 * User: nishad
 * Date: 11/10/14
 * Time: 15:30
 */
public class Buildable {

    public static List<String> names = null;
    public static java.util.Map<String, Tile> buildables = null;

    public static List<String> getNames() {
        if (names == null) {
            names = new ArrayList<String>();
            names.add("Wall");
            names.add("Floor");
            names.add("Table");
            names.add("Phone");
            names.add("Chair");
            names.add("Computer");
        }
        return names;
    }

    public static java.util.Map<String, Tile> getBuildables() {
        if (buildables == null) {
            buildables = new HashMap<String, Tile>();
            buildables.put("Wall", new Wall());
            buildables.put("Floor", new Floor());
            buildables.put("Table", new Table());
            buildables.put("Phone", new Phone());
            buildables.put("Chair", new Chair());
            buildables.put("Computer", new Computer());
            System.out.println("Initialised!");
        }
        return buildables;
    }

}
