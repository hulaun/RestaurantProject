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
public class Cash extends Bill {
    public Cash(int paymentId, int billId) {
        super(paymentId, billId);
    }

    public void makePayment() {
        System.out.println("Payment made by cash");
    }
}
