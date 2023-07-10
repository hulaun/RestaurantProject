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
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private List<MenuItem> items;
    private int customerId;
    private int serverId;

    public Order(int orderId, int customerId, int serverId) {
        this.orderId = orderId;
        this.items = new ArrayList<>();
        this.customerId = customerId;
        this.serverId = serverId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void addMenuItem(MenuItem item) {
        items.add(item);
    }

    public String toCSV() {
        String csv = orderId + "," + customerId + "," + serverId;
        for (MenuItem item : items) {
            csv += "," + item.getItemId() + "," + item.getAmount();
        }
        return csv;
    }
}
