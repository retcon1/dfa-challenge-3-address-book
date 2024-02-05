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

    @Nested
    @DisplayName("validateName function tests")

    class ValidateNameFunctionTests {
        // Arrange
        @Test
        public void validateNameReturnsTrueOnStandardName() {
            // Arrange
            String testName = "Test Name";
            // Act
            boolean result = Validator.validateName(testName);
            // Assert
            assertTrue(result);
        }

        @Test
        public void validateNameReturnsFalseWhenGivenNumbers() {
            // Arrange
            String testName = "T3st N4me";
            // Act
            boolean result = Validator.validateName(testName);
            // Assert
            assertFalse(result);
        }

        @Test
        public void validateNameReturnsFalseWithNoSpaces() {
            // Arrange
            String testName = "TestName";
            // Act
            boolean result = Validator.validateName(testName);
            // Assert
            assertFalse(result);
        }

        @Test
        public void validateNameReturnsTrueWithHyphenatedName() {
            // Arrange
            String testName = "Test-test Name-name";
            // Act
            boolean result = Validator.validateName(testName);
            // Assert
            assertTrue(result);
        }

        @Test
        public void validateNameReturnsTrueWithApostropheName() {
            // Arrange
            String testName = "Test O'Name";
            // Act
            boolean result = Validator.validateName(testName);
            // Assert
            assertTrue(result);
        }
    }

    @Nested
    @DisplayName("validateEmail function tests")
    class ValidateEmailFunctionTests {

        @Test
        public void validateEmailReturnsFalseIfInvalid() {
            // Arrange
            String testEmail = "testmail@com";
            // Act
            boolean result = Validator.validateEmail(testEmail);
            // Assert
            assertFalse(result);
        }

        @Test
        public void validateEmailReturnsTrueIfValid() {
            // Arrange
            String testEmail = "testmail@test.co.uk";
            // Act
            boolean result = Validator.validateEmail(testEmail);
            // Assert
            assertTrue(result);
        }
    }

    @Nested
    @DisplayName("validateNumber function tests")
    class ValidateNumberFunctionTests {

        @Test
        public void validateNumberReturnsTrueIfValid() {
            // Arrange
            String testNumber = "12345678910";
            String testNumber2 = "+919367788755";
            String testNumber3 = "786-307-3615";
            // Act
            boolean result = Validator.validateNumber(testNumber);
            boolean result2 = Validator.validateNumber(testNumber2);
            boolean result3 = Validator.validateNumber(testNumber3);
            // Assert
            assertTrue(result);
            assertTrue(result2);
            assertTrue(result3);
        }

        @Test
        public void validateNumberReturnsFalseIfTooShort() {
            // Arrange
            String testNumber = "1234";
            // Act
            boolean result = Validator.validateNumber(testNumber);
            // Assert
            assertFalse(result);
        }

        @Test
        public void validateNumberReturnsFalseIfGivenLetters() {
            // Arrange
            String testNumber = "12E4567891O";
            // Act
            boolean result = Validator.validateNumber(testNumber);
            // Assert
            assertFalse(result);
        }
    }

    @Nested
    @DisplayName("validateAll function tests")
    class ValidateAllFunctionTests {

        @Test
        public void validateAllReturnsTrueIfAllFieldsAreValid() {
            // Arrange
            String testName = "Test O'Name";
            String testNumber = "12345678910";
            String testEmail = "testmail@test.co.uk";
            // Act
            boolean result = Validator.validateAll(testName, testNumber, testEmail);
            // Assert
            assertTrue(result);
        }

        @Test
        public void validateAllReturnsFalseIfNameFieldIsInvalid() {
            // Arrange
            String testName = "Test O'N4m3";
            String testNumber = "12345678910";
            String testEmail = "testmail@test.co.uk";
            // Act
            boolean result = Validator.validateAll(testName, testNumber, testEmail);
            // Assert
            assertFalse(result);
        }

        @Test
        public void validateAllReturnsFalseIfNumberFieldIsInvalid() {
            // Arrange
            String testName = "Test O'Name";
            String testNumber = "notANumber";
            String testEmail = "testmail@test.co.uk";
            // Act
            boolean result = Validator.validateAll(testName, testNumber, testEmail);
            // Assert
            assertFalse(result);
        }

        @Test
        public void validateAllReturnsFalseIfEmailFieldIsInvalid() {
            // Arrange
            String testName = "Test O'Name";
            String testNumber = "12345678910";
            String testEmail = "testmail@test";
            // Act
            boolean result = Validator.validateAll(testName, testNumber, testEmail);
            // Assert
            assertFalse(result);
        }
    }
}
