package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    JLabel text;
    JTextField amount;
    JButton deposit, back;
    String pinnumber;
    
    Deposit(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        Image i2 = il.getImage().getScaledInstance(800,800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        text = new JLabel("Enter the amount you want to deposit");
        text.setBounds(200,300,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 14));
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD,22));
        amount.setBounds(235,345,200,30);
        image.add(amount);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(340,425,130,30);
        deposit.addActionListener(this);
        image.add(deposit);       
        
        back = new JButton("Back");
        back.setBounds(340,465,130,30);
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(900,900);
        setLocation(350,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == deposit){
            String number = amount.getText();
            Date date= new Date();
            
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            }
            else{
                try{
                    Conn conn = new Conn();
                    String query = "insert into bank values('"+pinnumber+"', '"+date+"','Deposit','"+number+"')"; 
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+number+" Deposited Successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        
        else if(ae.getSource() == back){
                setVisible(true);
                new Transactions(pinnumber).setVisible(true);
            }
        }
    
    public static void main(String args[]){
        new Deposit("");
    }

    
}
