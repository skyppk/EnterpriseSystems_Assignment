/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cf.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author apple
 */
public class UserDB {
    
    String dburl;
    String dbUser;
    String dbPassword;
    
    public UserDB(){
        
    }
    
    public UserDB(String dburl, String dbUser, String dbPassword) {
        this.dburl = dburl;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
    }
    
    public Connection getConnection() throws SQLException, IOException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(dburl, dbUser, dbPassword);
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
    
       public void CreateUserInfoTable(){
       Connection cnnct = null;
        Statement stmnt = null;
        
        try{
            cnnct = getConnection();
            stmnt = cnnct.createStatement();
            String sql
                    = "CREATE TABLE IF NOT EXISTS UserInfo ("
                    + "id int NOT NULL AUTO_INCREMENT,"
                    + "login_id varchar(25),"
                    + "password varchar(25),"
                    + "userName varchar(25) NOT NULL,"
                    + "sex varchar(1) NOT NULL,"
                    + "birthday date,"
                    + "tel int(8) NOT NULL,"
                    + "email varchar(255) NOT NULL,"
                    + "address varchar(255) NOT NULL,"
                    + "bonusPoints double,"
                    + "status varchar(15) NOT NULL,"
                    + "PRIMARY KEY (id)"
                    + ")";
            stmnt.execute(sql);
            stmnt.close();
            cnnct.close();
        } catch (SQLException ex){
            while(ex != null){
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex){
            ex.printStackTrace();
        } 
    }
    
    public boolean addUserInfo(String userName, String sex, String birthday, int tel, String email, String address ){
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try{
            cnnct = getConnection();
            String preQueryStatement = "INSERT INTO UserInfo VALUES (null,null,null,?,?,?,?,?,?,null,?)";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, userName);
            pStmnt.setString(2, sex);
            pStmnt.setString(3, birthday);
            pStmnt.setInt(4, tel);
            pStmnt.setString(5, email);
            pStmnt.setString(6, address);
            pStmnt.setString(7, "New");
            int rowCount = pStmnt.executeUpdate();
            if(rowCount >= 1){
                isSuccess = true;
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex){
            while(ex != null){
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
        return isSuccess;
    }
    
    public boolean addLoginInfo(String loginId, String pwd, int id){
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try{
            cnnct = getConnection();
            String preQueryStatement = "UPDATE UserInfo SET login_id = ? , password = ? , bonusPoints = 1000 WHERE id = ? ";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, loginId);
            pStmnt.setString(2, pwd);
            pStmnt.setInt(3, id);
            int rowCount = pStmnt.executeUpdate();
            if(rowCount >= 1){
                isSuccess = true;
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex){
            while(ex != null){
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
        return isSuccess;
    }
    
//    public boolean editRecord(CustomerBean cb){
//        Connection cnnct = null;
//        PreparedStatement pStmnt = null;
//        boolean isSuccess = false;
//        try{
//            cnnct = getConnection();
//            String preQueryStatement = "UPDATE CUSTOMER SET name = ? , tel = ? , age = ? WHERE custId = ? ";
//            pStmnt = cnnct.prepareStatement(preQueryStatement);
//            pStmnt.setString(1, cb.getName());
//            pStmnt.setString(2, cb.getTel());
//            pStmnt.setInt(3, cb.getAge());
//            pStmnt.setString(4, cb.getCustid());
//            int rowCount = pStmnt.executeUpdate();
//            if(rowCount >= 1){
//                isSuccess = true;
//            }
//            pStmnt.close();
//            cnnct.close();
//        } catch (SQLException ex){
//            while(ex != null){
//                ex.printStackTrace();
//                ex = ex.getNextException();
//            }
//        } catch (IOException ex){
//            ex.printStackTrace();
//        }
//        return isSuccess;
//    }
    
    public boolean isValidUser(String longinId, String pwd){
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isValid = false;
        try{
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM UserInfo WHERE login_id = ? and password = ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, longinId);
            pStmnt.setString(2, pwd);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            if(rs.next()){
                isValid = true;
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex){
            while(ex != null){
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
        return isValid;
    }
    
    public boolean checkEmail(String email) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isValid = false;
        try{
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM UserInfo WHERE email = ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, email);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            if(!rs.next()){
                isValid = true;
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex){
            while(ex != null){
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
        return isValid;
    }
}
