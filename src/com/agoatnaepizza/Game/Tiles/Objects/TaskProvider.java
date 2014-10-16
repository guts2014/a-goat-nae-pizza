package com.agoatnaepizza.Game.Tiles.Objects;

import com.agoatnaepizza.Game.Tasks.Customer;
import com.agoatnaepizza.Game.Tasks.TaskQueue;
import com.agoatnaepizza.Game.Tiles.Tile;

/**
 * User: nishad
 * Date: 10/10/14
 * Time: 23:52
 */
public abstract class TaskProvider extends Tile {

    public TaskProvider(String tile) {
        super(tile, false);
    }

    public abstract void setTaskQueue(TaskQueue queue);
    public abstract Customer getTask();
    public abstract boolean hasTask();
    public abstract int waiting();
}
