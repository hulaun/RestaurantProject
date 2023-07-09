/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurantproject;

import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class Validation {
    private Scanner sc = new Scanner(System.in);
    
    public String validCustomerId(String value){
        String id = sc.nextLine();
        if (id.matches("[0-9]*")) {
            return id;
        } else {
            return validCustomerId(getValue("Invalid ID format. Please enter ID with integers only: "));
        } 
    }
    public String validBillId(String value){
        String id = sc.nextLine();
        if (id.matches("[0-9]*")) {
            return id;
        } else {
            return validBillId(getValue("Invalid ID format. Please enter ID with integers only: "));
        } 
    }
    public String validPaymentId(String value){
        String id = sc.nextLine();
        if (id.matches("[0-9]*")) {
            return id;
        } else {
            return validPaymentId(getValue("Invalid ID format. Please enter ID with integers only: "));
        } 
    }
    public String validOrderId(String value){
        String id = sc.nextLine();
        if (id.matches("[0-9]*")) {
            return id;
        } else {
            return validOrderId(getValue("Invalid ID format. Please enter ID with integers only: "));
        } 
    }
    public String validChefId(String value){
        String id = sc.nextLine();
        if (id.matches("[0-9]*")) {
            return id;
        } else {
            return validChefId(getValue("Invalid ID format. Please enter ID with integers only: "));
        } 
    }
    public String validServerId(String value){
        String id = sc.nextLine();
        if (id.matches("[0-9]*")) {
            return id;
        } else {
            return validServerId(getValue("Invalid ID format. Please enter ID with integers only: "));
        } 
    }
    public String validEmployeeId(String value){
        String id = sc.nextLine();
        if (id.matches("[0-9]*")) {
            return id;
        } else {
            return validEmployeeId(getValue("Invalid ID format. Please enter ID with integers only: "));
        } 
    }
    public String validSalary(String value){
        String id = sc.nextLine();
        if (id.matches("[0-9]*\\.?[0-9]+")) {
            return id;
        } else {
            return validSalary(getValue("Invalid ID format. Please enter ID with integers only: "));
        } 
    }
    public String validName(String value){
        String name = sc.nextLine();
        if (name.matches("[a-zA-Z]+")) {
            return name;
        } else {
            return validName(getValue("Invalid name. Please enter name with characters only: "));
        } 
    }
    
    public String getValue(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }
}
