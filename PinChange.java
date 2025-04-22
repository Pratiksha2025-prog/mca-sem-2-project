package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class PinChange extends JFrame implements ActionListener {

    JPasswordField pin, repin;
    JButton change, back;
    String pinnumber;

    PinChange(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Change Your PIN");
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 26));
        text.setBounds(220, 290, 500, 30);
        image.add(text);

        JLabel pintext = new JLabel("Enter New PIN: ");
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setBounds(165, 340, 180, 24);
        image.add(pintext);

        pin = new JPasswordField();
        pin.setForeground(Color.black);
        pin.setFont(new Font("Raleway", Font.BOLD, 16));
        pin.setBounds(330, 340, 180, 20);
        image.add(pin);

        JLabel repintext = new JLabel("Re-Enter New PIN: ");
        repintext.setForeground(Color.white);
        repintext.setFont(new Font("System", Font.BOLD, 16));
        repintext.setBounds(165, 370, 180, 24);
        image.add(repintext);

        repin = new JPasswordField();
        repin.setForeground(Color.black);
        repin.setFont(new Font("Raleway", Font.BOLD, 16));
        repin.setBounds(330, 370, 180, 20);
        image.add(repin);

        change = new JButton("CHANGE");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            try {
                // Correct way to retrieve password from JPasswordField
                String npin = new String(pin.getPassword());
                String rpin = new String(repin.getPassword());

                // Validation
                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PINs do not match.");
                    return;
                }

                if (npin.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid PIN.");
                    return;
                }

                Conn conn = new Conn(); // Database connection

                // Use correct column name 'pin' in all queries
                String query1 = "UPDATE bank SET pin = ? WHERE pin = ?";
                String query2 = "UPDATE login SET pin = ? WHERE pin = ?";
                String query3 = "UPDATE signupthree SET pin = ? WHERE pin = ?";

                PreparedStatement stmt1 = conn.c.prepareStatement(query1);
                stmt1.setString(1, rpin);
                stmt1.setString(2, pinnumber);
                stmt1.executeUpdate();

                PreparedStatement stmt2 = conn.c.prepareStatement(query2);
                stmt2.setString(1, rpin);
                stmt2.setString(2, pinnumber);
                stmt2.executeUpdate();

                PreparedStatement stmt3 = conn.c.prepareStatement(query3);
                stmt3.setString(1, rpin);
                stmt3.setString(2, pinnumber);
                stmt3.executeUpdate();

                JOptionPane.showMessageDialog(null, "PIN Changed Successfully.");

                setVisible(false);
                new Transactions(rpin).setVisible(true);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        } else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
