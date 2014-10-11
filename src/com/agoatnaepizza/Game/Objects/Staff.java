package com.agoatnaepizza.Game.Objects;

import com.agoatnaepizza.Game.Map;
import com.agoatnaepizza.Game.Tasks.Customer;
import com.agoatnaepizza.Game.Tasks.TaskQueue;
import org.newdawn.slick.geom.Vector2f;

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
    private int experience = 1; 
    private boolean available; 
    private Customer currentTask;


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
    		currentTask = TaskQueue.getRandomCustomer(); //change
    		int percentage = currentTask.getPercentageComplete();  //change

    		while(percentage < 100){
    			if(percentage % 10 == 0){
    				if (currentTask.isAngry()){
    					
    				}
    				//depending on type of task(phone,email,social) 
    				percentage += 100/15;
    			}
    		}
    		
    		
    	}

    }
}
