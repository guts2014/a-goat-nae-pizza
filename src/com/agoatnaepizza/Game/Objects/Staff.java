package com.agoatnaepizza.Game.Objects;

import org.newdawn.slick.geom.Vector2f;

import com.agoatnaepizza.Game.Map;

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
    private Vector2f position;

    class Skills {
        Integer calls = 5;
        Integer socialMedia = 5;
        Integer Emails = 5;
    }

    public Staff(String name, Vector2f position) {
        Name = name;
        this.position = position;
    }


    public void tick(Map map) {

    }
}
