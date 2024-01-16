import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PharmacyAdministration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Aptek adini daaxil edin: ");
        String pharmacyName = scanner.next();
        Pharmacy pharmacy = new Pharmacy(pharmacyName);

        while (true) {
            System.out.println("\nAptek Administrasiyasi");
            System.out.println("1. Derman elave edin");
            System.out.println("2. Dermanlari gosterin");
            System.out.println("3. Isci elave edin");
            System.out.println("4. Iscileri gosterin");
            System.out.println("5. Aptek melumatlarini fileda yadda saxla");
            System.out.println("6. Programdan cixis");
            System.out.print("Seciminizi daxil edin: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Derman adini qeyd edin: ");
                    String medicineName = scanner.next();
                    System.out.print("Sayini daxil edin: ");
                    int medicineQuantity = scanner.nextInt();
                    pharmacy.addMedicine(medicineName, medicineQuantity);
                    break;

                case 2:
                    pharmacy.displayMedicines();
                    break;

                case 3:
                    System.out.print("Isci adini daxil edin: ");
                    String workerName = scanner.next();

                    System.out.print("iscinin ID sini yazin: ");
                    int workerId = scanner.nextInt();

                    pharmacy.addWorker(workerName, workerId);
                    break;

                case 4:
                    pharmacy.displayWorkers();
                    break;

                case 5:
                    pharmacy.saveItemsToFile();
                    System.out.println("Butun esyalar data file'da  saxlanildi.");
                    break;

                case 6:
                    System.out.println("Aptek sisteminden cixildi. ");
                    System.exit(0);

                default:
                    System.out.println("Yanlis secim, yeniden yoxlayin");
            }
        }
    }
}