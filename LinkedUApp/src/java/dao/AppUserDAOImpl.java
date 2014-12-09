/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.AppUserModel;

/**
 *
 * @author brando
 */
public class AppUserDAOImpl implements AppUserDAO{

    @Override
    public boolean validate(String username, String password) {
        boolean valid = false;
        
        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://gfish2.it.ilstu.edu:1527/bmgrayb_fall14_linkedu;create=true";
        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");

        String query = "SELECT * FROM LINKEDU.APPUSER WHERE USERNAME = '" + username + "'";
        System.out.println(query);
        String newPassword="";
        
        try{
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
           
            while(rs.next()){
                newPassword = rs.getString("password");
            } 
            rs.close();
            stmt.close();
            
        } catch (Exception e) {
            System.err.println("ERROR: Problems with SQL select");
            e.printStackTrace();
        }
        try {
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        
        System.out.println("New Password: " + newPassword);
        
       if(newPassword.equalsIgnoreCase(password))// if(newPassword != null && password.equals(newPassword))
            valid = true;
        
        return valid;
    }

    @Override
    public int addUser(AppUserModel user) {

        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://gfish2.it.ilstu.edu:1527/bmgrayb_fall14_linkedu;create=true";
        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");
        String insertString = "";
        
        int row = 0;
        
        try{
            Statement stmt = DBConn.createStatement();
            insertString = "INSERT INTO linkedu.AppUser values('"
            + user.getUsername()
            + "','" + user.getPassword()
            + "','" + user.getUserType()
            +"')";
            
            row = stmt.executeUpdate(insertString);
            System.out.println("Insert String: " + insertString);
            DBConn.close();
            
        } catch(SQLException e){
            System.err.println(e.getMessage());
        }
        
        return row;
    }
    
    @Override
    public String getUserType(String username) {
        boolean valid = false;
        
        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://gfish2.it.ilstu.edu:1527/bmgrayb_fall14_linkedu;create=true";
        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");

        String query = "SELECT usertype FROM LINKEDU.AppUser WHERE USERNAME = '" + username + "'";
        String type="";
        
        try{
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
           
            while(rs.next()){
                type = rs.getString("usertype");
            } 
            rs.close();
            stmt.close();
            
        } catch (Exception e) {
            System.err.println("ERROR: Problems with SQL select");
            e.printStackTrace();
        }
        try {
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        
        return type;
    }

    @Override
    public AppUserModel getUserByUsername(String un) {

        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://gfish2.it.ilstu.edu:1527/bmgrayb_fall14_linkedu;create=true";
        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");

        String query = "SELECT * FROM LINKEDU.AppUser WHERE USERNAME = '" + un + "'";
        String type="";
        String uname="";
        String pw="";
        AppUserModel user = new AppUserModel();
        
        try{
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
           
            while(rs.next()){
                type = rs.getString("usertype");
                //uname = rs.getString("username");
                pw = rs.getString("password");
                
                user.setUsername(uname);
                user.setPassword(pw);
                user.setUserType(type);
            } 
            rs.close();
            stmt.close();
            
        } catch (Exception e) {
            System.err.println("ERROR: Problems with SQL select");
            e.printStackTrace();
        }
        try {
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        
        return user;
    }
    
    
}
