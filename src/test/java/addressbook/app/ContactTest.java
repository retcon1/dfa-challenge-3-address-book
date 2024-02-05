package addressbook.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
    @Nested
    @DisplayName("Contact class tests")

    class ContactClassTests {
        @org.junit.jupiter.api.Test
        public void contactExists() {
            // Arrange
            Contact testContact = new Contact("Test Name", "12345678910", "testEmail@mail.com");
            // Assert
            assertInstanceOf(Contact.class, testContact);
        }

        @org.junit.jupiter.api.Test
        public void contactGettersWork() {
            // Arrange
            String testName = "Test Name";
            String testNumber = "12345678910";
            String testEmail = "testEmail@mail.com";
            Contact testContact = new Contact(testName, testNumber, testEmail);
            // Assert
            assertEquals(testContact.getName(), testName);
            assertEquals(testContact.getNumber(), testNumber);
            assertEquals(testContact.getEmail(), testEmail);
        }

        @org.junit.jupiter.api.Test
        public void contactSettersWork() {
            // Arrange
            String testName = "Test Name";
            String testNumber = "12345678910";
            String testEmail = "testEmail@mail.com";
            Contact testContact = new Contact(testName, testNumber, testEmail);
            String newName = "New Name";
            String newNumber = "12345678944";
            String newEmail = "newEmail@new.com";
            // Act
            testContact.setName(newName);
            testContact.setNumber(newNumber);
            testContact.setEmail(newEmail);
            // Assert
            assertEquals(testContact.getName(), newName);
            assertEquals(testContact.getNumber(), newNumber);
            assertEquals(testContact.getEmail(), newEmail);
        }

        @org.junit.jupiter.api.Test
        public void contactNotCreatedIfInvalid() {
            // Assert
            assertThrows(IllegalArgumentException.class, () -> new Contact("inv4lidNam3", "notaNumber", "notAnEmail")) ;
        }
    }
}