import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;

public class ListManagerTest {
    ListManager manager = new ListManager();

    @Test
    void addElement() {
        List<Integer> list = new ArrayList<>();
        manager.addElement(list, 10);
        manager.addElement(list, 20);
        assertTrue(list.contains(10));
        assertTrue(list.contains(20));
        assertEquals(2, list.size());
    }

    @Test
    void getSize() {
        List<Integer> list = new ArrayList<>();
        assertEquals(0, manager.getSize(list));
        manager.addElement(list, 1);
        assertEquals(1, manager.getSize(list));
        manager.addElement(list, 2);
        assertEquals(2, manager.getSize(list));
        manager.removeElement(list, 1);
        assertEquals(1, manager.getSize(list));
    }
}
