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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Menu {
    private String itemId;
    private String itemName;
    private double amount;

    public Menu() {
    }

    public Menu(String itemId, String itemName, double amount) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.amount = amount;
    }

    public static void displayItems() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("menu.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] itemData = line.split(",");
                String itemId = itemData[0].trim();
                String itemName = itemData[1].trim();
                double amount = Double.parseDouble(itemData[2].trim());

                Menu item = new Menu(itemId, itemName, amount);
                System.out.println("Item ID: " + item.itemId);
                System.out.println("Item Name: " + item.itemName);
                System.out.println("Amount: " + item.amount);
                System.out.println();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading menu file: " + e.getMessage());
        }
    }
}
