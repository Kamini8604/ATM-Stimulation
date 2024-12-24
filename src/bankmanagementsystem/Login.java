package bankmanagementsystem;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import java.sql.*;
/**
 *
 * @author Kamini Balu
 */
public class Login extends JFrame implements ActionListener{
    
    JButton SignUp, SignIn, Clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);
        setSize(700, 480);
        setVisible(true);
        setLocation(350,200);
        
//      For image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/69dhstte.png"));
        Image i2= i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label= new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);
        
//      For text
        JLabel text= new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Raleway",Font.BOLD, 25));
        text.setBounds(250,40, 400,40);
        add(text);
        
//      For CardNo
        JLabel CardNo= new JLabel("CARD NO:");
        CardNo.setFont(new Font("Raleway",Font.BOLD,20));
        CardNo.setBounds(120,150,400,40);
        add(CardNo);
        
        cardTextField= new JTextField();
        cardTextField.setBounds(260,160,250,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);        
        
//      For Pin
        JLabel Pin= new JLabel("PIN:");
        Pin.setFont(new Font("Raleway",Font.BOLD,20));
        Pin.setBounds(120,220, 400, 40);
        add(Pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(260,230,250,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);
        
//      Button
        SignIn = new JButton("SIGN IN");
        SignIn.setBounds(190,300,150,30);
        SignIn.setForeground(Color.white);
        SignIn.setBackground(Color.darkGray);
        SignIn.addActionListener(this);
        add(SignIn);
        
        Clear = new JButton("CLEAR");
        Clear.setBounds(350,300,150,30);
        Clear.setForeground(Color.white);
        Clear.setBackground(Color.darkGray);
        Clear.addActionListener(this);
        add(Clear);
        
        SignUp = new JButton("SIGN UP");
        SignUp.setBounds(190,360,310,30);
        SignUp.setForeground(Color.white);
        SignUp.setBackground(Color.darkGray);
        SignUp.addActionListener(this);
        add(SignUp);
          
        getContentPane().setBackground(Color.white);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == Clear){
           cardTextField.setText("");
           pinTextField.setText("");
        }
        else if(ae.getSource() == SignIn){
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";

            try{
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource() == SignUp){
            setVisible(false);
            new SignUp().setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Login();
    }

}
