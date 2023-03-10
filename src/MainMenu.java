import javax.swing.*;

public class MainMenu extends JFrame {
    SelectionMenu selectionMenu = new SelectionMenu(this);
    public MainMenu (){
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(selectionMenu);
        setVisible(true);

    }



}
