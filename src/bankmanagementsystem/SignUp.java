package bankmanagementsystem;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.util.Random;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp extends JFrame implements ActionListener{
    long random;
    JTextField nameTextField, fnameTextField, EmailTextField, AddressTextField, CityTextField, PincodeTextField, StateTextField;
    JButton next;
    JRadioButton male, female, married, unmarried, other;
    JDateChooser dateChooser;
    
    SignUp(){
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setSize(700,800);
        setLocation(400,10);
        setVisible(true);
        
        Random ran = new Random();
        random=Math.abs((ran.nextLong() % 9000L)) + 1000L;
        
        JLabel formNo = new JLabel("Application No: " + random);
        formNo.setFont(new Font("Raleway",Font.BOLD, 30 ));
        formNo.setBounds(200,20,600,40);
        add(formNo);
        
        JLabel Title = new JLabel("Page I: Personal Details");
        Title.setFont(new Font("Raleway",Font.BOLD, 19 ));
        Title.setBounds(220,80,600,40);
        add(Title);
        
        JLabel Name = new JLabel("NAME: ");
        Name.setFont(new Font("Raleway",Font.PLAIN,18));
        Name.setBounds(80,140,100,40);
        add(Name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,15));
        nameTextField.setBounds(330,145,300,30);
        add(nameTextField);
        
        JLabel FatherName = new JLabel("FATHER's NAME: ");
        FatherName.setFont(new Font("Raleway",Font.PLAIN,18));
        FatherName.setBounds(80,190,600,40);
        add(FatherName);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,15));
        fnameTextField.setBounds(330,195,300,30);
        add(fnameTextField);
        
        JLabel DOB = new JLabel("DOB: ");
        DOB.setFont(new Font("Raleway",Font.PLAIN,18));
        DOB.setBounds(80,240,600,40);
        add(DOB);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(330,245,300,30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);
        
        JLabel Gender = new JLabel("GENDER: ");
        Gender.setFont(new Font("Raleway",Font.PLAIN,18));
        Gender.setBounds(80,290,600,40);
        add(Gender);
        
        male = new JRadioButton("MALE");
        male.setBounds(330,295,100,30);
        male.setBackground(Color.white);
        add(male);
        
        female = new JRadioButton("FEMALE");
        female.setBounds(430,295,100,30);
        female.setBackground(Color.white);   
        add(female);
       
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
                
        JLabel Email = new JLabel("EMAIL: ");
        Email.setFont(new Font("Raleway",Font.PLAIN,18));
        Email.setBounds(80,340,600,40);
        add(Email);
        
        EmailTextField = new JTextField();
        EmailTextField.setFont(new Font("Raleway",Font.BOLD,15));
        EmailTextField.setBounds(330,345,300,30);
        add(EmailTextField);
        
        JLabel MaritalStatus = new JLabel("MARITAL STATUS: ");
        MaritalStatus.setFont(new Font("Raleway",Font.PLAIN,18));
        MaritalStatus.setBounds(80,390,600,40);
        add(MaritalStatus);
        
        married = new JRadioButton("MARRIED");
        married.setBounds(330,395,80,30);
        married.setBackground(Color.white);
        add(married);
        
        unmarried = new JRadioButton("UNMARRIED");
        unmarried.setBounds(420,395,100,30);
        unmarried.setBackground(Color.white);   
        add(unmarried);
       
        other = new JRadioButton("OTHER");
        other.setBounds(530,395,100,30);
        other.setBackground(Color.white);   
        add(other);
        
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);
        
        JLabel Address = new JLabel("ADDRESS: ");
        Address.setFont(new Font("Raleway",Font.PLAIN,18));
        Address.setBounds(80,440,600,40);
        add(Address);
        
        AddressTextField = new JTextField();
        AddressTextField.setFont(new Font("Raleway",Font.BOLD,15));
        AddressTextField.setBounds(330,445,300,30);
        add(AddressTextField);
        
        JLabel City = new JLabel("CITY: ");
        City.setFont(new Font("Raleway",Font.PLAIN,18));
        City.setBounds(80,490,600,40);
        add(City);
        
        CityTextField = new JTextField();
        CityTextField.setFont(new Font("Raleway",Font.BOLD,15));
        CityTextField.setBounds(330,495,300,30);
        add(CityTextField);
        
        JLabel State = new JLabel("STATE: ");
        State.setFont(new Font("Raleway",Font.PLAIN,18));
        State.setBounds(80,540,600,40);
        add(State);
        
        StateTextField = new JTextField();
        StateTextField.setFont(new Font("Raleway",Font.BOLD,15));
        StateTextField.setBounds(330,545,300,30);
        add(StateTextField);
        
        JLabel PinCode = new JLabel("PINCODE: ");
        PinCode.setFont(new Font("Raleway",Font.PLAIN,18));
        PinCode.setBounds(80,590,600,40);
        add(PinCode);
        
        PincodeTextField = new JTextField();
        PincodeTextField.setFont(new Font("Raleway",Font.BOLD,15));
        PincodeTextField.setBounds(330,595,300,30);
        add(PincodeTextField);
        
        next = new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(520,670,80,30);
        next.addActionListener(this);
        add(next);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        String formno = "" + random;
        String name = nameTextField.getText();
        String fname= fnameTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }else if(female.isSelected()){
            gender = "Female";
        }
        
        String email = EmailTextField.getText();
        String marital= "null";
        if(married.isSelected()){
           marital ="Married";
        }else if(unmarried.isSelected()){
            marital ="Unmarried";
        }else if(other.isSelected()){
            marital ="Other";
        }
        
        String address = AddressTextField.getText();
        String city = CityTextField.getText();
        String state = StateTextField.getText();
        String pin = PincodeTextField.getText();
        
         try{
             if(name.equals("")||fname.equals("")||dob.equals("")||address.equals("")||city.equals("")||state.equals("") ||pin.equals("")){
                 JOptionPane.showMessageDialog(null, "Every field must be filled");
             }else {
                 Conn c = new Conn();
                 String query = "insert into signup values ('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
                 c.s.executeUpdate(query);
                 
                 setVisible(false);
                 new SignUp2(formno).setVisible(true);
                 
             }
         }catch(Exception e){
             System.out.println(e);
         }
        
        
    }
    
    
    public static void main(String[] args) {
        new SignUp();
    }
}
