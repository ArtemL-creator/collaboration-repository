import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SortTest {
    @Test
    public void shouldBeEmpty() {
        List<Mouse> list = GFG.mergeSort(new ArrayList<>());
        assertTrue(list.isEmpty());
    }

    @Test
    public void sortTest() {
        List<Mouse> list = GFG.mergeSort(new ArrayList<>(List.of(
                new Mouse("bcd", 1),
                new Mouse("abc", 2),
                new Mouse("ABC", 3),
                new Mouse("BCD", 4)
        )));

        assertTrue(!list.isEmpty());

        assertEquals(list.get(0).getPrice(), 3);
        assertEquals(list.get(1).getPrice(), 4);
        assertEquals(list.get(2).getPrice(), 2);
        assertEquals(list.get(3).getPrice(), 1);
    }

    @Test
    public void shouldBeThrowNullPointer() {
        assertThrows(NullPointerException.class, () -> GFG.mergeSort(new ArrayList<>(List.of(
                        new Mouse(null, 1),
                        new Mouse("abc", 2),
                        new Mouse("ABC", 3),
                        new Mouse("BCD", 4)
                )))
        );
    }

    @Test
    public void testWithEqualsMouse() {
        List<Mouse> list = GFG.mergeSort(new ArrayList<>(List.of(
                new Mouse("ABC", 1),
                new Mouse("ABC", 2),
                new Mouse("ABC", 3),
                new Mouse("ABC", 4)
        )));

        assertTrue(!list.isEmpty());

        assertEquals(list.get(0).getPrice(), 4);
        assertEquals(list.get(1).getPrice(), 3);
        assertEquals(list.get(2).getPrice(), 2);
        assertEquals(list.get(3).getPrice(), 1);
    }
}