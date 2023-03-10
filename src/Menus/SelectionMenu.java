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
import java.util.ArrayList;

public class SelectionMenu extends JPanel {

    Window w;
    Person person;


    public SelectionMenu(Window w){
    this.w = w;
    initPanel();
    }

    public void initPanel(){
        System.out.println("Menus.SelectionMenu initialized");
        generatePanel();
        setLayout(new BorderLayout());
        JScrollPane scrollBar=new JScrollPane(pizzaPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollBar.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollBar);

        JMenuBar menubar = new JMenuBar();
        JMenu menu = new JMenu("Profile");
        JMenuItem logout= new JMenuItem("Logout");
        JMenuItem profile = new JMenuItem("Profile");
        menu.add(profile);menu.add(logout);
        menubar.add(menu);
        add(menubar, BorderLayout.NORTH);

        profile.addActionListener(e -> {
            w.setSize(200, 200);
            w.getContentPane().removeAll();
            w.add(new PersonInfoMenu(w, person, this));
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

            imageIcon = new ImageIcon("src\\images\\" + pizza.getName() + ".png");

            label = new JLabel(pizza.getName());
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(label);

            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
            panel.setPreferredSize(new Dimension(150, 250));

            panel.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Clicked");
                }
            });
            pizzaPanel.add(panel);
        }
        pizzaPanel.setLayout(new WrapLayout());
    }
}
