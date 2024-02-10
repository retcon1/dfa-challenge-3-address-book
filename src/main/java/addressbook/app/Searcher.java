package addressbook.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Searcher {

    public static boolean checkIfContactExists(ArrayList<Contact> contacts, Contact addedContact) {
        boolean nameCheck = contacts.stream().anyMatch(contact -> contact.getName().equals(addedContact.getName()));
        boolean numberCheck = contacts.stream().anyMatch(contact -> contact.getNumber().equals(addedContact.getNumber()));
        boolean emailCheck = contacts.stream().anyMatch(contact -> contact.getEmail().equals(addedContact.getEmail()));
        return nameCheck || numberCheck || emailCheck;
    }

    /* Older search function. New and shorter versions have been improved using Gen-AI

       public static ArrayList<Contact> searchByName(ArrayList<Contact> contacts, String name) {
           ArrayList<Contact> foundContacts = new ArrayList<>();
           for (Contact contact : contacts) {
               if (contact.getName().contains(name)) foundContacts.add(contact);
           }
           Collections.sort(foundContacts, Comparator.comparing(Contact::getName));
           return foundContacts;
       }
      */
    public static ArrayList<Contact> searchByName(ArrayList<Contact> contacts, String name) {
        return contacts.stream()
                .filter(contact -> contact.getName().contains(name))
                .sorted(Comparator.comparing(Contact::getName))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static ArrayList<Contact> searchByNumber(ArrayList<Contact> contacts, String number) {
        return contacts.stream()
                .filter(contact -> contact.getNumber().contains(number))
                .sorted(Comparator.comparing(Contact::getName))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static ArrayList<Contact> searchByEmail(ArrayList<Contact> contacts, String email) {
        return contacts.stream()
                .filter(contact -> contact.getEmail().contains(email))
                .sorted(Comparator.comparing(Contact::getName))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
