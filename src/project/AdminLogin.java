package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class AdminLogin extends JFrame implements ActionListener{
    JLabel label1, label2, label3;
    JTextField textField1;
    JPasswordField passwordField1;
    JButton button1,button2,button3;

    AdminLogin() {
        try {
            final Image backgroundImage = javax.imageio.ImageIO.read(new File("iindex.png"));
            setContentPane(new JPanel(new BorderLayout()) {
                @Override public void paintComponent(Graphics g) {
                    g.drawImage(backgroundImage, 10, 0, null);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        label1 = new JLabel("Login");
        label1.setFont(new Font("Segoe UI Symbol",Font.BOLD,30));
        label1.setBounds(50, 220, 200, 40);

        label2 = new JLabel("UserName");
        label2.setBounds(50, 280, 200, 30);

        textField1 = new JTextField();
        textField1.setBounds(150, 280, 700, 30);

        label3 = new JLabel("Password");
        label3.setBounds(50, 320, 200, 30);

        passwordField1 = new JPasswordField();
        passwordField1.setBounds(150, 320, 700, 30);

        button1 = new JButton("Login");
        button1.setBounds(320, 370, 100, 30);

        button2 = new JButton("Close");
        button2.setBounds(520, 370, 100, 30);

        button3 = new JButton("Forget Password?");
        button3.setBounds(320, 420, 300, 30);

        add(label1);
        add(label2);
        add(label3);
        add(button1);
        add(button2);
        add(button3);
        add(textField1);
        add(passwordField1);

        setSize(945, 500);
        setLocation(300,200);
        setLayout(null);
        setVisible(true);
        setName("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
    }

    public static void main(String[] args) {
        new AdminLogin();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            File file = new File("Hidden.txt");
            Scanner input = null;
            try {
                input = new Scanner(file);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            String adminUserName = input.nextLine();
            String adminPassword = input.nextLine();
            if (adminUserName.equals(textField1.getText()) && adminPassword.equals(new String(passwordField1.getPassword()))) {
                setVisible(false);
                new HomePage();
            } else {
                JOptionPane.showMessageDialog(null,   "Invalid UserName or Password");
            }
        }
        if (e.getSource() == button2) {
            dispose();
        }
        if (e.getSource() == button3) {
            setVisible(false);
            new ForgottenPassword();
        }
    }
}

