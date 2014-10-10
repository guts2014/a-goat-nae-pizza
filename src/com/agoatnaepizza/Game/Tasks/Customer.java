package com.agoatnaepizza.Game.Tasks;

import java.awt.*;

/**
 * User: nishad
 * Date: 10/10/14
 * Time: 23:06
 */
public class Customer {
    boolean angry = false;
    int money = 5;
    int patience = 50;

    int percentageComplete = 0;
    Image icon;

    public Customer(boolean angry, int money, int patience, int percentageComplete, Image icon) {
        this.angry = angry;
        this.money = money;
        this.patience = patience;
        this.percentageComplete = percentageComplete;
        this.icon = icon;
    }

    public void tick() {
        this.patience -= this.angry? 5 : 1;
    }
}


