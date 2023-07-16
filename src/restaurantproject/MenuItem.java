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
public class MenuItem {
    private int itemId;
    private String itemName;
    private int quantity;
    private double cost;

    public MenuItem(int itemId, String itemName, double cost) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.cost = cost;
    }


    public void itemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Item Name: " + itemName);
        System.out.println("Item Amout: " + cost);
    }
    
    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public double getCost() {
        return cost;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return String.format("%-5d%-20s%-10.2f", itemId, itemName, cost);
    }

    public String toCSV() {
        return String.format("%d,%s,%.2f", itemId, itemName, cost);
    }

}
