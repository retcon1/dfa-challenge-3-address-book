package addressbook.app;

import static addressbook.app.App.input;

public class AddMenu {
    public static void addNewContact() {
        System.out.println("Please enter the contact's full name: ");
        String name = input.nextLine();
        System.out.println("Now enter their phone number: ");
        String number = input.nextLine();
        System.out.println("Finally, enter their email address: ");
        String email = input.nextLine();
        System.out.println("Now we'll try adding it to your contacts...\n");
        try {
            Contact newContact = new Contact(name, number, email);
            App.myAddressBook.addContact(newContact);
        } catch (IllegalArgumentException e) {
            System.out.printf("%s, please try again!\n", e.getMessage());
            addNewContact();
        }
        System.out.println("Successfully added new contact! \n");
        MenuOptions.printMainMenu();
    }
}
