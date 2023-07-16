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

    public MenuItem(int itemId, String itemName, double amount, int quantity) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.cost = amount;
        this.quantity = quantity;
    }

    public void itemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Item Name: " + itemName);
        System.out.println("Item Quantity: " + quantity);
        System.out.println("Item Amout: " + cost);
    }
    
    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public double getAmount() {
        return cost;
    }

    public int getQuantity() {
        return quantity;
    }
}
