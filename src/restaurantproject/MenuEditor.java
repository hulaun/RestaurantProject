package restaurantproject;

public class MenuEditor {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.addMenuItem(new MenuItem(1, "Chicken", 10.0));
        menu.addMenuItem(new MenuItem(2, "Beef", 15.0));
        menu.addMenuItem(new MenuItem(3, "Pork", 12.0));
        menu.addMenuItem(new MenuItem(4, "Fish", 8.0));
        menu.addMenuItem(new MenuItem(5, "Vegetables", 5.0));
        menu.displayMenu();
        menu.writeMenuToCSV();
        menu.readMenuFromCSV();
        menu.displayMenu();
    }
}
