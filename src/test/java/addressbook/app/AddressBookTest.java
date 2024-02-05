package addressbook.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class AddressBookTest {
    @Nested
    @DisplayName("AddressBook class exists with appropriate ID")
    class AddressBookExistsWithId {
        @Test
        public void addressBookExistsWithId() {
            // Arrange
            AddressBook testBook = new AddressBook();
            // Assert
            assertInstanceOf(AddressBook.class, testBook);
            assertEquals( 1000, testBook.getId());
        }
    }
}