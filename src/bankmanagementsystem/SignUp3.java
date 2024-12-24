package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignUp3 extends JFrame implements ActionListener{
    
    JRadioButton r1,r2, r3, r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit, cancel;
    String formno;
    
    SignUp3(String  formno){
        this.formno = formno;
        setLayout(null);
        setSize(700, 800);
        setLocation(400,10);
        setVisible(true); 
        getContentPane().setBackground(Color.white);
        
        JLabel l1= new JLabel("Page III Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,20));
        l1.setBounds(220,40,400, 40);
        add(l1);
        
        JLabel type= new JLabel("ACCOUNT TYPE");
        type.setFont(new Font("Raleway", Font.BOLD, 20));
        type.setBounds(80, 120, 200, 30);
        add(type);
        
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.PLAIN, 14));
        r1.setBackground(Color.white);
        r1.setBounds(130, 160, 220, 20);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.PLAIN, 14));
        r2.setBackground(Color.white);
        r2.setBounds(350, 160, 250, 20);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.PLAIN, 14));
        r3.setBackground(Color.white);
        r3.setBounds(130, 190, 220, 20);
        add(r3);
        
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.PLAIN, 14));
        r4.setBackground(Color.white);
        r4.setBounds(350, 190, 250, 20);
        add(r4);
        
        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);
        
        JLabel card = new JLabel("CARD NUMBER");
        card.setFont(new Font("Raleway", Font.BOLD, 20));
        card.setBounds(80,240,200,30);
        add(card);
        
        JLabel number = new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway", Font.PLAIN, 20));
        number.setBounds(350,240,300,30);
        add(number);
        
        JLabel carddetail = new JLabel("Your 16 Digit Card Number");
        carddetail.setFont(new Font("Raleway", Font.BOLD, 13));
        carddetail.setBounds(350,260,300,30);
        add(carddetail);
        
        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(80,310,200,30);
        add(pin);
        
        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.PLAIN, 20));
        pnumber.setBounds(350,310,300,30);
        add(pnumber);
        
        JLabel pindetail = new JLabel("Your 4 digit Password");
        pindetail.setFont(new Font("Raleway", Font.BOLD, 12));
        pindetail.setBounds(350,330,300,30);
        add(pindetail);
        
        JLabel services = new JLabel("SERVICES REQUIRED");
        services.setFont(new Font("Raleway", Font.BOLD, 20));
        services.setBounds(80,380,300,30);
        add(services);
       
        c1 = new JCheckBox("ATM CARD");
        c1.setFont(new Font("Raleway", Font.PLAIN, 14));
        c1.setBackground(Color.white);
        c1.setBounds(130,420,200,30);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway", Font.PLAIN, 14));
        c2.setBackground(Color.white);
        c2.setBounds(350,420,200,30);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway", Font.PLAIN, 14));
        c3.setBackground(Color.white);
        c3.setBounds(130,450,200,30);
        add(c3);
        
        c4 = new JCheckBox("EMAIL AND SMS Alerts");
        c4.setFont(new Font("Raleway", Font.PLAIN, 14));
        c4.setBackground(Color.white);
        c4.setBounds(350,450,200,30);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway", Font.PLAIN, 14));
        c5.setBackground(Color.white);
        c5.setBounds(130,480,200,30);
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway", Font.PLAIN, 14));
        c6.setBackground(Color.white);
        c6.setBounds(350,480,200,30);
        add(c6);
        
        c7= new JCheckBox("I hereby declares that the above entered details are correct");
        c7.setFont(new Font("Raleway", Font.PLAIN, 14));
        c7.setBackground(Color.white);
        c7.setBounds(100,580,500,30);
        add(c7);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(200,650,100,40);
        submit.addActionListener(this);
        add(submit);
        
        cancel= new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(420,650,100,40);
        cancel.addActionListener(this);
        add(cancel);
      
}
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String accountType = null;
            if(r1.isSelected()){
                accountType= "Saving Account";
            } else if(r2.isSelected()){
                accountType= "Fixed Deposit Account";
            } else if(r3.isSelected()){
                accountType="Current Account";
            } else if(r4.isSelected()){
                accountType = "Recurring Deposit Account";
            }
            
            Random random = new Random();
            String cardnumber= "" + Math.abs((random.nextLong() % 90000000L)) + 5040936000000000L;
            
            String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            
            String facility ="";
            if(c1.isSelected()){
                facility = facility + "Atm card";
            }else if(c1.isSelected()){
                facility = facility + "Internet Banking";
            }else if(c1.isSelected()){
                facility = facility + "Mobile Banking";
            }else if(c1.isSelected()){
                facility = facility + "EMAIL AND SMS Alerts";
            }else if(c1.isSelected()){
                facility = facility + "Cheque Book";
            }else if(c1.isSelected()){
                facility = facility + "E-Statement";
            }
            
            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type is Required");
                } else {
                    Conn conn= new Conn();
                    String query1= "insert into signup3 values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String query2= "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                          
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber +"\n" + "Pin Number:" + pinnumber);
                }             
                setVisible(false);
                new Transactions(pinnumber).setVisible(false);
            }catch(Exception e){
                System.out.println(e);
            }
        }    
        else if(ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
                        
        }
    }
    
    
    
    public static void main(String args[]){
        new SignUp3("");
    }

}
