/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CustomerMenu;

import Admin.ObjWriteRead;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author james
 */
public class Message implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String messageID;
    private String UserID;
    private String message;
    private messageStatus status; 
    private messageType notify;
    private String OrderID;

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    public messageType getNotify() {
        return notify;
    }

    public void setNotify(messageType notify) {
        this.notify = notify;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String OrderID) {
        this.OrderID = OrderID;
    }
            
    public enum messageStatus{
        READ,NOTREAD
    }
    
    public enum confirmStatus{
        PENDING,ACCEPT,REJECT
    }
    
    public enum messageType{
        FOODORDER,DELIVERYORDER,NOTIFICATION
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public messageStatus getStatus() {
        return status;
    }

    public void setStatus(messageStatus status) {
        this.status = status;
    }

    public Message(String UserID, String message) {
        this.messageID="M"+Time.getOrderTime();
        this.UserID = UserID;
        this.message = message;
        this.status = messageStatus.NOTREAD;
        this.notify = messageType.NOTIFICATION;
        this.OrderID = "none";
    }
    
    public Message(String UserID, String message, messageType type , String OrderID) {
        this.messageID="M"+Time.getOrderTime();
        this.UserID = UserID;
        this.message = message;
        this.status = messageStatus.NOTREAD;
        this.notify = type;
        this.OrderID = OrderID;
    }
    
    @Override
    public String toString(){
        String ms = UserID + "\n" + message + "\n" + status;
        return ms;
    }
    
    public static void addMessage(Message ms) {
    try {
        File file = new File("MessageFile.dat");

        // If the file exists, read all existing messages into the list
        if (file.exists()) {
            ObjWriteRead.appendObjectToFile(ms, "MessageFile.dat");
        } else {
            if (file.createNewFile()) {
                ObjWriteRead.appendObjectToFile(ms, "MessageFile.dat");
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    
    public static int getMessageNo (String UserID)throws IOException,ClassNotFoundException{
        int notReadCount = 0;

        Object[] objectList = Admin.ObjWriteRead.readAllObjectsFromFile("MessageFile.dat");

        // Printing the objects in the list
        for (Object obj : objectList) {
            if (obj instanceof Message) {
                Message message = (Message) obj;
                if(message.getUserID().equals(UserID) && message.getStatus() == messageStatus.NOTREAD){
                    notReadCount += 1;
                }
            }
            // Add other instanceof checks for different types of objects
        }

        return notReadCount;
    }
    
    public static List<Message> getMessages (String UserID)throws IOException,ClassNotFoundException{

        Object[] objectList = Admin.ObjWriteRead.readAllObjectsFromFile("MessageFile.dat");
        List<Message> messages = new ArrayList<>();

        // Printing the objects in the list
        for (Object obj : objectList) {
            if (obj instanceof Message) {
                Message message = (Message) obj;
                if(message.getUserID().equals(UserID) && message.getStatus() == messageStatus.NOTREAD){
                    messages.add(message);
                }
            }
            // Add other instanceof checks for different types of objects
        }

        return messages;
    }
    
    public static void markMessageAsRead(String messageID) throws IOException, ClassNotFoundException {
    Object[] objectList = Admin.ObjWriteRead.readAllObjectsFromFile("MessageFile.dat");

    // Iterate through objects in the list
    boolean messageFound=false;
    
    for (int i = 0; i < objectList.length; i++) {
            Object obj = objectList[i];
            if(obj instanceof Message){
                Message message= (Message) obj;
                
                if(message.getMessageID().equals(messageID)&&message.getStatus()==messageStatus.NOTREAD){
                    message.setStatus(messageStatus.READ);
                    objectList[i] = message;
                    messageFound=true;
                    break;
                }
            }
    }        
    
    if(messageFound){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("MessageFile.dat"))) {
                // Write all objects to the file
                for (Object obj : objectList) {
                    oos.writeObject(obj);
                }
                System.out.println("Attribute changed successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    else{

    // If the message is not found
    System.out.println("Message not found or already marked as READ.");
    }
    }

}
