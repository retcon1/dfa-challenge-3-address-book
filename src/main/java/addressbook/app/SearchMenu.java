package addressbook.app;

import java.util.ArrayList;

import static addressbook.app.App.input;
import static addressbook.app.App.myAddressBook;

public class SearchMenu {
    public static void searchContacts() {
        System.out.println("Are you searching by name, number or email? Please enter one:");
        String choice = input.nextLine();
        switch (choice) {
            case "name":
                searchName();
                break;
            case "number":
                searchNumber();
                break;
            case "email":
                searchEmail();
                break;
            default:
                System.out.println("Please enter: name, number or email");
                searchContacts();
                break;
        }
    }

    private static void searchName() {
        System.out.println("Please enter the name to search: ");
        String enteredName = input.nextLine();
        ArrayList<Contact> result = Searcher.searchByName(myAddressBook.getContacts(), enteredName);
        Printer.printContacts(result);
        MenuOptions.printMainMenu();
    }

    private static void searchNumber() {
        System.out.println("Please enter the number to search: ");
        String enteredName = input.nextLine();
        ArrayList<Contact> result = Searcher.searchByNumber(myAddressBook.getContacts(), enteredName);
        Printer.printContacts(result);
        MenuOptions.printMainMenu();
    }

    private static void searchEmail() {
        System.out.println("Please enter the email to search: ");
        String enteredName = input.nextLine();
        ArrayList<Contact> result = Searcher.searchByEmail(myAddressBook.getContacts(), enteredName);
        Printer.printContacts(result);
        MenuOptions.printMainMenu();
    }
}
