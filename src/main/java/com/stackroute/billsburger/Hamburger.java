package com.stackroute.billsburger;

import java.util.ArrayList;
import java.util.List;

public class Hamburger {
    private int id;
    private String nameOfBurger;
    private String breadRollType;
    private String meat;
    private List<AdditionalItem> additions;
    private double price;

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

    public boolean addItem(AdditionalItem item) {
        if (getAdditions().size() <= 4) {
            getAdditions().add(item);
            return true;
        }
        return false;
    }

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

    public double getTotalCost() {
        double totalCost = price;
        for (AdditionalItem addition : additions) {
            totalCost += addition.getPriceOfTheAddOn();
        }
        return totalCost;
    }
}
