package addressbook.app;

import static addressbook.app.App.input;
import static addressbook.app.App.myAddressBook;

public class RemoveMenu {
    public static void removeContact() {
        System.out.println("Please enter the number of the contact you'd like to remove...");
        Printer.printContacts(myAddressBook.getContacts());
        String indexToRemove = input.nextLine();
        try {
            Contact contactToRemove = ContactsViewerMenu.selectContact(indexToRemove);
            myAddressBook.removeContact(contactToRemove);
            System.out.println("Contact removed!");
            Printer.printContacts(myAddressBook.getContacts());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Select a contact with an index in the list next time!");
        } finally {
            MenuOptions.printMainMenu();
        }
    }

    public static void removeAllContacts() {
        System.out.println("Are you sure you wish to wipe all of your contacts? This cannot be undone\n Type: yes to remove everyone, type anything else to abort");
        String decision = input.nextLine();
        System.out.println(decision);
        if (decision.equals("yes")) {
            myAddressBook.removeAllContacts();
            System.out.println("ALL CONTACTS DELETED");
        }
        MenuOptions.printMainMenu();
    }
}
