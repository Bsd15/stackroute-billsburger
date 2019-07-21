package com.stackroute.billsburger;

/**
 * Additions that can be added to the burger. Consists two properties i.e. name and price.
 */
public class AdditionalItem {
    private String nameOfTheAddOn;
    private double priceOfTheAddOn;

    public AdditionalItem(String nameOfTheAddOn, double priceOfTheAddOn) {
        this.nameOfTheAddOn = nameOfTheAddOn;
        this.priceOfTheAddOn = priceOfTheAddOn;
    }


    public String getNameOfTheAddOn() {
        return nameOfTheAddOn;
    }

    public double getPriceOfTheAddOn() {
        return priceOfTheAddOn;
    }

}
