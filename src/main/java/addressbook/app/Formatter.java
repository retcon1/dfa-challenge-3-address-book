package addressbook.app;

import java.util.ArrayList;

public class Formatter {

    public static String formatContactsArrayList(ArrayList<Contact> contacts) {
        StringBuilder result = new StringBuilder();
        for (Contact contact : contacts) {
            result.append(contact.getName()).append(" || ");
            result.append(contact.getNumber()).append(" || ");
            result.append(contact.getEmail()).append("\n");
        }
        return result.toString();
    }
}
