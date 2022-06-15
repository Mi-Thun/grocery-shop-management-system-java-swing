package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class ForgottenPassword extends JFrame implements ActionListener {
    JLabel label1,label2,label3;
    JButton button1;

    ForgottenPassword() {
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
        label1 = new JLabel("Check Your Phone Number");
        label1.setFont(new Font("Segoe UI Symbol", Font.BOLD, 20));
        label1.setBounds(350, 60, 800, 40);

        label3 = new JLabel("Without OTP by send this number you can not do anything");
        label3.setBounds(320, 425, 800, 30);

        label2 = new JLabel(" 01521509030");
        label2.setFont(new Font("Segoe UI Symbol", Font.BOLD, 20));
        label2.setBounds(400, 110, 500, 30);

        button1 = new JButton("Confirm");
        button1.setBounds(400, 150, 140, 30);

        add(label1);
        add(button1);
        add(label2);
        add(label3);

        setSize(945, 500);
        setLocation(300,200);
        setLayout(null);
        setVisible(true);
        setName("Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button1.addActionListener(this);
    }

    public static void main(String[] args) {
        new ForgottenPassword();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            setVisible(false);
            new ConfirmPage();
            JOptionPane.showMessageDialog(null,   "Successfully Complete Please Check Your Message");
        }
    }
}
