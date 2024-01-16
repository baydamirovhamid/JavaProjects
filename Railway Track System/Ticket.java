public class Ticket {
    public int ticketNumber;
    public Train train;
    public String passengerName;

    public Ticket(int ticketNumber, Train train, String passengerName) {
        this.ticketNumber = ticketNumber;
        this.train = train;
        this.passengerName = passengerName;
    }

    @Override
    public String toString() {
        return "Bilet{" +
                "\nBilet nomresi=" + ticketNumber +
                "\n qatar=" + train +
                "\n Sernisin adi='" + passengerName + '\'' +
                '}';
    }
}