package Objects;

import javax.swing.*;

public class Person {

    private String name, address;
    private double distance;

    public Person(String name, String address, double distance){
        this.name = name;
        this.address = address;
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

 public String toString(){
        return "Name: " + name + " Address: " + address;
 }


}
