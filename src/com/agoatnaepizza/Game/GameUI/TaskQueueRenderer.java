package com.agoatnaepizza.Game.GameUI;

import com.agoatnaepizza.Game.Tasks.Customer;
import com.agoatnaepizza.Game.Tasks.TaskQueue;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import java.util.HashMap;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * User: nishad
 * Date: 12/10/14
 * Time: 15:24
 */
public class TaskQueueRenderer {
    java.util.Map<String, TaskQueue> taskQueues;

    public TaskQueueRenderer() {
        this.taskQueues = new HashMap<>();
    }

    public void addTasks(String name, TaskQueue queue) {
        taskQueues.put(name, queue);
    }

    public void render(Graphics graphics, int xOffset, int yOffset, int height, int width) {
        int iconSize = 15;
        int maxIconCount = width / iconSize;

        int i = 0;
        for (String queueName: taskQueues.keySet()) {
            TaskQueue queue = taskQueues.get(queueName);
            int j = 0;
            for (Customer task: queue) {

                if (j > maxIconCount) break;

                graphics.setColor(new Color(
                   (float) (1.0 - max(0, min(1, task.getPatience() / 100.))),
                   (float) task.getWorkDone() / task.getWorkNeeded(),
                   (float) 1.,
                   (float) 0.5
                ));
                graphics.drawOval(xOffset + iconSize * j, yOffset + iconSize * i, iconSize, iconSize);
                j++;
            }

            graphics.setColor(new Color(0,0,0));
            graphics.drawString(queueName+" "+queue.getWaitingCount()+"/"+queue.getTotalHandeled(), xOffset + iconSize * j, yOffset + iconSize * i);
            i++;
        }
    }


}
