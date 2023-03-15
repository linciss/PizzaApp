package Menus;

import Menus.LoginMenu;
import Menus.SelectionMenu;
import Objects.Person;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    PersonInfoMenu personInfoMenu;
    ConfirmationMenu confirmationMenu;
    SelectionMenu selectionMenu = new SelectionMenu(this, confirmationMenu);
    public Person person;
    LoginMenu loginMenu = new LoginMenu(this, selectionMenu);


    //Frame constructor
    public Window(){

        setTitle("Pizza Ordering App");

        setSize(400, 600);

        add(loginMenu);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

    }




}
