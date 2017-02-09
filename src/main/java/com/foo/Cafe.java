package com.foo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cafe {

    private static Map<String, MenuItemData> MENU = new HashMap<>();

    static {
        MENU.put("Cola", new MenuItemData(Temperature.COLD, 0.5d, false));
        MENU.put("Coffee", new MenuItemData(Temperature.HOT, 1.0d, false));
        MENU.put("Cheese Sandwich", new MenuItemData(Temperature.COLD, 2.0d, true));
        MENU.put("Steak Sandwich", new MenuItemData(Temperature.HOT, 4.5d, true));
    }

    public double calculateTotalFor(List<String> items) {

        double totalWithoutServiceCharge = items.stream()
                .mapToDouble(i -> (MENU.get(i).getPrice()))
                .sum();

        double cumulativeTotal = totalWithoutServiceCharge + calculateFoodServiceCharge(items, totalWithoutServiceCharge);

        cumulativeTotal += calculateHotFoodServiceCharge(items, totalWithoutServiceCharge);

        return cumulativeTotal;
    }

    private double calculateHotFoodServiceCharge(List<String> items, double total) {

        boolean hasHotFoodServiceCharge = items.stream()
                .anyMatch( i -> ( MENU.get(i).isHotFood() ) );

        double hotFoodServiceCharge = 0d;

        if (hasHotFoodServiceCharge) {
             hotFoodServiceCharge = total * 0.2;
             return (hotFoodServiceCharge > 20.0d) ? 20.0d : hotFoodServiceCharge;
        }

        return 0d;
    }

    private double calculateFoodServiceCharge(List<String> items, double total) {

        boolean hasFoodServiceCharge = items.stream()
                .anyMatch( i -> ( MENU.get(i).isFood() ) );

        return hasFoodServiceCharge ? total * 0.1 : 0d;
    }
}
