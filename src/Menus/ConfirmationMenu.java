package Menus;

import javax.swing.*;
import java.awt.*;

public class ConfirmationMenu extends JPanel{
    Window w;
    SelectionMenu SelectionMenu;
    public ConfirmationMenu(Window w, SelectionMenu SelectionMenu){
              this.SelectionMenu = SelectionMenu;
           this.w = w;
              initPanel();
    }
    public void initPanel(){
        generatePanel();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public void generatePanel(){
        JPanel confirmationPanel = new JPanel();
        confirmationPanel.setLayout(new BoxLayout(confirmationPanel, BoxLayout.Y_AXIS));

        JLabel confirmationLabel = new JLabel("Are you sure you want to exit?");
        confirmationLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton yesButt = new JButton("Yes");
        yesButt.setAlignmentX(Component.CENTER_ALIGNMENT);
        yesButt.addActionListener(e -> {
            System.exit(0);
        });

        JButton noButt = new JButton("No");
        noButt.setAlignmentX(Component.CENTER_ALIGNMENT);
        noButt.addActionListener(e -> {
            w.getContentPane().removeAll();
            w.add(new SelectionMenu(w, this));
            w.revalidate();
        });

        confirmationPanel.add(confirmationLabel);
        confirmationPanel.add(yesButt);
        confirmationPanel.add(noButt);
        add(confirmationPanel);
    }


}
