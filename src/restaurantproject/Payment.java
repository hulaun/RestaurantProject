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
public class Payment {
    private int paymentId;
    private int billId;
    private boolean isPaid;

    public Payment(int paymentId, int billId) {
        this.paymentId = paymentId;
        this.billId = billId;
        this.isPaid = false; // Initialize payment status as not paid
    }

    public void markAsPaid() {
        isPaid = true;
        System.out.println("Payment ID: " + paymentId);
        System.out.println("Bill ID: " + billId);
        System.out.println("Payment status: Paid");
    }

    public void markAsUnpaid() {
        isPaid = false;
        System.out.println("Payment ID: " + paymentId);
        System.out.println("Bill ID: " + billId);
        System.out.println("Payment status: Not paid");
    }

    public boolean isPaid() {
        return isPaid;
    }
}

