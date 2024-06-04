/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CustomerMenu;
import Admin.Customer;
import Admin.ObjWriteRead;
import Admin.Runner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;
import java.util.Date;
import java.io.Serializable;
/**
 *
 * @author james
 */
public class OrderFile implements Serializable{

    public static double getOrderTotal(String OrderPath) {
        String filename = OrderPath;
        double total = 0.0; // Initialize total outside the try block
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    String foodID = data[0].trim(); // Trim any leading/trailing spaces
                    int quantity = Integer.parseInt(data[4].trim());
                    double foodPrice = FoodChecker.findFoodPrice(foodID);
                    total += (foodPrice * quantity);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return total; // Return total outside the try block
    }

    public static String getVendor(String OrderPath) {
        String filename = CustomerLogin.customerID + "Cart.txt";
        String Vendor = "not found"; // Initialize total outside the try block
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    String foodID = data[0].trim(); // Trim any leading/trailing spaces
                    Vendor = FoodChecker.findFoodVendor(foodID);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return Vendor; // Return total outside the try block
    }
    private String CustomerID;
    private String OrderID;
    private OrderStatus orderStatus;
    private String vendorName;
    private Review review;
    private String date;
    private double total;
    private FoodStatus foodStatus;
    private Where eatWhere;
    private DeliveryStatus delivery;
    private confirmation Confirm;
    private String DeliveryGuy;
    private List<String> DeliveryGuyAvailable;

    public FoodStatus getFoodStatus() {
        return foodStatus;
    }

    public void setFoodStatus(FoodStatus foodStatus) {
        this.foodStatus = foodStatus;
    }

    public List<String> getDeliveryGuyAvailable() {
        return DeliveryGuyAvailable;
    }

