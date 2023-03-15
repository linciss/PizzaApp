package Menus;

import Objects.Person;
import utils.WrapLayout;


import javax.print.attribute.standard.PrinterMakeAndModel;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class LoginMenu extends JPanel{
Random rand =  new Random();
ConfirmationMenu ConfirmationMenu;
    Window w;
    SelectionMenu selectionMenu = new SelectionMenu(w, ConfirmationMenu);
    PersonInfoMenu personInfoMenu;
     Person person;
    public LoginMenu(Window w, SelectionMenu selectionMenu){
        this.selectionMenu = selectionMenu;
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

    public void generatePanel(){
        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new WrapLayout());
        imagePanel.setBackground(new Color(18, 18, 18));
        ImageIcon image = new ImageIcon("src\\Images\\LoginIcon.png");
        imagePanel.setMaximumSize(new Dimension(400, 250));
        imagePanel.add(new JLabel(image));
        add(imagePanel);

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
        loginPanel.setMaximumSize(new Dimension(400, 350));
        loginPanel.setBackground(new Color(18, 18, 18));

        JLabel nameLabel = new JLabel("Name");
        JLabel addressLabel = new JLabel("Address");
        JTextField nameField = new JTextField();
        JTextField addressField = new JTextField();

        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        addressLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameLabel.setForeground(new Color(187, 134, 252));
        addressLabel.setForeground(new Color(187, 134, 252));

        //sets layout for the nameField to be horizontal
        nameField.setMaximumSize(new Dimension(200, 30));
        nameField.setBackground(new Color(38, 37, 37));
        nameField.setForeground(new Color(187, 134, 252));

        // sets layout for the addressField to be horizontal
        addressField.setMaximumSize(new Dimension(200, 30));
        addressField.setBackground(new Color(38, 37, 37));
        addressField.setForeground(new Color(187, 134, 252));
        //login button to login, when pressed show the selection menu
        JButton loginButton= new JButton("Login");
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setBackground(new Color(38, 37, 37));
        loginButton.setForeground(new Color(187, 134, 252));

        loginButton.addActionListener(e -> {
            if(!nameField.getText().equals("") && !addressField.getText().equals("")){
                w.person= new Person(nameField.getText(), addressField.getText(), (rand.nextDouble()) *10 );
                w.getContentPane().removeAll();
                w.add(selectionMenu);
                w.revalidate();
                w.repaint();
            } else {
                JOptionPane.showMessageDialog(null, "Credentials invalid!");
            }
        });

        loginPanel.add(nameLabel);
        loginPanel.add(nameField);
        loginPanel.add(addressLabel);
        loginPanel.add(addressField);
        loginPanel.add(loginButton);
        add(loginPanel);
    }
}





