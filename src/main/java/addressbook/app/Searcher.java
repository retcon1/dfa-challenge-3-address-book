package addressbook.app;

import java.util.ArrayList;

public class Searcher {

   public static boolean checkIfContactExists(ArrayList<Contact> contacts, Contact addedContact) {
        boolean nameCheck = contacts.stream().anyMatch(contact -> contact.getName().equals(addedContact.getName()));
        boolean numberCheck = contacts.stream().anyMatch(contact -> contact.getNumber().equals(addedContact.getNumber()));
        boolean emailCheck = contacts.stream().anyMatch(contact -> contact.getEmail().equals(addedContact.getEmail()));
        return nameCheck || numberCheck || emailCheck;
    }

    public static Contact searchByName(ArrayList<Contact> contacts, String name) {
       Contact foundContact = null;
       for (Contact contact : contacts) {
           if (contact.getName().equals(name)) foundContact = contact;
       }
       return foundContact;
    }

}
