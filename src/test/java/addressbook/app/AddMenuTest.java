package addressbook.app;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class AddMenuTest {
    private final InputStream originalInput = System.in;
    private final AddMenu addMenu = new AddMenu();

    @BeforeEach
    public void setUp() {
        App.myAddressBook = new AddressBook(); // Create a new AddressBook before each test
    }

    @AfterEach
    public void tearDown() {
        System.setIn(originalInput); // Restore original input stream after each test
    }

    @Test
    public void testAddNewContact_Successful() {
        String input = "John Doe\n12345678910\njohn@example.com\n7";
        provideInput(input);

        addMenu.addNewContact();

        assertEquals(1, App.myAddressBook.getContacts().size());
    }

    @Test
    public void testAddNewContact_InvalidInput_OnlyOneAdded() {
        PrintStream outMock = mock(PrintStream.class);
        System.setOut(outMock);
        String input = "John Doe\ninvalidNumber\njohn@example.com\nValid Input\n12340987561\ntest@test.com\n7\n7";
        provideInput(input);

        addMenu.addNewContact();

        assertEquals(1, App.myAddressBook.getContacts().size());
        verify(outMock).println("Name, Phone Number or Email is invalid, please try again!");
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
