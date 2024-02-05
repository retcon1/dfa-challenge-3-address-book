package addressbook.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.Mockito.*;

public class AddressBookTest {
    private AddressBook testBook;

    @BeforeEach
    void newBook() {
        testBook = new AddressBook();
    }
    @Nested
    @DisplayName("AddressBook class exists with appropriate ID")
    class AddressBookExistsWithId {
        @Test
        public void addressBookExistsWithId() {
            // Assert
            assertInstanceOf(AddressBook.class, testBook);
            assertInstanceOf(Integer.class, testBook.getId());
        }
    }

    @Nested
    @DisplayName("addContact function tests")
    class AddContactsFunctionTests {

        @Test
        public void addContactIncreasesArrayListSizeByOne() {
            // Arrange
            Contact mockContact = mock(Contact.class);
            when(mockContact.getName()).thenReturn("Test Name");
            when(mockContact.getNumber()).thenReturn("12345678910");
            when(mockContact.getEmail()).thenReturn("test@email.com");

            // Act
            testBook.addContact(mockContact);
            int result = testBook.getContacts().size();

            // Assert
            assertEquals(1, result);
        }

        @Test
        public void addContactPutsInstanceOfContactIntoArrayList() {
            // Arrange
            Contact mockContact = mock(Contact.class);
            when(mockContact.getName()).thenReturn("Test Name");
            when(mockContact.getNumber()).thenReturn("12345678910");
            when(mockContact.getEmail()).thenReturn("test@email.com");

            // Act
            testBook.addContact(mockContact);
            Contact result = testBook.getContacts().get(0);

            // Assert
            assertEquals(mockContact, result);
            assertEquals(mockContact.getName(), result.getName());
        }
    }
}