import javax.swing.*;

public class LoginMenu extends JPanel{
    Window w;
    SelectionMenu selectionMenu;
    public LoginMenu(Window w, SelectionMenu selectionMenu){
        this.selectionMenu = selectionMenu;
        this.w = w;
        initPanel();
    }

    public void initPanel(){

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

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> {
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




