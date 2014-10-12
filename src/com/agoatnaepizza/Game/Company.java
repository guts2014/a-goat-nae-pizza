package com.agoatnaepizza.Game;

import static java.lang.Math.max;

/**
 * User: nishad
 * Date: 11/10/14
 * Time: 19:03
 */
public class Company {

    public static final Company company = new Company();

    int Money = 1000;
    int rent = 1;
    int reputation = 0;

    void tick() {
        Money -= rent;
    }

    public void addMoney(int money) {
        this.Money += money;
    }

    public int getMoney() {
        return this.Money;
    }

    public int getReputation() {
        return reputation;
    }

    public void adjustReputation(int amount) {
        reputation = max(-100, reputation + amount);
    }
}
