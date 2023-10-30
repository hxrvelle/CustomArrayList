import org.example.CustomArrayList;
import org.junit.*;

import java.util.Comparator;

import static org.junit.Assert.*;

public class CustomArrayListPositiveTests {
    private CustomArrayList<Integer> customArrayList;
    @Before
    public void setUp() {
        customArrayList = new CustomArrayList<>();
    }

    @Test
    public void testAdd() {
        assertTrue(customArrayList.add(1));
        assertTrue(customArrayList.add(2));
        assertEquals(2, customArrayList.size());
        assertEquals(Integer.valueOf(1), customArrayList.get(0));
        assertEquals(Integer.valueOf(2), customArrayList.get(1));
    }

    @Test
    public void testAddAtIndex() {
        customArrayList.add(1);
        customArrayList.add(2);
        customArrayList.add(3);

        assertTrue(customArrayList.add(1, 4));
        assertEquals(4, customArrayList.size());
        assertEquals(Integer.valueOf(1), customArrayList.get(0));
        assertEquals(Integer.valueOf(4), customArrayList.get(1));
        assertEquals(Integer.valueOf(2), customArrayList.get(2));
        assertEquals(Integer.valueOf(3), customArrayList.get(3));
    }

    @Test
    public void testGet() {
        customArrayList.add(1);
        customArrayList.add(2);

        assertEquals(Integer.valueOf(1), customArrayList.get(0));
        assertEquals(Integer.valueOf(2), customArrayList.get(1));
    }

    @Test
    public void testDelete() {
        customArrayList.add(1);
        customArrayList.add(2);
        customArrayList.add(3);

        customArrayList.delete(1);

        assertEquals(2, customArrayList.size());
        assertEquals(Integer.valueOf(1), customArrayList.get(0));
        assertEquals(Integer.valueOf(3), customArrayList.get(1));
    }

    @Test
    public void testDeleteAll() {
        customArrayList.add(1);
        customArrayList.add(2);

        customArrayList.deleteAll();

        assertEquals(0, customArrayList.size());
    }

    @Test
    public void testSortAsc() {
        customArrayList.add(3);
        customArrayList.add(1);
        customArrayList.add(2);

        customArrayList.sortAsc();

        assertEquals(3, customArrayList.size());
        assertEquals(Integer.valueOf(1), customArrayList.get(0));
        assertEquals(Integer.valueOf(2), customArrayList.get(1));
        assertEquals(Integer.valueOf(3), customArrayList.get(2));
    }

    @Test
    public void testSortDesc() {
        customArrayList.add(3);
        customArrayList.add(1);
        customArrayList.add(2);

        customArrayList.sortDesc();

        assertEquals(3, customArrayList.size());
        assertEquals(Integer.valueOf(3), customArrayList.get(0));
        assertEquals(Integer.valueOf(2), customArrayList.get(1));
        assertEquals(Integer.valueOf(1), customArrayList.get(2));
    }

    @Test
    public void testQuickSort() {
        customArrayList.add(3);
        customArrayList.add(1);
        customArrayList.add(2);

        customArrayList.quickSort(Comparator.naturalOrder());

        assertEquals(3, customArrayList.size());
        assertEquals(Integer.valueOf(1), customArrayList.get(0));
        assertEquals(Integer.valueOf(2), customArrayList.get(1));
        assertEquals(Integer.valueOf(3), customArrayList.get(2));
    }

    @Test
    public void testSet() {
        customArrayList.add(1);
        customArrayList.add(2);

        customArrayList.set(1, 3);

        assertEquals(Integer.valueOf(1), customArrayList.get(0));
        assertEquals(Integer.valueOf(3), customArrayList.get(1));
    }

    @Test
    public void testSize() {
        customArrayList.add(1);
        customArrayList.add(2);
        customArrayList.add(3);

        int size = customArrayList.size();

        assertEquals(3, size);
    }
}