package Menus;

import Objects.Pizza;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ConfirmationMenu extends JPanel{
    Window w;
    SelectionMenu SelectionMenu;

    Pizza pizza;
    public ConfirmationMenu(Window w, SelectionMenu SelectionMenu, Pizza pizza){
        this.SelectionMenu = SelectionMenu;
        this.pizza = pizza;
        this.w = w;
        initPanel();
    }
    public void initPanel(){
        generatePanel();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public void generatePanel() {
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));
        JLabel label;

        ImageIcon imageIcon = new ImageIcon("src\\images\\" + pizza.getName() + ".png");
        label = new JLabel(imageIcon);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        displayPanel.add(label);

        label = new JLabel("Basic info");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        displayPanel.add(label);

        label = new JLabel("Name: " + pizza.getName()+ ", Sauce: " + pizza.getSauce() + ", Cheese: " + pizza.getCheese());
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        displayPanel.add(label);

        label = new JLabel("Toppings: " + pizza.getTop());
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        displayPanel.add(label);

        //back button for now
        JButton noButt = new JButton("No");
        noButt.setAlignmentX(Component.CENTER_ALIGNMENT);
        noButt.addActionListener(e -> {
            w.setSize(400, 600);
            w.getContentPane().removeAll();
            w.add(new SelectionMenu(w, this));
            w.revalidate();
        });

        displayPanel.add(noButt);

        //adds the first panel to the main panel
        add(displayPanel);



    }
}
