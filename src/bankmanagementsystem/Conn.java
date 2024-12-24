package bankmanagementsystem;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class Conn{
    Connection c;
    Statement s;
    
    public Conn(){
    try{
        c= DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "Root@123");
        s= c.createStatement();
    }
    catch(SQLException e){
        System.out.println(e);
        }
    }
}