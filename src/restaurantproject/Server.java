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
public class Server extends Employees {
    private int serverId;
    private int orderId;

    public Server(int employeeId, String employeeName, double employeeSalary, int serverId, int orderId) {
        super(employeeId, employeeName, employeeSalary);
        this.serverId = serverId;
        this.orderId = orderId;
    }
}