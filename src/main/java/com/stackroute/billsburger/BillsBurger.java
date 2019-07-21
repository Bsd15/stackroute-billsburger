package com.stackroute.billsburger;

/**
 * BillsBurger - The purpose of the application is to help a fictitious company
 * called Bills Burgers to manage their process of selling hamburgers.
 */
public class BillsBurger {

    public static void main(String[] args) {
//        Create a server object
        Server server = new Server();
//        Start serving to customers
        server.startServing();
    }
}
