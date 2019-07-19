package com.stackroute.billsburger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Server {
    private final Scanner scanner;
    private List<Order> orderList;

    Server() {
        orderList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    public void startServing() {
        int option;
        boolean showMenu = true;
        orderList = new ArrayList<>();
        while (showMenu) {
            System.out.println("1. New Order\n2. Update Order");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    newOrder();
                    break;
                case 2:
                    int orderID = getScanner().nextInt();
                    updateOrder(getOrderList().get(orderID));
                    break;
                case 0:
                    showMenu = false;
                    break;
                default:
                    System.out.println("Please enter correct choice");
            }
        }
    }

    private void updateOrder(Order order) {
        if (order.getHamburgersList().size() > 0) {
            System.out.println("Select burger to update:");
            for (Hamburger burger: order.getHamburgersList()) {
                System.out.println(burger.getNameOfBurger());
            }
        }
    }

    public Scanner getScanner() {
        return scanner;
    }

    private List<Order> getOrderList() {
        return orderList;
    }

    private void newOrder() {
        boolean showMenu = true;
        int option;
        Hamburger burger;
        while (showMenu) {
            displayMenu();
            System.out.println("Select an option: ");
            option = getScanner().nextInt();
            switch (option) {
                case 1:
                    /*Case for Hamburger*/
                    burger = new Hamburger("White bread", "meat", 50);
                    setNameOfBurger(burger);
                    addOrder(burger);
                    takeAdditionalItemsOrder(burger);
                    break;
                case 2:
                    /*Case for HealthyBurger*/
                    burger = new HealthyBurger("meat", 60);
                    setNameOfBurger(burger);
                    addOrder(burger);
                    takeAdditionalItemsOrder(burger);
                    break;
                case 3:
                    /*Case for DeluxeBurger*/
                    burger = new DeluxeBurger("White bread", "meat", 70);
                    setNameOfBurger(burger);
                    addOrder(burger);
                    break;
                case 0:
                    /*Break the loop condition*/
                    showMenu = false;
                    break;
                default:
                    System.out.println("Select correct option.");
            }
        }
    }

    private void takeAdditionalItemsOrder(Hamburger burger) {
        boolean showMenu = true;
        int choice;
        AdditionalItem additionalItem;
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
    private void addItemToBurger(Hamburger burger, String itemName, int price){
        AdditionalItem additionalItem = new AdditionalItem(itemName, price);
        if (burger.addItem(additionalItem)){
            System.out.println("Added item");
        }else {
            System.out.println("Sorry number of items limit has reached");
        }
    }
    private static void showAdditionalItemsMenu() {
        System.out.println("1. Extra cheese\t-\t20rs");
        System.out.println("2. Tomato\t-\t20rs");
        System.out.println("3.Onions\t-\t20rs");
        System.out.println("4.Chips\t-\t30rs");
        System.out.println("5.Coke\t-\t30rs");
        System.out.println("0. None");
    }

    private void addOrder(Hamburger burger) {
        Order order = new Order(getOrderList().size() + 1);
        order.addBurger(burger);
        getOrderList().add(order);
    }

    private static void displayMenu() {
        System.out.println("1 -> Hamburger(Hamburger, can have 4 additional items \t Price: 50");
        System.out.println("2 -> Healthy Burger(Healthy Burger, can have 6 additional items \t 60");
        System.out.println("3 -> Deluxe Burger(Deluxe Burger, can have 4 additional items \n And also it contains chips and drink \t Price: 70");
    }

    public void setNameOfBurger(Hamburger burger) {
        System.out.println("Enter name: ");
        String nameOfBurger = getScanner().next();
        burger.setNameOfBurger(nameOfBurger);
    }
}
