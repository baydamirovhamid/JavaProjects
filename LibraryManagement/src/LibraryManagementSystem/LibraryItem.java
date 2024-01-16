package LibraryManagementSystem;

public class LibraryItem implements Display {
    public String Title;
    public String Author;
    public ItemStatus Status;

    public LibraryItem(String Title, String Author, ItemStatus Status) {
        this.Title = Title;
        this.Author = Author;
        this.Status = Status;
    }

    public String context() {
        return "Bashliq: " + Title + ",\n" +
                "Muellif: " + Author + ",\n" +
                "Status: " + Status + ",\n";
    }

    @Override
    public void displayInfo() {
        System.out.println(context());
    }

}



