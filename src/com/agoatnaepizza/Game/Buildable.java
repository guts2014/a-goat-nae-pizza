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

    public static final List<String> names = new ArrayList<String>() {{
        add("wall"); add("floor"); add("table"); add("phone"); add("chair"); // This is to work around an initialisation error.
    }};

    public static final java.util.Map<String, Tile> buildables = new HashMap<String, Tile>() {{
        put("wall", new Wall());
        put("floor", new Floor());
        put("table", new Table());
        put("phone", new Phone());
        put("chair", new Chair());
        System.out.println("Initialised!");
    }};
}
