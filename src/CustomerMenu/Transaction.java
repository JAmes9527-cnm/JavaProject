/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CustomerMenu;

import Admin.ObjWriteRead;
import java.util.Date;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author james
 */
public class Transaction implements Serializable{
    private type transactionType;
    private double creditBefore;
    private double creditAfter;
    private Date date;
    
    public enum type{
        TOPUP,ORDER,REFUND;
    }

    public type getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(type transactionType) {
        this.transactionType = transactionType;
    }

    public double getCreditBefore() {
        return creditBefore;
    }

    public void setCreditBefore(double creditBefore) {
        this.creditBefore = creditBefore;
    }

    public double getCreditAfter() {
        return creditAfter;
    }

    public void setCreditAfter(double creditAfter) {
        this.creditAfter = creditAfter;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Transaction(type transactionType, double creditBefore, double creditAfter) {
        this.transactionType = transactionType;
        this.creditBefore = creditBefore;
        this.creditAfter = creditAfter;
        this.date = new Date();
    }
    
    public void addTransactionRecord(String customerID){
        String fileName = customerID + "transRecord.dat";
        ObjWriteRead.appendObjectToFile(this, fileName);
    }
    
    public static Object[] getTransactions(String CustomerID){
        String transfile = CustomerID+"transRecord.dat";
        List<Transaction> trans = new ArrayList<>();
        File f = new File(transfile);
        if(!f.exists()){
            JOptionPane.showMessageDialog(null, "There is no transaction record");
            return null;
        }
        Object[] Objectlist = ObjWriteRead.readAllObjectsFromFile(transfile);
        for(Object obj: Objectlist){
            if(obj instanceof Transaction){
                Transaction tran = (Transaction) obj;
                trans.add(tran);
            }
        }
        return trans.toArray();
    }
    
    @Override
    public String toString(){
        return transactionType  + "," + creditBefore + "," + creditAfter + "," + date;
    }
}
