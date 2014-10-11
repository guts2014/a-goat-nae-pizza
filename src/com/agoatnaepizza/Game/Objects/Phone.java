package com.agoatnaepizza.Game.Objects;

import com.agoatnaepizza.Game.ImageOrDefault;
import com.agoatnaepizza.Game.Tasks.Customer;
import com.agoatnaepizza.Game.Tasks.TaskQueue;

/**
 * User: nishad
 * Date: 10/10/14
 * Time: 23:55
 */
public class Phone extends TaskProvider {

    public static TaskQueue taskQueue = new TaskQueue();

    public Phone() {
        super(ImageOrDefault.load("Resources/Phone/phone50.png")); //TODO Implement me!!
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
