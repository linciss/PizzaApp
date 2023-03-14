import Menus.Window;
import Objects.Person;
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

  /* Todo:
  * 1. Finish the profile menu and logout button
  * 2. Finish the confirmation menu
  * 3 Maybe add a order history in the profile menu
  * 4. Maybe make a prefrences
  * 5. make a brach for sizes
    */


}