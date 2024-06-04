/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Admin;

/**
 *
 * @author james
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjWriteRead {

    // Method to write an object to a file with a custom extension
   public static void appendObjectToFile(Object newObj, String fileName) {
       File f = new File(fileName);
        if(!f.exists()){
            try {
                f.createNewFile();
            } catch (Exception e) {
            }
        }
    Object[] existingObjects = readAllObjectsFromFile(fileName);

        // Create a dynamic list to store all objects
        List<Object> objectList = new ArrayList<>();

        // Add existing objects to the list
        if (existingObjects != null) {
            for (Object obj : existingObjects) {
                objectList.add(obj);
            }
        }

        // Add the new object to the list
        objectList.add(newObj);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            // Write all objects to the file
            for (Object obj : objectList) {
                oos.writeObject(obj);
            }
            System.out.println("Object added to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
}





    public static Object[] readAllObjectsFromFile(String fileName) {
    List<Object> objectList = new ArrayList<>();

    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
        // Read objects until the end of the file is reached
        while (true) {
            try {
                Object obj = ois.readObject();
                objectList.add(obj);
            } catch (EOFException e) {
                // End of file reached
                break;
            }
        }

        System.out.println("Objects read from file successfully.");
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }

    return objectList.toArray();
}

    
    public static void writeObjectstoFile(String filename,Object[] objects){
        File f = new File(filename);
        if(!f.exists()){
            try {
                f.createNewFile();
            } catch (Exception e) {
            }
        }
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
                // Write all objects to the file
                for (Object obj : objects) {
                    oos.writeObject(obj);
                }
                System.out.println("Attribute changed successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public static void FileCopy(String sourceFileName, String destinationFileName) {
        try {
            // Create input stream for the source file
            FileInputStream fileInputStream = new FileInputStream(sourceFileName);
            // Create output stream for the destination file
            FileOutputStream fileOutputStream = new FileOutputStream(destinationFileName);
            // Create a buffer to hold the data while transferring
            byte[] buffer = new byte[1024];
            int bytesRead;
            // Read data from the source file and write it to the destination file
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }
            // Close the streams
            fileInputStream.close();
            fileOutputStream.close();
            System.out.println("File duplicated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
