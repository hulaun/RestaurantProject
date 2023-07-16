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

    public Chef(int employeeId, String employeeName, double employeeSalary) {
        super(employeeId, employeeName, employeeSalary);
    }
    
    @Override
    public String toCSV() {
        return TYPE + "," + getId() + "," + getName() + "," + getSalary();
    }

    @Override
    public void setTYPE() {
        super.TYPE="chef";
    }
}

