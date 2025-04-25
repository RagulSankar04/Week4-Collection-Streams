import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringUtilsTest {
    StringUtils utils = new StringUtils();

    @Test
    void testReverse() {
        assertEquals("abc", utils.reverse("cba"));
        assertEquals("olleh", utils.reverse("hello"));
        assertNull(utils.reverse(null));
    }

    @Test
    void testPalindrome() {
        assertTrue(utils.isPalindrome("amma"));
        assertTrue(utils.isPalindrome("madam"));
        assertTrue(utils.isPalindrome("RaceCar"));
        assertFalse(utils.isPalindrome(null));
    }

    @Test
    void testUpperCase() {
        assertEquals("HELLO", utils.toUpperCase("hello"));
        assertEquals("JAVA", utils.toUpperCase("java"));
        assertNull(utils.toUpperCase(null));
    }
}
