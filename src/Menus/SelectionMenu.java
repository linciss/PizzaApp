package Menus;

import Objects.Person;

import Objects.Pizza;
import Presets.PizzaPresets;
import utils.WrapLayout;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

public class SelectionMenu extends JPanel {
    ConfirmationMenu confirmationMenu;
    Window w;
    Person person;
    public SelectionMenu(Window w, ConfirmationMenu confirmationMenu){
        this.w = w;
        this.confirmationMenu = confirmationMenu;
        setBackground(new Color(18,18,18));
        initPanel();

    }


    public void initPanel(){
        generatePanel();
        setLayout(new BorderLayout());
        JScrollPane scrollBar=new JScrollPane(pizzaPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollBar.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollBar);

        JMenuBar menubar = new JMenuBar();
        JMenu menu = new JMenu("Profile");

        JMenuItem logout= new JMenuItem("Logout");
        JMenuItem profile = new JMenuItem("Profile");
        logout.setForeground(new Color(187, 134, 252));
        profile.setForeground(new Color(187, 134, 252));

        menu.add(profile);menu.add(logout);

        menu.setForeground(Color.blue);
        menu.setBackground(new Color(18, 18, 18));

        menubar.add(menu);
        menubar.setBackground(new Color(18,18,18));
        menubar.setForeground(new Color(187, 134, 252));
        add(menubar, BorderLayout.NORTH);

        profile.addActionListener(e -> {
            w.getContentPane().removeAll();
            w.add(new PersonInfoMenu(w, w.person, this));
            w.revalidate();

        });

        logout.addActionListener(e -> {
            w.getContentPane().removeAll();
            w.add(new LoginMenu(w, this));
            w.oldLogin = false;
            w.revalidate();
        });

    }
    JPanel pizzaPanel = new JPanel();

    public void generatePanel(){

        ArrayList<Pizza> pizzaPresets = PizzaPresets.getPresets();

        for(Pizza pizza : pizzaPresets){

            JPanel panel = new JPanel();
            JLabel label;
            ImageIcon imageIcon;

            //image
            imageIcon = new ImageIcon("src\\images\\" + pizza.getName() + ".png");
            label = new JLabel(imageIcon);
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            label.setMaximumSize(new Dimension(120, 120));
            panel.add(label);

            //name
            label = new JLabel(pizza.getName());
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            label.setFont(new Font(label.getFont().getFontName(), Font.BOLD, 13));
            label.setForeground(new Color(187, 134, 252));
            panel.add(label);

            //price
            label = new JLabel(pizza.getPrice() + " $");
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            label.setFont(new Font(label.getFont().getFontName(), Font.BOLD, 13));
            label.setForeground(new Color(187, 134, 252));
            panel.add(label);
                                   //__________________________
            label = new JLabel("-------------------------");
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            label.setForeground(new Color(187, 134, 252));
            panel.add(label);

            label = new JLabel("Crust: "+pizza.getCrust());
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            label.setForeground(new Color(187, 134, 252));
            panel.add(label);

            label = new JLabel("Sauce: "+pizza.getSauce());
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            label.setForeground(new Color(187, 134, 252));
            panel.add(label);

            label = new JLabel("Cheese: "+pizza.getCheese());
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            label.setForeground(new Color(187, 134, 252));
            panel.add(label);

            label = new JLabel("Toppings: "+pizza.getTop());
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            label.setForeground(new Color(187, 134, 252));
            panel.add(label);

            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
            panel.setPreferredSize(new Dimension(150, 250));

            panel.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    w.getContentPane().removeAll();
                    w.add(new ConfirmationMenu(w, SelectionMenu.this, pizzaPresets.get(pizzaPanel.getComponentZOrder(panel))));
                    w.revalidate();
                }
            });
            panel.setBackground(new Color(38, 37, 37));
            pizzaPanel.add(panel);
        }
        pizzaPanel.setLayout(new WrapLayout());
        pizzaPanel.setBackground(new Color(18,18,18));
    }
}
