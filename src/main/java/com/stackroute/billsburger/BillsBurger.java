package com.stackroute.billsburger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BillsBurger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;
        List<Order> orderList = new ArrayList<>();
        while (true) {
            System.out.println("1. New Order\n2. Update Order");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    newOrder();
                    break;
                case 2:
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Please enter correct choice");
            }
        }
    }

    private static void newOrder() {
        displayMenu();
    }


}
