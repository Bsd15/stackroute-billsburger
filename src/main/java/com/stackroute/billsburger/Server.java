package com.stackroute.billsburger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Server class takes the request of the customers and stores them in a list
 * so that customers can view their order details or can add more burgers to their
 * orders
 */
public class Server {
//    Scanner to take input from the user
    private final Scanner scanner;
//    List object to store orders
    private List<Order> orderList;

    /**
     * Initialize orderList which is used to store the orders of the customers
     * Initialize scanner which is used to take input from the customer.
     */
    Server() {
        orderList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    /**
     * Initializing method where the serving starts. The method loops through menu's
     * and asks customer for input.
     */
    public void startServing() {
        int option;
//        Boolean used to exit out of loop when required.
        boolean showMenu = true;
//        Infinite loop used to keep showing the menu until user wants to exit.
        while (showMenu) {
            System.out.println("1. New Order\n2. Update Order\n3.Show Order Details\n0.Exit");
            System.out.println("Enter your choice: ");
            option = getScanner().nextInt();
            switch (option) {
                case 1:
//                    Take new order from customer
                    newOrder();
                    break;
                case 2:
//                    Update a previous order
                    System.out.println("Enter order ID: ");
                    int orderID = getScanner().nextInt();
                    try {
                        updateOrder(getOrderList().get(orderID - 1));
                    } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                        System.out.println("Sorry. The order id does'nt exist");
                    }
                    break;
                case 3:
//                    Show details of the order
                    if (!getOrderList().isEmpty()) {
                        System.out.println("Enter your order id: ");
                        orderID = getScanner().nextInt();
                        try {
                            getOrderList().get(orderID - 1).showOrderDetails();
                        } catch (IndexOutOfBoundsException indexOutOfBoundException) {
                            System.out.println("Sorry the order ID does not exist.");
                        }

                    } else {
                        System.out.println("You donot have any order's yet. Please use the" +
                                "menu to make an order.");
                    }

                    break;
                case 0:
//                    When cutomer chooses 0 break out of the loop.
                    showMenu = false;
                    break;
                default:
                    System.out.println("Please enter correct choice");
            }
        }
    }

