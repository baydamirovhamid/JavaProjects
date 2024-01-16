package LibraryManagementSystem;

public class Book extends LibraryItem {
    public int pageCount;

    public Book(String title, String author, ItemStatus status, int pageCount) {
        super(title, author, status);
        this.pageCount = pageCount;
    }

    @Override
    public void displayInfo() {
        System.out.println(context() +
                "Sehife sayi: " + pageCount
        );
    }
}