package restaurantproject;

import java.io.IOException;

public class TestFileHandler {
    public static void main(String[] args) {
        String cat = "A cat is not a catepillar\nA cat says meow\nA cat is a cat\n";

        try {
            FileHandler.writeToFile("cat.txt", cat);
        } catch (IOException e) {
            System.out.println("Error writing to file");
        }
    }
}
