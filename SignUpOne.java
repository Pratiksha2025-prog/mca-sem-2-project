package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
//import java.sql.*;

public class SignUpOne extends JFrame implements ActionListener {

    long random;
    JTextField nameTextField, fnameTextField, dobTextField, emailTextField, cityTextField, addressTextField, stateTextField, pincodeTextField;
    JButton next;
    JRadioButton male, female, married, unmarried, other;
    

    SignUpOne() {
        
        

        setTitle("New Account Application Form : BOI Bank ");
        setLayout(null);

        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        JLabel formnumber = new JLabel("APPLICATION FORM NO. " + random);
        formnumber.setFont(new Font("Raleway", Font.BOLD, 38));
        formnumber.setBounds(140, 20, 600, 40);
        add(formnumber);

        JLabel personaldetails = new JLabel(" Page 1 : Personal Details " );
        personaldetails.setFont(new Font("Raleway", Font.BOLD,22));
        personaldetails.setBounds(290, 80, 400, 30);
        add(personaldetails);
        
        
         
        JLabel name = new JLabel(" Name : " );
        name.setFont(new Font("Raleway", Font.BOLD,20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD,14));
        nameTextField.setBackground(Color.WHITE);
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);
        
        JLabel fname = new JLabel(" Father's Name : " );
        fname.setFont(new Font("Raleway", Font.BOLD,20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD,14));
        fnameTextField.setBackground(Color.WHITE);
        fnameTextField.setBounds(300,190,400,30);
        add(fnameTextField);
        
        JLabel dob = new JLabel(" Date Of Birth : ");
        dob.setFont(new Font("Raleway", Font.BOLD,20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        
         
        dobTextField = new JTextField();
        dobTextField.setFont(new Font("Raleway", Font.BOLD,14));
        dobTextField.setBackground(Color.WHITE);
        dobTextField.setBounds(300,240,400,30);
        add(dobTextField);
        
        
        JLabel gender = new JLabel(" Gender : ");
        gender.setFont(new Font("Raleway", Font.BOLD,20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);
        
        male = new JRadioButton(" Male");
        male.setBounds(300,290,100,30);
        male.setBackground(Color.white);
        male.setForeground(Color.black);
        add(male); 
        
        female = new JRadioButton(" Female");
        female.setBounds(450,290,100,30);
        female.setBackground(Color.white);
        female.setForeground(Color.black);
        add(female);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        JLabel email = new JLabel(" Email Address : ");
        email.setFont(new Font("Raleway", Font.BOLD,20));
        email.setBounds(100, 340, 200, 30);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD,14));
        emailTextField.setBackground(Color.WHITE);
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);
        
        JLabel marital = new JLabel(" Marital Status : ");
        marital.setFont(new Font("Raleway", Font.BOLD,20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);
        
        married = new JRadioButton("Married");
        married.setBounds(300, 390, 100, 30);
        married.setBackground(Color.white);
        married.setForeground(Color.black);
        add(married);
        
        unmarried = new JRadioButton(" Unmarried");
        unmarried.setBounds(450, 390, 140, 30);
        unmarried.setBackground(Color.white);
        unmarried.setForeground(Color.black);
        add(unmarried);
        
        other = new JRadioButton(" Other ");
        other.setBounds(630, 390, 100, 30);
        other.setBackground(Color.white);
        other.setForeground(Color.black);
        add(other);
        
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);
        
        JLabel address = new JLabel(" Address : ");
        address.setFont(new Font("Raleway", Font.BOLD,20));
        address.setBounds(100, 440, 200, 30);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD,14));
        addressTextField.setBackground(Color.WHITE);
        addressTextField.setBounds(300,440,400,30);
        add(addressTextField);
        
        JLabel city = new JLabel(" City : ");
        city.setFont(new Font("Raleway", Font.BOLD,20));
        city.setBounds(100, 490, 200, 30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD,14));
        cityTextField.setBackground(Color.WHITE);
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);
        
        JLabel state = new JLabel(" State : ");
        state.setFont(new Font("Raleway", Font.BOLD,20));
        state.setBounds(100, 540, 200, 30);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD,14));
        stateTextField.setBackground(Color.WHITE);
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);
        
        JLabel pincode = new JLabel(" Pincode : ");
        pincode.setFont(new Font("Raleway", Font.BOLD,20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);
        
        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway", Font.BOLD,14));
        pincodeTextField.setBackground(Color.WHITE);
        pincodeTextField.setBounds(300,590,400,30);
        add(pincodeTextField);
        
        
        next = new JButton(" NEXT ");
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.setFont(new Font("Raleway" , Font.BOLD,14));
        next.setBounds(590, 640, 100, 40);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800, 720);
        setLocation(350, 10);
        setVisible(true);

        

    }

    public void actionPerformed(ActionEvent ae) {
        String formnumber = " " + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = dobTextField.getText();

        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }

        String email = emailTextField.getText();
        String marital = null;
        if (married.isSelected()) {
            marital = "Married";
        } else if (unmarried.isSelected()) {
            marital = "Unmarried";
        } else if (other.isSelected()) {
            marital = "Other";
        }

        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String pincode = pincodeTextField.getText();
        String state = stateTextField.getText();

        try {

            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required");
            } else {
                Conn c = new Conn();
                String query = " insert into signup values('" + formnumber + "' , '" + name + "' , '" + fname + "', '" + dob + "' , '" + gender + "' , '" + email + "' , '" + marital + "', '" + address + "' , '" + city + "' , '" + state + "' , '" + pincode + "' )";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formnumber).setVisible(true);
            }

            if (fname.equals("")) {
                JOptionPane.showMessageDialog(null, "Father's Name is Required");
            }

            if (dob.equals("")) {
                JOptionPane.showMessageDialog(null, "Date of Birth is Required");
            }

            if (marital.equals("")) {
                JOptionPane.showMessageDialog(null, "Marital Status is Required");
            }

            if (email.equals("")) {
                JOptionPane.showMessageDialog(null, "Email is Required");
            }

            if (address.equals("")) {
                JOptionPane.showMessageDialog(null, "Address is Required");
            }

            if (city.equals("")) {
                JOptionPane.showMessageDialog(null, "City is Required");
            }

            if (state.equals("")) {
                JOptionPane.showMessageDialog(null, "State is Required");
            }

            if (pincode.equals("")) {
                JOptionPane.showMessageDialog(null, "Pincode is Required");
            }
            

        } catch (Exception e) {

            System.out.println(e);
        }

    }

    public static void main(String args[]) {
        new SignUpOne().setVisible(true);

    }

}
