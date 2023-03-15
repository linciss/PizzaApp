package Objects;

import java.util.Random;

public class Pizza {
    Random rand = new Random();
    private String top, crust, sauce, cheese, name;
    private float price;

    public Pizza(String name, String crust, String sauce, String cheese, String top, float price){
        this.name = name;
        this.crust = crust;
        this.sauce = sauce;
        this.cheese = cheese;
        this.top = top;
        this.price = price;
    }


    public float withDelivery(double distance){
        return price += distance;
    }
    public float withoutDelivery(double distance){
        return price -= distance;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public String getCrust() {
        return crust;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public String getCheese() {
        return cheese;
    }

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public String toString(){
        return "Name: " + name + "\n" +
                "Crust: " + crust + "\n" +
                "Sauce: " + sauce + "\n" +
                "Cheese: " + cheese + "\n" +
                "Toppings: " + top + "\n" +
                "Price: " + price;
    }

    public void calculatePrice(String item){
        switch (item) {
            case "Sauce":  price += 0.5;break;
            case "Cheese": price += 0.75; break;
            case "Toppings": price += 1.0; break;

        };
    }


}
