package com.agoatnaepizza.Game.Objects;

import org.newdawn.slick.geom.Vector2f;

import com.agoatnaepizza.Game.Map;

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
    private Vector2f position;
    private boolean available; 
    private TaskProvider currentTask; 

    class Skills {
        Integer calls = 5;
        Integer socialMedia = 5;
        Integer Emails = 5;
    }

    public Staff(String name, Vector2f position) {
        Name = name;
        this.position = position;
        this.available = true; 
    }

    //provisional 
    public void tick(Map map) {
    	if(available){ 
    		currentTask = new TaskProvider(null, null) //change 
    		int persentage = TaskProvider.taskQueue.deque().getPersentage();  //change 
    		while(persentage < 100){
    			if(persentage%10 == 0){ 
    				if (Customer is angry){ 
    					
    				}
    			}
    		}
    		
    		
    	}

    }
}
