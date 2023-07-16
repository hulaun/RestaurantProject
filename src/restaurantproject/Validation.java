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
        if (value.matches("[0-9]*")) {
            return value;
        } else {
            return validCustomerId(getValue("Invalid ID format. Please enter ID with integers only: "));
        } 
    }
    public String validBillId(String value){
        if (value.matches("[0-9]*")) {
            return value;
        } else {
            return validBillId(getValue("Invalid ID format. Please enter ID with integers only: "));
        } 
    }
    public String validPaymentId(String value){
        if (value.matches("[0-9]*")) {
            return value;
        } else {
            return validPaymentId(getValue("Invalid ID format. Please enter ID with integers only: "));
        } 
    }
    public String validOrderId(String value){
        if (value.matches("[0-9]*")) {
            return value;
        } else {
            return validOrderId(getValue("Invalid ID format. Please enter ID with integers only: "));
        } 
    }
    public String validItemId(String value){
        if (value.matches("[1-8]")) {
            return value;
        } else {
            return validItemId(getValue("Invalid ID format. Please enter itemId or 0 to submit order: "));
        } 
    }
    public String validChefId(String value){
        if (value.matches("[0-9]*")) {
            return value;
        } else {
            return validChefId(getValue("Invalid ID format. Please enter ID with integers only: "));
        } 
    }
    public String validServerId(String value){
        if (value.matches("[0-9]*")) {
            return value;
        } else {
            return validServerId(getValue("Invalid ID format. Please enter ID with integers only: "));
        } 
    }
    public String validEmployeeId(String value){
        if (value.matches("[0-9]*")) {
            return value;
        } else {
            return validEmployeeId(getValue("Invalid ID format. Please enter ID with integers only: "));
        } 
    }
    public String validSalary(String value){
        if (value.matches("[0-9]*\\.?[0-9]+")) {
            return value;
        } else {
            return validSalary(getValue("Invalid ID format. Please enter ID with integers only: "));
        } 
    }
    public String validName(String value){
        if (value.matches("[a-zA-Z]+")) {
            return value;
        } else {
            return validName(getValue("Invalid name. Please enter name with characters only: "));
        } 
    }
    
    public String getValue(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }
}
