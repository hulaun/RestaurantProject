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
public class Table {
    private int tableNumber;
    private boolean occupiedStatus;
    private int serverId;
    private int customerId;

    public Table(int tableNumber, boolean occupiedStatus, int serverId, int customerId) {
        this.tableNumber = tableNumber;
        this.occupiedStatus = occupiedStatus;
        this.serverId = serverId;
        this.customerId = customerId;
    }

    public void tableDetails() {
        System.out.println("Table Number: " + tableNumber);
        System.out.println("Occupied Status: " + occupiedStatus);
        System.out.println("Server ID: " + serverId);
        System.out.println("Customer ID: " + customerId);
    }

    public boolean availabilityStatus() {
        return occupiedStatus;
    }
}