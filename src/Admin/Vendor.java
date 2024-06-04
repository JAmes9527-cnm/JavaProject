/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Admin;

import static Admin.Customer.doesCustomerIDExist;
import CustomerMenu.OrderFile;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author james
 */
public class Vendor extends User {
    
    @Override
    public boolean login() {
        boolean login = false;
        if(!doesVendorIDExist(ID)){
            JOptionPane.showMessageDialog(null, "Vendor ID does not exist!");
            return login;
        }
        else if(!password.equals(Vendor.findVendorPassword(ID))){
            JOptionPane.showMessageDialog(null, "Wrong password!"); 
            return login;
        }
        else{
            login=true;
            return login;
        }
    }

    public static List<OrderFile> getOrderHistory(String VendorID) {
        List<OrderFile> completedOrders = new ArrayList<>();
        Object[] ObjectList = ObjWriteRead.readAllObjectsFromFile("Orders.dat");
        for (Object obj : ObjectList) {
            if (obj instanceof OrderFile) {
                OrderFile order = (OrderFile) obj;
                if (order.getVendorName().equals(VendorID) && order.getOrderStatus() == OrderFile.OrderStatus.COMPLETED) {
                    completedOrders.add(order);
                }
            }
        }
        return completedOrders;
    }

    public static List<OrderFile> getOrders(String VendorID) {
        List<OrderFile> orders = new ArrayList<>();
        Object[] objectList = ObjWriteRead.readAllObjectsFromFile("Orders.dat");
        for (Object obj : objectList) {
            if (obj instanceof OrderFile) {
                OrderFile order = (OrderFile) obj;
                if (order.getVendorName().equals(VendorID)) {
                    orders.add(order);
                }
            }
        }
        return orders;
    }
    public Vendor(String ID,String Name, String password){
        super(ID,Name,password);
    }
    
    public Vendor(String id, String Password) {
        super(id, Password);
    }
    
    

    
    public static boolean doesVendorIDExist(String VendorID) {
    try (BufferedReader reader = new BufferedReader(new FileReader("vendor.txt"))) {
        String line;

        while ((line = reader.readLine()) != null) {
            String[] Data = line.split(",");
            if (Data.length == 3) {
                String customerID = Data[0].trim(); // Trim any leading/trailing spaces
                if (customerID.equals(VendorID)) {
                    // The FoodID exists in the "menu.txt" file
                    return true;
                }
            }
        }
    } catch (IOException ex) {
        ex.printStackTrace();
    }
    return false;
    }
    
    public static String findVendorPassword(String VendorID) {
         try (BufferedReader reader = new BufferedReader(new FileReader("vendor.txt"))) {
            String line;
    
            while ((line = reader.readLine()) != null) {
                String[] Data = line.split(",");
                if (Data.length == 3) {
                    String customerID = Data[0].trim(); // Trim any leading/trailing spaces
                    if (customerID.equals(VendorID)) {
                        // The FoodID exists, return the price
                        String password = Data[2].trim(); // Assuming the price is in the third position
                        return password;
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         
         return "0";
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
}
