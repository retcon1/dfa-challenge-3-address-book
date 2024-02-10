package addressbook.app;

import static addressbook.app.AddMenu.addNewContact;
import static addressbook.app.App.input;
import static addressbook.app.ContactsViewerMenu.seeAllContacts;
import static addressbook.app.EditMenu.editContactMenu;
import static addressbook.app.RemoveMenu.removeAllContacts;
import static addressbook.app.RemoveMenu.removeContact;
import static addressbook.app.SearchMenu.searchContacts;

public class MenuOptions {
    public static void printMainMenu() {
        System.out.println("What would you like to do? Type in a number to select!");
        System.out.println("1. Add a New Contact");
        System.out.println("2. See All Contacts");
        System.out.println("3. Search My Contacts");
        System.out.println("4. Edit Contacts");
        System.out.println("5. Remove a Contact");
        System.out.println("6. Remove All Contacts");
        System.out.println("7. Close Application");
        String menuSelect = input.nextLine();

        switch (menuSelect) {
            case "1":
                addNewContact();
                break;
            case "2":
                seeAllContacts();
                break;
            case "3":
                searchContacts();
                break;
            case "4":
                editContactMenu();
                break;
            case "5":
                removeContact();
                break;
            case "6":
                removeAllContacts();
                break;
            case "7":
                break;
            default:
                System.out.println("Only enter a number from the list!");
                printMainMenu();
                break;
        }
    }
}
