package Menus;

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

    Window menu;

    public SelectionMenu(Window menu){
    this.menu = menu;
    initPanel();
    }

    public void initPanel(){
        System.out.println("Menus.SelectionMenu initialized");
        generatePanel();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JScrollPane scrollBar=new JScrollPane(pizzaPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollBar.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollBar);

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
