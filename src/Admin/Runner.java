/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Admin;

import CustomerMenu.OrderFile;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author james
 */
public class Runner extends User{
    
    public Runner(String id, String Password) {
        super(id, Password);
    }
    
    @Override
    public boolean login() {
        boolean login = false;
        if(!doesRunnerIDExist(ID)){
            JOptionPane.showMessageDialog(null, "Runner ID does not exist!");
            return login;
        }
        else if(!password.equals(Runner.findRunnerPassword(ID))){
            JOptionPane.showMessageDialog(null, "Wrong password!"); 
            return login;
        }
        else{
            login=true;
            return login;
        }
    }

    public static String findRunnerPassword(String RunnerID) {
        try (BufferedReader reader = new BufferedReader(new FileReader("Runner.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] Data = line.split(",");
                if (Data.length == 4) {
                    String runnerID = Data[0].trim(); // Trim any leading/trailing spaces
                    if (runnerID.equals(RunnerID)) {
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

    public static boolean doesRunnerIDExist(String RunnerID) {
        try (BufferedReader reader = new BufferedReader(new FileReader("Runner.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] Data = line.split(",");
                if (Data.length == 4) {
                    String runnerID = Data[0].trim(); // Trim any leading/trailing spaces
                    if (runnerID.equals(runnerID)) {
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
    
    private String status;
    
    public Runner(String id, String name, String password,String status){
        super(id, name, password);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public static List<Object> getOrders(String runnerID){
        List<Object> Orders = new ArrayList<>();
        
        Object[] ObjectList = ObjWriteRead.readAllObjectsFromFile("Orders.dat");
        for(Object obj : ObjectList){
            if(obj instanceof OrderFile){
                OrderFile order = (OrderFile) obj;
                if((order.getDeliveryGuy().equals(runnerID)||order.getDeliveryGuy().equals("Pending"))&&order.getOrderStatus()==OrderFile.OrderStatus.PENDING&&doesStringExist(order.getDeliveryGuyAvailable(), runnerID)){
                    Orders.add(obj);
                }
            }
        }
        
        return Orders;
    }
    
    public static List<OrderFile> getTaskHistory(String runnerID){
    List<OrderFile> Orders = new ArrayList<>();

    Object[] ObjectList = ObjWriteRead.readAllObjectsFromFile("Orders.dat");
    for(Object obj : ObjectList){
        if(obj instanceof OrderFile){
            OrderFile order = (OrderFile) obj;
            if((order.getDeliveryGuy().equals(runnerID) && order.getOrderStatus() == OrderFile.OrderStatus.COMPLETED)){
                Orders.add(order);
            }
        }
    }

    return Orders;
}
    
    public static boolean doesStringExist(List<String> list, String searchString) {
        // Check if the list contains the specified string
        return list.contains(searchString);
    }
    
    public static List<String> getRunnerAvailable(){
        List<String> Runners = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("Runner.txt"))) {
            String line;
    
            while ((line = reader.readLine()) != null) {
                String[] Data = line.split(",");
                if (Data.length == 4) {
                    String runner = Data[0].trim();
                    Runners.add(runner);                    
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return Runners;
    }
}
