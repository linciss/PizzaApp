import javax.swing.*;

public class SelectionMenu extends JPanel {

    MainMenu menu;

    public SelectionMenu(MainMenu menu){
    this.menu = menu;
    initPanel();
    }

    public void initPanel(){

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JScrollPane scrollBar=new JScrollPane(pizzaPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollBar.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollBar);
    }

    JPanel pizzaPanel = new JPanel();



}
