/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantproject;

/**
 *
 * @author dvtso
 */
public class Server extends Employee {
    // Bro just violated encapsulation
    private int orderId;
    private int tableId;
    private final String TYPE = "server";

    public Server(int employeeId, String employeeName, double employeeSalary) {
        super(employeeId, employeeName, employeeSalary);
    }

    public void assignTable(int tableId) {
        this.tableId = tableId;
    }

    public void assignOrder(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toCSV() {
        return TYPE + "," + getId() + "," + getName() + "," + getSalary() + "," + orderId;
    }

    @Override
    public void setTYPE() {
        super.TYPE="server";
    }
}