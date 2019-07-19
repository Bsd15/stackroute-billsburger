package com.stackroute.billsburger;

public class DeluxeBurger extends Hamburger {
    public DeluxeBurger(String breadRollType, String meat, double price) {
        super(breadRollType, meat, price);
        getAdditions().add(new AdditionalItem("Chips", 0));
        getAdditions().add(new AdditionalItem("Coke", 0));
    }

    @Override
    public boolean addItem(AdditionalItem item) {
        return false;
    }
}
