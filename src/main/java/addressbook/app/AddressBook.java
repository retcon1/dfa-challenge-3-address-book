/**
 * The AddressBook class represents a collection of contacts.
 * It provides methods to manage contacts such as adding, removing,
 * and searching for contacts by name, number, or email.
 */
package addressbook.app;

import java.util.ArrayList;

public class AddressBook {
    // Fields
    private int id;
    private static int nextId = 1000;
    private ArrayList<Contact> contacts;

    /**
     * Constructs an AddressBook object with a unique ID and initializes
     * an empty list of contacts.
     */
    AddressBook() {
        this.id = AddressBook.nextId++;
        this.contacts = new ArrayList<>();
    }

    /**
     * Returns the ID of the address book.
     *
     * @return the ID of the address book
     */
    public int getId() {
        return id;
    }

    /**
     * Returns a list of all contacts in the address book.
     *
     * @return an ArrayList of contacts
     */
    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    /**
     * Adds a new contact to the address book.
     *
     * @param contact the contact to add
     * @throws IllegalArgumentException if the contact already exists or is null
     */
    public void addContact(Contact contact) throws IllegalArgumentException {
        if (Searcher.checkIfContactExists(contacts, contact) || contact == null)
            throw new IllegalArgumentException("That contact already exists");
        contacts.add(contact);
    }

    /**
     * Removes a contact from the address book.
     *
     * @param contact the contact to remove
     * @throws IllegalArgumentException if the contact does not exist
     */
    public void removeContact(Contact contact) throws IllegalArgumentException {
        if (!Searcher.checkIfContactExists(contacts, contact))
            throw new IllegalArgumentException("Contact does not exist");
        contacts.remove(contact);
    }

    /**
     * Removes all contacts from the address book.
     */
    public void removeAllContacts() {
        contacts.clear();
    }

    /**
     * Searches for contacts in the address book by name.
     *
     * @param name the name to search for
     * @return an ArrayList of contacts with matching names
     */
    public ArrayList<Contact> getContactsByName(String name) {
        return Searcher.searchByName(contacts, name);
    }

    /**
     * Searches for contacts in the address book by number.
     *
     * @param number the number to search for
     * @return an ArrayList of contacts with matching numbers
     */
    public ArrayList<Contact> getContactsByNumber(String number) {
        return Searcher.searchByNumber(contacts, number);
    }

    /**
     * Searches for contacts in the address book by email.
     *
     * @param email the email to search for
     * @return an ArrayList of contacts with matching emails
     */
    public ArrayList<Contact> getContactsByEmail(String email) {
        return Searcher.searchByEmail(contacts, email);
    }
}
