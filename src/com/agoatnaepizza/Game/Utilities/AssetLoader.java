package com.agoatnaepizza.Game.Utilities;

import org.newdawn.slick.Image;

import java.util.HashMap;
import java.util.Map;

/**
 * User: nishad
 * Date: 16/10/14
 * Time: 10:30
 */
public class AssetLoader {
    static final Map<String, Image> pathImageMap = new HashMap<>(100);

    public static Image loadImage(String path) {
        if (!pathImageMap.containsKey(path)) {
            pathImageMap.put(path, ImageOrDefault.load(path));
        }
        return pathImageMap.get(path);
    }

}
