package Menus;

import Objects.Pizza;
import utils.WrapLayout;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

public class ConfirmationMenu extends JPanel{
    Window w;
    SelectionMenu SelectionMenu;

    Pizza pizza;
    JRadioButton onTheSpot, delivery;

    JSlider slider;

    JButton buyButt;
    JPanel buyPanel;

    boolean isOnTheSpot = true;
    boolean isDelivery = true;
    public ConfirmationMenu(Window w, SelectionMenu SelectionMenu, Pizza pizza){
        this.SelectionMenu = SelectionMenu;
        this.pizza = pizza;
        this.w = w;
        setBackground(new Color(18,18,18));
        initPanel();
    }
    public void initPanel(){
        generatePanel();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
    // panel.setBackground(new Color(18,18,18));
    // label.setForeground(new Color(187, 134, 252));
    // subpanel.setBackground(new Color(38, 37, 37));

    public void generatePanel() {

/////////////////////////////////////////////////BACKPANEL////////////////////////////////////////////////////////
        //back button
        JPanel backPanel = new JPanel(new BorderLayout());
        backPanel.setBackground(new Color(18, 18, 18));
        JButton backButt = new JButton("Back");
        backButt.setBackground(new Color(38, 37, 37));
        backButt.setForeground(new Color(187, 134, 252));
        //backButt.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButt.addActionListener(e -> {
            w.getContentPane().removeAll();
            w.add(new SelectionMenu(w, this));
            w.revalidate();
        });

        backPanel.add(backButt, BorderLayout.WEST);
        backPanel.setMaximumSize(new Dimension(400, 20));
        add(backPanel);

///////////////////////////////////////////////DISPLAYPANEL////////////////////////////////////////////////////////////////////////////////////////

        //display panel displaying the pizza
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));
        JLabel label;

        ImageIcon imageIcon = new ImageIcon("src\\images\\" + pizza.getName() + ".png");
        label = new JLabel(imageIcon);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        displayPanel.add(label);

        label = new JLabel(pizza.getName());
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setForeground(new Color(187, 134, 252));
        displayPanel.add(label);

        label = new JLabel("Basic info");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setForeground(new Color(187, 134, 252));
        displayPanel.add(label);

        label = new JLabel("Sauce: " + pizza.getSauce() + ", Cheese: " + pizza.getCheese());
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setForeground(new Color(187, 134, 252));
        displayPanel.add(label);

        label = new JLabel("Toppings: " + pizza.getTop());
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setForeground(new Color(187, 134, 252));
        displayPanel.add(label);
        displayPanel.setBackground(new Color(18, 18, 18));

        //adds the first panel to the main panel
        add(displayPanel);

///////////////////////////////////////////////EDITPANEL////////////////////////////////////////////////////////////////////////////////////////

        //main second panel
        JPanel editPanel = new JPanel();

        editPanel.setLayout(new WrapLayout());

        // sauce panel
        editPanel.add(createPanel("Sauce"));
        //cheese panel
        editPanel.add(createPanel("Cheese"));
        //toppings panel
        editPanel.add(createPanel("Toppings"));


        //radio buttons
        onTheSpot = new JRadioButton("On the spot");
        delivery = new JRadioButton("Delivery");
        ButtonGroup group = new ButtonGroup();

        group.add(delivery);
        group.add(onTheSpot);

        //set to true on default
        onTheSpot.setSelected(true);
        onTheSpot.setForeground(new Color(187, 134, 252));
        delivery.setForeground(new Color(187, 134, 252));
        //if pressed change the price of the pizza

            onTheSpot.addActionListener(e -> {
                if(isOnTheSpot) {
                    System.out.println("On the spot!");
                    if(pizza.getPrice()!=10) {
                        pizza.setPrice(pizza.withoutDelivery(w.person.getDistance()));
                    }
                    refreshButton();
                    System.out.println("Debbuging for price: " + pizza.getPrice());
                    isDelivery = true;
                    isOnTheSpot = false;
                    onTheSpot.setSelected(true);
                    delivery.setSelected(false);
                    //debugging
                    System.out.println("isonthespot in onthespot " + isOnTheSpot);
                    System.out.println("isdelivery in onthespot " + isDelivery);
                }
            });

        //if pressed change the price of the pizza

            delivery.addActionListener(e -> {
                if(isDelivery) {
                    System.out.println("Delivery!");
                    pizza.setPrice(pizza.withDelivery(w.person.getDistance()));
                    isOnTheSpot = true;
                    isDelivery = false;
                    refreshButton();
                    onTheSpot.setSelected(false);
                    delivery.setSelected(true);
                    //debugging
                    System.out.println("isonthespot in delivery"+isOnTheSpot);
                    System.out.println("isdelivery in delivery"+isDelivery);
                }
            });


        editPanel.add(onTheSpot);
        editPanel.add(delivery);
        System.out.println(pizza.getPrice());
        editPanel.setMaximumSize(new Dimension(400, 250));
        editPanel.setBackground(new Color(18, 18, 18));
        add(editPanel);

////////////////////////////////////////////////////BUYPANEL///////////////////////////////////////////////////////////////////////////////////

        buyPanel = new JPanel();
        buyPanel.setLayout(new BoxLayout(buyPanel, BoxLayout.Y_AXIS));
        buyPanel.setMaximumSize(new Dimension(400, 250));

        //slider
        slider = new JSlider(1, 10);
        slider.setValue(1);
        slider.setMajorTickSpacing(1);
        slider.setPaintLabels(true);
        slider.setForeground(new Color(187, 134, 252));
        slider.setAlignmentX(Component.CENTER_ALIGNMENT);
        slider.addChangeListener(e -> {
            refreshButton();
            repaint();
        });

        buyPanel.add(slider);
        //buy button
        buyButt = new JButton("Buy for " + pizza.getPrice() + "€");
        buyButt.setAlignmentX(Component.CENTER_ALIGNMENT);
        buyButt.setFont(new Font("Arial", Font.BOLD, 20));
        buyButt.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Your order has been placed!");
        });
        System.out.println("Buy butt" + buyButt.getHeight());
        buyButt.setMaximumSize(new Dimension(300, 30));
        buyButt.setBackground(new Color(38, 37, 37));
        buyButt.setForeground(new Color(187, 134, 252));
        buyPanel.add(buyButt);

        buyPanel.setBackground(new Color(18, 18, 18));

        add(editPanel);
        add(buyPanel)  ;

    }

    public JPanel createPanel(String item){
        JPanel panel = new JPanel();
        JLabel label = new JLabel(item);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                pizza.setPrice(pizza.calculatePrice(item)+pizza.getPrice());
                refreshButton();
            }
        });
        panel.add(label);
        panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        panel.setPreferredSize(new Dimension(100, 200));
        return panel;
    }

    public void refreshButton(){
        DecimalFormat df = new DecimalFormat(".##");
        //float price = pizza.getPrice() * slider.getValue() ;
        buyButt.setText("Buy for " + df.format(pizza.getPrice() * slider.getValue()) + "€");
    }

}
