import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DateFormatterTest {

    private DateFormatter formatter;

    @BeforeEach
    void setUp() {
        formatter = new DateFormatter();
    }

    @Test
    void testValidDate() {
        assertEquals("25-12-2024", formatter.formatDate("2024-12-25"));
        assertEquals("01-01-2023", formatter.formatDate("2023-01-01"));
    }

    @Test
    void testInvalidDateFormat() {
        assertThrows(IllegalArgumentException.class, () -> formatter.formatDate("25/12/2024"));
        assertThrows(IllegalArgumentException.class, () -> formatter.formatDate("2024.12.25"));
        assertThrows(IllegalArgumentException.class, () -> formatter.formatDate("Dec 25, 2024"));
    }

    @Test
    void testEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> formatter.formatDate(""));
    }

    @Test
    void testNullInput() {
        assertThrows(NullPointerException.class, () -> formatter.formatDate(null));
    }
}
