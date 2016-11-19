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
public class ItemDB {
    String dburl;
    String dbUser;
    String dbPassword;
    
    public ItemDB(){
        
    }
    
    public ItemDB(String dburl, String dbUser, String dbPassword) {
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
    
       public void CreateItemInfoTable(){
       Connection cnnct = null;
        Statement stmnt = null;
        
        try{
            cnnct = getConnection();
            stmnt = cnnct.createStatement();
            String sql
                    = "CREATE TABLE IF NOT EXISTS ItemInfo ("
                    + "id int NOT NULL AUTO_INCREMENT,"
                    + "itemName varchar(50) NOT NULL,"
                    + "descriptions varchar(255) NOT NULL,"
                    + "category varchar(20) NOT NULL,"
                    + "designerName varchar(30) NOT NULL,"
                    + "price double NOT NULL,"
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
    
    public boolean addItemInfo(String itemName, String descriptions, String category, String designerName, double price ){
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try{
            cnnct = getConnection();
            String preQueryStatement = "INSERT INTO UserInfo VALUES (null,?,?,?,?,?)";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, itemName);
            pStmnt.setString(2, descriptions);
            pStmnt.setString(3, category);
            pStmnt.setString(4, designerName);
            pStmnt.setDouble(5, price);
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
    
    public boolean editItemInfo(String itemName, String descriptions, String category, String designerName, double price){
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try{
            cnnct = getConnection();
            String preQueryStatement = "UPDATE UserInfo SET itemName = ? , descriptions = ? , category = ? , designerName = ? , price = ? WHERE id = ? ";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, itemName);
            pStmnt.setString(2, descriptions);
            pStmnt.setString(3, category);
            pStmnt.setString(4, designerName);
            pStmnt.setDouble(5, price);
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
    
    
}
