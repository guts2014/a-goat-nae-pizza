package com.agoatnaepizza.Game.Tasks;

import java.awt.Image;
import java.util.Random;

import com.agoatnaepizza.Game.Tasks.Customer.CustomerType;

/**
 * User: nishad
 * Date: 10/10/14
 * Time: 23:53
 */
public class TaskQueue {	
	ArrayQueue emailQue;
	ArrayQueue callQue;
	ArrayQueue socialQue;
	
	int calltime=15;
	int emailtime=10;
	int socialtime=5;
	public TaskQueue() throws InterruptedException{
		Customer newCustomer=getRandomCustomer();
		//get 1000 different customers
		for(int i=0;i<1000;i++){
			if(newCustomer.getType()==CustomerType.call) callQue.enqueue(newCustomer);
			else if(newCustomer.getType()==CustomerType.email) emailQue.enqueue(newCustomer);
			else if(newCustomer.getType()==CustomerType.soc) socialQue.enqueue(newCustomer);
			newCustomer=getRandomCustomer();
		}
	}
	
	
	//mplement random customers CustomerType type, boolean angry, int money, int patience, Image icon
	
	public Customer getRandomCustomer(){
		//generating random customer
		int pick = new Random().nextInt(CustomerType.values().length);
	    CustomerType cusT= CustomerType.values()[pick];
	    //Random randVal=
	    //creating a customer with random values 
	    //money range=5-100
	    //patience range=5-100
		Customer newCustomer=new Customer(cusT, new Random().nextBoolean(), new Random().nextInt(95)+5,
				new Random().nextInt(95)+5, null);
		if(newCustomer.isAngry()) newCustomer.setPatience(0);
		
		return newCustomer;
		
	}
}
