package com.stackroute.billsburger;

/**
 * A subclass of Hamburger which has two additions included while creating and does not
 * take any additions.
 */
public class DeluxeBurger extends Hamburger {
    public DeluxeBurger(String breadRollType, String meat, double price) {
        super(breadRollType, meat, price);
        getAdditions().add(new AdditionalItem("Chips", 0));
        getAdditions().add(new AdditionalItem("Coke", 0));
    }

    /**
     * Overrides the parent's addItem method to always return false and to prevent
     * any new addtions to the additionsList.
     * @param item AdditionItem to be added to the additions list.
     * @return False by default as this class does not take any additions.
     */
    @Override
    public boolean addItem(AdditionalItem item) {
        return false;
    }
}
