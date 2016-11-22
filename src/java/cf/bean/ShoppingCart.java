/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cf.bean;

import java.util.ArrayList;

/**
 *
 * @author apple
 */
public class ShoppingCart {
    ArrayList<OrderDetails> orderDetails;

    public ShoppingCart() {
        orderDetails = new ArrayList();
    }

    public ShoppingCart(ArrayList<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public ArrayList<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(ArrayList<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }
    
    
}
