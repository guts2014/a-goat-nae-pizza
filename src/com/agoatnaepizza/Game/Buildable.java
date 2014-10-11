package com.agoatnaepizza.Game;

import com.agoatnaepizza.Game.Objects.Chair;
import com.agoatnaepizza.Game.Objects.Phone;
import com.agoatnaepizza.Game.Objects.Table;
import com.agoatnaepizza.Game.Objects.Tile;
import com.agoatnaepizza.Game.Tiles.Floor;
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
            names.add("Chair"); // This is to work around an initialisation error.
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
            System.out.println("Initialised!");
        }
        return buildables;
    }

}
