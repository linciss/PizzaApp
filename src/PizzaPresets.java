import java.util.ArrayList;

public class PizzaPresets {

    public static ArrayList<Pizza> makePresets(){
        ArrayList<Pizza> pizzaPresets = new ArrayList<>();
        pizzaPresets.add(new Pizza("Pepperoni", "Thin", "Tomato", "Mozzarella", "Pepperoni", 10));
        pizzaPresets.add(new Pizza("Hawaiian", "Thin", "Tomato", "Mozzarella", "Ham, Pineapple", 10));
        pizzaPresets.add(new Pizza("Meat Lovers", "Thin", "Tomato", "Mozzarella", "Pepperoni, Ham, Sausage", 10));
        pizzaPresets.add(new Pizza("Veggie", "Thin", "Tomato", "Mozzarella", "Mushrooms, Onions, Peppers", 10));
        pizzaPresets.add(new Pizza("Cheese", "Thin", "Tomato", "Mozzarella", "None", 10));
        pizzaPresets.add(new Pizza("Supreme", "Thin", "Tomato", "Mozzarella", "Pepperoni, Ham, Sausage, Mushrooms, Onions, Peppers", 10));
        return pizzaPresets;
    }

}





