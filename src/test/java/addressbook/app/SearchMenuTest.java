package addressbook.app;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class SearchMenuTest {

    private final InputStream originalInput = System.in;
    private final SearchMenu searchMenu = new SearchMenu();
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
    public void searchName() {
        PrintStream outMock = mock(PrintStream.class);
        System.setOut(outMock);

        String input = "name\nJohn\n7";
        provideInput(input);
        String expectedResult = "0. John Doe || 09871234653 || demo@contact.com";
        searchMenu.searchContacts();
        verify(outMock).println(expectedResult);
    }

    @Test
    public void searchNameNoResult() {
        PrintStream outMock = mock(PrintStream.class);
        System.setOut(outMock);

        String input = "name\nNotaname\n7";
        provideInput(input);
        String expectedResult = "No contacts found";
        searchMenu.searchContacts();
        verify(outMock).println(expectedResult);
    }


    @Test
    public void searchNumber() {
        PrintStream outMock = mock(PrintStream.class);
        System.setOut(outMock);

        String input = "number\n09871\n7";
        provideInput(input);
        String expectedResult = "0. John Doe || 09871234653 || demo@contact.com";
        searchMenu.searchContacts();
        verify(outMock).println(expectedResult);
    }

    @Test
    public void searchNumberNoResult() {
        PrintStream outMock = mock(PrintStream.class);
        System.setOut(outMock);

        String input = "number\nnotANumber\n7";
        provideInput(input);
        String expectedResult = "No contacts found";
        searchMenu.searchContacts();
        verify(outMock).println(expectedResult);
    }

    @Test
    public void searchEmail() {
        PrintStream outMock = mock(PrintStream.class);
        System.setOut(outMock);

        String input = "email\ndemo@contact\n7";
        provideInput(input);
        String expectedResult = "0. John Doe || 09871234653 || demo@contact.com";
        searchMenu.searchContacts();
        verify(outMock).println(expectedResult);
    }

    @Test
    public void searchEmailNoResult() {
        PrintStream outMock = mock(PrintStream.class);
        System.setOut(outMock);

        String input = "email\nnotAnEmail\n7";
        provideInput(input);
        String expectedResult = "No contacts found";
        searchMenu.searchContacts();
        verify(outMock).println(expectedResult);
    }

    @Test
    public void returnsWarningIfNotGivenNameNumberOrEmail() {
        PrintStream outMock = mock(PrintStream.class);
        System.setOut(outMock);

        String input = "incorrect\nname\nDoe\n7";
        provideInput(input);
        String expectedResult = "Please enter: name, number or email";
        searchMenu.searchContacts();
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
