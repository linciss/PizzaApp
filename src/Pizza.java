
public class Pizza {

    private String top, crust, sauce, cheese, name;
    private double pizzaPrice, extraCrustPrice, extraSaucePrice, extraCheesePrice, extraTopPrice;

    public Pizza(String name, String crust, String sauce, String cheese, String top){
        this.name = name;
        this.crust = crust;
        this.sauce = sauce;
        this.cheese = cheese;
        this.top = top;
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

    public double getPrice() {
        return pizzaPrice;
    }

    public void setPrice(double price) {
        this.pizzaPrice = price;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }



    public String toString(){
        return "Crust: " + crust + "" +
                "Sauce: " + sauce + "" +
                "Cheese: " + cheese + "" +
                "Toppings: " + top + "" +
                "Price: " + pizzaPrice;
    }

}
