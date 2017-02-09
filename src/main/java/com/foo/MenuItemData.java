package com.foo;

public class MenuItemData {

    private Temperature temperature;
    private double price;

    public MenuItemData(Temperature temperature, double price) {
        this.temperature = temperature;
        this.price = price;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public double getPrice() {
        return price;
    }
}
