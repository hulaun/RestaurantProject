package restaurantproject;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

public class Menu {
    List<MenuItem> menuItems;

    public Menu(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public Menu() {
        this.menuItems = new ArrayList<>();
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public void removeMenuItem(MenuItem menuItem) {
        menuItems.remove(menuItem);
    }

    public void displayMenu() {
        System.out.println("Menu:");
        for (MenuItem menuItem : menuItems) {
            System.out.println(menuItem);
        }
    }

    public String toCSV() {
        StringBuilder sb = new StringBuilder();
        for (MenuItem menuItem : menuItems) {
            sb.append(menuItem.toCSV());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void writeMenuToCSV() {
        try {
            FileHandler.writeToFile("menu.csv", toCSV());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readMenuFromCSV() {
        try {
            String csv = FileHandler.readFromFile("menu.csv");
            String[] lines = csv.split("\n");
            for (String line : lines) {
                String[] tokens = line.split(",");
                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double price = Double.parseDouble(tokens[2]);
                MenuItem menuItem = new MenuItem(id, name, price);
                menuItems.add(menuItem);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (MenuItem menuItem : menuItems) {
            sb.append(menuItem.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
}
