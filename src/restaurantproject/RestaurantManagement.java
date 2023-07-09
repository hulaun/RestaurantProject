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
    
    static String[] menu = {
        "Employee management", 
        "Customer management",
        "Exit"
    };
    
    static String[] customerMenu = {
        "List all customers",
        "Search customer and his order", 
        "Add customer", 
        "Add order", 
        "Read File",
        "Remove Order",
        "Remove Customer(payment)", 
        "Return"
    };

    static String[] employeeMenu = {
        "List all employees", 
        "Search employee", 
        "Add employee", 
        "Read File",
        "Remove Employee", 
        "Return"
    };
    
    //Validation val = new Validation();
    public RestaurantManagement() {
        super("Company Management System!!!", menu);
    }
//--------------------------------------------------

    public static void main(String[] args) {
        // Instantiate the Restaurant and read data from CSV file
        Restaurant.getInstance();
        Restaurant.fromCSV();

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
                        Restaurant.printCustomers();
                        break;
                    case 2:
                        customerSearching();
                        break;
                    case 3:
                        addCustomer();
                        break;
                    case 4:
                        addOrder();
                        break;
                    case 5:
                        try {
                            Restaurant.customersFromCSV(FileHandler.readFromFile("customers.csv"));
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                    case 6:
                        removeOrder();
                        break;
                    case 7:
                        removeCustomer();
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
                        Restaurant.printEmployees();
                        break;
                    case 2:
                        employeeSearching();
                        break;
                    case 3:
                        addEmployee();
                        break;
                    case 4:
                        try {
                            Restaurant.employeesFromCSV(FileHandler.readFromFile("employees.csv"));
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                    case 5:
                        removeEmployee();
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
        int id = Integer.parseInt(getValue("Enter CustomerID :"));

        // Check if the customer already exists
        Customer existingCustomer = Restaurant.getCustomerById(id);
        if (existingCustomer != null) {
            // Print the customer name and prompt for bill, order, and payment
            System.out.println("Customer name: " + existingCustomer.getName());
            int billId = Integer.parseInt(getValue("Enter BillID: "));
            int orderId = Integer.parseInt(getValue("Enter OrderID: "));
            int paymentId = Integer.parseInt(getValue("Enter PaymentID: "));
    
            // Update the existing customer
            existingCustomer.setBillId(billId);
            existingCustomer.setOrderId(orderId);
            existingCustomer.setPaymentId(paymentId);
            System.out.println("Customer updated successfully.");
        } else {
            // Add a new customer
            String name = getValue("Enter Name of Customer: ");
            int billId = Integer.parseInt(getValue("Enter BillID: "));
            int orderId = Integer.parseInt(getValue("Enter OrderID: "));
            int paymentId = Integer.parseInt(getValue("Enter PaymentID: "));
            Restaurant.appendCustomer(new Customer(id, name, billId, orderId, paymentId));
            System.out.println("Customer added successfully.");
        }
    }

    public void addOrder() {
        int id = Integer.parseInt(getValue("Enter OrderID: "));
        int customerId = Integer.parseInt(getValue("Enter CustomerID: "));
        int chefId = Integer.parseInt(getValue("Enter ChefID: "));
        int serverId = Integer.parseInt(getValue("Enter ServerID: "));

        // Check if the order already exists
        Order existingOrder = Restaurant.getOrderById(id);
        /* TODO */
    }

    public void addEmployee() {
        int id = Integer.parseInt(getValue("Enter EmployeeID: "));
        

        // Check if the employee already exists
        Employee existingEmployee = Restaurant.getEmployeeById(id);

        if (existingEmployee != null) {
            // Print the employee name and prompt for salary
            System.out.println("Employee name: " + existingEmployee.getName());
            double newSalary = Double.parseDouble(getValue("Enter new salary: "));

            // Update the existing employee
            existingEmployee.setSalary(newSalary);
            System.out.println("Employee updated successfully.");
        } else {
            String name = getValue("Enter Name of Employee: ");
            double salary = Double.parseDouble(getValue("Enter Salary of Employee: "));
            // Add a new employee
            Restaurant.appendEmployee(new Employee(id, name, salary));
            System.out.println("Employee added successfully.");
        }
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
                        Restaurant.searchCustomerById(Integer.parseInt(val));
                        break;
                    case 2:
                        val = getValue("Enter Name of Customer :");
                        Restaurant.searchCustomerByName(val);
                        break;

                    default:
                        return;
                }
            }
        };
        m.run();
    }
//--------------------------------------------------  
private void employeeSearching() {  
    String[] mSearch = {"Find by ID", "Find by Name"};
    UIMenu m = new UIMenu("Employee Searching", mSearch) {
        @Override
        public void execute(int n) {
            switch (n) {
                case 1:
                    String val = getValue("Enter ID :");
                    Restaurant.searchEmployeeById(Integer.parseInt(val));
                    break;
                case 2:
                    val = getValue("Enter Name of Employee :");
                    Restaurant.searchEmployeeByName(val);
                    break;

                default:
                    return;
            }
        }
    };
    m.run();
}

    private static void close() {
        System.out.println("Writing to file...");
        try {
            FileHandler.writeToFile("customers.csv", Restaurant.customersToCSV());
            FileHandler.writeToFile("employees.csv", Restaurant.employeesToCSV());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Thank you for choosing us! bye bye");
        System.exit(0);
    }

    private void removeOrder() {
        int id = Integer.parseInt(getValue("Enter OrderID: "));
        Restaurant.removeOrderById(id);
    }

    private void removeCustomer() {
        int id = Integer.parseInt(getValue("Enter CustomerID: "));
        Restaurant.removeCustomerById(id);
    }

    private void removeEmployee() {
        int id = Integer.parseInt(getValue("Enter EmployeeID: "));
        Restaurant.removeEmployeeById(id);
    }
}
