package LibraryManagementSystem;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Program {
    public static void main(String[] args) {
        String pattern = "^[a-zA-Z0-9\\s]*$";
        Pattern regex = Pattern.compile(pattern);
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Kitabxana İdareetme Sistemi");
            System.out.println("1. Esya elave et");
            System.out.println("2. Esyalarin siyahisi");
            System.out.println("3. Esya yoxlanilmasi");
            System.out.println("4. Esya qaytarilmasi");
            System.out.println("5. Kitabxana melumatlarinin saxlanilmasi");
            System.out.println("6. Cixis");
            System.out.print("Secimini daxil et: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Esyanin novunu daxil edin (Kitab/DVD): ");
                    String itemType = scanner.nextLine();

                    if (itemType.equals("Kitab")) {
                        System.out.print("Kitabin basligini daxil edin: ");
                        String bookTitle = scanner.nextLine();
                        Matcher matcher = regex.matcher(bookTitle);
                        if (!matcher.matches()) {
                            System.out.println("Yanlish numune! \n" +
                                    "Duzgun kitab bashligini yeniden daxil edin!");
                            break;
                        }

                        System.out.print("Muellifi daxil et: ");
                        String bookAuthor = scanner.nextLine();
                        System.out.print("Sehife sayini daxil et: ");
                        int pageCount = scanner.nextInt();
                        Book book = new Book(bookTitle, bookAuthor, ItemStatus.Available, pageCount);
                        library.addItem(book);
                    } else if (itemType.equals("DVD")) {
                        System.out.print("DVD bashligini daxil edin: ");
                        String dvdTitle = scanner.nextLine();
                        Matcher matcher = regex.matcher(dvdTitle);
                        if (!matcher.matches()) {
                            System.out.println("Yanlish numune! \n" +
                                    "Duzgun DVD bashligini yeniden daxil edin!");
                            break;
                        }

                        System.out.print("Rejissoru daxil edin: ");
                        String dvdAuthor = scanner.nextLine();
                        System.out.print("İsh vaxtini daxil edin (deqiqe ile): ");
                        int timeMinutes = scanner.nextInt();
                        DVD dvd = new DVD(dvdTitle, dvdAuthor, ItemStatus.Available, timeMinutes);
                        library.addItem(dvd);
                    } else {
                        System.out.println("Yanlish! Zehmet olmasa kitab ve DVD daxil edin.");
                    }
                    break;
                case 2:
                    library.listItems();
                    break;
                case 3:
                    library.checkOutItem();
                    break;
                case 4:
                    library.returnItem();
                    break;
                case 5:
                    library.saveItemsToFile();
                    System.out.println("Butun esyalar metn faylinda saxlanildi.");
                    break;
                case 6:
                    System.out.println("Programdan cix.");
                    return;
                default:
                    System.out.println("Yanlish secim. Bir daha yoxla.");
                    break;
            }
            System.out.println("-------------------------------");
        }
    }
}