    /**
     * Method is used to take new order from the customer and store in the
     * ordersList of the server. Upon creating a new order the customer will
     * be prompted the order id, which can be used later to update their orders
     * or view detailed bill.
     */
    private void newOrder() {
        int option;
        String choice;
        Order createdOrder = null;
        Hamburger burger;
//        Show the various types burger present
        showBurgerMenu();
        System.out.println("Select an option: ");
        option = getScanner().nextInt();
        /*Inorder to ignore the next line*/
        getScanner().nextLine();
        switch (option) {
            case 1:
                /*Case for Hamburger*/
                burger = new Hamburger("White bread", "meat", 50);
                setNameOfBurger(burger);
                createdOrder = addOrder(burger);
                System.out.println("Would you like to add additions to the burger? (yes/y or no/n)");
                choice = getScanner().next();
                if (choice.equalsIgnoreCase("y")) {
                    takeAdditionalItemsOrder(burger);
                }
                break;
            case 2:
                /*Case for HealthyBurger*/
                burger = new HealthyBurger("meat", 60);
                setNameOfBurger(burger);
                createdOrder = addOrder(burger);
                System.out.println("Would you like to add additions to the burger? (yes/y or no/n)");
                choice = getScanner().next();
                if (choice.equalsIgnoreCase("y")) {
                    takeAdditionalItemsOrder(burger);
                }
                break;
            case 3:
                /*Case for DeluxeBurger*/
                burger = new DeluxeBurger("White bread", "meat", 70);
                setNameOfBurger(burger);
                createdOrder = addOrder(burger);
                break;
            case 0:
                /*Break the loop condition*/
                break;
            default:
                System.out.println("Select correct option.");
        }
        System.out.println("Added. Would like to add another burger?");
        choice = getScanner().next();
        /*In order to skip the next line*/
        getScanner().nextLine();
        if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
            updateOrder(createdOrder);
        }
    }

    private Scanner getScanner() {
        return scanner;
    }

    /**
     * Takes in a order object and prompts burger menu from which user
     * can add new burger to the order.
     * @param order Order which is to be updated.
     */
    private void updateOrder(Order order) {
        if (order != null && !order.getHamburgersList().isEmpty()) {
            boolean showMenu = true;
            int option;
            Hamburger burger;
            while (showMenu) {
                showBurgerMenu();
                System.out.println("Enter choice: ");
                option = getScanner().nextInt();
                /*In order to ignore the next line*/
                getScanner().nextLine();
                switch (option) {
                    case 1:
                        /*Case for Hamburger*/
                        burger = new Hamburger("White bread", "meat", 50);
                        setNameOfBurger(burger);
                        order.addBurger(burger);
                        System.out.println("Would you like to add additions to the burger?");
                        String choice = getScanner().next();
                        if (choice.equalsIgnoreCase("y")) {
                            takeAdditionalItemsOrder(burger);
                        }
                        break;
                    case 2:
                        /*Case for HealthyBurger*/
                        burger = new HealthyBurger("meat", 60);
                        setNameOfBurger(burger);
                        order.addBurger(burger);
                        System.out.println("Would you like to add additions to the burger?");
                        choice = getScanner().next();
                        if (choice.equalsIgnoreCase("y")) {
                            takeAdditionalItemsOrder(burger);
                        }
                        break;
                    case 3:
                        /*Case for DeluxeBurger*/
                        burger = new DeluxeBurger("White bread", "meat", 70);
                        setNameOfBurger(burger);
                        order.addBurger(burger);
                        break;
                    case 0:
                        /*Break the loop condition*/
                        showMenu = false;
                        break;
                    default:
                        System.out.println("Select correct option.");
                }
            }
            System.out.println("choice: ");
        }
    }

    private List<Order> getOrderList() {
        return orderList;
    }

    /**
     * Displays burger menu from which user can choose from.
     */
    private static void showBurgerMenu() {
        System.out.println("1 -> Hamburger(Hamburger, can have 4 additional items \t Price: 50");
        System.out.println("2 -> Healthy Burger(Healthy Burger, can have 2 additional items \t 60");
        System.out.println("3 -> Deluxe Burger(Deluxe Burger, cannot have additional items \n as also it contains chips and drink \t Price: 70");
        System.out.println("0 -> Exit");
    }

    /**
     * Set the name of the burger selected by the customer.
     * @param burger Burger to which the name has to be set.
     */
    private void setNameOfBurger(Hamburger burger) {
        System.out.println("Enter name: ");
        String nameOfBurger = getScanner().nextLine();
        burger.setNameOfBurger(nameOfBurger);
    }

    /**
     * Adds an order to the ordersList and return the created order.
     * @param burger Burger to be added to the ordersList
     * @return Order object that is added to the ordersList
     */
    private Order addOrder(Hamburger burger) {
        Order order = new Order(getOrderList().size() + 1);
        order.addBurger(burger);
        getOrderList().add(order);
        System.out.println("Your order id is " + order.getOrderNumber());
        return order;
    }

    /**
     * Method prompts for user input to select from various additional items
     * that can be added to the burger which is passed as a param. If the limit of
     * additions crosses then a error message is displayed.
     * @param burger Burger to which additional items are to be added.
     */
    private void takeAdditionalItemsOrder(Hamburger burger) {
        boolean showMenu = true;
        int choice;
        System.out.println("Would you like to add any additions to the burger?");
        while (showMenu) {
            showAdditionalItemsMenu();
            System.out.println("Select option: ");
            choice = getScanner().nextInt();
            switch (choice) {
                case 1:
                    addItemToBurger(burger, "Extra cheese", 20);
                    break;
                case 2:
                    addItemToBurger(burger, "Tomato", 20);
                    break;
                case 3:
                    addItemToBurger(burger, "Onions", 20);
                    break;
                case 4:
                    addItemToBurger(burger, "Chips", 30);
                    break;
                case 5:
                    addItemToBurger(burger, "Coke", 30);
                    break;
                case 0:
                    showMenu = false;
                    break;
                default:
                    System.out.println("Please select correct option");
            }
        }
    }

    /**
     * Method to display menu of additional items that can be added
     * to the burger
     */
    private static void showAdditionalItemsMenu() {
        System.out.println("1. Extra cheese\t-\t20rs");
        System.out.println("2. Tomato\t-\t20rs");
        System.out.println("3.Onions\t-\t20rs");
        System.out.println("4.Chips\t-\t30rs");
        System.out.println("5.Coke\t-\t30rs");
        System.out.println("0. None");
    }

    /**
     * Creates a AdditionalItem object and adds it to the burger.
     * @param burger Burger to which item is added
     * @param itemName The name of the item selected.
     * @param price Price of the item selected.
     */
    private void addItemToBurger(Hamburger burger, String itemName, int price) {
        AdditionalItem additionalItem = new AdditionalItem(itemName, price);
        if (burger.addItem(additionalItem)) {
            System.out.println("Added item. Would you like to add any other Item?");
        } else {
            System.out.println("Sorry number of items limit has reached");
        }
    }
}
