package com.stackroute.billsburger;

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

    public void setNameOfTheAddOn(String nameOfTheAddOn) {
        this.nameOfTheAddOn = nameOfTheAddOn;
    }

    public double getPriceOfTheAddOn() {
        return priceOfTheAddOn;
    }

    public void setPriceOfTheAddOn(double priceOfTheAddOn) {
        this.priceOfTheAddOn = priceOfTheAddOn;
    }

}
