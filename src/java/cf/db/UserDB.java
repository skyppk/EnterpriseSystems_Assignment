/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cf.db;

import cf.bean.UserInfo;
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

    public UserDB() {

    }

    public UserDB(String dburl, String dbUser, String dbPassword) {
        this.dburl = dburl;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
    }

    public Connection getConnection() throws SQLException, IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(dburl, dbUser, dbPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void CreateUserInfoTable() {
        Connection cnnct = null;
        Statement stmnt = null;

        try {
            cnnct = getConnection();
            stmnt = cnnct.createStatement();
            String sql
                    = "CREATE TABLE IF NOT EXISTS UserInfo ("
                    + "id int NOT NULL AUTO_INCREMENT,"
                    + "login_id varchar(25),"
                    + "last_name varchar(25) NOT NULL,"
                    + "first_name varchar(25) NOT NULL,"
                    + "sex varchar(1) NOT NULL,"
                    + "birthday date,"
                    + "tel varchar(8) NOT NULL,"
                    + "address varchar(255) NOT NULL,"
                    + "email varchar(255) NOT NULL,"
                    + "user_status varchar(15) DEFAULT 'NEW',"
                    + "UNIQUE (email),"
                    + "PRIMARY KEY (id)"
                    + ")";
            stmnt.execute(sql);
            stmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void CreateAccountInfoTable() {
        Connection cnnct = null;
        Statement stmnt = null;

        try {
            cnnct = getConnection();
            stmnt = cnnct.createStatement();
            String sql
                    = "CREATE TABLE IF NOT EXISTS AccountInfo ("
                    + "login_id varchar(25) NOT NULL,"
                    + "password varchar(60) NOT NULL,"
                    + "money double DEFAULT '0',"
                    + "credit_amount int DEFAULT '0',"
                    + "bonus_point double DEFAULT '1000',"
                    + "PRIMARY KEY (login_id)"
                    + ")";
            stmnt.execute(sql);
            stmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public boolean addUserInfo(String lastName,String firstName, String sex, String birthday, String tel, String address, String email) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try {
            cnnct = getConnection();
            String preQueryStatement = "INSERT INTO UserInfo VALUES (null,null,?,?,?,?,?,?,?,DEFAULT)";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, lastName);
            pStmnt.setString(2, firstName);
            pStmnt.setString(3, sex);
            pStmnt.setString(4, birthday);
            pStmnt.setString(5, tel);
            pStmnt.setString(6, address);
            pStmnt.setString(7, email);
//            pStmnt.setString(8, "New");
            int rowCount = pStmnt.executeUpdate();
            if (rowCount >= 1) {
                isSuccess = true;
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }

//    public boolean addLoginInfo(String loginId, String pwd, int id) {
//        Connection cnnct = null;
//        PreparedStatement pStmnt = null;
//        boolean isSuccess = false;
//        try {
//            cnnct = getConnection();
//            String preQueryStatement = "UPDATE UserInfo SET login_id = ? , password = ? , bonusPoints = 1000 WHERE id = ? ";
//            pStmnt = cnnct.prepareStatement(preQueryStatement);
//            pStmnt.setString(1, loginId);
//            pStmnt.setString(2, pwd);
//            pStmnt.setInt(3, id);
//            int rowCount = pStmnt.executeUpdate();
//            if (rowCount >= 1) {
//                isSuccess = true;
//            }
//            pStmnt.close();
//            cnnct.close();
//        } catch (SQLException ex) {
//            while (ex != null) {
//                ex.printStackTrace();
//                ex = ex.getNextException();
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        return isSuccess;
//    }

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
    
    public boolean isValidUser(String longinId, String pwd) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isValid = false;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM UserInfo INNER JOIN AccountInfo ON UserInfo.login_id = AccountInfo.login_id WHERE login_id = ? AND password = ? AND user_status = 'ACCEPTED' AND account_type = 'CUSTOMER';";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, longinId);
            pStmnt.setString(2, pwd);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            if (rs.next()) {
                isValid = true;
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isValid;
    }

    public UserInfo getUserInfo(String longinId, String pwd) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isValid = false;
        UserInfo user = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM UserInfo INNER JOIN AccountInfo ON UserInfo.login_id = AccountInfo.login_id WHERE login_id = ? AND password = ? AND user_status = 'ACCEPTED' AND account_type = 'CUSTOMER';";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, longinId);
            pStmnt.setString(2, pwd);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            if (rs.next()) {
                user = new UserInfo();
                user.setId(rs.getInt("id"));
                user.setLoginId(rs.getString("login_id"));
                user.setPassword(rs.getString("password"));
                user.setLastName(rs.getString("last_name"));
                user.setFirstName(rs.getString("first_name"));
                user.setSex(rs.getString("sex"));
                user.setBirthday(rs.getString("birthday"));
                user.setTel(rs.getString("tel"));
                user.setAddress(rs.getString("address"));
                user.setEmail(rs.getString("email"));
                user.setUserStatus(rs.getString("user_status"));
                user.setMoney(rs.getDouble("money"));
                user.setCreditAmount(rs.getInt("credit_amount"));
                user.setBonusPoints(rs.getDouble("bonusPoints"));
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public boolean checkEmail(String email) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isValid = false;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM UserInfo WHERE email = ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, email);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            if (!rs.next()) {
                isValid = true;
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isValid;
    }
    
    public boolean dropUserInfoTable(){
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try{
            cnnct = getConnection();
            String preQueryStatement = "DROP TABLE UserInfo ";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            
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
    
    public boolean dropAccountInfoTable(){
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try{
            cnnct = getConnection();
            String preQueryStatement = "DROP TABLE AccountInfo ";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            
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
}
