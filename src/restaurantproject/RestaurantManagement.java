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
public class RestaurantManagement extends UIMenu<String>{
    
    static String[] menu = {"Employee management", "Customer management","Exit"};
    static String[] customerMenu = {"List all customers", "Search customer and his order", "Add customer", "Add order", "Read File","Remove Order","Remove Customer(payment)", "Return"};
    static String[] employeeMenu = {"List all employees", "Search employee", "Add employee", "Read File","Remove Employee", "Return"};
    
    //Validation val = new Validation();
    public RestaurantManagement() {
        super("Company Management System!!!", menu);
    }
//--------------------------------------------------

    public static void main(String[] args) {
        RestaurantManagement rm = new RestaurantManagement();
        rm.run();
        close();
    }
//--------------------------------------------------

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                customerUIMenu();
                break;
            case 2:
                employeeUIMenu();
                break;
            default:
                break;
        }
        

    }
//--------------------------------------------------
    private void customerUIMenu() {
        UIMenu m = new UIMenu("Customer Searching", customerMenu) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1:
                        break;
                    case 2:
                        customerSearching();
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break; 
                    default:
                        break;
                }
            }
        };
        m.run();
    }
//--------------------------------------------------
    private void employeeUIMenu() {
        UIMenu m = new UIMenu("Customer Searching", employeeMenu) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1:
                        break;
                    case 2:
                        customerSearching();
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break; 
                    default:
                        break;
                }
            }
        };
        m.run();
    }
//--------------------------------------------------

    public String getValue(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.print(msg);
        return sc.nextLine();
    }
//--------------------------------------------------

    public void addCustomer() {
        /*them customer va order chung vao CustomerFile
            khi old customer muon order thi update CustomerFile 
        */
    }

//--------------------------------------------------
    private void customerSearching() {  
        String[] mSearch = {"Find by CustomerID", "Find by Name"};
        UIMenu m = new UIMenu("Customer Searching", mSearch) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1:
                        String val = getValue("Enter CustomerID :");
                        break;
                    case 2:
                        val = getValue("Enter Name of Customer :");
                        break;

                    default:
                        return;
                }
            }
        };
        m.run();
    }
//--------------------------------------------------  

    private static void close() {
        System.out.println("Thank you for choosing us! bye bye");
        System.exit(0);
    }
}
