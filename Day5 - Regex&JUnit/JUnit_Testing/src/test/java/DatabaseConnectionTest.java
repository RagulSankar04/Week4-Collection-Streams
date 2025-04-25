import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;


public class DatabaseConnectionTest {
    private DatabaseConnection db;

    @BeforeEach
    void setUp() {
        db = new DatabaseConnection();
        db.connect();
    }

    @AfterEach
    void tearDown() {
        db.disConnect();
    }

    @Test
    void testConnectionEstablished() {
        assertTrue(db.isConnected(), "Connection should be established in @BeforeEach");
    }

    @Test
    void testConnectionStateDuringTest() {
        assertTrue(db.isConnected(), "Should remain connected during test execution");
    }
}
