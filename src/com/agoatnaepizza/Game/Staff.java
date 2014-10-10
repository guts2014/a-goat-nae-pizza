package com.agoatnaepizza.Game;

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



    class Skills {
        Integer calls = 5;
        Integer socialMedia = 5;
        Integer Emails = 5;
    }
}
