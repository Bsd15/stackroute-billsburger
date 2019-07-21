package com.stackroute.billsburger;

import java.util.ArrayList;
import java.util.List;

/**
 * Hamburger class which is created for the customer on request.
 */
public class Hamburger {
//    Id of the burger
    private int id;
//    Name of the burger
    private String nameOfBurger;
    private String breadRollType;
    private String meat;
//    List object used to store additions to the burger.
    private List<AdditionalItem> additions;
    private double price;

    /**
     * Constructor which takes no parameter used by sub classes.
     */
    public Hamburger() {
        additions = new ArrayList<>();
    }

    /**
     * @param breadRollType Bread roll type
     * @param meat Meat type
     * @param price price of the burger
     */
    public Hamburger(String breadRollType, String meat, double price) {
        this.breadRollType = breadRollType;
        this.meat = meat;
        this.price = price;
        additions = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfBurger() {
        return nameOfBurger;
    }

    public void setNameOfBurger(String nameOfBurger) {
        this.nameOfBurger = nameOfBurger;
    }

    public String getBreadRollType() {
        return breadRollType;
    }

    public void setBreadRollType(String breadRollType) {
        this.breadRollType = breadRollType;
    }

    public String getMeat() {
        return meat;
    }

    public void setMeat(String meat) {
        this.meat = meat;
    }

    public List<AdditionalItem> getAdditions() {
        return additions;
    }

    public void setAdditions(List<AdditionalItem> additions) {
        this.additions = additions;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Check if the limit of additions is reached or not and if not adds the given
     * addition to the additions list.
     * @param item AdditionItem to be added to the additions list.
     * @return True if added successfully. False if limit of additions has been reached.
     *
     */
    public boolean addItem(AdditionalItem item) {
        if (getAdditions().size() < 4) {
            getAdditions().add(item);
            return true;
        }
        return false;
    }

    /**
     * Displays the detailed cost of the burger by looping through the
     * additions list and displaying their cost as well. In the end, display's the
     * total cost of the burger.
     */
    public void getCostDetails() {
        System.out.println("Base price: " + getPrice());
        if (!getAdditions().isEmpty()) {
            System.out.println("Additional Item -- Price");
            for (AdditionalItem addition : additions) {
                System.out.println(addition.getNameOfTheAddOn() + " -- " + addition.getPriceOfTheAddOn());
            }
        }
        System.out.println("Total Price : " + getTotalCost());
    }

    /**
     * Get the total cost of the burger i.e. base price + cost of all the additions in
     * the additions list.
     * @return Total cost of the burger
     */
    public double getTotalCost() {
        double totalCost = price;
        for (AdditionalItem addition : additions) {
            totalCost += addition.getPriceOfTheAddOn();
        }
        return totalCost;
    }
}
