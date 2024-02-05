package addressbook.app;

public class AddressBook {
    private int id;
    private static int nextId = 1000;

    AddressBook() {
        this.id = AddressBook.nextId++;
    }

    public int getId() {
        return id;
    }
}
