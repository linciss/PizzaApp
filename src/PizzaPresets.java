import java.util.ArrayList;

public class PizzaPresets {

    public static void makePresets(){
        ArrayList<Pizza> pizzaPresets = new ArrayList<>();
        pizzaPresets.add(new Pizza("Pepperoni", "Thin", "Tomato", "Mozzarella", "Pepperoni"));
        pizzaPresets.add(new Pizza("Hawaiian", "Thin", "Tomato", "Mozzarella", "Ham, Pineapple"));
        pizzaPresets.add(new Pizza("Meat Lovers", "Thin", "Tomato", "Mozzarella", "Pepperoni, Ham, Sausage"));
        pizzaPresets.add(new Pizza("Veggie", "Thin", "Tomato", "Mozzarella", "Mushrooms, Onions, Peppers"));
        pizzaPresets.add(new Pizza("Cheese", "Thin", "Tomato", "Mozzarella", "None"));
        pizzaPresets.add(new Pizza("Supreme", "Thin", "Tomato", "Mozzarella", "Pepperoni, Ham, Sausage, Mushrooms, Onions, Peppers"));

    }

}





