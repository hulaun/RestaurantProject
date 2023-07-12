package restaurantproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class FileHandler {
    public static String readFromFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
        }
        reader.close();
        return sb.toString();
    }

    public static void writeToFile(String fileName, String content) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(content);
        writer.close();
    }

    public static void writeToFile(String fileName, Object content) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(content.toString());
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to file " + fileName);
        }
    }

    public static void appendToFile(String fileName, String content) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        writer.append(content);
        writer.close();
    }

    public static void readFromFile(String fileName, Object content) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading from file " + fileName);
        }
    }


}