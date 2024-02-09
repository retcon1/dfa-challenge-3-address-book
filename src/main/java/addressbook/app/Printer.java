package addressbook.app;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Printer {

    /* Previous version of printContacts, followed by Gen-AI improved version...
    public static String printContacts(ArrayList<Contact> contacts) {
         StringBuilder result = new StringBuilder();
         for (Contact contact : contacts) {
             result.append(contact.getName()).append(" || ");
             result.append(contact.getNumber()).append(" || ");
             result.append(contact.getEmail()).append("\n");
         }
         return result.toString();
     }
     */
    public static void printContacts(ArrayList<Contact> contacts) {
        String formattedContacts = formatContacts(contacts);
        System.out.println(formattedContacts);
    }

    public static String formatContacts(ArrayList<Contact> contacts) {
        return contacts.stream()
                .map(contact -> contact.getName() + " || " + contact.getNumber() + " || " + contact.getEmail())
                .collect(Collectors.joining("\n"));
    }
}
