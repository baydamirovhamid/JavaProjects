import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

 public class RailwaySystem
 {
    String name;
    ArrayList<Train> trains;
    ArrayList<Ticket> ticket;


    RailwaySystem(String name)
    {
        this.name = name;
        this.trains = new ArrayList<>();
        this.ticket = new ArrayList<>();

    }

   public void addTrain(String trainNumber, String source, String destination, int totalSeats) {
        Train train = new Train(trainNumber, source, destination, totalSeats);

        trains.add(train);
        System.out.println("Qatar ugurla elave edildi: " + trainNumber);
    }

    public void displayTrains()
    {
        if (trains.isEmpty()) {
            System.out.println("Sistemde bele bir qatar infosu yoxdur.");
        }
        else
        {
            System.out.println("Qatar hal hazirda movcuddur (" + name + "):");

            for (Train train : trains)
            {
                System.out.println("Qatar nomresi: " + train.trainNumber +
                        ", Cixis yeri: " + train.source +
                        ", Son stansiya: " + train.destination +
                        ", Movcud oturacaqlarin sayi: " + train.availableSeats);
            }
        }
    }

    public void saveItemsToFile()
    {
        String directoryPath = "C:\\Users\\99470\\Desktop\\RailwaySystemProjectOOP";

        String fileName = "RailwaySystemSaveData.txt";
        String filePath = Paths.get(directoryPath, fileName).toString();

        try {
            Files.createDirectories(Paths.get(directoryPath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            Iterator a = this.trains.iterator();

            while (a.hasNext())
            {
                Train train = (Train) a.next();

                try
                {
                    writer.write("Qatarin nomresi: " + train.trainNumber +
                            ", Cixis yeri: " + train.source +
                            ", Son stansiya: " + train.destination +
                            ", Movcud oturacaqlarin sayi: " + train.availableSeats + "\n");
                }
                catch (IOException b)
                {
                    System.out.println("Xeta bash verdi: " + b.getMessage());
                }
            }

            writer.close();
        }
        catch (IOException c)
        {
            System.out.println("Xeta bash verdi: " + c.getMessage());
        }
    }
}