    public void setDeliveryGuyAvailable(List<String> DeliveryGuyAvailable) {
        this.DeliveryGuyAvailable = DeliveryGuyAvailable;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public confirmation getConfirm() {
        return Confirm;
    }

    public void setConfirm(confirmation Confirm) {
        this.Confirm = Confirm;
    }

    public String getDeliveryGuy() {
        return DeliveryGuy;
    }

    public void setDeliveryGuy(String DeliveryGuy) {
        this.DeliveryGuy = DeliveryGuy;
    }
    
    public void setDeliveryGuy(String OrderID,String DeliveryGuy){
        Object[] objectList = ObjWriteRead.readAllObjectsFromFile("Orders.dat");

    // Iterate through objects in the list
        boolean OrderFound=false;
    
    for (int i = 0; i < objectList.length; i++) {
            Object obj = objectList[i];
            if(obj instanceof OrderFile){
                OrderFile order= (OrderFile) obj;
                
                if(order.getOrderID().equals(OrderID)){
                    order.setDeliveryGuy(DeliveryGuy);
                    objectList[i] = order;
                    OrderFound=true;
                    break;
                }
            }
    }        
    
    if(OrderFound){
        ObjWriteRead.writeObjectstoFile("Orders.dat", objectList);
    }
    else{

    // If the message is not found
       System.out.println("Order not found");
    }
    }

    public Where getEatWhere() {
        return eatWhere;
    }

    public void setEatWhere(Where eatWhere) {
        this.eatWhere = eatWhere;
    }

    public DeliveryStatus getDelivery() {
        return delivery;
    }

    public void setDelivery(DeliveryStatus delivery) {
        this.delivery = delivery;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public enum OrderStatus {
    PENDING, COMPLETED, CANCELED,NOTFOUND,PENDINGCOMFIRM
    }
    
    public enum Where {
    DINEIN, DELIVERY, TAKEAWAY,NOTFOUND
    }
    
    public enum confirmation{
        PENDING,ACCEPTED,REJECTED,NOTFOUND
    }
    
    public enum DeliveryStatus {
        PENDING,ACCEPTED,DELIVERING,DELIVERED,NONE
    }
    
    public enum FoodStatus {
        PENDING,PREPARING,COMPLETE
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String orderpath) {
        this.OrderID = orderpath;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus status) {
        this.orderStatus = status;
    }
    
    public static void setOrderStatus(String OrderID,OrderStatus status) {
        Object[] objectList = ObjWriteRead.readAllObjectsFromFile("Orders.dat");

    // Iterate through objects in the list
        boolean OrderFound=false;
    
    for (int i = 0; i < objectList.length; i++) {
            Object obj = objectList[i];
            if(obj instanceof OrderFile){
                OrderFile order= (OrderFile) obj;
                
                if(order.getOrderID().equals(OrderID)){
                    order.setOrderStatus(status);
                    objectList[i] = order;
                    OrderFound=true;
                    break;
                }
            }
    }        
    
    if(OrderFound){
        ObjWriteRead.writeObjectstoFile("Orders.dat", objectList);
    }
    else{

    // If the message is not found
       System.out.println("Order not found");
    }
    }
    
    public static void setDeliveryStatus(String OrderID,DeliveryStatus status) {
        Object[] objectList = ObjWriteRead.readAllObjectsFromFile("Orders.dat");

    // Iterate through objects in the list
        boolean OrderFound=false;
    
    for (int i = 0; i < objectList.length; i++) {
            Object obj = objectList[i];
            if(obj instanceof OrderFile){
                OrderFile order= (OrderFile) obj;
                
                if(order.getOrderID().equals(OrderID)){
                    order.setDelivery(status);
                    objectList[i] = order;
                    OrderFound=true;
                    break;
                }
            }
    }        
    
    if(OrderFound){
        ObjWriteRead.writeObjectstoFile("Orders.dat", objectList);
    }
    else{

    // If the message is not found
       System.out.println("Order not found");
    }
    }
    
    public static void setFoodStatus(String OrderID,FoodStatus status) {
            Object[] objectList = Admin.ObjWriteRead.readAllObjectsFromFile("Orders.dat");

    // Iterate through objects in the list
    boolean OrderFound=false;
    
    for (int i = 0; i < objectList.length; i++) {
            Object obj = objectList[i];
            if(obj instanceof OrderFile){
                OrderFile order= (OrderFile) obj;
                
                if(order.getOrderID().equals(OrderID) && order.getOrderStatus()==OrderStatus.PENDING){
                    order.setFoodStatus(status);
                    objectList[i] = order;
                    OrderFound=true;
                    break;
                }
                
                else if(order.getOrderID().equals(OrderID) && order.getOrderStatus()!=OrderStatus.PENDING){
                    JOptionPane.showMessageDialog(null, "Order already completed");
                    break;
                }
            }
    }        
    
    if(OrderFound){
        ObjWriteRead.writeObjectstoFile("Orders.dat", objectList);
    }
    else{

    // If the message is not found
       System.out.println("Order not found");
    }
    }
    
    
    
    public static void deductDeliveryGuyAvailable(String OrderID,String runnerID) {
        Object[] objectList = ObjWriteRead.readAllObjectsFromFile("Orders.dat");

    // Iterate through objects in the list
        boolean OrderFound=false;
    
    for (int i = 0; i < objectList.length; i++) {
            Object obj = objectList[i];
            if(obj instanceof OrderFile){
                OrderFile order= (OrderFile) obj;
                
                if(order.getOrderID().equals(OrderID)){
                    List<String> newList = removeStringFromList(order.getDeliveryGuyAvailable(), runnerID);
                    order.setDeliveryGuyAvailable(newList);
                    objectList[i] = order;
                    OrderFound=true;
                    if(order.getDeliveryGuyAvailable().size()==0){
                        Message ms = new Message(order.getCustomerID(), "The order "+ order.getOrderID()+" can't find any delivery runner, the order has been cancelled and refunded.\nPlease try Dine in or Take away");
                        Message.addMessage(ms);
                        double creditbf = Customer.findCustomerCredit(order.getCustomerID());
                        Transaction tran = new Transaction(Transaction.type.REFUND, creditbf,creditbf+order.getTotal());
                        tran.addTransactionRecord(order.getCustomerID());
                        Customer.topupCustomerCredit(order.getCustomerID(), order.getTotal());
                        order.setOrderStatus(order.getOrderID(), OrderFile.OrderStatus.CANCELED);
                    }
                    break;
                }
            }
    }
    
    
    if(OrderFound){
        ObjWriteRead.writeObjectstoFile("Orders.dat", objectList);
    }
    else{

    // If the message is not found
       System.out.println("Order not found");
    }
    }
    
    public static List<String> removeStringFromList(List<String> list, String stringToRemove) {
        // Remove the specified string
        list.remove(stringToRemove);

        // You can also handle the case where the string might appear multiple times
        // list.removeAll(Collections.singleton(stringToRemove));

        return list;
    }

    public void seteatWhere(Where eatWhere) {
        this.eatWhere = eatWhere;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }
    
     public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    public OrderFile(String CustomerID, String OrderID,Where eatWhere){
        this.CustomerID = CustomerID;
        this.OrderID = OrderID;
        this.orderStatus = OrderStatus.PENDING;
        this.vendorName = getVendor(OrderID);
        this.review= new Review();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.date = dateFormat.format(new Date()); // Setting date as a formatted string
        this.total = getOrderTotal(OrderID);
        this.eatWhere = eatWhere;
        this.Confirm = confirmation.PENDING;
        this.foodStatus = FoodStatus.PENDING;
        if(eatWhere==Where.DELIVERY){
            this.delivery = DeliveryStatus.PENDING;
            this.DeliveryGuy = "Pending";
            this.total += 5;
            this.DeliveryGuyAvailable = Runner.getRunnerAvailable();
        }
        else{
            this.delivery = DeliveryStatus.NONE;
            this.DeliveryGuy="None";
            this.DeliveryGuyAvailable = null;
        }
    }
    
    public static OrderStatus getStatus(String OrderPath) {
        Object[] objectList = Admin.ObjWriteRead.readAllObjectsFromFile("Orders.dat");
        OrderStatus status = OrderStatus.NOTFOUND;
        // Printing the objects in the list
        boolean orderfound=false;
        for (Object obj : objectList) {
            if (obj instanceof OrderFile) {
                OrderFile order = (OrderFile) obj;
                if(order.getOrderID().equals(OrderPath)){
                    status = order.getOrderStatus();
                    orderfound=true;
                    break;
                }
            }
            // Add other instanceof checks for different types of objects
        }
        if(!orderfound){
            JOptionPane.showMessageDialog(null, "Order not found");
            return status;
        }
        return status;
    }
    
    public static Where getEatWhere(String OrderPath) {
        Object[] objectList = Admin.ObjWriteRead.readAllObjectsFromFile("Orders.dat");
        Where where = Where.NOTFOUND;
        // Printing the objects in the list
        boolean orderfound=false;
        for (Object obj : objectList) {
            if (obj instanceof OrderFile) {
                OrderFile order = (OrderFile) obj;
                if(order.getOrderID().equals(OrderPath)){
                    where = order.getEatWhere();
                    orderfound=true;
                    break;
                }
            }
            // Add other instanceof checks for different types of objects
        }
        if(!orderfound){
            JOptionPane.showMessageDialog(null, "Order not found");
            return where;
        }
        return where;
    }
    
    
    public static void addReview(String OrderPath,Review review) {
        Object[] objectList = Admin.ObjWriteRead.readAllObjectsFromFile("Orders.dat");

    // Iterate through objects in the list
    boolean OrderFound=false;
    
    for (int i = 0; i < objectList.length; i++) {
            Object obj = objectList[i];
            if(obj instanceof OrderFile){
                OrderFile order= (OrderFile) obj;
                
                if(order.getOrderID().equals(OrderPath) && order.getOrderStatus()==OrderStatus.COMPLETED){
                    order.setReview(review);
                    objectList[i] = order;
                    OrderFound=true;
                    break;
                }
                
                else if(order.getOrderID().equals(OrderPath) && order.getOrderStatus()!=OrderStatus.COMPLETED){
                    JOptionPane.showMessageDialog(null, "Order not yet completed!");
                    break;
                }
            }
    }        
    
    if(OrderFound){
        ObjWriteRead.writeObjectstoFile("Orders.dat", objectList);
    }
    else{

    // If the message is not found
       System.out.println("Order not found");
    }
    }
    
    public static void changeConfirmStatus(String OrderPath, confirmation confirm) {
    Object[] objectList = ObjWriteRead.readAllObjectsFromFile("Orders.dat");

    // Iterate through objects in the list
    boolean OrderFound = false;

    for (int i = 0; i < objectList.length; i++) {
        Object obj = objectList[i];
        if (obj instanceof OrderFile) {
            OrderFile order = (OrderFile) obj;

            if (order.getOrderID().equals(OrderPath) && order.getConfirm() == confirmation.PENDING) {
                order.setConfirm(confirm);
                objectList[i] = order;
                OrderFound = true;
                break;
            }

            // Other code...
        }
    }

    if (OrderFound) {
        ObjWriteRead.writeObjectstoFile("Orders.dat", objectList);
    } else {
        System.out.println("Order not found");
    }
}
    
    
    public static Date parseDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static List<OrderFile> filterByCurrentDate(List<OrderFile> orders) {
        List<OrderFile> filteredOrders = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = dateFormat.format(new Date());

        for (OrderFile order : orders) {
            if (order.getDate().equals(currentDate)) {
                filteredOrders.add(order);
            }
        }
        return filteredOrders;
    }
    
    public static List<OrderFile> filterByMonth(List<OrderFile> orders, int month) {
        List<OrderFile> filteredOrders = new ArrayList<>();
        for (OrderFile order : orders) {
            String[] dateParts = order.getDate().split("/");
            int orderMonth = Integer.parseInt(dateParts[1]);
            if (orderMonth == month) {
                filteredOrders.add(order);
            }
        }
        return filteredOrders;
    }
    
    
     
    public static List<OrderFile> filterByQuarter(List<OrderFile> orders, int quarter) {
        List<OrderFile> filteredOrders = new ArrayList<>();

        for (OrderFile order : orders) {
            String[] dateParts = order.getDate().split("/");
            int orderMonth = Integer.parseInt(dateParts[1]);
            int orderQuarter = (orderMonth - 1) / 3 + 1; // Determine the quarter of the year

            if (orderQuarter == quarter) {
                filteredOrders.add(order);
            }
        }
        return filteredOrders;
    }
    
    public static OrderFile findOrderById(String OrderID) {
        Object[] objectList = ObjWriteRead.readAllObjectsFromFile("Orders.dat");

        for (Object obj : objectList) {
            if (obj instanceof OrderFile) {
                OrderFile order = (OrderFile) obj;
                if (order.getOrderID().equals(OrderID)) {
                    return order;
                }
            }
        }

        // Order not found
        return null;
    }
     
    
    
    @Override
    public String toString(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        String formattedDate = dateFormat.format(date);
        
        String order = OrderID + "," + orderStatus + "," + review + "," + vendorName + "," + formattedDate + "," + total + "," + eatWhere;
        return order;
    }
}
