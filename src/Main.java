import Menus.Window;
import Objects.Pizza;
import Presets.PizzaPresets;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Pizza> pizzaPresets = PizzaPresets.getPresets();

        for(Pizza pizza : pizzaPresets){
            System.out.println(pizza.toString());
        }

        new Window();
    }
}