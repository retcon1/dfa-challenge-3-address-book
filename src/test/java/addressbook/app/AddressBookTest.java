package addressbook.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
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
        @Test
        public void addContactDoesNotAddIfContactExists() {
            // Arrange
            Contact mockContact = mock(Contact.class);
            when(mockContact.getName()).thenReturn("Test Name");
            when(mockContact.getNumber()).thenReturn("12345678910");
            when(mockContact.getEmail()).thenReturn("test@email.com");

            // Act
            testBook.addContact(mockContact);

            // Assert
            assertThrows(IllegalArgumentException.class, () -> testBook.addContact(mockContact));
            assertEquals(1, testBook.getContacts().size());
        }
    }
    @Nested
    @DisplayName("removeContact function tests")
    class removeContactFunctionTests {

        @Test
        public void removeContactReducesArraySizeByOne() {
            // Arrange
            Contact mockContact = mock(Contact.class);
            when(mockContact.getName()).thenReturn("Test Name");
            when(mockContact.getNumber()).thenReturn("12345678910");
            when(mockContact.getEmail()).thenReturn("test@email.com");
            testBook.addContact(mockContact);
            // Act
            testBook.removeContact(mockContact);
            // Assert
            assertEquals(0, testBook.getContacts().size());
        }

        @Test
        public void removeContactRemovesTheExactContact() {
            Contact mockContact = mock(Contact.class);
            when(mockContact.getName()).thenReturn("Test Name");
            when(mockContact.getNumber()).thenReturn("12345678910");
            when(mockContact.getEmail()).thenReturn("test@email.com");

            Contact mockContact2 = mock(Contact.class);
            when(mockContact2.getName()).thenReturn("Another Name");
            when(mockContact2.getNumber()).thenReturn("12345678444");
            when(mockContact2.getEmail()).thenReturn("test2@email.com");
            testBook.addContact(mockContact);
            testBook.addContact(mockContact2);
            // Act
            testBook.removeContact(mockContact);
            String result = testBook.getContacts().get(0).getName();
            // Assert
            assertEquals(mockContact2.getName(), result);
        }

        @Test
        public void removeContactThrowsExceptionIfContactNotFound() {
            // Arrange
            Contact mockContact = mock(Contact.class);
            when(mockContact.getName()).thenReturn("Test Name");
            when(mockContact.getNumber()).thenReturn("12345678910");
            when(mockContact.getEmail()).thenReturn("test@email.com");

            Contact mockContact2 = mock(Contact.class);
            when(mockContact2.getName()).thenReturn("Another Name");
            when(mockContact2.getNumber()).thenReturn("12345678444");
            when(mockContact2.getEmail()).thenReturn("test2@email.com");
            testBook.addContact(mockContact);

            // Assert
            assertThrows(IllegalArgumentException.class, () -> testBook.removeContact(mockContact2));
            assertEquals(1, testBook.getContacts().size());

        }
    }
}