package com.agoatnaepizza.Game.Tasks;

import java.util.ArrayDeque;

import com.agoatnaepizza.Game.Tasks.Customer.CustomerType;

/**
 * User: nishad
 * Date: 10/10/14
 * Time: 23:53
 */
public class TaskQueue {	
	ArrayDeque emailQue;
	ArrayDeque callQue;
	ArrayDeque socialQue;
	
	int calltime=15;
	int emailtime=10;
	int socialtime=5;
	public TaskQueue(){
		
	}
	
	
	//implement random customers
	public Customer getRandomEmailCustomer(){
		Customer newCustomer=new Customer(CustomerType.email, false, calltime, calltime, calltime, null);
		return null;
		
	}
	public Customer getRandomCallCustomer(){
		Customer newCustomer=new Customer(CustomerType.call, false, calltime, calltime, calltime, null);
		return null;
		
	}
	public Customer getRandomSocCustomer(){
		Customer newCustomer=new Customer(CustomerType.soc, false, calltime, calltime, calltime, null);
		return null;
		
	}
}
