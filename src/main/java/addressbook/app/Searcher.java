package addressbook.app;

import java.util.ArrayList;

public class Searcher {

   public static boolean checkIfContactExists(ArrayList<Contact> contacts, Contact addedContact) {
        boolean nameCheck = contacts.stream().anyMatch(contact -> contact.getName().equals(addedContact.getName()));
        boolean numberCheck = contacts.stream().anyMatch(contact -> contact.getNumber().equals(addedContact.getNumber()));
        boolean emailCheck = contacts.stream().anyMatch(contact -> contact.getEmail().equals(addedContact.getEmail()));
        return nameCheck || numberCheck || emailCheck;
    }

    public static ArrayList<Contact> searchByName(ArrayList<Contact> contacts, String name) {
        ArrayList<Contact> foundContacts = new ArrayList<>();
       for (Contact contact : contacts) {
           if (contact.getName().contains(name)) foundContacts.add(contact);
       }
       return foundContacts;
    }

    public static ArrayList<Contact> searchByNumber(ArrayList<Contact> contacts, String number) {
        ArrayList<Contact> foundContacts = new ArrayList<>();;
        for (Contact contact : contacts) {
            if (contact.getNumber().contains(number)) foundContacts.add(contact);
        }
        return foundContacts;
    }

    public static ArrayList<Contact> searchByEmail(ArrayList<Contact> contacts, String email) {
        ArrayList<Contact> foundContacts = new ArrayList<>();;
        for (Contact contact : contacts) {
            if (contact.getEmail().contains(email)) foundContacts.add(contact);
        }
        return foundContacts;
    }

}
