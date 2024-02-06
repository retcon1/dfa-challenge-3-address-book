package addressbook.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
    class RemoveContactFunctionTests {

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

    @Nested
    @DisplayName("removeAllContacts function tests")
    class RemoveAllContactsFunctionTests {

        @Test
        public void removeAllContactsReducesContactsListSizeTo0() {
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
            testBook.addContact(mockContact2);
            // Act
            testBook.removeAllContacts();
            // Assert
            assertEquals(0, testBook.getContacts().size());
            assertThrows(IndexOutOfBoundsException.class, () -> testBook.getContacts().get(0));
        }
    }

    @Nested
    @DisplayName("getContactsBy... function tests")
    class GetContactsByFunctionTests {

        @Test
        public void getContactsByNameReturnsMatchingName() {
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
            testBook.addContact(mockContact2);
            // Act
            ArrayList<Contact> result = testBook.getContactsByName("Another Name");
            // Assert
            assertEquals(1, result.size());
            assertEquals("Another Name", result.get(0).getName());
        }

        @Test
        public void getContactsByNumberReturnsMatchingContact() {
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
            testBook.addContact(mockContact2);
            // Act
            ArrayList<Contact> result = testBook.getContactsByNumber("12345678910");
            // Assert
            assertEquals("Test Name", result.get(0).getName());
            assertEquals("12345678910", result.get(0).getNumber());
        }

        @Test
        public void getContactsByEmailReturnsMatchingContact() {
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
            testBook.addContact(mockContact2);
            // Act
            ArrayList<Contact> result = testBook.getContactsByEmail("test2@email.com");
            // Assert
            assertEquals("Another Name", result.get(0).getName());
            assertEquals("test2@email.com", result.get(0).getEmail());
        }

        @Test
        public void getContactsByFunctionsReturnContactWhenOnlyGivenSomeInfo() {
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
            testBook.addContact(mockContact2);
            // Act
            ArrayList<Contact> nameSearch = testBook.getContactsByName("other");
            ArrayList<Contact> numberSearch = testBook.getContactsByNumber("910");
            ArrayList<Contact> emailSearch = testBook.getContactsByEmail("test2");
            // Assert
            assertEquals("Another Name", nameSearch.get(0).getName());
            assertEquals("Test Name", numberSearch.get(0).getName());
            assertEquals("Another Name", emailSearch.get(0).getName());
        }

        @Test
        public void getContactsByFunctionsReturnEmptyArrayListIfContactDoesNotExist() {
            // Arrange
            Contact mockContact = mock(Contact.class);
            when(mockContact.getName()).thenReturn("Test Name");
            when(mockContact.getNumber()).thenReturn("12345678910");
            when(mockContact.getEmail()).thenReturn("test@email.com");

            testBook.addContact(mockContact);
            // Act
            ArrayList<Contact> nameSearch = testBook.getContactsByName("Not A Name");
            ArrayList<Contact> numberSearch = testBook.getContactsByNumber("Not A Number");
            ArrayList<Contact> emailSearch = testBook.getContactsByEmail("Not An Email");
            // Assert
            assertEquals(0, nameSearch.size());
            assertEquals(0, numberSearch.size());
            assertEquals(0, emailSearch.size());
        }

        @Test
        public void getContactsByFunctionsReturnMultipleContactsForMultipleMatches() {
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
            testBook.addContact(mockContact2);
            // Act
            ArrayList<Contact> nameSearch = testBook.getContactsByName("ame");
            ArrayList<Contact> numberSearch = testBook.getContactsByNumber("123");
            ArrayList<Contact> emailSearch = testBook.getContactsByEmail("@email");
            // Assert
            assertEquals(2, nameSearch.size());
            assertEquals(2, numberSearch.size());
            assertEquals(2, emailSearch.size());
        }
        @Test
        public void getContactsByFunctionsReturnAlphabetically() {
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
            testBook.addContact(mockContact2);
            // Act
            ArrayList<Contact> nameSearch = testBook.getContactsByName("ame");
            ArrayList<Contact> numberSearch = testBook.getContactsByNumber("123");
            ArrayList<Contact> emailSearch = testBook.getContactsByEmail("@email");
            // Assert
            assertEquals("Another Name", nameSearch.get(0).getName());
            assertEquals("12345678444", numberSearch.get(0).getNumber());
            assertEquals("test2@email.com", emailSearch.get(0).getEmail());
        }
    }
}