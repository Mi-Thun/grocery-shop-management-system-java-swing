package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class ConfirmPage extends JFrame implements ActionListener {
    JLabel label1, label2, label3, label4;
    JTextField textField1,textField2;
    JPasswordField passwordField1;
    JButton button1, button2;

    ConfirmPage() {
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
        label1 = new JLabel("Set new password");
        label1.setFont(new Font("Segoe UI Symbol",Font.BOLD,25));
        label1.setBounds(50, 180, 400, 30);

        label4 = new JLabel("OTP Number");
        label4.setBounds(50, 240, 200, 30);

        textField2 = new JTextField();
        textField2.setBounds(150, 240, 700, 30);

        label2 = new JLabel("New UserName");
        label2.setBounds(50, 280, 200, 30);

        textField1 = new JTextField();
        textField1.setBounds(150, 280, 700, 30);

        label3 = new JLabel("New password");
        label3.setBounds(50, 320, 200, 30);

        passwordField1 = new JPasswordField();
        passwordField1.setBounds(150, 320, 700, 30);

        button1 = new JButton("Confirm");
        button1.setBounds(320, 370, 100, 30);

        button2 = new JButton("Cancel");
        button2.setBounds(520, 370, 100, 30);

        add(label1);
        add(label2);
        add(label3);
        add(label4);
        add(button1);
        add(button2);
        add(textField1);
        add(textField2);
        add(passwordField1);

        setSize(945, 500);
        setLocation(300,200);
        setLayout(null);
        setVisible(true);
        setName("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button1.addActionListener(this);
        button2.addActionListener(this);
    }

    public static void main(String[] args) {
        new ConfirmPage();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            try {
                File file1 = new File("Hidden.txt");
                PrintWriter file2 = new PrintWriter(file1);

                file2.println(textField1.getText());
                file2.println(new String(passwordField1.getPassword()));

                file2.close();
                JOptionPane.showMessageDialog(null,   "Successfully Change");
                new AdminLogin();

            } catch (IOException w) {
                w.printStackTrace();
            }
            setVisible(false);
        }
        if (e.getSource() == button2) {
            setVisible(false);
            new AdminLogin();
        }
    }
}
