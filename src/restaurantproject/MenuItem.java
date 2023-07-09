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
    private double amount;

    public MenuItem(int itemId, String itemName, double amount, int quantity) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.amount = amount;
        this.quantity = quantity;
    }

    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public double getAmount() {
        return amount;
    }

    public int getQuantity() {
        return quantity;
    }
}
