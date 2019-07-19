package com.stackroute.billsburger;

public class HealthyBurger extends Hamburger {
    public HealthyBurger(String meat, double price) {
        String breadRollType = "Brown rye bread roll";
        setMeat(meat);
        setPrice(price);
        setBreadRollType(breadRollType);
    }

    public boolean addItem(AdditionalItem item) {
        if (getAdditions().size() <= 2) {
            getAdditions().add(item);
            return true;
        }
        return false;
    }
}
