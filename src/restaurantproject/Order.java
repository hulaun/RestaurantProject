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
    private boolean isOrdered = false;

    public Order(int orderId, int customerId) {
        this.orderId = orderId;
        this.items = new ArrayList<>();
        this.customerId = customerId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void addMenuItem(MenuItem item, int quantity) {
        MenuItem newItem = new MenuItem(item.getItemId(), item.getItemName(), item.getCost());
        newItem.setQuantity(quantity);
        items.add(newItem);
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public boolean isOrdered() {
        return isOrdered;
    }

    public void addMenuItem(MenuItem item) {
        items.add(item);
    }

    public String toCSV() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            sb.append(items.get(i).getItemId()).append("::").append(items.get(i).getQuantity()).append("::").append(items.get(i).getCost());
            if (i != items.size() - 1) {
                sb.append(";");
            }
        }
        return orderId + "," + customerId+","+sb+","+isOrdered;
    }
    public void checkIsOrdered(){
        this.isOrdered =true;
    }
    public boolean hasItemsInList(){
        return !(items.isEmpty());
    }
}
