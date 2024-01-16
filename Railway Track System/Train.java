import java.util.ArrayList;
import java.util.Scanner;

class Train {
    public String trainNumber;
    public String source;
    public String destination;
    public int totalSeats;
    public int availableSeats;

    public Train(String trainNumber, String source, String destination, int totalSeats) {
        this.trainNumber = trainNumber;
        this.source = source;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }

    public String getTrainNumber() {

        return trainNumber;
    }

    public String getSource()
    {
        return source;
    }

    public String getDestination()
    {
        return destination;
    }

    public int getTotalSeats()
    {
        return totalSeats;
    }

    public int getAvailableSeats()
    {
        return availableSeats;
    }

    public void bookTicket()
    {
        if (availableSeats > 0) {
            availableSeats--;
            System.out.println("Bilet ugurla sifaris edildi.");
        }
        else {
            System.out.println("Sifarisde sehv bas verdi. Qatarda yer yoxdur.");
        }
    }

    @Override
    public String toString()
    {
        return
                "Qatar nomresi: " + trainNumber +
                "\nCixis yeri: " + source +
                "\nSon stansiya: " + destination +
                "\nMovcud oturacaqlarin sayi: " + availableSeats +
                "\n..............................";
    }
}