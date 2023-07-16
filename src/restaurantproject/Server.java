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
    private final String TYPE = "server";
    private int serverId;
    private int orderId;
    private int tableId;

    public Server(int employeeId, String employeeName, double employeeSalary, int serverId, int orderId) {
        super(employeeId, employeeName, employeeSalary);
        this.serverId = serverId;
        this.orderId = orderId;
    }

    public void assignTable(int tableId) {
        this.tableId = tableId;
    }

    public void assignOrder(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toCSV() {
        return TYPE + "," + getId() + "," + getName() + "," + getSalary() + "," + serverId + "," + orderId;
    }
}