package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    
    JPasswordField pin, repin;
    JButton change, back;
    String pinnumber;
     
    PinChange(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        Image i2 = il.getImage().getScaledInstance(800,800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(260,290,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 14));
        image.add(text);
        
        JLabel pintext = new JLabel("New PIN: ");
        pintext.setBounds(220,340,100,25);
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("System", Font.BOLD, 14));
        image.add(pintext);
        
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD,12));
        pin.setBounds(340,340,120,25);
        image.add(pin);
        
        JLabel repintext = new JLabel("Re-Enter PIN:");
        repintext.setBounds(220,370,100,25);
        repintext.setForeground(Color.white);
        repintext.setFont(new Font("System", Font.BOLD, 14));
        image.add(repintext);
        
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD,12));
        repin.setBounds(340,370,120,25);
        image.add(repin);
        
        change = new JButton("CHANGE");
        change.setBounds(340,430,120,25);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        back.setBounds(340,460,120,25);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(350,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== change){
            try{
                String npin = pin.getText();
                String rpin = repin.getText();
            
                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Enter PIN");
                    return;
                }
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Re-enter new PIN");
                    return;
                }
                
                Conn conn = new Conn();
                String query1 = "update bank set pin = '"+rpin+"' where pin= '"+pinnumber+"'";
                String query2 = "update login set pin = '"+rpin+"' where pin= '"+pinnumber+"'";
                String query3 = "update signup3 set pin = '"+rpin+"' where pin= '"+pinnumber+"'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null,"PIN changed successfully");
                
            }catch(Exception e){
                System.out.println(e);
             }
        }else if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new PinChange("").setVisible(true);
    }
}
