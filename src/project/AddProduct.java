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
import java.util.Scanner;

public class AddProduct extends JFrame implements ActionListener {
    JTextField textField1, textField2, textField3, textField4, textField5;
    JLabel label1, label2, label3, label4, label5, label6, label7;
    JButton button1, button2;
    JTable table;
    JScrollPane scrollPane;
    DefaultTableModel tableModel;
    String row[] = new String[5];

    AddProduct() {
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
        label1 = new JLabel("Product Management");
        label1.setFont(new Font("Segoe UI Symbol", Font.BOLD, 30));
        label1.setBounds(5, 5, 800, 40);

        label2 = new JLabel("Product Management (;");
        label2.setBounds(10, 45, 800, 25);

        label3 = new JLabel("Product Name");
        label3.setBounds(20, 75, 100, 25);

        textField1 = new JTextField();
        textField1.setBounds(250, 75, 200, 25);

        label4 = new JLabel("Cost Per Unit");
        label4.setBounds(20, 105, 100, 25);

        textField2 = new JTextField();
        textField2.setBounds(250, 105, 200, 25);

        label5 = new JLabel("Company Name");
        label5.setBounds(20, 135, 100, 25);

        textField3 = new JTextField();
        textField3.setBounds(250, 135, 200, 25);

        label6 = new JLabel("Product Type");
        label6.setBounds(20, 165, 100, 25);

        textField4 = new JTextField();
        textField4.setBounds(250, 165, 200, 25);

        label7 = new JLabel("Description");
        label7.setBounds(20, 195, 100, 25);

        textField5 = new JTextField();
        textField5.setBounds(250, 195, 200, 25);

        button1 = new JButton("Add Product");
        button1.setBounds(40, 225, 150, 25);

        button2 = new JButton("Cancel");
        button2.setBounds(250, 225, 150, 25);

        String column[]={"Product Name","Cost Per Unit","Company Name","Product Type","Description"};

        table = new JTable();
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(column);
        table.setModel(tableModel);
        table.setRowHeight(25);

        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10,265,910,185);

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
            row[0]= textField1.getText();
            row[1]= textField2.getText();
            row[2]= textField3.getText();
            row[3]= textField4.getText();
            row[4]= textField5.getText();
            JOptionPane.showMessageDialog(null,   "Successfully Add");
            tableModel.addRow(row);
            try {
                File file1 = new File("Product.txt");
                File file2 = new File("ProductFinal.txt");
                Scanner obj = new Scanner(file1);
                PrintWriter file3 = new PrintWriter(file2);
                while (obj.hasNext()) {
                    String r1 = obj.nextLine();
                    String[] r2 = r1.split(",");
                    file3.println(r2[0] + "," + r2[1] + "," + r2[2] + "," + r2[3] + "," + r2[4]);
                }
                file3.println(row[0] + "," + row[1] + "," + row[2] + "," + row[3] + "," + row[4]);
                file3.close();
            } catch (IOException w) {
                w.printStackTrace();
            }
            try {
                File file1 = new File("Product.txt");
                File file2 = new File("ProductFinal.txt");
                Scanner obj = new Scanner(file2);
                PrintWriter file3 = new PrintWriter(file1);
                while (obj.hasNext()) {
                    String r1 = obj.nextLine();
                    String[] r2 = r1.split(",");
                    file3.println(r2[0] + "," + r2[1] + "," + r2[2] + "," + r2[3] + "," + r2[4]);
                }
                file3.close();
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
        new AddProduct();
    }
}
