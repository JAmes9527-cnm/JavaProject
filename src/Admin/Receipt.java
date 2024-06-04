/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Admin;

import java.io.Serializable;

/**
 *
 * @author james
 */
public class Receipt implements Serializable{
    private String CustomerID;
    private double BeforeBalance;
    private double AfterBalance;

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public double getBeforeBalance() {
        return BeforeBalance;
    }

    public void setBeforeBalance(double BeforeBalance) {
        this.BeforeBalance = BeforeBalance;
    }

    public double getAfterBalance() {
        return AfterBalance;
    }

    public void setAfterBalance(double AfterBalance) {
        this.AfterBalance = AfterBalance;
    }

    public Receipt(String CustomerID, double BeforeBalance, double AfterBalance) {
        this.CustomerID = CustomerID;
        this.BeforeBalance = BeforeBalance;
        this.AfterBalance = AfterBalance;
    }
    
    public String toFile(){
        return CustomerID + "," + BeforeBalance  + "," + AfterBalance;
    }
    
    @Override
    public String toString(){
        return "CustomerID: " + CustomerID + "\n" + "Before Balance: " + BeforeBalance + "\n" + "After Balance: " + AfterBalance;
    }
}
