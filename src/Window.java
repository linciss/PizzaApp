import javax.swing.*;

public class Window extends JFrame {
    SelectionMenu selectionMenu = new SelectionMenu(this);
    LoginMenu loginMenu = new LoginMenu(this, selectionMenu);
    public Window(){
        setSize(400, 600);
        //add(selectionMenu);
        add(loginMenu);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }


}
