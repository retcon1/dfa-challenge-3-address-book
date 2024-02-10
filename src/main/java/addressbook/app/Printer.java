package addressbook.app;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        if (contacts.isEmpty()) {
            System.out.println("No contacts found");
            return;
        }
        String formattedContacts = formatContacts(contacts);
        System.out.println(formattedContacts);
    }

    public static void printContact(Contact contact) {
        System.out.printf("%s | %s | %s\n", contact.getName(), contact.getNumber(), contact.getEmail());
    }

    public static String formatContacts(ArrayList<Contact> contacts) {
        return IntStream.range(0, contacts.size())
                .mapToObj(i -> (i) + ". " + contacts.get(i).getName() + " || " + contacts.get(i).getNumber() + " || " + contacts.get(i).getEmail())
                .collect(Collectors.joining("\n"));
    }
}
