package com.agoatnaepizza.Game.Objects;

import com.agoatnaepizza.Game.Company;
import com.agoatnaepizza.Game.Map;
import com.agoatnaepizza.Game.Tasks.Customer;
import com.agoatnaepizza.Game.Tiles.StaffTile;
import org.newdawn.slick.geom.Vector2f;

import java.util.List;
import java.util.Random;

/**
 * User: nishad
 * Date: 10/10/14
 * Time: 22:49
 */
public class Staff {
    private String Name;
    private Integer Salary = 20;
    private Skills skill = new Skills();
    private Vector2f position;
    private int experience = 1; 
    private States state;
    private Customer currentTask;
    private State condition;
    private Tile tile;

    Random r = new Random();

    class Skills {
        Integer calls = 5;
        Integer socialMedia = 5;
        Integer Emails = 5;
    }

    class State {
        Integer energy = 100;
        Integer happiness = 100;
    }

    public Staff(String name, Vector2f position) {
        Name = name;
        this.position = position;
        this.state = States.LookingForWork;
        this.condition = new State();
        this.tile = new StaffTile();
    }

    //provisional 
    public void tick(Map map) {
        switch (state) {
            case LookingForWork:

                if (condition.energy <= 0) {
                    state = States.Idle;
                }

                List<Tile> stack = map.getObjects().get((int) position.x).get((int) position.y);
                for (Tile tile: stack) {
                    if (tile instanceof Chair) {
                        for (int i = -1; i <= 1; i++) {
                            for (int j = -1; j <= 1; j++ ){
                                for (Tile adjacent: map.getObjects().get(i).get(j)) {
                                    if (adjacent instanceof TaskProvider) {
                                        TaskProvider provider = (TaskProvider) adjacent;
                                        if (provider.hasTask()) {
                                            currentTask = provider.getTask();
                                            state = States.handlingTask;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            case Idle:
                condition.energy += 5;

                if (condition.energy >= 100) {
                    state = States.LookingForWork;
                }
            case Moving:
                break;
            case Sitting:
                break;
            case handlingTask:
                currentTask.tick(condition.happiness, experience);
                experience += (r.nextInt(10) > 7)? 1:0;

                if (currentTask.getPercentageComplete() >= 100) {
                    if (currentTask.getPatience() > 0) {
                        Company.company.addMoney(currentTask.getMoney());
                    }
                    state = States.LookingForWork;
                }
        }

    }

    public enum States {
        handlingTask, Moving, Sitting, Idle, LookingForWork
    }

    public Tile getTile() {
        return tile;
    }

    public String getName() {
        return Name;
    }

    public States getState() {
        return state;
    }
}
