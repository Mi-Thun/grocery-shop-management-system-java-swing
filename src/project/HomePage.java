package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class HomePage extends JFrame implements ActionListener {
    JLabel label1, label2;
    JButton button1, button2, button3, button4, button5, button6;

    HomePage() {
        button1 = new JButton("About");
        button1.setBounds(20, 30, 140, 30);

        button2 = new JButton("Add Product");
        button2.setBounds(170, 30, 140, 30);

        button3 = new JButton("Product Report");
        button3.setBounds(320, 30, 140, 30);

        button4 = new JButton("Add Seals");
        button4.setBounds(470, 30, 140, 30);

        button5 = new JButton("Sales Report");
        button5.setBounds(620, 30, 140, 30);

        button6 = new JButton("Logout");
        button6.setBounds(770, 30, 140, 30);

        label1 = new JLabel("Grocery Shop Management System");
        label1.setFont(new Font("Segoe UI Symbol", Font.BOLD, 30));
        label1.setBounds(5, 70, 800, 40);

        label2 = new JLabel("Admin Dashboard..................................................");
        label2.setBounds(10, 110, 800, 30);

        try {
            final Image backgroundImage = javax.imageio.ImageIO.read(new File("final05.jpg"));
            setContentPane(new JPanel(new BorderLayout()) {
                @Override public void paintComponent(Graphics g) {
                    g.drawImage(backgroundImage, 0, 140, null);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        add(label1);
        add(label2);
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
        add(button6);

        setSize(945, 500);
        setLocation(300,200);
        setLayout(null);
        setVisible(true);
        setName("Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
    }

    public static void main(String[] args) {
        new HomePage();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            setVisible(false);
            new About();
        }
        if (e.getSource() == button2) {
            setVisible(false);
            new AddProduct();
        }
        if (e.getSource() == button3) {
            setVisible(false);
            new ProductReport();
        }
        if (e.getSource() == button4) {
            setVisible(false);
            new AddSells();
        }
        if (e.getSource() == button5) {
            setVisible(false);
            new SalesReport();
        }
        if (e.getSource() == button6) {
            setVisible(false);
            new AdminLogin();
        }
    }
}