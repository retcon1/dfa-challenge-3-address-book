package addressbook.app;



import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;


public class RemoveMenuTest {

    private final InputStream originalInput = System.in;
    private final RemoveMenu removeMenu = new RemoveMenu();

    @BeforeEach
    public void setUp() {
        App.myAddressBook = new AddressBook(); // Create a new AddressBook before each test
        Contact demoContact = new Contact("Demo Contact", "09871234653", "demo@contact.com");
        Contact demoContact2 = new Contact("Another Demo", "12350098734", "contact@demo.co.uk");
        App.myAddressBook.addContact(demoContact);
        App.myAddressBook.addContact(demoContact2);
    }

    @AfterEach
    public void tearDown() {
        System.setIn(originalInput); // Restore original input stream after each test
    }


    @Nested
    @DisplayName("remove single contact functionality")
    class RemoveSingleContactFunction {
        @Test
        public void testRemoveContactSuccessful() {
            String input = "0\n7";
            provideInput(input);
            removeMenu.removeContact();
            assertEquals(1, App.myAddressBook.getContacts().size());
            assertEquals("Another Demo", App.myAddressBook.getContacts().get(0).getName());
        }

        @Test
        public void testRemoveContactFailsWithInvalidIndex() {
            String input = "8\n7";
            provideInput(input);
            removeMenu.removeContact();
            assertEquals(2, App.myAddressBook.getContacts().size());
        }
    }

    @Nested
    @DisplayName("remove all contacts functionality")
    class RemoveAllContactsFunction {
        @Test
        public void testRemoveAllContactsSuccessful() {
            String input = "yes\n7";
            provideInput(input);
            removeMenu.removeAllContacts();
            assertEquals(0, App.myAddressBook.getContacts().size());
        }

        @Test
        public void testRemoveAllContactsUnsuccessful() {
            String input = "no\n7";
            provideInput(input);
            removeMenu.removeAllContacts();
            assertEquals(2, App.myAddressBook.getContacts().size());
        }
    }

    private void provideInput(String data) {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scanner = new Scanner(System.in);
        try {
            App.setInput(scanner);
        } finally {
            System.setIn(stdin); // Reset System.in to original stream
        }
    }
}
