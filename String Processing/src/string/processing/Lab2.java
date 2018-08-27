/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package string.processing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author carlt
 */
public class Lab2 {
    
    
    public static void main(String[] args) {
         String filename = "";
        if (args.length > 0) {
            filename = args[0];
        }
         ArrayList<String> data = new ArrayList<>();
        readData(data, filename);
        printData(data);
     }
     public static void readData(ArrayList<String> data, String filename) {
         try {
            Scanner read = new Scanner(new File(filename));
             while (read.hasNext()) {
                String[] info = read.nextLine().split(",");
                if (validateName(info[0].trim()) && validateName(info[1].trim()) && validateGender(info[2].trim()) && validateAge(info[3].trim()) && validatePhoneNumber(info[4].trim()) && validateEmailAddress(info[5].trim())) {
                    String formattedData = String.format("%-20s%-20s%-10s%10s%20s%30s", info[0], info[1], info[2], info[3], info[4], info[5]);
                    data.add(formattedData);
                } else {
                    String formattedData = String.format("%-20s%-20s%-10s%10s%20s%30s", info[0], info[1], info[2], info[3], info[4], info[5]);
                    System.out.println("Data is Not Valid:" + formattedData);
                }
             }
        } catch (FileNotFoundException ex) {
            System.out.print("File was not found");
        }
    }
     public static boolean validateName(String name) {
        boolean valid = false;
        for (int i = 0; i < name.length(); i++) {
            valid = (name.charAt(i) >= 'a' && name.charAt(i) <= 'z') || (name.charAt(i) >= 'A' && name.charAt(i) <= 'Z');
        }
        return valid;
    }
     public static boolean validateGender(String gender) {
        boolean isValid = gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female");
        return isValid;
    }
     public static boolean validateAge(String age) {
         boolean isValid;
        try {
            int personAge = Integer.parseInt(age);
            if (personAge >= 1 && personAge <= 130) {
                isValid = true;
            } else {
                isValid = false;
            }
        } catch (NumberFormatException ex) {
            return false;
        }
        return isValid;
    }
     public static boolean validatePhoneNumber(String number) {
         if(number.substring(0,1).equals("(") && number.substring(4,5).equals(")") && number.substring(8,9).equals("-")){
            if(number.substring(1,4).matches("[0-9]+") && number.substring(5,8).matches("[0-9]+") && number.substring(9).matches("[0-9]+")){
                return true;
            }
        }
        return false;
    }
     public static boolean validateEmailAddress(String email) {
        boolean isValid = false;
        if (email.contains("@") && email.contains(".")) {
            email = email.replaceAll("@", ".");
            String[] splitEmail = email.split("\\.");
            if (splitEmail.length == 3) {
                isValid = validateEmailStrings(splitEmail[0], splitEmail[1], splitEmail[2]);
            }
        } else {
            isValid = false;
        }
        return isValid;
    }
     public static boolean validateEmailStrings(String start, String middle, String end) {
        boolean isLetter =  (start.charAt(0) >= 'a' && start.charAt(0) <= 'z') || (start.charAt(0) >= 'A' && start.charAt(0) <= 'Z');
        return (isLetter && start.matches("(\\d|\\w)+")) && middle.matches("(\\d|\\w)+") && (end.equalsIgnoreCase("net") || end.equalsIgnoreCase("com"));
    }
    
     public static void printData(ArrayList<String> data) {
        System.out.println();
        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i));
}
     }
}
