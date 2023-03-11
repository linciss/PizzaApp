package Menus;

import Objects.Person;

import javax.swing.*;
import java.awt.*;

public class LoginMenu extends JPanel{

ConfirmationMenu ConfirmationMenu;
    Window w;
    SelectionMenu selectionMenu;
    public LoginMenu(Window w, SelectionMenu selectionMenu){
        this.selectionMenu = selectionMenu;
        this.w = w;
        initPanel();
    }

    public void initPanel(){
        w.setSize(200, 200);
        generatePanel();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public void generatePanel(){

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));

        JLabel nameLabel = new JLabel("Name");
        JLabel addressLabel = new JLabel("Address");
        JTextField nameField = new JTextField();
        JTextField addressField = new JTextField();

        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        addressLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        //sets layout for the nameField to be horizontal
        nameField.setMaximumSize(new Dimension(200, 20));


        // sets layout for the addressField to be horizontal
        addressField.setMaximumSize(new Dimension(200, 20));


        //login button to login, when pressed show the selection menu
        JButton loginButton = new JButton("Login");
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.addActionListener(e -> {
            selectionMenu.person = new Person(nameField.getText(), addressField.getText());
            w.setSize(400, 600);
            w.getContentPane().removeAll();
            w.add(selectionMenu);
            w.revalidate();
        });


        loginPanel.add(nameLabel);
        loginPanel.add(nameField);
        loginPanel.add(addressLabel);
        loginPanel.add(addressField);
        loginPanel.add(loginButton);
        add(loginPanel);
    }
}




