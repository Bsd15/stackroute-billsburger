package com.stackroute.billsburger;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderNumber;
    private List<Hamburger> hamburgersList = new ArrayList<>();

    Order(int orderNo){
        this.orderNumber = orderNo;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public List<Hamburger> getHamburgersList() {
        return hamburgersList;
    }

    public void addBurger(Hamburger hamburger){
        hamburgersList.add(hamburger);
    }

    public double getTotalCost(){
        double totalCost = 0;
        for (Hamburger hamburger: hamburgersList){
            totalCost += hamburger.getTotalCost();
        }
        return totalCost;
    }
}
