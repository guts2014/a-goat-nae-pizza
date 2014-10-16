package com.agoatnaepizza.Game.Entities;

import com.agoatnaepizza.Game.Company;
import com.agoatnaepizza.Game.GameUI.Renderable;
import com.agoatnaepizza.Game.Tasks.Customer;
import com.agoatnaepizza.Game.Tiles.Objects.Chair;
import com.agoatnaepizza.Game.Tiles.Objects.TaskProvider;
import com.agoatnaepizza.Game.Tiles.StaffTile;
import com.agoatnaepizza.Game.Tiles.Tile;
import com.agoatnaepizza.Game.maps.Map;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;

import java.util.List;
import java.util.Random;

import static java.lang.Math.max;

/**
 * User: nishad
 * Date: 10/10/14
 * Time: 22:49
 */
public class Staff implements Renderable {
    private String Name;
    private Integer Salary = 20;
    private Skills skill = new Skills();
    private Vector2f position;
    private int experience = 1; 
    private States state;
    private Customer currentTask;
    private State condition;
    private Tile tile;

    private static int SimTick = 0;
    private static final int SalaryTickRate = 30;
    private static final int WorkRate = 6;

    Random r = new Random();

    @Override
    public void render(Graphics graphics, float x, float y) {
        tile.render(graphics, x, y);
    }

    @Override
    public void render(Graphics graphics, float x, float y, float dx, float dy) {
        tile.render(graphics, x, y, dx, dy);
    }

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
        SimTick += 1;

        if (SimTick % SalaryTickRate == 0) {
            Company.company.addMoney(-Salary);
        }

        switch (state) {
            case handlingTask:

                if (currentTask != null) {

                    currentTask.tick(condition.happiness, experience);

                    if (SimTick % WorkRate == 0) {
                        experience += (r.nextInt(10) > 7) ? 1 : 0;
                    }

                    condition.energy -= 1;

                    currentTask.adjustPatience(-1);

                    currentTask.doWork((int) Math.log10(max(10, experience)));

                    if (currentTask.isDone()) {

                        if (currentTask.getPatience() > 0) {
                            Company.company.addMoney(currentTask.getMoney());
                            Company.company.adjustReputation((int) Math.log10(Math.abs(currentTask.getPatience())));
                        } else {
                            Company.company.adjustReputation((int) -Math.log10(Math.abs(currentTask.getPatience())));
                        }

                        currentTask = null;
                        System.out.print(" WORK DONE ");

                    }
                } else {
                    state = States.LookingForWork;
                }
                break;
            case Moving:
                break;
            case Sitting:
                break;
            case Idle:
                condition.energy += 1;

                if (condition.energy >= 300) {
                    state = States.LookingForWork;
                }
            case LookingForWork:
            case waitingForWork:

                if (condition.energy <= 50) {
                    state = States.Idle;
                }


                int px = (int) position.x;
                int py = (int) position.y;

                List<Tile> stack = map.getObjects(px, py);
                for (Tile tile: stack) {
                    if (tile instanceof Chair) {
                        for (int i = -1; i <= 1; i++) {
                            for (int j = -1; j <= 1; j++ ){
                                for (Tile adjacent: map.getObjects(px+i, py+j)) {
                                    if (adjacent instanceof TaskProvider) {
                                        state = States.waitingForWork;
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


        }
    }

    public enum States {
        handlingTask, Moving, Sitting, Idle, LookingForWork, waitingForWork
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
