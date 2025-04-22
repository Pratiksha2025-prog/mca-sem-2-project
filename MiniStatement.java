package bankmanagementsystem;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {
    
    MiniStatement(String pin) {
        setTitle("Mini Statement");
        
        // Labels for displaying the data
        JLabel mini = new JLabel();
        mini.setBounds(20,140,600,200);
        add(mini);
        
        JLabel bank = new JLabel(" BOI Bank");
        bank.setBounds(150,20,500,20);
        add(bank);
        
        JLabel card = new JLabel(" BOI Bank");
        card.setBounds(20,80,500,20);
        add(card);
        
        JLabel balance = new JLabel(" BOI Bank");
        balance.setBounds(20,400,300,20);
        add(balance);
        
        // Fetch and display the card number from the 'login' table
        try{
            Conn conn = new Conn();  // Establish database connection  
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '"+pin+"'"); // Query the database for the 'pin' column
            while(rs.next()){
                card.setText("Card Number : " + rs.getString("cardnumber").substring(0,4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        // Fetch and display the transaction history and balance from the 'bank' table
        try{
            Conn conn = new Conn();
            int bal = 0;
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pin+"'"); // Query the database for the 'pin' column in the 'bank' table
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +  rs.getString("amount") + "<br><br><html>");  
                
                // Calculate balance
                if(rs.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your current account balance is Rs : " + bal);
        }catch(Exception e){
            System.out.println(e);
        }
        
        // Setting up the JFrame
        setLayout(null);
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }
    
    public static void main(String args[]){
        new MiniStatement("").setVisible(true); // Pass a valid pin to test
    }
}
