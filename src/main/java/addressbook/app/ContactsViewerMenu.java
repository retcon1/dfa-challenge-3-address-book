package addressbook.app;

import static addressbook.app.App.myAddressBook;

public class ContactsViewerMenu {
    public static void seeAllContacts() {
        System.out.println("Here are you current contacts...\n");
        Printer.printContacts(myAddressBook.getContacts());
        System.out.println("----------------------");
        MenuOptions.printMainMenu();
    }

    public static Contact selectContact(String index) {
        return myAddressBook.getContacts().get(Integer.parseInt(index));
    }
}
