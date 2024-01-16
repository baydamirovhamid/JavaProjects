package LibraryManagementSystem;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private List<LibraryItem> items = new ArrayList<>();

    public void addItem(LibraryItem item) {
        if (items.contains(item)) {
            System.out.println(item.Title + " by " + item.Author + " is already in the library.");
        } else {
            items.add(item);
            System.out.println(item.Title + " by " + item.Author + " added to the library.");
        }
    }

    public void listItems() {
        System.out.println("Kitabxana esyalari:");
        for (LibraryItem item : items) {
            item.displayInfo();
            System.out.println();
        }
    }

    public void checkOutItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ad daxil edin: ");
        String title = scanner.nextLine();
        List<String> names = new ArrayList<>();
        for (LibraryItem item : items) {
            names.add(item.Title);
            if (item.Title.equals(title)) {
                if (item.Status == ItemStatus.Available) {
                    item.Status = ItemStatus.CheckedOut;
                    System.out.println(item.Title + " yoxlanildi.");
                } else {
                    System.out.println(item.Title + " artiq yoxlanilib.");
                }
                break;
            }
        }
        if (!names.contains(title)) {
            System.out.println(title + " kitabxanada yoxdur.");
        }
    }

    public void returnItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bashliq daxil edin: ");
        String title = scanner.nextLine();
        List<String> names = new ArrayList<>();

        for (LibraryItem item : items) {
            names.add(item.Title);
            if (item.Title.equals(title)) {
                System.out.println(item.Title + " qaytarildi.");
                item.Status = ItemStatus.Available;
                break;
            }
        }
        if (!names.contains(title)) {
            System.out.println(title + " kitabxanada yoxdur.");
        }
    }

    public void saveItemsToFile() {
           String directoryPath = "C:\\Users\\99470\\Desktop\\BACKEND COURSE\\LibraryManagement";
           String fileName = "libraryData.txt";
           String filePath = Paths.get(directoryPath, fileName).toString();

        try {
            Files.createDirectories(Paths.get(directoryPath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            for (LibraryItem item : items) {
                try {
                    writer.write("Bashliq: " + item.Title + ",\n" +
                            "Muellif: " + item.Author + ",\n" +
                            "Status: " + item.Status + "\n\n");
                } catch (IOException ex) {
                    System.out.println("An error occurred: " + ex.getMessage());
                }
            }
            writer.close();
        } catch (IOException ex) {
            System.out.println("An error occurred: " + ex.getMessage());
        }
    }
}
