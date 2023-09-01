/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component.managment.system;
import java.sql.*;
public class MyConnection {
    public static Connection getConnection(){
        
        Connection cn=null;
        
        ResultSet rs=null;
        try{
        
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/database01","root","");
            Statement st=cn.createStatement();
        }catch(Exception e){
            System.out.println("1.Error: "+e);
        }
        return cn;
    }
}