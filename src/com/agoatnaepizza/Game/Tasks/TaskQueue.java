package com.agoatnaepizza.Game.Tasks;

import com.agoatnaepizza.Game.Company;
import com.agoatnaepizza.Game.Tasks.Customer.CustomerType;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import static java.lang.Math.max;

/**
 * User: nishad
 * Date: 10/10/14
 * Time: 23:53
 */
public class TaskQueue {	
	private Queue<Customer> queue;

	public TaskQueue() {
        this.queue = new LinkedList<>();
	}
	
	
	//mplement random customers CustomerType type, boolean angry, int money, int patience, Image icon
	
	public static Customer getRandomCustomer(){
		//generating random customer
		int pick = new Random().nextInt(CustomerType.values().length);
	    CustomerType cusT = CustomerType.values()[pick];

	    //Random randVal=
	    //creating a customer with random values 
	    //money range=5-100
	    //patience range=5-100

        return new Customer(
            cusT,
            new Random().nextBoolean(),
            new Random().nextInt(100)+5,
            new Random().nextInt(100)+5, null
        );
	}

    public void tick() {
        Random r = new Random();
        if (r.nextFloat() * Math.log10(max(10, Company.company.getReputation())) >= 0.99 && queue.size() < 100) {
            queue.add(getRandomCustomer());
        }

        for (Customer c: queue) {
            c.waitingTick();
        }
    }

    public Customer getTask() {
        return queue.element();
    }

    public boolean hasTask() {
        return !queue.isEmpty();
    }

    public int waiting() {
        return queue.size();
    }
}
