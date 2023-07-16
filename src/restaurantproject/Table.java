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
    private int customerId;

    public Table(int tableNumber, boolean occupiedStatus, int customerId) {
        this.tableNumber = tableNumber;
        this.occupiedStatus = occupiedStatus;
        this.customerId = customerId;
    }

    public void tableDetails() {
        if(availabilityStatus()){
            System.out.println("Table Number: " + tableNumber);
            System.out.println("Occupied Status: " + occupiedStatus);
            System.out.println("Customer ID: " + customerId);
        }else {
            System.out.println("Table Number: " + tableNumber);
            System.out.println("Occupied Status: " + occupiedStatus);
        }
    }

    public void setOccupiedStatus(boolean occupiedStatus) {
        this.occupiedStatus = occupiedStatus;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public boolean availabilityStatus() {
        return occupiedStatus;
    }
}