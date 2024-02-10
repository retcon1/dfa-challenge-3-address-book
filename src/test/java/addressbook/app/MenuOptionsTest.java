package addressbook.app;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class MenuOptionsTest {

    private final InputStream originalInput = System.in;
    private final MenuOptions menuOptions = new MenuOptions();
    private final PrintStream originalOut = System.out;


    @BeforeEach
    public void setUp() {
        App.myAddressBook = new AddressBook(); // Create a new AddressBook before each test
        Contact demoContact = new Contact("John Doe", "09871234653", "demo@contact.com");
        Contact demoContact2 = new Contact("Jo Schmo", "12350098734", "contact@demo.co.uk");
        App.myAddressBook.addContact(demoContact);
        App.myAddressBook.addContact(demoContact2);
    }

    @AfterEach
    public void tearDown() {
        System.setIn(originalInput); // Restore original input stream after each test
    }


    @Test
    public void entersContactMenuSuccessfully() {
        PrintStream outMock = mock(PrintStream.class);
        System.setOut(outMock);

        String input = "1\nNew Contact\n12345678910\njohn@example.com\n7";
        provideInput(input);
        String expectedResult = "Please enter the contact's full name: ";
        menuOptions.printMainMenu();
        verify(outMock).println(expectedResult);
    }

    @Test
    public void printsAllContacts() {
        PrintStream outMock = mock(PrintStream.class);
        System.setOut(outMock);

        String input = "2\n7";
        provideInput(input);
        String expectedResult1 = "Here are you current contacts...\n";
        String expectedResult2 = "0. John Doe || 09871234653 || demo@contact.com\n" +
                "1. Jo Schmo || 12350098734 || contact@demo.co.uk";
        menuOptions.printMainMenu();
        verify(outMock).println(expectedResult1);
        verify(outMock).println(expectedResult2);
    }

    @Test
    public void entersSearchContactsMenuSuccessfully() {
        PrintStream outMock = mock(PrintStream.class);
        System.setOut(outMock);

        String input = "3\nname\nDoe\n7";
        provideInput(input);
        String expectedResult = "Are you searching by name, number or email? Please enter one:";
        menuOptions.printMainMenu();
        verify(outMock).println(expectedResult);
    }

    @Test
    public void entersEditContactMenuSuccessfully() {
        PrintStream outMock = mock(PrintStream.class);
        System.setOut(outMock);

        String input = "4\n0\nname\nNew Name\n7";
        provideInput(input);
        String expectedResult = "Enter the number of the contact you'd like to edit:";
        menuOptions.printMainMenu();
        verify(outMock).println(expectedResult);
    }

    @Test
    public void entersRemoveContactMenuSuccessfully() {
        PrintStream outMock = mock(PrintStream.class);
        System.setOut(outMock);

        String input = "5\n9\n7";
        provideInput(input);
        String expectedResult = "Please enter the number of the contact you'd like to remove:";
        menuOptions.printMainMenu();
        verify(outMock).println(expectedResult);
    }

    @Test
    public void entersRemoveAllContactsMenuSuccessfully() {
        PrintStream outMock = mock(PrintStream.class);
        System.setOut(outMock);

        String input = "6\nno\n7";
        provideInput(input);
        String expectedResult = "Are you sure you wish to wipe all of your contacts? This cannot be undone\n Type: yes to remove everyone, type anything else to abort";
        menuOptions.printMainMenu();
        verify(outMock).println(expectedResult);
    }

    @Test
    public void returnsWarningStringWhenGivenIncorrectInput() {
        PrintStream outMock = mock(PrintStream.class);
        System.setOut(outMock);

        String input = "Invalid\n7";
        provideInput(input);
        String expectedResult = "Only enter a number from the list!";
        menuOptions.printMainMenu();
        verify(outMock).println(expectedResult);
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
