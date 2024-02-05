package addressbook.app;

import java.util.List;

public class Searcher {

   public static boolean checkIfContactExists(List<Contact> contacts, Contact addedContact) {
        boolean nameCheck = contacts.stream().anyMatch(contact -> contact.getName().equals(addedContact.getName()));
        boolean numberCheck = contacts.stream().anyMatch(contact -> contact.getNumber().equals(addedContact.getNumber()));
        boolean emailCheck = contacts.stream().anyMatch(contact -> contact.getEmail().equals(addedContact.getEmail()));
        return nameCheck || numberCheck || emailCheck;
    }
}
