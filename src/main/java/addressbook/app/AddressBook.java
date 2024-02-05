package addressbook.app;

import java.util.ArrayList;

public class AddressBook {
    private int id;
    private static int nextId = 1000;
    private ArrayList<Contact> contacts;

    AddressBook() {
        this.id = AddressBook.nextId++;
        this.contacts = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }
}
