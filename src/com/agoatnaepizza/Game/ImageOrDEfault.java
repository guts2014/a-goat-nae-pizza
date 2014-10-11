package com.agoatnaepizza.Game;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * User: nishad
 * Date: 11/10/14
 * Time: 15:40
 */
public class ImageOrDefault {
    static Image defaultImage = null;

    static {

    }

    public static Image load(String path) {
        if (defaultImage == null) {
            try {
                defaultImage = new Image("Resources/Wall/wall_paper2.png");
            } catch (SlickException e) {
                e.printStackTrace();
                return null; // Probably not the best idea to add a poison pill here.
            }
        } else {
            try {
                return new Image(path);
            } catch (SlickException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Couldn't Load:"+path);
        return defaultImage;
    }
}
