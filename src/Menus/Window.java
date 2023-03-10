package Menus;

import Menus.LoginMenu;
import Menus.SelectionMenu;
import Objects.Person;

import javax.swing.*;

public class Window extends JFrame {
    PersonInfoMenu personInfoMenu;

    SelectionMenu selectionMenu = new SelectionMenu(this);
    Person person;
    LoginMenu loginMenu = new LoginMenu(this, selectionMenu);


    //Frame constructor
    public Window(){

        setTitle("Pizza Ordering App");


        setSize(300, 150);
        //add(selectionMenu);

        add(loginMenu);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }




}
