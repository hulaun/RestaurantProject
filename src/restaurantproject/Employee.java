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

public class Employee {
    private int employeeId;
    private String employeeName;
    private double employeeSalary;

    public Employee(int employeeId, String employeeName, double employeeSalary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
    }

    public String getName() {
        return employeeName;
    }

    public int getId() {
        return employeeId;
    }

    public double getSalary() {
        return employeeSalary;
    }

    public void setSalary(double salary) {
        this.employeeSalary = salary;
    }

    public void employeeDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Employee Salary: " + employeeSalary);
    }

    public String toCSV() {
        return employeeId + "," + employeeName + "," + employeeSalary;
    }
}
