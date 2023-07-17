package restaurantproject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private static Restaurant instance;
    private List<Employee> employees;
    private List<Customer> customers;
    private List<Order> orders;
    private Menu menu;
    private List<Table> tables;

    private Restaurant() {
        // private constructor to prevent instantiation from outside
        employees = new ArrayList<>();
        customers = new ArrayList<>();
        orders = new ArrayList<>();
        menu = new Menu();
        tables = new ArrayList<>();
    }

    public static Restaurant getInstance() {
        if (instance == null) {
            instance = new Restaurant();
        }
        return instance;
    }

    public Menu menu() {
        return menu;
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
        }
    }

    public static void printEmployees() {
        for (Employee employee : instance.employees) {
            employee.employeeDetails();
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
    public static List<MenuItem> getItemsByOrderId(int orderid) {
        for (Order ord : instance.orders) {
            if (ord.getOrderId() == orderid) {
                return ord.getItems();
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
        }
        try {
            csv = FileHandler.readFromFile("employees.csv");
            employeesFromCSV(csv);
        } catch (IOException e) {
        }
        try {
            csv = FileHandler.readFromFile("orders.csv");
            employeesFromCSV(csv);
        } catch (IOException e) {
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
            if(fields.length == 4){
                int customerId = Integer.parseInt(fields[0]);
                String customerName = fields[1].trim();
                int billId = Integer.parseInt(fields[2].trim());
                String[] lines2 = fields[3].split(";");
                List<Integer> orderIds = new ArrayList<>();
                for(String line2 : lines2){
                    orderIds.add(Integer.parseInt(line2.trim()));
                }
                instance.customers.add(new Customer(customerId, customerName, billId, orderIds));
            }
        }
    }
    public static void ordersFromCSV(String csv) {
        String[] lines = csv.split("\n");
        for (String line : lines) {
            String[] fields = line.split(",");
            if(fields.length == 4){
                int customerId = Integer.parseInt(fields[0]);
                String customerName = fields[1].trim();
                int billId = Integer.parseInt(fields[2].trim());
                String[] lines2 = fields[3].split(";");
                List<Integer> orderIds = new ArrayList<>();
                if(lines2.length == 0){
                    orderIds.add(Integer.parseInt(fields[3]));
                }else{
                    for(String line2 : lines2){
                        orderIds.add(Integer.parseInt(line2.trim()));
                    }
                }
                instance.customers.add(new Customer(customerId, customerName, billId, orderIds));
            }
        }
    }

    public static void employeesFromCSV(String csv) {
        String[] lines = csv.split("\n");
        for (String line : lines) {
            String[] fields = line.split(",");
            String type = fields[0].trim();
            int id = Integer.parseInt(fields[1].trim());
            String name = fields[2].trim();
            double salary = Double.parseDouble(fields[3].trim());
            if (type.equals("server")) {
                Server server = new Server(id, name, salary);
                appendEmployee(server);
            } else if (type.equals("chef")) {
                Chef chef = new Chef(id, name, salary);
                appendEmployee(chef);
            }
        }
    }

    public static void billCalculate(Bill bill){
        List<List<MenuItem>> orders = new ArrayList<>();
        for(int i : bill.getOrderIds()){
            if(getItemsByOrderId(i) != null){
                orders.add(getItemsByOrderId(i));
            }
        }
        bill.calculateBill(orders);
    }
    
    public static void appendEmployee(Employee employee) {
        instance.employees.add(employee);
    }

    public static MenuItem getMenuItemById(int id) {
        for (MenuItem menuItem : instance.menu.getMenuItems()) {
            if (menuItem.getItemId() == id) {
                return menuItem;
            }
        }
        return null;
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
        instance.orders.removeIf(ord -> ord.getOrderId() == id);
    }

    public static void removeCustomerById(int id) {
        instance.customers.removeIf(cus -> cus.getCustomerId() == id);
    }

    public static void removeEmployeeById(int id) {
        instance.employees.removeIf(emp -> emp.getId() == id);
    }

    public static void save() {
        try {
            FileHandler.writeToFile("customers.csv", customersToCSV());
            FileHandler.writeToFile("employees.csv", employeesToCSV());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}