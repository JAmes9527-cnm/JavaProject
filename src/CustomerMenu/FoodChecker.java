/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CustomerMenu;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author james
 */
public class FoodChecker {
    public static double findFoodPrice(String foodID) {
    File folder = new File("menu");
    File[] listOfFiles = folder.listFiles();

    for (File file : listOfFiles) {
        if (file.isFile()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;

                while ((line = reader.readLine()) != null) {
                    String[] menuData = line.split(",");
                    if (menuData.length == 4 && menuData[0].trim().equals(foodID)) {
                        return Double.parseDouble(menuData[2].trim());
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    return -1.0;
}
    
   public static String findFoodName(String foodID) {
    File folder = new File("menu");
    File[] listOfFiles = folder.listFiles();

    for (File file : listOfFiles) {
        if (file.isFile()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;

                while ((line = reader.readLine()) != null) {
                    String[] menuData = line.split(",");
                    if (menuData.length == 4 && menuData[0].trim().equals(foodID)) {
                        return menuData[1].trim();
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    return "0";
}
    
    public static String findFoodVendor(String foodID) {
    File folder = new File("menu");
    File[] listOfFiles = folder.listFiles();

    for (File file : listOfFiles) {
        if (file.isFile()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;

                while ((line = reader.readLine()) != null) {
                    String[] menuData = line.split(",");
                    if (menuData.length == 4 && menuData[0].trim().equals(foodID)) {
                        return menuData[3].trim();
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    return "0";
}
}