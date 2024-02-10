package addressbook.app;

import java.util.Scanner;

public class App {

    public static Scanner input = new Scanner(System.in);

    public static AddressBook myAddressBook = new AddressBook();

    public static void main(String[] args) {
        Contact demoContact = new Contact("Demo Contact", "09871234653", "demo@contact.com");
        Contact demoContact2 = new Contact("Another Demo", "12350098734", "contact@demo.co.uk");
        myAddressBook.addContact(demoContact);
        myAddressBook.addContact(demoContact2);

        MenuOptions.printMainMenu();
    }

    public static void setInput(Scanner scanner) {
        input = scanner;
    }

    public static Scanner getInput() {
        return input;
    }
}
