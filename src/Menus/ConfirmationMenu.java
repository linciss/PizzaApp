package Menus;

import Objects.Pizza;
import utils.WrapLayout;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ConfirmationMenu extends JPanel{
    Window w;
    SelectionMenu SelectionMenu;

    Pizza pizza;
    JRadioButton onTheSpot, delivery;
    boolean isOnTheSpot = true;
    boolean isDelivery = false;
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

        JPanel editPanel = new JPanel();
        //main second panel
        editPanel.setLayout(new BoxLayout(editPanel, BoxLayout.Y_AXIS));

        //cheese panel
        editPanel.add(createPanel("Cheese"));
        // sauce panel
        editPanel.add(createPanel("Sauce"));
        //toppings panel
        editPanel.add(createPanel("Toppings"));

        editPanel.setLayout(new WrapLayout());

        onTheSpot = new JRadioButton("On the spot");
        delivery = new JRadioButton("Delivery");
        ButtonGroup group = new ButtonGroup();


        group.add(delivery);
        group.add(onTheSpot);
        //set to tru on default
        onTheSpot.setSelected(true);


        //if pressed change the price of the pizza
        if(!isOnTheSpot){
            onTheSpot.addActionListener(e -> {
                System.out.println("On the spot!");
                pizza.setPrice(pizza.withoutDelivery(w.person.getDistance()));
                isOnTheSpot = true;
                isDelivery = false;
                refresh();
                onTheSpot.setSelected(true);
                delivery.setSelected(false);
                System.out.println("isonthespot in onthespot "+isOnTheSpot);
                System.out.println("isdelivery in onthespot "+isDelivery);
            });}

        //if pressed change the price of the pizza
        if(!isDelivery) {
            delivery.addActionListener(e -> {
                System.out.println("Delivery!");
                pizza.setPrice(pizza.withDelivery(w.person.getDistance()));
                isOnTheSpot = false;
                isDelivery = true;
                refresh();
                onTheSpot.setSelected(false);
                delivery.setSelected(true);
                System.out.println("isonthespot in delivery"+isOnTheSpot);
                System.out.println("isdelivery in delivery"+isDelivery);
            });
        }

        editPanel.add(onTheSpot);
        editPanel.add(delivery);
        System.out.println(pizza.getPrice());
        label = new JLabel("Price: "+ pizza.getPrice());
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        editPanel.add(label);
        add(editPanel);
    }

    public JPanel createPanel(String item){
        JPanel panel = new JPanel();
        JLabel label = new JLabel(item);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println(item);
                pizza.calculatePrice(item);
                refresh();
            }
        });
        panel.add(label);
        panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        panel.setPreferredSize(new Dimension(100, 200));
        return panel;
    }
    public void refresh(){
        removeAll();
        generatePanel();
        revalidate();
    }

}
