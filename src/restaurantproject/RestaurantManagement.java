/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurantproject;

import java.io.IOException;

/**
 *
 * @author ACER
 */
public class RestaurantManagement extends UIMenu<String>{
    
    Validation val = new Validation();
    static String[] menu = {
        "Customer management",
        "Employee management", 
        "Exit"
    };
    
    static String[] customerMenu = {
        "List all customers",
        "List menu items",
        "Search customer and his order", 
        "Add customer", 
        "Add order", 
        "Read File",
        "Check Ordered",
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
    
    public RestaurantManagement() {
        super("Company Management System!!!", menu);
    }
//--------------------------------------------------

    public static void main(String[] args) {
        // Instantiate the Restaurant and read data from CSV file
        Restaurant.getInstance();
        // Restaurant.fromCSV();

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
                        Restaurant.printMenuItems();
                        break;
                    case 3:
                        customerSearching();
                        break;
                    case 4:
                        addCustomer();
                        break;
                    case 5:
                        addOrder();
                        break;
                    case 6:
                        try {
                            Restaurant.customersFromCSV(FileHandler.readFromFile("customers.csv"));
                            Restaurant.menuItemsFromCSV(FileHandler.readFromFile("menuItems.csv"));
                        } catch (IOException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                    case 7:
                        isOrdered();
                        break;
                    case 8:
                        removeOrder();
                        break;
                    case 9:
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
                        } catch (IOException e) {
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
        System.out.print(msg);
        return sc.nextLine();
    }
//--------------------------------------------------

    public void addCustomer() {
        int id = Integer.parseInt(val.validCustomerId(getValue("Enter CustomerID :")));

        // Check if the customer already exists
        Customer existingCustomer = Restaurant.getCustomerById(id);
        if (existingCustomer != null) {
            // Print the customer name and prompt for bill, order, and payment
            System.out.println("Customer name: " + existingCustomer.getName());
            int billId = Integer.parseInt(val.validBillId(getValue("Enter BillID: ")));
            int orderId = Integer.parseInt(val.validOrderId(getValue("Enter OrderID: ")));
            int paymentId = Integer.parseInt(val.validPaymentId(getValue("Enter PaymentID: ")));
    
            // Update the existing customer
            existingCustomer.setBillId(billId);
            existingCustomer.setOrderId(orderId);
            existingCustomer.setPaymentId(paymentId);
            System.out.println("Customer updated successfully.");
        } else {
            // Add a new customer
            String name = val.validName(getValue("Enter Name of Customer: "));
            int billId = Integer.parseInt(val.validBillId(getValue("Enter BillID: ")));
            int orderId = Integer.parseInt(val.validOrderId(getValue("Enter OrderID: ")));
            int paymentId = Integer.parseInt(val.validPaymentId(getValue("Enter PaymentID: ")));
            Restaurant.appendCustomer(new Customer(id, name, billId, orderId, paymentId));
            System.out.println("Customer added successfully.");
        }
    }

    public void addOrder() {

        int id = Integer.parseInt(val.validOrderId(getValue("Enter OrderID: ")));

        // Check if the order already exists
        Order order = Restaurant.getOrderById(id);
        if (order == null) {
            // Add a new order
            int customerId = Integer.parseInt(val.validCustomerId(getValue("Enter CustomerID: ")));
            int serverId = Integer.parseInt(val.validServerId(getValue("Enter ServerID: ")));

            order = new Order(id, customerId, serverId);
        }
        //IN menu
        Restaurant.printMenuItems();
        //
//        while()
//        int itemId = Integer.parseInt(val.validItemId(getValue("Enter itemID which you want to order (1-7)or 8 to submit order:")));

        // TODO: Add item to order
        // TODO: Iteratively prompt the user to add items, check for valid input, and add to order
    }

    public void addEmployee() {
        int id = Integer.parseInt(val.validEmployeeId(getValue("Enter EmployeeID: ")));
        // Check if the employee already exists
        Employee employee = Restaurant.getEmployeeById(id); 
        if (employee != null) {
            System.out.println("Employee already exists.");
            return;
        }

        String type = val.validType(getValue("Enter Type of Employee (\"chef\" or \"server\"): "));
        // Add a new employee
        String name = val.validName(getValue("Enter Name of Employee: "));
        int salary = Integer.parseInt(val.validSalary(getValue("Enter Salary of Employee: ")));
        if (type.equals("chef")) {
            employee = new Chef(id, name, salary);
        } else if (type.equals("server")) {
            employee = new Server(id, name, salary);
        } else {
            System.out.println("Invalid employee type.");
            return;
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
                        String value = val.validCustomerId(getValue("Enter CustomerID :"));
                        Restaurant.searchCustomerById(Integer.parseInt(value));
                        break;
                    case 2:
                        value = val.validName(getValue("Enter Name of Customer :"));
                        Restaurant.searchCustomerByName(value);
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
                    String value = val.validEmployeeId(getValue("Enter ID :"));
                    Restaurant.searchEmployeeById(Integer.parseInt(value));
                    break;
                case 2:
                    value = val.validName(getValue("Enter Name of Employee :"));
                    Restaurant.searchEmployeeByName(value);
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
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Thank you for choosing us! bye bye");
        System.exit(0);
    }
    
    private void isOrdered() {
        int id = Integer.parseInt(val.validCustomerId(getValue("Enter CustomerID: ")));
        Restaurant.removeCustomerById(id);
    }

    private void removeOrder() {
        int id = Integer.parseInt(val.validOrderId(getValue("Enter OrderID: ")));
        Restaurant.removeOrderById(id);
    }

    private void removeCustomer() {
        int id = Integer.parseInt(val.validCustomerId(getValue("Enter CustomerID: ")));
        Restaurant.removeCustomerById(id);
    }
    
    private void removeEmployee() {
        int id = Integer.parseInt(val.validEmployeeId(getValue("Enter EmployeeID: ")));
        Restaurant.removeEmployeeById(id);
    }
}
