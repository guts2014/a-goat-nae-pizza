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
            names.add("wall");
            names.add("floor");
            names.add("table");
            names.add("phone");
            names.add("chair"); // This is to work around an initialisation error.
        }
        return names;
    }

    public static java.util.Map<String, Tile> getBuildables() {
        if (buildables == null) {
            buildables = new HashMap<String, Tile>();
            buildables.put("wall", new Wall());
            buildables.put("floor", new Floor());
            buildables.put("table", new Table());
            buildables.put("phone", new Phone());
            buildables.put("chair", new Chair());
            System.out.println("Initialised!");
        }
        return buildables;
    }

}
