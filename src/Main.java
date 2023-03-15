import Menus.Window;
import Objects.Person;
import Objects.Pizza;
import Presets.PizzaPresets;
import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Pizza> pizzaPresets = PizzaPresets.getPresets();

        for(Pizza pizza : pizzaPresets){
            System.out.println(pizza.toString());
        }
        new Window();
    }

  /* Todo:
  * 1. FInish logout button
  * 3 Maybe add a order history in the profile menu
    */


}