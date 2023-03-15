import Menus.Window;
import Objects.Person;
import Objects.Pizza;
import Presets.PizzaPresets;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(new FlatMacLightLaf());
        }catch (Exception e){
            e.printStackTrace();
        }

        ArrayList<Pizza> pizzaPresets = PizzaPresets.getPresets();

        for(Pizza pizza : pizzaPresets){
            System.out.println(pizza.toString());
        }
        new Window();
    }
}