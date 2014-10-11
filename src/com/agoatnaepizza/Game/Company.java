package com.agoatnaepizza.Game;

/**
 * User: nishad
 * Date: 11/10/14
 * Time: 19:03
 */
public class Company {

    public static final Company company = new Company();

    int Money = 1000;
    int rent = 1;

    void tick() {
        Money -= rent;
    }

    public void addMoney(int money) {
        this.Money += money;
    }

    public int getMoney() {
        return this.Money;
    }
}
