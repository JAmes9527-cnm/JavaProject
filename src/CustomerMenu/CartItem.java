/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CustomerMenu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import vendor.MenuItem;

/**
 *
 * @author james
 */
public class CartItem extends MenuItem{

    public static String getVendor() {
        String filename = CustomerLogin.customerID + "Cart.txt";
        String vendor;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    vendor = data[3].trim(); // Trim any leading/trailing spaces
                    return vendor;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "Error";
    }

    public static boolean cartExist() {
        String filename = CustomerLogin.customerID + "Cart.txt";
        File file = new File(filename);
        return file.exists();
    }

    public static double getTotal() {
        String filename = CustomerLogin.customerID + "Cart.txt";
        double total = 0.0; // Initialize total outside the try block
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    String foodID = data[0].trim(); // Trim any leading/trailing spaces
                    int quantity = Integer.parseInt(data[4].trim());
                    double foodPrice = Double.parseDouble(data[2].trim());
                    total += (foodPrice * quantity);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return total; // Return total outside the try block
    }

    public static void clearCart() {
        String filename = CustomerLogin.customerID + "Cart.txt";
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write("");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("An error occurred while clearing the file.");
        }
    }

    public static boolean doesFoodIDExist(String foodID) {
        try (BufferedReader reader = new BufferedReader(new FileReader(CustomerLogin.customerID + "Cart.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] menuData = line.split(",");
                if (menuData.length == 5) {
                    String menuFoodID = menuData[0].trim(); // Trim any leading/trailing spaces
                    if (menuFoodID.equals(foodID)) {
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
    private int Quantity;

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }
    
    public CartItem(String itemID,String Name, String Price,String vendorName,int Quantity){
        super(itemID,Name,Price,vendorName);
        this.Quantity=Quantity;
    }
    
    @Override
    public String toString(){
        return super.toString()+","+Quantity;
    }
}
