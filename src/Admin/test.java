/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Admin;

import CustomerMenu.OrderFile;
import java.util.List;

/**
 *
 * @author james
 */
public class test {
    public static void main(String[] args) {
        List<OrderFile> orders = Vendor.getOrders("teh");
        for(OrderFile order: orders){
            System.out.println(order.getOrderID()+order.getReview());
        }
    }
}
