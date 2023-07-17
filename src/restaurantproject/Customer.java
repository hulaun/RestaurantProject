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

public class Customer {
    private int customerId;
    private String customerName;
    private int billId;
    private List<Integer> orderIds;

    public Customer(int customerId, String customerName, int billId, List<Integer> orderId) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.billId = billId;
        this.orderIds = orderId;
    }

    public void customerDetails() {
        System.out.println("Customer ID: " + customerId);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Bill ID: " + billId);
        System.out.println("Order ID: ");
        for(int i =0 ;i<orderIds.size();i++){
            System.out.println("\t"+(i+1)+" "+orderIds.get(i));
        }
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

    public List<Integer> getOrderIds() {
        return orderIds;
    }

    public void setOrderId(int orderId) {
        this.orderIds.add(orderId);
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
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < orderIds.size(); i++) {
            sb.append(orderIds.get(i));
            if (i != orderIds.size() - 1) {
                sb.append(";");
            }
        }
        return customerId + "," + customerName + "," + billId + "," + sb;
    }
}
