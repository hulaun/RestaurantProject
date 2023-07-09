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
public class Chef extends Employee {
    private int chefId;
    private int orderId;

    public Chef(int employeeId, String employeeName, double employeeSalary, int chefId, int orderId) {
        super(employeeId, employeeName, employeeSalary);
        this.chefId = chefId;
        this.orderId = orderId;
    }
}

