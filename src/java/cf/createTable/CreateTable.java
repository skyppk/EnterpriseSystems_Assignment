/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cf.createTable;

import cf.db.ItemDB;
import cf.db.UserDB;

/**
 *
 * @author apple
 */
public class CreateTable {
    public static void main(String[] arg){
        String url = "jdbc:mysql://localhost:3306/ESD_Assignment";
        String username = "root";
        String password = "";
        UserDB userDb = new UserDB(url, username, password);
        ItemDB itemDb = new ItemDB(url, username, password);
        userDb.CreateUserInfoTable();
        itemDb.CreateItemInfoTable();
    }
}
