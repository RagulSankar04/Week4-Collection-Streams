import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class PasswordValidatorTest {

    private PasswordValidator validator;

    @BeforeEach
    void setUp() {
        validator = new PasswordValidator();
    }

    @Test
    void testValidPassword() {
        assertTrue(validator.isValid("Secure123"));
    }

    @Test
    void testPasswordTooShort() {
        assertFalse(validator.isValid("S1c"));
    }

    @Test
    void testPasswordWithoutUppercase() {
        assertFalse(validator.isValid("secure123"));
    }

    @Test
    void testPasswordWithoutDigit() {
        assertFalse(validator.isValid("SecurePass"));
    }

    @Test
    void testNullPassword() {
        assertFalse(validator.isValid(null));
    }

    @Test
    void testExactlyEightCharactersWithAllRules() {
        assertTrue(validator.isValid("A1b2c3d4"));
    }
}
