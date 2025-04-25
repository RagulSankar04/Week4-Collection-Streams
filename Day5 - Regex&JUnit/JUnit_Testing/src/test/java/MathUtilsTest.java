import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MathUtilsTest {
    MathUtils utils = new MathUtils();

    @Test
    void testDivide() {
        assertEquals(2, utils.divide(10, 5));
    }

    @Test
    void testException() {
        assertThrows(ArithmeticException.class, () -> utils.divide(10, 0));
    }
}
