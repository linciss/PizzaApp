package Menus;

import Menus.LoginMenu;
import Menus.SelectionMenu;
import Objects.Log;
import Objects.Person;
import com.formdev.flatlaf.*;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Window extends JFrame {
    Log log;
    Boolean oldLogin = false;

    PersonInfoMenu personInfoMenu;
    ConfirmationMenu confirmationMenu;
    SelectionMenu selectionMenu = new SelectionMenu(this, confirmationMenu);
    public Person person;
    LoginMenu loginMenu = new LoginMenu(this, selectionMenu);

    ArrayList<Log> orderHistory = new ArrayList<>();


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
