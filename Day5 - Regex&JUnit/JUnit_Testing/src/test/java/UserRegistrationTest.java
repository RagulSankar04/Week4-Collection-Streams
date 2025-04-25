import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserRegistrationTest {

    private UserRegistration userReg;

    @BeforeEach
    void setUp() {
        userReg = new UserRegistration();
    }

    @Test
    void testValidUserRegistration() {
        assertDoesNotThrow(() -> userReg.registerUser("ragul", "ragul@example.com", "secure123"));
    }

    @Test
    void testEmptyUsername() {
        assertThrows(IllegalArgumentException.class, () -> userReg.registerUser("", "ragul@example.com", "secure123"));
    }

    @Test
    void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> userReg.registerUser("ragul", "notanemail", "secure123"));
    }

    @Test
    void testShortPassword() {
        assertThrows(IllegalArgumentException.class, () -> userReg.registerUser("ragul", "ragul@example.com", "123"));
    }

    @Test
    void testNullInputs() {
        assertThrows(IllegalArgumentException.class, () -> userReg.registerUser(null, "email@example.com", "password"));

        assertThrows(IllegalArgumentException.class, () -> userReg.registerUser("username", null, "password"));

        assertThrows(IllegalArgumentException.class, () -> userReg.registerUser("username", "email@example.com", null));
    }
}
