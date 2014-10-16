package com.agoatnaepizza.Game.Tiles.Objects;

import com.agoatnaepizza.Game.Tasks.Customer;
import com.agoatnaepizza.Game.Tasks.TaskQueue;

/**
 * User: nishad
 * Date: 11/10/14
 * Time: 18:09
 */
public class Computer extends TaskProvider {

    public static TaskQueue taskQueue;

    public Computer() {
        super("Resources/Computer/Computer.png");
    }

    @Override
    public void setTaskQueue(TaskQueue queue) {
        taskQueue = queue;
    }

    @Override
    public Customer getTask() {
        return taskQueue.getTask();
    }

    @Override
    public boolean hasTask() {
        return taskQueue.hasTask();
    }

    @Override
    public int waiting() {
        return taskQueue.waiting();
    }
}
