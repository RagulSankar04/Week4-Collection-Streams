import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberUtilsTest {
    NumberUtils utils = new NumberUtils();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6})
    void testIsEven(int n) {
        assertTrue(utils.isEven(n), n + " Should be Even");
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 9})
    void testIsOdd(int n) {
        assertFalse(utils.isEven(n), n + "Should be Odd");
    }
}
