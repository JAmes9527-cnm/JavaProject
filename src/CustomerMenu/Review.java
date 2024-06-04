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
public class Review implements Serializable{
    private int stars;
    private String comment;

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    public Review(){
        this.stars = 0;
        this.comment = "";
    }
    
    public Review(int stars,String comment){
        this.stars = stars;
        this.comment = comment;
    }
    
    @Override
    public String toString(){
        String rev = stars  + "," + comment;
        return rev;
    }
}
