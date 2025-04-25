import org.junit.jupiter.api.*;

import java.io.IOException;
import java.nio.file.*;

import static org.junit.jupiter.api.Assertions.*;

class FileProcessorTest {

    private FileProcessor processor;
    private final String testFile = "testfile.txt";

    @BeforeEach
    void setUp() {
        processor = new FileProcessor();
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(Paths.get(testFile));
    }

    @Test
    void testWriteAndReadFromFile() throws IOException {
        String content = "Hello, File!";
        processor.writeToFile(testFile, content);
        String readContent = processor.readFromFile(testFile);

        assertEquals(content, readContent);
    }

    @Test
    void testFileExistsAfterWrite() throws IOException {
        processor.writeToFile(testFile, "Testing existence");
        assertTrue(Files.exists(Paths.get(testFile)));
    }

    @Test
    void testReadFromNonExistentFileThrowsException() {
        String nonExistentFile = "no_such_file.txt";
        assertThrows(IOException.class, () -> {
            processor.readFromFile(nonExistentFile);
        });
    }
}
