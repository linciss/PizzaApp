package Menus;

import Objects.Log;
import Objects.Person;
import utils.WrapLayout;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class PersonInfoMenu extends JPanel {
    public Window w;
    public Person person;
    Log log;
    JPanel orderHistoryPanel;
    SelectionMenu selectionMenu;
    DecimalFormat df = new DecimalFormat(".##");

    public PersonInfoMenu(Window w, Person person, SelectionMenu selectionMenu) {
        this.person = person;
        this.w = w;
        this.selectionMenu = selectionMenu;
        setBackground(new Color(18, 18, 18));
        initPanel();
    }

    public void initPanel() {
        generatePanel();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }


    // panel.setBackground(new Color(18,18,18));
    // label.setForeground(new Color(187, 134, 252));
    // subpanel.setBackground(new Color(38, 37, 37));

    public void generatePanel() {

        JPanel backPanel = new JPanel(new BorderLayout());
        backPanel.setBackground(new Color(18, 18, 18));
        JButton backButt = new JButton("Back");
        backButt.setBackground(new Color(38, 37, 37));
        backButt.setForeground(new Color(187, 134, 252));
        //backButt.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButt.addActionListener(e -> {
            w.getContentPane().removeAll();
            w.add(selectionMenu);
            w.revalidate();
            w.repaint();
        });

        backPanel.add(backButt, BorderLayout.WEST);
        backPanel.setMaximumSize(new Dimension(400, 20));
        add(backPanel);


        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new WrapLayout());
        imagePanel.setBackground(new Color(18, 18, 18));
        ImageIcon image = new ImageIcon("src\\Images\\ProfileIcon.png");
        imagePanel.setMaximumSize(new Dimension(400, 250));
        imagePanel.add(new JLabel(image));
        add(imagePanel);


        JPanel personInfoPanel = new JPanel();
        personInfoPanel.setLayout(new BoxLayout(personInfoPanel, BoxLayout.Y_AXIS));
        personInfoPanel.setBackground(new Color(18, 18, 18));

        JLabel nameLabel = new JLabel("Name: " + person.getName());
        JLabel addressLabel = new JLabel("Address: " + person.getAddress());
        JLabel distanceLabel = new JLabel("Distance: " + df.format(person.getDistance()) + " KM");
        JLabel orderLabel = new JLabel("Order History");

        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameLabel.setForeground(new Color(187, 134, 252));
        nameLabel.setFont(new Font(nameLabel.getFont().getFontName(), nameLabel.getFont().getStyle(), 20));

        addressLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        addressLabel.setForeground(new Color(187, 134, 252));
        addressLabel.setFont(new Font(addressLabel.getFont().getFontName(), addressLabel.getFont().getStyle(), 20));

        distanceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        distanceLabel.setForeground(new Color(187, 134, 252));
        distanceLabel.setFont(new Font(distanceLabel.getFont().getFontName(), distanceLabel.getFont().getStyle(), 20));

        orderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        orderLabel.setForeground(new Color(187, 134, 252));
        orderLabel.setFont(new Font(orderLabel.getFont().getFontName(), orderLabel.getFont().getStyle(), 20));

        //ORDER HISTORY
        JLabel orderHistoryLabel;

        orderHistoryPanel = new JPanel();
        orderHistoryPanel.setLayout(new BoxLayout(orderHistoryPanel, BoxLayout.Y_AXIS));
        orderHistoryPanel.setBackground(new Color(18, 18, 18));
        orderHistoryPanel.setMaximumSize(new Dimension(400, 50));
        System.out.println(w.oldLogin + "PersonInfoMenu");
                readOrderHistory();

            JScrollPane scrollBar = new JScrollPane(orderHistoryPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scrollBar.getVerticalScrollBar().setUnitIncrement(16);

        /*JPanel backPanel = new JPanel();
        backPanel.setLayout(new BoxLayout(backPanel, BoxLayout.Y_AXIS));
        backPanel.setBackground(new Color(18,18,18));
        backPanel.setMaximumSize(new Dimension(400, 200));

        JButton backButt = new JButton("Back");
        backButt.setBackground(new Color(38, 37, 37));
        backButt.setForeground(new Color(187, 134, 252));
        backButt.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButt.addActionListener(e -> {
            w.getContentPane().removeAll();
            w.add(selectionMenu);
            w.repaint();
        });*/

            personInfoPanel.add(nameLabel);
            personInfoPanel.add(addressLabel);
            personInfoPanel.add(distanceLabel);
            personInfoPanel.add(orderLabel);
            add(personInfoPanel);
            add(scrollBar);
        }


        public void readOrderHistory() {
           JLabel orderHistoryLabel;
            try {
                FileReader fr = new FileReader(new File("OrderHistory.txt"));
                BufferedReader br = new BufferedReader(fr);
                if(new File("OrderHistory.txt").length() == 0) {
                    orderHistoryLabel = new JLabel("No order history");
                    orderHistoryLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                    orderHistoryLabel.setForeground(new Color(187, 134, 252));
                    orderHistoryLabel.setFont(new Font(orderHistoryLabel.getFont().getFontName(), orderHistoryLabel.getFont().getStyle(), 15));
                    orderHistoryPanel.add(orderHistoryLabel);
                    return;
                }
                while (br.ready()) {
                    orderHistoryLabel = new JLabel(br.readLine());
                    orderHistoryLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                    orderHistoryLabel.setForeground(new Color(187, 134, 252));
                    orderHistoryLabel.setFont(new Font(orderHistoryLabel.getFont().getFontName(), orderHistoryLabel.getFont().getStyle(), 15));
                    orderHistoryPanel.add(orderHistoryLabel);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

