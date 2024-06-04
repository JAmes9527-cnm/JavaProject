/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CustomerMenu;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author james
 */
public class Time {
    private int hour;
    private int minute;
    private int second;
    
     // Constructor to set the time to the current time in GMT
    public Time() {
        // Get the current time in milliseconds since epoch
        long currentTimeMillis = System.currentTimeMillis();
        long totalSecond = currentTimeMillis/1000;
        second = (int)totalSecond%60;
        long totalminute = totalSecond / 60;
        minute = (int)totalminute%60;
        long totalhour = totalminute / 60;
        hour = (int)totalhour %24; 

    // Convert the current time in milliseconds to hours, minutes, and seconds.
    //Date date = new Date(currentTimeMillis);
   // this.hour = date.getHours();
   //this.minute = date.getMinutes();
    //this.second = date.getSeconds();
    
    }
    
    public int getHour() {
    return hour;
  }

  public int getMinute() {
    return minute;
  }

  public int getSecond() {
    return second;
  }
  @Override
    public String toString() {
        return String.format("%02d:%02d:%02d",hour,minute,second);
    }
    

    
    public static String getOrderTime() {
    Time currentTime = new Time(); // Create an instance to access the time
    return String.format("%02d%02d%02d", currentTime.getHour(), currentTime.getMinute(), currentTime.getSecond());
}
}

