package Presets;

import Objects.Pizza;

import java.util.ArrayList;
import java.util.Random;

public class PizzaPresets {

    public static ArrayList<Pizza> getPresets(){
        ArrayList<Pizza> pizzaPresets = new ArrayList<>();
        Random rand = new Random();
        pizzaPresets.add(new Pizza("Pepperoni", "Thin", "Tomato", "Mozzarella", "Pepperoni", 10));
        pizzaPresets.add(new Pizza("Hawaiian", "Thin", "Tomato", "Mozzarella", "Ham, Pineapple", 10));
        pizzaPresets.add(new Pizza("Meat Lovers", "Thin", "Tomato", "Mozzarella", "Pepperoni, Ham, Sausage", 15));
        pizzaPresets.add(new Pizza("Veggie", "Thin", "Tomato", "Mozzarella", "Mushrooms, Onions, Peppers", 10));
        pizzaPresets.add(new Pizza("Cheese", "Thin", "Tomato", "Mozzarella", "None", 10));
        pizzaPresets.add(new Pizza("Margherita", "Thin", "Marinara", "Mozzarella", "Garlic, Fresh basil", 15));
        pizzaPresets.add(new Pizza("The Works Pizza", "Thin", "Pizza sauce", "Mozzarella", "Pepperoni, Spicy sausage, Mushrooms, Peppers", 20));
        pizzaPresets.add(new Pizza("Supreme", "Thin", "Tomato", "Mozzarella", "Pepperoni, Ham, Sausage, Mushrooms, Onions, Peppers", 15));
        pizzaPresets.add(new Pizza("Buffalo Chicken", "Thin", "Tomato", "Mozzarella", "Chicken, Buffalo Sauce", 20));
        pizzaPresets.add(new Pizza("BBQ Chicken", "Thin", "Tomato", "Mozzarella", "Chicken, BBQ Sauce", 15));


        return pizzaPresets;
    }

}





