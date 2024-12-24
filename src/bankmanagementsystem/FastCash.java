package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    
    JButton Amount1, Amount2, Amount3, Amount4, Amount5, Amount6, Back;
    String pinnumber;
            
    FastCash(String pinnumber){
        this.pinnumber= pinnumber;
        setLayout(null);
        
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        Image i2 = il.getImage().getScaledInstance(800,800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(220,290,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 14));
        image.add(text);
        
        Amount1= new JButton("Rs.100");
        Amount1.setBounds(195,345,130,30);
        Amount1.addActionListener(this);
        image.add(Amount1);
        
        Amount2= new JButton("Rs.500");
        Amount2.setBounds(335,345,130,30);
        Amount2.addActionListener(this);
        image.add(Amount2);
        
        Amount3= new JButton("Rs.1000");
        Amount3.setBounds(195,385,130,30);
        Amount3.addActionListener(this);
        image.add(Amount3);
        
        Amount4= new JButton("Rs.2000");
        Amount4.setBounds(335,385,130,30);
        Amount4.addActionListener(this);
        image.add(Amount4);

        Amount5= new JButton("Rs.5000");
        Amount5.setBounds(195,425,130,30);
        Amount5.addActionListener(this);
        image.add(Amount5);
        
        Amount6= new JButton("Rs.10000");
        Amount6.setBounds(335,425,130,30);
        Amount6.addActionListener(this);
        image.add(Amount6);
        
        Back= new JButton("Back");
        Back.setBounds(335,465,130,30);
        Back.addActionListener(this);
        image.add(Back);
       
        setSize(900,900);
        setLocation(350,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == Back ){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c= new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin= '"+pinnumber+"'");
                int balance =0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }
                    else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
            if(ae.getSource() != Back && balance < Integer.parseInt(amount)){
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return;
            }
            Date date = new Date();
            String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Rs " +amount+ "Debited Successfully");
            
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
     public static void main(String args[]){
        new FastCash("");
    }
        
    }
    
    
   
