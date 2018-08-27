/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package string.processing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlt
 */
public class StringProcessing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         
       String[] records = new String[100];
            
        try {
            Scanner reader = new Scanner(new File(args[0]));
            
            int currentIndex = 0;
            while(reader.hasNext()){
                String[] input = reader.nextLine().split(",");
                
                String firstName = input[0];
                String lastName = input[1];
                String age = input[2];
                String gender = input[3];
                String phoneNumber = input[4];
                String emailAddress = input[5];
                
                records[currentIndex] = String.format("%-20s%-20s%-10s%-10s%-20s%-20s", firstName, lastName, age, gender, phoneNumber, emailAddress);
                System.out.println(records[currentIndex]);
                currentIndex ++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(String.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
    }
    
}
