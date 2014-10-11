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

    public Customer(CustomerType type, boolean angry, int money, int patience, int percentageComplete, Image icon) {
        this.type = type;
        this.angry = angry;
        this.money = money;
        this.patience = patience;
        this.percentageComplete = percentageComplete;
        this.icon = icon;
        this.waiting = true;
    }

    public void answer() {
        this.waiting = false;
    }

    public void tick() {
        if (!waiting) {
            this.patience -= this.angry ? 5 : 1;
        }
    }
}


