package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Transactions extends JFrame implements ActionListener{
    
    JButton deposit, cashwithdrawl, FastCash, MiniStatement, PinChange, BalanceEnquiry, Exit;
    String pinnumber;
            
    Transactions(String pinnumber){
        this.pinnumber= pinnumber;
        setLayout(null);
        
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        Image i2 = il.getImage().getScaledInstance(800,800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Please select your Transactions");
        text.setBounds(220,290,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 14));
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(195,345,130,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        cashwithdrawl = new JButton("Cash Withdrawl");
        cashwithdrawl.setBounds(335,345,130,30);
        cashwithdrawl.addActionListener(this);
        image.add(cashwithdrawl);
        
        FastCash = new JButton("Fast Cash");
        FastCash.setBounds(195,385,130,30);
        FastCash.addActionListener(this);
        image.add(FastCash);
        
        MiniStatement = new JButton("Mini Statement");
        MiniStatement.setBounds(335,385,130,30);
        MiniStatement.addActionListener(this);
        image.add(MiniStatement);

        PinChange = new JButton("Pin Change");
        PinChange.setBounds(195,425,130,30);
        PinChange.addActionListener(this);
        image.add(PinChange);
        
        BalanceEnquiry = new JButton("Balance Enquiry");
        BalanceEnquiry.setBounds(335,425,130,30);
        BalanceEnquiry.addActionListener(this);
        image.add(BalanceEnquiry);
        
        Exit = new JButton("Exit");
        Exit.setBounds(335,465,130,30);
        Exit.addActionListener(this);
        image.add(Exit);
       
        setSize(900,900);
        setLocation(350,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == Exit ){
            System.exit(0);
        }else if(ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource() == cashwithdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }else if(ae.getSource() == FastCash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if(ae.getSource() == PinChange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if(ae.getSource() == BalanceEnquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if(ae.getSource() == MiniStatement){
            setVisible(false);
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
    
     public static void main(String args[]){
        new Transactions("");
    }
        
    }
    
    
   
