/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverPackage;

import studentPackage.Student;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iit
 */
public class Serialize_IO {
    private static String filename = "serialize_data.txt";
    

    
    public void writeSerializeListObject(ArrayList<Student> students){
        /*Account ac1 = new Account("Sezan", "12345", 600, "fr4567");
        Account ac2 = new Account("Kavi", "12336", 2600, "frdf567");
        
        ArrayList<Account> accountList = new ArrayList<>();
        
        accountList.add(ac1);
        accountList.add(ac2);*/
        
        FileOutputStream fout = null;
        ObjectOutputStream object_out_for_serializable = null;
        try {
            fout = new FileOutputStream(filename);
            object_out_for_serializable = new ObjectOutputStream(fout);
            
            object_out_for_serializable.writeObject(students);
            object_out_for_serializable.flush();
            
            System.out.println("Success to write serializable");
                    
        } catch (FileNotFoundException ex) {
            System.out.println("FileOutputStream in " + ex.toString());
        } catch (IOException ex) {
            System.out.println("ObjectOutputStream in " + ex.toString());
        } 
        
    }
    
    


    public  ArrayList<Student> readDeserializeListObject(){
 
        try {
            ObjectInputStream object_in_for_deserializable =
                    new ObjectInputStream(new FileInputStream(filename));
            
            ArrayList<Student> students =
                    (ArrayList<Student>) object_in_for_deserializable.readObject();
            
            /*for (Student deserializeStudent : listOfAccounts){
                System.out.println(deserializeStudent);
            }*/

            return students;
//            Student student1 = (Student) object_in_for_deserializable.readObject();
//            
//            System.out.println(student1.name + "; All:" + student1.toString());
            
        } catch (IOException ex) {
            Logger.getLogger(Serialize_IO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Serialize_IO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
        
    }

    
}
