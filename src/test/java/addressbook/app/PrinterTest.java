package addressbook.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PrinterTest {

    @Test
    public void printerClassExists() {
        Printer myPrinter = new Printer();
        assertInstanceOf(Printer.class, myPrinter);
    }
    @Nested
    @DisplayName("formatContactsArrayList function returns a properly formatted string when given an ArrayList of contacts")
    class PrintContactsFunction {
        @Test
        public void functionPrintsOutListToConsole() {
            // Arrange
            Contact mockContact = mock(Contact.class);
            when(mockContact.getName()).thenReturn("Test Name");
            when(mockContact.getNumber()).thenReturn("12345678910");
            when(mockContact.getEmail()).thenReturn("test@email.com");

            Contact mockContact2 = mock(Contact.class);
            when(mockContact2.getName()).thenReturn("Another Name");
            when(mockContact2.getNumber()).thenReturn("12345678444");
            when(mockContact2.getEmail()).thenReturn("test2@email.com");

            ArrayList<Contact> mockContactList = new ArrayList<>();
            mockContactList.add(mockContact);
            mockContactList.add(mockContact2);
            ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStreamCaptor));

            // Act
            Printer.printContacts(mockContactList);

            // Assert
            String expectedOutput = "0. Test Name || 12345678910 || test@email.com\n1. Another Name || 12345678444 || test2@email.com\n";
            assertEquals(expectedOutput, outputStreamCaptor.toString());
        }

        @Test
        public void functionPrintsNoContactsMessageIfGivenEmptyArrayList() {
            // Arrange
            ArrayList<Contact> mockContactList = new ArrayList<>();
            ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStreamCaptor));

            // Act
            Printer.printContacts(mockContactList);

            // Assert
            String expectedOutput = "No contacts found\n";
            assertEquals(expectedOutput, outputStreamCaptor.toString());
        }
    }
}
