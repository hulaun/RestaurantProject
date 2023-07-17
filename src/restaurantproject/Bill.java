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
    private List<Integer> orderIds;
    private double totalBill;
    private boolean isPaid=false;

    public Bill(int billId, List<Integer> orderId) {
        this.billId = billId;
        this.orderIds = orderId;
        this.totalBill = 0.0;
    }

    public void calculateBill(List<List<MenuItem>> orders) {
        for(List<MenuItem> order : orders){
            for (MenuItem item : order) {
                double itemCost = item.getCost();
                int itemQuantity = item.getQuantity();

                double itemsCost = itemCost * itemQuantity;
                totalBill += itemsCost;
            }
        }
        System.out.println("Bill ID: " + billId);
        System.out.println("Total Bill: " + totalBill);
    }

    public List<Integer> getOrderIds() {
        return orderIds;
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
    
    public void makePaymentWithCash() {
        System.out.println("Payment made by cash successfully");
    }
    
    public void makePaymentWithCard() {
        System.out.println("Payment made by card or online successfully");
    }
    
    public boolean isPaid() {
        return isPaid;
    }
}
