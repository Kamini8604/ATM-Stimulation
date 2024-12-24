 package bankmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SignUp2 extends JFrame implements ActionListener{
    JTextField pan,aadhar;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, category, occupation, income, education;
    String formno;
    
    
    SignUp2(String formno){
        this.formno = formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICABLE FORM - PAGE 2");
        setSize(700,800);
        setLocation(400,10);
        getContentPane().setBackground(Color.white);
        setVisible(true);
        
        JLabel AdditionalDetails = new JLabel("Page II Additional Details");
        AdditionalDetails.setFont(new Font("Raleway",Font.BOLD, 20 ));
        AdditionalDetails.setBounds(200,80,600,40);
        add(AdditionalDetails);
        
        JLabel Name = new JLabel("RELIGION:");
        Name.setFont(new Font("Raleway",Font.PLAIN,18));
        Name.setBounds(80,140,100,40);
        add(Name);
        
        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(330,145,300,30);
        religion.setBackground(Color.white);
        add(religion);
        
        JLabel FatherName = new JLabel("CATEGORY: ");
        FatherName.setFont(new Font("Raleway",Font.PLAIN,18));
        FatherName.setBounds(80,190,600,40);
        add(FatherName);
        
        String valCategory[] = {"General", "SC", "OBC", "ST", "Other"};
        category= new JComboBox(valCategory);
        category.setBounds(330,195,300,30);
        category.setBackground(Color.white);
        add(category);
        
        JLabel DOB = new JLabel("INCOME: ");
        DOB.setFont(new Font("Raleway",Font.PLAIN,18));
        DOB.setBounds(80,240,600,40);
        add(DOB);
        
        String valIncome[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
        income= new JComboBox(valIncome);
        income.setBounds(330,245,300,30);
        income.setBackground(Color.white);
        add(income);
                
        JLabel qualification = new JLabel("QUALIFICATION:");
        qualification.setFont(new Font("Raleway",Font.PLAIN,18));
        qualification.setBounds(80,290,600,40);
        add(qualification);
        
        String educationValues[] = {"Non-Graduation", "Graduate", "Post-Graduate", "Doctrate", "Others"};
        education = new JComboBox(educationValues);
        education.setBounds(330,295,300,30);
        education.setBackground(Color.white);
        add(education);
        
        JLabel MaritalStatus = new JLabel("OCCUPATION: ");
        MaritalStatus.setFont(new Font("Raleway",Font.PLAIN,18));
        MaritalStatus.setBounds(80,340,600,40);
        add(MaritalStatus);
        
        String occupationValues[] = {"Salaried", "Self Employed", "Bussiness", "Student", "Retired"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(330,345,300,30);
        occupation.setBackground(Color.white);
        add(occupation);
        
        JLabel pancard = new JLabel("PANCARD: ");
        pancard.setFont(new Font("Raleway",Font.PLAIN,18));
        pancard.setBounds(80,390,600,40);
        add(pancard);
        
        pan = new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,15));
        pan.setBounds(330,395,300,30);
        add(pan);
        
        JLabel Aadhar = new JLabel("AADHAR NUMBER: ");
        Aadhar.setFont(new Font("Raleway",Font.PLAIN,18));
        Aadhar.setBounds(80,440,600,40);
        add(Aadhar);
        
        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,15));
        aadhar.setBounds(330,445,300,30);
        add(aadhar);
        
        JLabel State = new JLabel("SENIOR CITIZEN: ");
        State.setFont(new Font("Raleway",Font.PLAIN,18));
        State.setBounds(80,490,600,40);
        add(State);
        
        syes = new JRadioButton("YES");
        syes.setBounds(330,495,80,30);
        syes.setBackground(Color.white);
        add(syes);
        
        sno = new JRadioButton("NO");
        sno.setBounds(430,495,80,30);
        sno.setBackground(Color.white);
        add(sno);
        
        ButtonGroup seniorCitizen = new ButtonGroup();
        seniorCitizen.add(syes);
        seniorCitizen.add(sno);
        
        JLabel PinCode = new JLabel("EXISITING ACCOUNT: ");
        PinCode.setFont(new Font("Raleway",Font.PLAIN,18));
        PinCode.setBounds(80,540,600,40);
        add(PinCode);
        
        eyes = new JRadioButton("YES");
        eyes.setBounds(330,545,80,30);
        eyes.setBackground(Color.white);
        add(eyes);
        
        eno = new JRadioButton("NO");
        eno.setBounds(430,545,80,30);
        eno.setBackground(Color.white);
        add(eno);
        
        ButtonGroup exisiting = new ButtonGroup();
        exisiting.add(eyes);
        exisiting.add(eno);
        
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
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        
        String seniorcitizen = "NULL";
        if(syes.isSelected()){
            seniorcitizen = "YES";
        }else if(sno.isSelected()){
            seniorcitizen = "NO";
        }
        
        String exisitingaccount= "null";
        if(eyes.isSelected()){
           exisitingaccount ="Yes";
        }else if(eno.isSelected()){
            exisitingaccount ="No";
        }
        
        String saadhar = aadhar.getText();
        String span = pan.getText();
        
         try{
             Conn c = new Conn();
             String query = "insert into signup2 values ('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+exisitingaccount+"')";
             c.s.executeUpdate(query);
             
             setVisible(false);
             new SignUp3(formno).setVisible(true);
             
         }catch(Exception e){
             System.out.println(e);
         }
        
        
    }
    
    
    public static void main(String[] args) {
        new SignUp2("");
    }
}
