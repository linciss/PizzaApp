package Menus;

import Menus.LoginMenu;
import Menus.SelectionMenu;
import Objects.Person;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;

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
        setForeground(Color.DARK_GRAY);
        setSize(400, 600);
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        }catch (Exception e){
            e.printStackTrace();
        }
        add(loginMenu);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

    }




}
