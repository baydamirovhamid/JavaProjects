import java.util.Scanner;

public class RailwayManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Demiryolu xettinin adini qeyd edin: ");

        String railwaySystemName = scanner.next();
        RailwaySystem railwaySystem = new RailwaySystem(railwaySystemName);

        while (true)
        {
            System.out.println("\nDemiryolu Xetti Sistemi");
            System.out.println("1. Qatar elave edin");
            System.out.println("2. Qatar infolarini gosterin");
            System.out.println("3. Bilet sifarisi");
            System.out.println("4. Gedis ve qatar infolari textde yadda saxlanildi");
            System.out.println("5. Sistemden cixin");
            System.out.print("Seciminizi daxil edin: ");

            int secim = scanner.nextInt();

            switch (secim)
            {
                case 1:
                    System.out.print("Qatarin nomresini yazin: ");
                    String trainNumber = scanner.next();

                    System.out.print("Qatarin cixis yeri: ");
                    String source = scanner.next();

                    System.out.print("Son stansiya: ");
                    String destination = scanner.next();

                    System.out.print("Butun oturacaqlarin sayi: ");
                    int totalSeats = scanner.nextInt();

                    railwaySystem.addTrain(trainNumber, source, destination, totalSeats);
                    break;

                case 2:
                    railwaySystem.displayTrains();
                    break;

                case 3:

                    System.out.print("Qatar nomresini qeyd edin: ");
                    trainNumber = scanner.next();

                    System.out.print("Sernisin ad/soyadi: ");
                    String passengerName = scanner.next();
                    scanner.nextLine();


                case 4:
                    railwaySystem.saveItemsToFile();
                    System.out.println("Butun infolar faylda saxla.");
                    break;

                case 5:
                    System.out.println("Sistemden cixildi");
                    System.exit(0);

                default:
                    System.out.println("Sehv secim, yeniden cehd edin!!");
            }
        }
    }
}
