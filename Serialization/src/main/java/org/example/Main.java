package org.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {

        String fileName = "time.ser";
        Person p = new Person("Lars", "Vogel");

        //save the object to file
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try
        {
            fos = new FileOutputStream(fileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(p);
            out.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        //read the object from file
        //save the object to file
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try{
            fis = new FileInputStream(fileName);
            in = new ObjectInputStream(fis);
            p = (Person) in.readObject();
            in.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println(p);
    }
}