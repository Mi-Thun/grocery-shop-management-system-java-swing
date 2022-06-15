package project;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AddSells extends JFrame implements ActionListener {
    JTextField textField1, textField2, textField3, textField4, textField5;
    JLabel label1, label2, label3, label4, label5, label6, label7,label8;
    JButton button1, button2;
    JTable table;
    JScrollPane scrollPane;
    DefaultTableModel tableModel;
    String row[] = new String[5];

    AddSells() {
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
        label1 = new JLabel("Sales Dashboard");
        label1.setFont(new Font("Segoe UI Symbol", Font.BOLD, 30));
        label1.setBounds(5, 5, 800, 40);

        label2 = new JLabel("Customer Details (;");
        label2.setBounds(10, 45, 800, 25);

        label3 = new JLabel("Customer Name");
        label3.setBounds(10, 75, 100, 25);

        textField1 = new JTextField();
        textField1.setBounds(120, 75, 200, 25);

        label4 = new JLabel("Phone Number");
        label4.setBounds(340, 75, 100, 25);

        textField2 = new JTextField();
        textField2.setBounds(450, 75, 200, 25);

        label5 = new JLabel("Product Name");
        label5.setBounds(10, 105, 100, 25);

        textField3 = new JTextField();
        textField3.setBounds(120, 105, 200, 25);

        label6 = new JLabel("Quantity");
        label6.setBounds(340, 105, 100, 25);

        textField4 = new JTextField();
        textField4.setBounds(450, 105, 200, 25);

        label7 = new JLabel("Cost");
        label7.setBounds(10, 135, 100, 25);

        textField5 = new JTextField();
        textField5.setBounds(120, 135, 200, 25);

        button1 = new JButton("Add Sales");
        button1.setBounds(40, 165, 150, 25);

        button2 = new JButton("Cancel");
        button2.setBounds(250, 165, 150, 25);

        label8 = new JLabel("# Available Product List....");
        label8.setFont(new Font("Segoe UI Symbol", Font.BOLD, 20));
        label8.setBounds(10,200,500,30);

        String column[] = {"Product Name","Cost Per Unit","Company Name","Type","Description"};

        table = new JTable();
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(column);
        table.setModel(tableModel);
        table.setRowHeight(25);

        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 235, 910, 215);

        try {
            File file = new File("Product.txt");
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
                tableModel.addRow(r3);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        add(label1);
        add(label2);
        add(label3);
        add(label4);
        add(label5);
        add(label6);
        add(label7);
        add(label8);
        add(textField1);
        add(textField2);
        add(textField3);
        add(textField4);
        add(textField5);
        add(button1);
        add(button2);
        add(scrollPane);

        setSize(945, 500);
        setLocation(300,200);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button1.addActionListener(this);
        button2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            String a = textField1.getText();
            String b = textField2.getText();
            String c = textField3.getText();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd   HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String d = dtf.format(now);
            String f = textField5.getText();
            try {
                File file1 = new File("Seals.txt");
                File file2 = new File("SealsFinal.txt");
                Scanner obj = new Scanner(file1);
                PrintWriter file3 = new PrintWriter(file2);
                while (obj.hasNext()) {
                    String r1 = obj.nextLine();
                    String[] r2 = r1.split(",");
                    file3.println(r2[0] + "," + r2[1] + "," + r2[2] + "," + r2[3] + "," + r2[4]);
                }
                file3.println(a + "," + b + "," + c + "," + d + "," + f);
                file3.close();
            } catch (IOException w) {
                w.printStackTrace();
            }
            try {
                File file1 = new File("Seals.txt");
                File file2 = new File("SealsFinal.txt");
                Scanner obj = new Scanner(file2);
                PrintWriter file3 = new PrintWriter(file1);
                while (obj.hasNext()) {
                    String r1 = obj.nextLine();
                    String[] r2 = r1.split(",");
                    file3.println(r2[0] + "," + r2[1] + "," + r2[2] + "," + r2[3] + "," + r2[4]);
                }
                file3.close();
                JOptionPane.showMessageDialog(null,   "Successfully Add");
            } catch (IOException w) {
                w.printStackTrace();
            }
        }
        if (e.getSource() == button2) {
            setVisible(false);
            new HomePage();
        }
    }

    public static void main(String[] args) {
        new AddSells();
    }
}
