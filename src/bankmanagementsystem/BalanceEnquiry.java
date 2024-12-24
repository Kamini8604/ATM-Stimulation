package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {
    
    JButton back;
    String pinnumber;
    
   BalanceEnquiry(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        Image i2 = il.getImage().getScaledInstance(800,800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        back = new JButton("BACK");
        back.setBounds(340,450,120,25);
        back.addActionListener(this);
        image.add(back);
        
        Conn c = new Conn();
          int balance =0;
        try{
            ResultSet rs= c.s.executeQuery("select * from bank where pin= '"+pinnumber+"'");
          
            while(rs.next()){ 
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        JLabel text = new JLabel("Your Current Account Balance is RS " + balance);
        text.setForeground(Color.white);
        text.setBounds(200,360,400,30);
        image.add(text);
        
        
        setSize(900,900);
        setLocation(350,0);
        //setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(true);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new BalanceEnquiry("");
    }

    
}
