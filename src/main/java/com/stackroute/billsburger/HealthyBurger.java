package com.stackroute.billsburger;

/**
 * A subclass of HealthyBurger which has the breadRollType predefined and takes in
 * only two additional items.
 */
public class HealthyBurger extends Hamburger {
    /**
     * Calls the superclass setter methods to set values of meat and price.
     * The breadRollType is constant and added with a default value.
     * @param meat Type of meat
     * @param price Price of the burger
     */
    public HealthyBurger(String meat, double price) {
        String breadRollType = "Brown rye bread roll";
        setMeat(meat);
        setPrice(price);
        setBreadRollType(breadRollType);
    }

    /**
     * Overrides the super classes method to allow only 2 additions.
     * @param item AdditionItem to be added to the additions list.
     * @return True if item is added. False if addition limit is reached.
     */
    @Override
    public boolean addItem(AdditionalItem item) {
        if (getAdditions().size() < 2) {
            getAdditions().add(item);
            return true;
        }
        return false;
    }
}
