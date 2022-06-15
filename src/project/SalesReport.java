package project;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class SalesReport extends JFrame implements ActionListener {
    JLabel label1,label2;
    JButton button1;
    SalesReport() {
        try {
            final Image backgroundImage = javax.imageio.ImageIO.read(new File("iindex.png"));
            setContentPane(new JPanel(new BorderLayout()) {
                @Override public void paintComponent(Graphics g) {
                    g.drawImage(backgroundImage, 0, 0, null);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        label1 = new JLabel("Sales Report Management");
        label1.setFont(new Font("Segoe UI Symbol", Font.BOLD, 30));
        label1.setBounds(5, 10, 800, 40);

        label2 = new JLabel("Sales Management (;");
        label2.setBounds(10, 50, 800, 30);

        button1 = new JButton("Close");
        button1.setBounds(840, 425, 80, 30);

        String column[]={"Customer Name","Phone Number","Product Name","Date","Cost",};
        String row[] = new String[5];

        JTable table = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(column);
        try {
            File file = new File("Seals.txt");
            Scanner input = new Scanner(file);
            while (input.hasNext()) {
                String r1 = input.nextLine();
                String[] r2 = r1.split(",");
                String r3[] = new String[5];
                r3[0] = r2[0];
                r3[1] = r2[1];
                r3[2] = r2[2];
                r3[3] = r2[3];
                r3[4] = r2[4];
                model.addRow(r3);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        table.setModel(model);
        table.setRowHeight(25);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(10,90,920,310);

        add(label1);
        add(label2);
        add(button1);
        add(scroll);

        setSize(945, 500);
        setLocation(300,200);
        setLayout(null);
        setVisible(true);
        setName("Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button1.addActionListener(this);

    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            setVisible(false);
            new HomePage();
        }
    }

    public static void main(String[] args) {
        new SalesReport();
    }
}
