/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantproject;

import java.util.List;

/**
 *
 * @author dvtso
 */
public class Bill {
    private int billId;
    private int orderId;
    private double totalBill;

    public Bill(int billId, int orderId) {
        this.billId = billId;
        this.orderId = orderId;
        this.totalBill = 0.0;
    }

    public void calculateBill(List<MenuItem> items) {
        for (MenuItem item : items) {
            double itemAmount = item.getAmount();
            int itemQuantity = item.getQuantity();

            double itemCost = itemAmount * itemQuantity;
            totalBill += itemCost;
        }

        System.out.println("Bill ID: " + billId);
        System.out.println("Order ID: " + orderId);
        System.out.println("Total Bill: " + totalBill);
    }
}
