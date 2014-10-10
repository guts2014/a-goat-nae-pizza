package com.agoatnaepizza.Game.Objects;

import com.agoatnaepizza.Game.Map;
import com.sun.javafx.geom.Vec2d;

/**
 * User: nishad
 * Date: 10/10/14
 * Time: 22:49
 */
public class Staff {
    private String Name;
    private Integer Happiness = 50;
    private Integer Salary = 20;
    private Skills skill = new Skills();
    private Vec2d position;

    class Skills {
        Integer calls = 5;
        Integer socialMedia = 5;
        Integer Emails = 5;
    }

    public Staff(String name, Vec2d position) {
        Name = name;
        this.position = position;
    }


    public void tick(Map map) {

    }
}
