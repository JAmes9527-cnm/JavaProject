/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CustomerMenu;

import java.io.Serializable;

/**
 *
 * @author james
 */
public class item implements Serializable{
    private String Id;
    private String Name;
    private String Price;

    public item (String Id, String Name, String Price){
    this.Id = Id;
    this.Name = Name;
    this.Price = Price;
    
}
    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }
    
    @Override
    public String toString(){
        return Id+","+Name+","+Price;
    }
    
}

 
 


