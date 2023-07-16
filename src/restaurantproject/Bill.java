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
    private boolean isPaid=false;

    public Bill(int billId, int orderId) {
        this.billId = billId;
        this.orderId = orderId;
        this.totalBill = 0.0;
    }

    public void calculateBill(List<MenuItem> items) {
        for (MenuItem item : items) {
            double itemCost = item.getCost();
            int itemQuantity = item.getQuantity();

            double itemsCost = itemCost * itemQuantity;
            totalBill += itemsCost;
        }

        System.out.println("Bill ID: " + billId);
        System.out.println("Order ID: " + orderId);
        System.out.println("Total Bill: " + totalBill);
    }
    
    public void markAsPaid() {
        isPaid=true;
        System.out.println("Bill ID: " + billId);
        System.out.println("Payment status: Paid");
    }

    public void markAsUnpaid() {
        System.out.println("Bill ID: " + billId);
        System.out.println("Payment status: Not paid");
    }

    public boolean isPaid() {
        return isPaid;
    }
}
