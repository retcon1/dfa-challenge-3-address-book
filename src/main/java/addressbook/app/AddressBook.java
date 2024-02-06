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

    public void addContact(Contact contact) throws IllegalArgumentException {
        if (Searcher.checkIfContactExists(contacts, contact)) throw new IllegalArgumentException("That contact already exists");
        contacts.add(contact);
    }

    public void removeContact(Contact contact) {
        if (!Searcher.checkIfContactExists(contacts, contact)) throw new IllegalArgumentException("Contact does not exist");
        contacts.remove(contact);
    }

    public void removeAllContacts() {
         ArrayList<Contact> emptyContacts = new ArrayList<>();
         contacts = emptyContacts;
    }

    public Contact getContactsByName(String name) {
        return Searcher.searchByName(contacts, name);
    }

    public Contact getContactsByNumber(String number) {
        return Searcher.searchByNumber(contacts, number);
    }

    public Contact getContactsByEmail(String email) {
        return Searcher.searchByEmail(contacts, email);
    }
}
