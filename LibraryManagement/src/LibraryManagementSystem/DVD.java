package LibraryManagementSystem;

public class DVD extends LibraryItem {
    private int timeMinute;

    public DVD(String title, String author, ItemStatus status, int timeMinute) {
        super(title, author, status);
        this.timeMinute = timeMinute;
    }


    public void displayInfo() {
        System.out.println(context() +
                "Zaman deqiqe ile: " + timeMinute
        );
    }
}