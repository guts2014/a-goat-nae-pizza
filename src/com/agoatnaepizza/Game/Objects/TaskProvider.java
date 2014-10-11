package com.agoatnaepizza.Game.Objects;

import com.agoatnaepizza.Game.Tasks.TaskQueue;

import java.awt.*;

/**
 * User: nishad
 * Date: 10/10/14
 * Time: 23:52
 */
public class TaskProvider extends Tile {
    TaskQueue taskQueue;

    public TaskProvider(org.newdawn.slick.Image tile, TaskQueue queue) {
        super(tile, false);
        this.taskQueue = queue;
    }
}
