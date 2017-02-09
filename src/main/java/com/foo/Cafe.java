package com.foo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.DoubleStream;

public class Cafe {

    private static Map<String, MenuItemData> MENU = new HashMap<>();

    static {
        MENU.put("Cola", new MenuItemData(Temperature.COLD, 0.5d));
        MENU.put("Coffee", new MenuItemData(Temperature.HOT, 1.0d));
        MENU.put("Cheese Sandwich", new MenuItemData(Temperature.COLD, 2.0d));
        MENU.put("Steak Sandwich", new MenuItemData(Temperature.HOT, 4.5d));
    }

    public double calculateTotalFor(List<String> items) {

        return items.stream()
                .mapToDouble(i -> (MENU.get(i).getPrice()))
                .sum();
    }
}
