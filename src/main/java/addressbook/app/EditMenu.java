package addressbook.app;

import static addressbook.app.App.input;
import static addressbook.app.App.myAddressBook;

public class EditMenu {
    public static void editContactMenu() {
        System.out.println("Enter the number of the contact you'd like to edit:");
        Printer.printContacts(myAddressBook.getContacts());
        String indexToEdit = input.nextLine();
        try {
            Contact contactToEdit = ContactsViewerMenu.selectContact(indexToEdit);
            editAttributeSelector(contactToEdit);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Select a contact with an index in the list next time!\n");
        } finally {
            MenuOptions.printMainMenu();
        }
    }

    public static void editAttributeSelector(Contact contact) {
        System.out.println("Enter name, number or email to choose what to edit!");
        String editAttribute = input.nextLine();
        switch (editAttribute) {
            case "name":
                setNewName(contact);
                break;
            case "number":
                setNewNumber(contact);
                break;
            case "email":
                setNewEmail(contact);
                break;
            default:
                System.out.println("Please enter: name, number or email");
                editAttributeSelector(contact);
        }
    }

    public static void setNewName(Contact contact) {
        System.out.println("Enter a new full name: ");
        String newName = input.nextLine();
        try {
            contact.setName(newName);
            System.out.println("Contact changed!");
            Printer.printContact(contact);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Please try again...");
            setNewName(contact);
        }
    }

    public static void setNewNumber(Contact contact) {
        System.out.println("Enter a new phone number: ");
        String newNumber = input.nextLine();
        try {
            contact.setNumber(newNumber);
            System.out.println("Contact changed!");
            Printer.printContact(contact);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Please try again...");
            setNewNumber(contact);
        }
    }

    public static void setNewEmail(Contact contact) {
        System.out.println("Enter a new email address: ");
        String newEmail = input.nextLine();
        try {
            contact.setEmail(newEmail);
            System.out.println("Contact changed!");
            Printer.printContact(contact);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Please try again...");
            setNewEmail(contact);
        }
    }

}
