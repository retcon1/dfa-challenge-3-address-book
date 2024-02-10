package addressbook.app;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class EditMenuTest {

    private final InputStream originalInput = System.in;
    private final EditMenu editMenu = new EditMenu();
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
    public void informsUserWhenNotTriggeringAnOption() {
        PrintStream outMock = mock(PrintStream.class);
        System.setOut(outMock);

        String input = "0\nnotAnOption\nname\nNew Name\n7";
        provideInput(input);
        String expectedResult = "Please enter: name, number or email";
        editMenu.editContactMenu();
        verify(outMock).println(expectedResult);
    }

    @Test
    public void successfullyEditsName() {
        PrintStream outMock = mock(PrintStream.class);
        System.setOut(outMock);

        String input = "0\nname\nNew Name\n7";
        provideInput(input);
        String expectedResult = "New Name | 09871234653 | demo@contact.com";
        editMenu.editContactMenu();
        verify(outMock).println(expectedResult);
    }

    @Test
    public void failsToEditNameFirstTime() {
        PrintStream outMock = mock(PrintStream.class);
        System.setOut(outMock);

        String input = "0\nname\nIn4lidN4ame\nValid Name\n7";
        provideInput(input);
        String expectedResult = "Given name is invalid! Please try again...";
        String expectedChange = "Valid Name | 09871234653 | demo@contact.com";
        editMenu.editContactMenu();
        verify(outMock).println(expectedResult);
        verify(outMock).println(expectedChange);
    }

    @Test
    public void successfullyEditsNumber() {
        PrintStream outMock = mock(PrintStream.class);
        System.setOut(outMock);

        String input = "0\nnumber\n12345678910\n7";
        provideInput(input);
        String expectedResult = "John Doe | 12345678910 | demo@contact.com";
        editMenu.editContactMenu();
        verify(outMock).println(expectedResult);
    }

    @Test
    public void failsToEditNumberFirstTime() {
        PrintStream outMock = mock(PrintStream.class);
        System.setOut(outMock);

        String input = "0\nnumber\nInvalidNumber\n12345678910\n7";
        provideInput(input);
        String expectedResult = "Given number is invalid! Please try again...";
        String expectedChange = "John Doe | 12345678910 | demo@contact.com";
        editMenu.editContactMenu();
        verify(outMock).println(expectedResult);
        verify(outMock).println(expectedChange);
    }

    @Test
    public void successfullyEditsEmail() {
        PrintStream outMock = mock(PrintStream.class);
        System.setOut(outMock);

        String input = "0\nemail\nnew@email.com\n7";
        provideInput(input);
        String expectedResult = "John Doe | 09871234653 | new@email.com";
        editMenu.editContactMenu();
        verify(outMock).println(expectedResult);
    }

    @Test
    public void failsToEditEmailFirstTime() {
        PrintStream outMock = mock(PrintStream.class);
        System.setOut(outMock);

        String input = "0\nemail\nInvalidEmail\nvalid@email.com\n7";
        provideInput(input);
        String expectedResult = "Given email is invalid! Please try again...";
        String expectedChange = "John Doe | 09871234653 | valid@email.com";
        editMenu.editContactMenu();
        verify(outMock).println(expectedResult);
        verify(outMock).println(expectedChange);
    }

    @Test
    public void breaksOutWhenGivenInvalidIndex() {
        PrintStream outMock = mock(PrintStream.class);
        System.setOut(outMock);

        String input = "9\n7";
        provideInput(input);
        String expectedResult = "Select a contact with an index in the list next time!\n";
        editMenu.editContactMenu();
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
