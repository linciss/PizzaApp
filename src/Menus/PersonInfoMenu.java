package Menus;

import Objects.Person;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class PersonInfoMenu extends JPanel{
    public Window w;
    public Person person;
    SelectionMenu SelectionMenu;
    DecimalFormat df = new DecimalFormat(".##");
    public PersonInfoMenu(Window w, Person person, SelectionMenu SelectionMenu){
        this.person = person ;
        this.w = w;
        this.SelectionMenu = SelectionMenu;
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

    public void generatePanel(){
        JPanel personInfoPanel = new JPanel();
        personInfoPanel.setLayout(new BoxLayout(personInfoPanel, BoxLayout.Y_AXIS));
        personInfoPanel.setBackground(new Color(18,18,18));

        JLabel nameLabel = new JLabel("Name: " + person.getName());
        JLabel addressLabel = new JLabel("Address: " + person.getAddress());
        JLabel distanceLabel = new JLabel("Distance: " + df.format(person.getDistance()));

        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameLabel.setForeground(new Color(187, 134, 252));
        addressLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        addressLabel.setForeground(new Color(187, 134, 252));
        distanceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        distanceLabel.setForeground(new Color(187, 134, 252));

        JButton backButt = new JButton("Back");
        backButt.setBackground(new Color(38, 37, 37));
        backButt.setForeground(new Color(187, 134, 252));
        backButt.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButt.addActionListener(e -> {
            w.getContentPane().removeAll();
            w.add(SelectionMenu);
            w.repaint();
        });

        personInfoPanel.add(nameLabel);
        personInfoPanel.add(addressLabel);
        personInfoPanel.add(distanceLabel);
        personInfoPanel.add(backButt);
        add(personInfoPanel);
    }


}
