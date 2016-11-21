/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cf.createTable;

import cf.db.ItemDB;
import cf.db.OrderDB;
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
        OrderDB orderDb = new OrderDB(url, username, password);
        userDb.CreateUserInfoTable();
        itemDb.CreateItemInfoTable();
        userDb.CreateAccountInfoTable();
        orderDb.CreateOrderInfoTable();
        orderDb.CreateOrderDetailsTable();
//        addItemInfo(String itemId, String itemName, String category, String designerName, double price, String descriptions, String img, String itemStatus )
        itemDb.addItemInfo("IT1", "Item1", "PIG", "SYW", 33.1 , "SYW IS A PIG", "pig.png");
        
//        addUserInfo(String lastName,String firstName, String sex, String birthday, int tel, String address, String email)
        userDb.addUserInfo("Wong", "Shuk Yan", "F", "1995-9-2", "34329483", "pig street", "sywispig@gmail.com");
        
//        addOrderInfo(String orderId, String loginId, String deliveryType, String deliverDate, String deliveryTime, String deliveryAddress, double orderPrice)
        orderDb.addOrderInfo("o1", "syw", "prick", "2034-4-4", "PM", "pig street", 999.4);
    }
}
