package addressbook.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTest {

    @Test
    public void validatorExists() {
        // Arrange
        Validator testValidator = new Validator();
        // Assert
        assertInstanceOf(Validator.class, testValidator);
    }
    @Nested
    @DisplayName("validateType function tests")

    class ValidateTypeFunctionTests {

        @Test
        public void validateTypeReturnsTrueIfSame() {
            // Arrange
            String testString = "test";
            // Act
            boolean result = Validator.validateType(testString, String.class);
            // Assert
            assertTrue(result);
        }

        @Test
        public void validateTypeReturnsFalseIfDifferent() {
            // Arrange
            String testString = "test";
            // Act
            boolean result = Validator.validateType(testString, Integer.class);
            // Assert
            assertFalse(result);
        }
    }
}
