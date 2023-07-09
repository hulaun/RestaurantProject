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

public class Customer {
    private int customerId;
    private String customerName;
    private int billId;
    private int orderId;
    private int paymentId;

    public Customer(int customerId, String customerName, int billId, int orderId, int paymentId) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.billId = billId;
        this.orderId = orderId;
        this.paymentId = paymentId;
    }

    public void customerDetails() {
        System.out.println("Customer ID: " + customerId);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Bill ID: " + billId);
        System.out.println("Order ID: " + orderId);
        System.out.println("Payment ID: " + paymentId);
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getName() {
        return customerName;
    }

    public void orderedItems() {
        System.out.println("Items ordered by customer");
    }

    public void paymentStatus() {
        System.out.println("Payment status: Paid");
    }

    public String toCSV() {
        return customerId + "," + customerName + "," + billId + "," + orderId + "," + paymentId + "\n";
    }
}
