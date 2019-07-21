package com.stackroute.billsburger;

import java.util.ArrayList;
import java.util.List;

/**
 * An order class that is used to store all the orders made by the customer.
 * It consists of a orderList which consists of all the hamburger that a customer
 * orders.
 */
public class Order {
//    ID
    private int orderNumber;
//    List to store burgers
    private List<Hamburger> hamburgersList = new ArrayList<>();

    /**
     * @param orderNo Order ID which is used to identify the order.
     */
    Order(int orderNo){
        this.orderNumber = orderNo;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public List<Hamburger> getHamburgersList() {
        return hamburgersList;
    }

    /**
     * Adds a given burger to the order.
     * @param hamburger Add the burger to the hamburgersList.
     */
    void addBurger(Hamburger hamburger){
        hamburgersList.add(hamburger);
    }

    /**
     * Display the price of the burger in detail including the price of the
     * additions added to the burgers.
     */
    protected void showOrderDetails() {
        System.out.println("-------- Order " + getOrderNumber() + " --------");
        for (Hamburger burger : hamburgersList) {
            System.out.println("------------------------");
            System.out.println("Name:\t" + burger.getNameOfBurger());
            System.out.println("------------------------");
            System.out.println("Details:");
            burger.getCostDetails();
        }
        System.out.println("------------------------");
        System.out.println("Total order cost:\t" + getTotalCost());
        System.out.println("-------------------------------------------------");
    }

    /**
     * @return Total cost of all the burgers in the hamburgersList
     */
    public double getTotalCost(){
        double totalCost = 0;
        for (Hamburger hamburger: hamburgersList){
            totalCost += hamburger.getTotalCost();
        }
        return totalCost;
    }
}
