import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Pharmacy {
    String name;
    ArrayList<Medicine> medicines;
    ArrayList<Workers> workers;

    Pharmacy(String name) {
        this.name = name;
        this.medicines = new ArrayList<>();
        this.workers = new ArrayList<>();
    }

    void addMedicine(String name, int quantity) {
        Medicine medicine = new Medicine(name, quantity);
        medicines.add(medicine);

        System.out.println("Dermanlar elave olundu" + name + ".");
    }

    void displayMedicines()
    {
        if (medicines.isEmpty())
        {
            System.out.println("Bu derman movcud deyil " + name + ".");
        }
        else
        {
            System.out.println("Derman hal-hazirda stokda var " + name + ":");
            for (Medicine medicine : medicines)
            {
                System.out.println(medicine.name + " - sayi: " + medicine.quantity);
            }
        }
    }

    void addWorker(String name, int id)
    {
        Workers worker = new Workers(name, id);
        workers.add(worker);

        System.out.println("Isci elave olundu" + name + ".");
    }

    void displayWorkers()
    {
        if (workers.isEmpty())
        {
            System.out.println("Bele bir isci yoxdur " + name + ".");
        }
        else
        {
            System.out.println("Isci" + name + ":");
            for (Workers worker : workers)
            {
                System.out.println(worker.name + " - ID: " + worker.id);
            }
        }
    }
    public void saveItemsToFile() {

        String directoryPath = "C:\\Users\\99470\\Desktop\\PharmacyProjectOOP";
        String fileName = "PharmacySaveData.txt";
        String filePath = Paths.get(directoryPath, fileName).toString();

        try {
            Files.createDirectories(Paths.get(directoryPath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            Iterator x = this.medicines.iterator();

            while (x.hasNext()) {
                Medicine medicines = (Medicine) x.next();

                try {
                    writer.write("Derman adi: " + medicines.name + ",\nSayi: " + medicines.quantity);
                } catch (IOException y) {
                    System.out.println("Error bas verdi: " + y.getMessage());
                }
            }

            writer.close();
        } catch (IOException z) {
            System.out.println("Error bas verdi: " + z.getMessage());
        }
    }
}



