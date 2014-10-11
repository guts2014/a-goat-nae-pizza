package com.agoatnaepizza.Game.Objects;

import com.agoatnaepizza.Game.Tasks.Customer;
import com.agoatnaepizza.Game.Tasks.TaskQueue;
import org.newdawn.slick.Image;

/**
 * User: nishad
 * Date: 10/10/14
 * Time: 23:52
 */
public class TaskProvider extends Tile { 
	static TaskQueue taskQueue;

    public TaskProvider(Image tile) {
        super(tile, false);
        taskQueue = new TaskQueue();
    }

    public Customer getTask() {
        return taskQueue.getTask();
    }
   
}
