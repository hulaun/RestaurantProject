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
        "Customer Management",
        "Employee Management",
        "Exit",
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
        "Return",
    };

    static String[] employeeMenu = {
        "List all employees", 
        "Search employee", 
        "Add employee", 
        "Read File",
        "Remove Employee", 
        "Return",
    };
    
    public RestaurantManagement() {
        super("Company Management System!!!", menu);
    }
//--------------------------------------------------

    public static void main(String[] args) {
        // Instantiate the Restaurant and read data from CSV file
        Restaurant.getInstance();
        if (getValue("Read from file? (y/n)").equalsIgnoreCase("y")) {
            try {
                Restaurant.customersFromCSV(FileHandler.readFromFile("customers.csv"));
                Restaurant.employeesFromCSV(FileHandler.readFromFile("employees.csv"));
                // TODO: Implement save order as a raw object
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

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
                        Menu menuItems = Restaurant.getInstance().menu();
                        menuItems.displayMenu();
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
                            menuItems = Restaurant.getInstance().menu();
                            menuItems.readMenuFromCSV();
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

    public static String getValue(String msg) {
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
    
            // Update the existing customer
            existingCustomer.setBillId(billId);
            existingCustomer.setOrderId(orderId);
            System.out.println("Customer updated successfully.");
        } else {
            // Add a new customer
            String name = val.validName(getValue("Enter Name of Customer: "));
            int billId = Integer.parseInt(val.validBillId(getValue("Enter BillID: ")));
            int orderId = Integer.parseInt(val.validOrderId(getValue("Enter OrderID: ")));
            int paymentId = Integer.parseInt(val.validPaymentId(getValue("Enter PaymentID: ")));
            Restaurant.appendCustomer(new Customer(id, name, billId, orderId));
            System.out.println("Customer added successfully.");
        }
    }

    public void addOrder() {

        int id = Integer.parseInt(val.validOrderId(getValue("Enter OrderID: ")));

        // Check if the order already exists
        Order order = Restaurant.getOrderById(id);
        if (order == null) {
            // Add a new order
            // TODO: Validation check: check for valid customer and server IDs (must exist)
            int customerId = Integer.parseInt(val.validCustomerId(getValue("Enter CustomerID: ")));

            Restaurant.getCustomerById(customerId).setOrderId(id);
            order = new Order(id, customerId);
        }

        // Print the menu
        Restaurant restaurant = Restaurant.getInstance();
        Menu menuItems = restaurant.menu();
        menuItems.displayMenu();

        // Iteratively prompt the user to add items, check for valid input, and add to order
//        Scanner scanner = new Scanner(System.in);
        boolean done = false;
        while (!done) {
            // Prompt the user for the item ID and quantity
            // TODO: Check for valid input 
            int itemId = Integer.parseInt(getValue("Enter item ID: "));
            int quantity = Integer.parseInt(getValue("Enter quantity: "));

            // Check if the item ID is valid
            MenuItem menuItem = Restaurant.getMenuItemById(itemId);
            if (menuItem == null) {
                System.out.println("Invalid item ID. Please try again.");
                continue;
            }

            // Add the item to the order
            order.addMenuItem(menuItem, quantity);

            // Prompt the user to add another item or finish
            String input = getValue("Add another item? (y/n)");
            if (input.equalsIgnoreCase("n")) {
                done = true;
            }
        }
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
        double salary = Double.parseDouble(val.validSalary(getValue("Enter Salary of Employee: ")));
        switch (type) {
            case "chef":
                employee = new Chef(id, name, salary);
                Restaurant.appendEmployee(employee);
                break;
            case "server":
                employee = new Server(id, name, salary);
                Restaurant.appendEmployee(employee);
                break;
            default:
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
        if (getValue("Do you want to save the changes? (y/n): ").equalsIgnoreCase("y")) {
            Restaurant.save();
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
        Bill bill = new Bill(Restaurant.getCustomerById(id).getBillId(),Restaurant.getCustomerById(id).getOrderIds()); 
        Restaurant.billCalculate(bill);
        System.out.println(bill.toString());
        String choice = getValue("Enter way to pay (\"cash\" or \"card\"): ");
        switch (choice) {
            case "cash":
                bill.makePaymentWithCash();
                bill.markAsPaid();
                for(int ordId : bill.getOrderIds()){
                    Restaurant.removeOrderById(ordId);
                }
                break;
            case "server":
                bill.makePaymentWithCard();
                bill.markAsPaid();
                for(int ordId : bill.getOrderIds()){
                    Restaurant.removeOrderById(ordId);
                }
                break;
            default:
                System.out.println("Invalid input.");
                return;
        }
        Restaurant.removeCustomerById(id);
    }
    
    private void removeEmployee() {
        int id = Integer.parseInt(val.validEmployeeId(getValue("Enter EmployeeID: ")));
        Restaurant.removeEmployeeById(id);
    }
}
