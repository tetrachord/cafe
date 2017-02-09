package com.foo;

public class MenuItemData {

    private Temperature temperature;
    private double price;
    private boolean isFood;

    public MenuItemData(Temperature temperature, double price, boolean isFood) {
        this.temperature = temperature;
        this.price = price;
        this.isFood = isFood;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public double getPrice() {
        return price;
    }

    public boolean isFood() {
        return isFood;
    }

    public boolean isHotFood() {
        return (isFood == true) && (temperature.equals(Temperature.HOT));
    }
}
