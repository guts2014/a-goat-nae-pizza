package com.agoatnaepizza.Game.Tasks;

import java.awt.*;

/**
 * User: nishad
 * Date: 10/10/14
 * Time: 23:06
 */
public class Customer {

    CustomerType type;

    boolean angry = false;
    int money = 5;
    int patience = 50;

    int percentageComplete = 0;
    Image icon;

    boolean waiting;

    enum CustomerType {
        call, email, soc
    }

    public Customer(CustomerType type, boolean angry, int money, int patience, Image icon) {
        this.type = type;
        this.angry = angry;
        this.money = money;
        this.patience = patience;
//        this.percentageComplete = percentageComplete;
        this.icon = icon;
        this.waiting = true;
    }
    
    
	public void answer() {
        this.waiting = false;
    }

    public void tick(int EmployeeHappiness, int StaffExperience) {
        this.patience -= (this.angry ? 5 : 1) * ((EmployeeHappiness > 50)? -1 : 1);
        this.percentageComplete += StaffExperience / ((StaffExperience > 10)? 3 : 6);
    }

    public void waitingTick() {
        this.patience -= 1;
    }
    
    //GETTERS AND SETTERS	

    public CustomerType getType() {
		return type;
	}

	public void setType(CustomerType type) {
		this.type = type;
	}

	public boolean isAngry() {
		return angry;
	}

	public void setAngry(boolean angry) {
		this.angry = angry;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getPatience() {
		return patience;
	}

	public void setPatience(int patience) {
		this.patience = patience;
	}

	public int getPercentageComplete() {
		return percentageComplete;
	}

	public void setPercentageComplete(int percentageComplete) {
		this.percentageComplete = percentageComplete;
	}


    
    
}


