import java.awt.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Pizza> pizzaPresets = PizzaPresets.makePresets();

        for(Pizza pizza : pizzaPresets){
            System.out.println(pizza.toString());
        }

        new MainMenu();
    }
}