package bankmanagementsystem;

import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame{
    
    MiniStatement(String pinnumber){
        setTitle("MINI STATEMENT");
        setLayout(null);
        
        JLabel mini= new JLabel();
        mini.setBounds(80,130,300,200);
        add(mini);
        
        JLabel bank = new JLabel("INDIAN BANK");
        bank.setBounds(160,20,100,20);
        add(bank);
        
        JLabel card = new JLabel("Card Number");
        card.setBounds(80,70,300,20);
        add(card);
        
        JLabel balance = new JLabel();
        balance.setBounds(80,400,300,20);
        add(balance);
        
        try{
            Conn conn= new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin= '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number: " + rs.getString("cardnumber").substring(0,4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }
        }catch(Exception e){
            System.out.println(e);
        } 
        
        try{
            Conn conn = new Conn();
            int bal=0;
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText()+ "<html>" + rs.getString("type") + "&nbsp;" + rs.getString("amount") + "&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("date")+ "<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("amount"));
                }else{
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
             balance.setText("Your Current Account Balance is Rs "+ bal);
        }catch(Exception e){
            System.out.println(e);
        }
        
        setSize(400,600);
        setLocation(350,0);
        setVisible(true);
    }

    public static void main(String args[]){
        new MiniStatement("");
    }
}
