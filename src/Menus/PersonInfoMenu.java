package Menus;

import Objects.Person;

import javax.swing.*;
import java.awt.*;

public class PersonInfoMenu extends JPanel{
    public Window w;
    public Person person;
    SelectionMenu SelectionMenu;

    public PersonInfoMenu(Window w, Person person, SelectionMenu SelectionMenu){
        this.person = person;
        this.w = w;
        this.SelectionMenu = SelectionMenu;
        initPanel();
    }

    public void initPanel(){
        generatePanel();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public void generatePanel(){
        JPanel personInfoPanel = new JPanel();
        personInfoPanel.setLayout(new BoxLayout(personInfoPanel, BoxLayout.Y_AXIS));

        JLabel nameLabel = new JLabel("Name: " + person.getName());
        JLabel addressLabel = new JLabel("Address: " + person.getAddress());

        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        addressLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton backButt = new JButton("Back");
        backButt.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButt.addActionListener(e -> {
            w.setSize(400, 600);
            w.getContentPane().removeAll();
            w.add(SelectionMenu);
            w.revalidate();
        });

        personInfoPanel.add(nameLabel);
        personInfoPanel.add(addressLabel);
        personInfoPanel.add(backButt);
        add(personInfoPanel);
    }


}
