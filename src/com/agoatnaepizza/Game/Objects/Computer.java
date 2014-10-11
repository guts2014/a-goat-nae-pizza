package com.agoatnaepizza.Game.Objects;

import com.agoatnaepizza.Game.ImageOrDefault;
import com.agoatnaepizza.Game.Tasks.Customer;
import com.agoatnaepizza.Game.Tasks.TaskQueue;

/**
 * User: nishad
 * Date: 11/10/14
 * Time: 18:09
 */
public class Computer extends TaskProvider {
    static TaskQueue taskQueue;

    public Computer() {
        super(ImageOrDefault.load("Resources/Computer/Computer.bmp"));
        taskQueue = new TaskQueue();
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
}
