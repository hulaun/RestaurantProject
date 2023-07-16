package restaurantproject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private static Restaurant instance;
    private List<Employee> employees;
    private List<Customer> customers;
    private List<Order> orders;
    private List<MenuItem> menuItems;
    private List<Table> tables;

    private Restaurant() {
        // private constructor to prevent instantiation from outside
        employees = new ArrayList<>();
        customers = new ArrayList<>();
        orders = new ArrayList<>();
        menuItems = new ArrayList<>();
        tables = new ArrayList<>();
    }

    public static Restaurant getInstance() {
        if (instance == null) {
            instance = new Restaurant();
        }
        return instance;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public List<Table> getTables() {
        return tables;
    }

    public static void addOrder(Order order) {
        instance.orders.add(order);
    }

    public static void appendCustomer(Customer customer) {
        instance.customers.add(customer);
    }

    public static void printCustomers() {
        for (Customer customer : instance.customers) {
            customer.customerDetails();
            System.out.println();
        }
    }

    public static void printEmployees() {
        for (Employee employee : instance.employees) {
            employee.employeeDetails();
            System.out.println();
        }
    }
    
    public static void printMenuItems() {
        for (MenuItem item : instance.menuItems) {
            item.itemDetails();
            System.out.println();
        }
    }

    public static Customer getCustomerById(int id) {
        for (Customer customer : instance.customers) {
            if (customer.getCustomerId() == id) {
                return customer;
            }
        }
        return null;
    }

    public static Order getOrderById(int id) {
        for (Order order : instance.orders) {
            if (order.getOrderId() == id) {
                return order;
            }
        }
        return null;
    }

    public static void fromCSV() {
        String csv;
        try {
            csv = FileHandler.readFromFile("customers.csv");
            customersFromCSV(csv);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            csv = FileHandler.readFromFile("employees.csv");
            employeesFromCSV(csv);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            csv = FileHandler.readFromFile("menuItems.csv");
            menuItemsFromCSV(csv);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String customersToCSV() {
        StringBuilder sb = new StringBuilder();
        for (Customer customer : instance.customers) {
            sb.append(customer.toCSV());
        }
        return sb.toString();
    }

    public static String employeesToCSV() {
        StringBuilder sb = new StringBuilder();
        for (Employee employee : instance.employees) {
            sb.append(employee.toCSV());
        }
        return sb.toString();
    }

    public static void customersFromCSV(String csv) {
        String[] lines = csv.split("\n");
        for (String line : lines) {
            String[] fields = line.split(",");
            if(fields.length == 5){
                int customerId = Integer.parseInt(fields[0]);
                String customerName = fields[1].trim();
                int billId = Integer.parseInt(fields[2].trim());
                int orderId = Integer.parseInt(fields[3].trim());
                int paymentId = Integer.parseInt(fields[4].trim());
                instance.customers.add(new Customer(customerId, customerName, billId, orderId, paymentId));
            }
        }
    }

    public static void employeesFromCSV(String csv) {
        String[] lines = csv.split("\n");
        for (String line : lines) {
            String[] fields = line.split(",");
            int employeeId = Integer.parseInt(fields[0].trim());
            String employeeName = fields[1].trim();
            double employeeSalary = Double.parseDouble(fields[2].trim());
            instance.employees.add(new Employee(employeeId, employeeName, employeeSalary));
        }
    }

    public static void menuItemsFromCSV(String csv) {
        String[] lines = csv.split("\n");
        for (String line : lines) {
            String[] fields = line.split(",");
            int itemId = Integer.parseInt(fields[0].trim());
            String itemName = fields[1].trim();
            double itemAmount = Double.parseDouble(fields[2].trim());
            int itemQuantity = Integer.parseInt(fields[3].trim());
            instance.menuItems.add(new MenuItem(itemId, itemName, itemAmount, itemQuantity));
        }
    }

    public static void appendEmployee(Employee employee) {
        instance.employees.add(employee);
    }

    public static Employee getEmployeeById(int id) {
        for (Employee employee : instance.employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    // God bless the linear search algorithm
    public static void searchCustomerById(int id) {
        for (Customer customer : instance.customers) {
            if (customer.getCustomerId() == id) {
                customer.customerDetails();
            }
        }
    }

    public static void searchEmployeeById(int id) {
        for (Employee employee : instance.employees) {
            if (employee.getId() == id) {
                employee.employeeDetails();
            }
        }
    }

    public static void searchCustomerByName(String name) {
        for (Customer customer : instance.customers) {
            if (customer.getCustomerName().equals(name)) {
                customer.customerDetails();
            }
        }
    }

    public static void searchEmployeeByName(String name) {
        for (Employee employee : instance.employees) {
            if (employee.getName().equals(name)) {
                employee.employeeDetails();
            }
        }
    }

    public static void removeOrderById(int id) {
        for (Order order : instance.orders) {
            if (order.getOrderId() == id) {
                instance.orders.remove(order);
            }
        }
    }

    public static void removeCustomerById(int id) {
        for (Customer customer : instance.customers) {
            if (customer.getCustomerId() == id) {
                instance.customers.remove(customer);
            }
        }
    }

    public static void removeEmployeeById(int id) {
        for (Employee employee : instance.employees) {
            if (employee.getId() == id) {
                instance.employees.remove(employee);
            }
        }
    }

    public static boolean validItemId(int id) {
        for (MenuItem menuItem : instance.menuItems) {
            if (menuItem.getItemId() == id) {
                return true;
            }
        }
        return false;
    }
}