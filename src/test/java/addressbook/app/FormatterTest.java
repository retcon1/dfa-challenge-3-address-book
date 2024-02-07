package addressbook.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FormatterTest {
    @Nested
    @DisplayName("formatContactsArrayList function returns a properly formatted string when given an ArrayList of contacts")
    class FormatContactsArrayListFunction {
        @Test
        public void functionReturnsProperlyFormattedString() {
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
            String expectedResult = "Test Name || 12345678910 || test@email.com\nAnother Name || 12345678444 || test2@email.com\n";
            // Act
            String result = Formatter.formatContactsArrayList(mockContactList);
            // Assert
            assertEquals(expectedResult, result);
        }
    }
}
