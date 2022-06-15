package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About extends JFrame implements ActionListener {
    JLabel label1, label2, label3;
    JTextField textField1;
    JPasswordField passwordField1;
    JButton button1,button2,button3;

    About(){
        label1 = new JLabel("About Grocery Shop Management System");
        label1.setFont(new Font("Segoe UI Symbol",Font.BOLD,30));
        label1.setBounds(5, 10, 800, 40);

        label2 = new JLabel("<html>"+ "A grocery shop sales associate is responsible for all sales activities and sales associate job duties, from greeting customers, answering question, offering assistance, suggesting items, lending opinions and providing product information. Individual responsibilities as a retail sales associate may include demonstrating outstanding customer service and selling skills, keeping the selling floor stocked with merchandise, assisting in display of merchandise or organizing the selling floor and stock areas. A retail sale associte must process payments by totaling purchases, processing checks, cash and store or other credit card. Must also be able to deal with custonar refunds courteously and professionally."+"</html>");
        label2.setBounds(20, 30, 850, 200);
        label2.setFont(new Font("Segoe UI Symbol",Font.ITALIC,16));

        button1 = new JButton("Close");
        button1.setBounds(840, 425, 80, 30);

        /*try {
            final Image backgroundImage = javax.imageio.ImageIO.read(new File("D:\\iindex.png"));
            setContentPane(new JPanel(new BorderLayout()) {
                @Override public void paintComponent(Graphics g) {
                    g.drawImage(backgroundImage, 0, 230, null);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        add(label1);
        add(label2);
        add(button1);

        setSize(945, 500);
        setLocation(300,200);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button1.addActionListener(this);
    }

    public static void main(String[] args) {
        new About();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            setVisible(false);
            new HomePage();
        }
    }
}
