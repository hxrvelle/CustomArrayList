package datastructuresTests;

import org.example.datastructures.CustomArrayList;
import org.junit.*;

import java.util.Comparator;

import static org.junit.Assert.*;

public class CustomArrayListPositiveTests {
    private CustomArrayList<Integer> customArrayList;
    private CustomArrayList<String> customArrayListString;

    @Before
    public void setUp() {
        customArrayList = new CustomArrayList<>();
        customArrayListString = new CustomArrayList<>();
    }

    @Test
    public void testAdd() {
        for (int i = 1; i <= 3; i++) {
            assertTrue(customArrayList.add(i));
        }
        assertEquals(3, customArrayList.size());
        for (int i = 0; i < 3; i++) {
            assertEquals(Integer.valueOf(i + 1), customArrayList.get(i));
        }
    }

    @Test
    public void testAddAtIndex() {
        for (int i = 1; i <= 3; i++) {
            customArrayList.add(i);
        }

        assertTrue(customArrayList.add(1, 4));
        assertEquals(4, customArrayList.size());
        assertEquals(Integer.valueOf(1), customArrayList.get(0));
        assertEquals(Integer.valueOf(4), customArrayList.get(1));
        for (int i = 2; i <= 3; i++) {
            assertEquals(Integer.valueOf(i), customArrayList.get(i));
        }
    }

    @Test
    public void testAddAtIndexSameIndex() {
        for (int i = 0; i < 1000; i++) {
            customArrayList.add(0, 1);
        }

        assertTrue(customArrayList.add(1, 2));
        assertEquals(1001, customArrayList.size());
        assertEquals(Integer.valueOf(1), customArrayList.get(0));
        assertEquals(Integer.valueOf(2), customArrayList.get(1));
    }

    @Test
    public void testGet() {
        for (int i = 1; i <= 2; i++) {
            customArrayList.add(i);
        }
        for (int i = 0; i < 2; i++) {
            assertEquals(Integer.valueOf(i + 1), customArrayList.get(i));
        }
    }

    @Test
    public void testDelete() {
        for (int i = 1; i <= 3; i++) {
            customArrayList.add(i);
        }

        customArrayList.delete(1);

        assertEquals(2, customArrayList.size());
        assertEquals(Integer.valueOf(1), customArrayList.get(0));
        assertEquals(Integer.valueOf(3), customArrayList.get(1));
    }

    @Test
    public void testDeleteAll() {
        for (int i = 1; i <= 2; i++) {
            customArrayList.add(i);
        }

        customArrayList.deleteAll();

        assertEquals(0, customArrayList.size());
    }

    @Test
    public void testSortAsc() {
        for (int i = 3; i >= 1; i--) {
            customArrayList.add(i);
        }

        customArrayList.sortAsc();

        assertEquals(3, customArrayList.size());
        for (int i = 0; i < 3; i++) {
            assertEquals(Integer.valueOf(i + 1), customArrayList.get(i));
        }
    }

    @Test
    public void testSortDesc() {
        for (int i = 3; i >= 1; i--) {
            customArrayList.add(i);
        }

        customArrayList.sortDesc();

        assertEquals(3, customArrayList.size());
        for (int i = 0; i < 3; i++) {
            assertEquals(Integer.valueOf(3 - i), customArrayList.get(i));
        }
    }

    @Test
    public void testSortAscAtoZ() {
        customArrayListString.add("Banana");
        customArrayListString.add("Apple");
        customArrayListString.add("Cherry");

        customArrayListString.sortAscAtoZ();

        assertEquals("Apple", customArrayListString.get(0));
        assertEquals("Banana", customArrayListString.get(1));
        assertEquals("Cherry", customArrayListString.get(2));
    }

    @Test
    public void testSortDescZtoA() {
        customArrayListString.add("Banana");
        customArrayListString.add("Apple");
        customArrayListString.add("Cherry");

        customArrayListString.sortDescZtoA();

        assertEquals("Cherry", customArrayListString.get(0));
        assertEquals("Banana", customArrayListString.get(1));
        assertEquals("Apple", customArrayListString.get(2));
    }

    @Test
    public void testQuickSort() {
        for (int i = 3; i >= 1; i--) {
            customArrayList.add(i);
        }

        customArrayList.quickSort(Comparator.naturalOrder());

        assertEquals(3, customArrayList.size());
        for (int i = 0; i < 3; i++) {
            assertEquals(Integer.valueOf(i + 1), customArrayList.get(i));
        }
    }

    @Test
    public void testSet() {
        for (int i = 1; i <= 2; i++) {
            customArrayList.add(i);
        }

        customArrayList.set(1, 3);

        assertEquals(Integer.valueOf(1), customArrayList.get(0));
        assertEquals(Integer.valueOf(3), customArrayList.get(1));
    }

    @Test
    public void testSize() {
        for (int i = 1; i <= 3; i++) {
            customArrayList.add(i);
        }

        int size = customArrayList.size();

        assertEquals(3, size);
    }
}